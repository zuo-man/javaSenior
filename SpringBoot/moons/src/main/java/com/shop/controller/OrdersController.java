package com.shop.controller;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shop.entity.ReUtil;
import com.shop.entity.Result;
import com.shop.mapper.OrdersMapper;
import com.shop.pojo.AliPay;
import com.shop.pojo.Orders;
import com.shop.service.OrdersService;
import com.shop.service.OrdersforService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author shengda
* @description orders CRUD操作
* @createDate 2022-05-23 22:54:22
*/

@Api(tags = "订单")
@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersforService ordersforService;

    //http://47.96.175.143:5000/orders/pay?subject=112233&traceNo=121313123&totalAmount=1000

    @ApiOperation("订单支付")
    @GetMapping("/pay") // &subject=xxx&traceNo=xxx&totalAmount=xxx
    @Transactional(rollbackFor = Exception.class)
    public String pay(AliPay aliPay) {
        AlipayTradePagePayResponse response;
        try {
            //发起API调用（以创建当面付收款二维码为例）
            response = Factory.Payment.Page().pay(URLEncoder.encode(aliPay.getSubject(), "UTF-8"),
                    aliPay.getTraceNo(), aliPay.getTotalAmount(), "");
        } catch (Exception e) {
            System.err.println("调用遭遇异常，原因：" + e.getMessage());
            throw new RuntimeException(e.getMessage(), e);
        }
        return response.getBody();
    }



    @ApiOperation("支付后跳转")
    @PostMapping("/notify")
    @Transactional(rollbackFor = Exception.class)
    public Result payNotify(HttpServletRequest request) throws Exception {
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {

            Map<String, String> params = new HashMap<>();
            Map<String, String[]> requestParams = request.getParameterMap();
            for (String name : requestParams.keySet()) {
                params.put(name, request.getParameter(name));
            }

            //订单号，就是orders的id字段
            Integer id = Integer.valueOf(params.get("out_trade_no"));
            //支付时间
            String paytime = params.get("gmt_payment");
            //支付宝交易凭证号
            String TradeNo = params.get("trade_no");

            // 支付宝验签
            if (Factory.Payment.Common().verifyNotify(params)) {
                // 验签通过
//                System.out.println("交易名称: " + params.get("subject"));
//                System.out.println("交易状态: " + params.get("trade_status"));
//                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
//                System.out.println("商户订单号: " + params.get("out_trade_no"));
//                System.out.println("交易金额: " + params.get("total_amount"));
//                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
//                System.out.println("买家付款时间: " + params.get("gmt_payment"));
//                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));

                // 更新订单已支付
                ordersService.updateState(id, "已支付", paytime, TradeNo);
            }
        }
        return ReUtil.succ(null);
    }


    @ApiOperation("根据用户ID查询订单")
    @GetMapping("/getOrders/{uid}")
    public Result getOrders(@PathVariable("uid") Integer uid){
        List<Orders> orders = ordersService.getByUid(uid);

        return ReUtil.succ(orders);
    }

    @ApiOperation("根据订单ID查询订单信息")
    @GetMapping("/getOrderById/{id}")
    public Result getOrderById(@PathVariable("id") Integer id){
        Orders orders = ordersService.getOrdersById(id);

        return ReUtil.succ(orders);
    }


    @ApiOperation("分页模糊查询所有订单")
    @PostMapping("/getOrdersAll/{page}/{limit}")
    public Result getOrdersAll (@PathVariable("page") Integer page,
                                @PathVariable("limit") Integer limit,
                                @RequestBody HashMap<Object, Object> map){

        String user = (String) map.get("user");
        String state = (String) map.get("state");
        Integer isdown = (Integer) map.get("isdown");

        Page<Orders> data = new Page<>(page, limit);

        Page orders = ordersService.getOrders(data, user, state, isdown);

        return ReUtil.succ(orders);
    }

    @ApiOperation("修改是否线下取货")
    @PostMapping("/updateIsdown")
    public Result updateIsdown(@RequestBody HashMap<Object, Integer> map){
        Integer id = map.get("id");
        Integer isdown = map.get("isdown");

        //获取 订单对应 交易号
        String payNo = ordersService.getOrdersById(id).getPayNo();

        if(payNo != null){
            //修改线下取货
            ordersService.updateIsdownById(id, isdown);
            return ReUtil.succ(null);
        }else {
            return new Result(399, null, "未付款，无法修改", false);
        }
    }


    @ApiOperation("根据订单 id删除订单")
    @DeleteMapping("/remove/{id}")
    public Result RemoveBatchShop(@PathVariable("id") Integer id){
        ordersService.removeById(id);

        //删除订单对应订单商品
        ordersforService.removeByOid(id);

        return ReUtil.succ(null);
    }


}
