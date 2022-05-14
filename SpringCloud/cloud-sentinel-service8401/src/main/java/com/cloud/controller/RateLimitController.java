package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.entities.CommonResult;
import com.cloud.entities.Payment;
import com.cloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * value： Sentinel资源的名称，我们不仅可以通过url进行限流，也可以把此值作为资源名配置，一样可以限流。
 * entryType： 条目类型（入站或出站），默认为出站（EntryType.OUT）
 * resourceType： 资源的分类（类型）
 * blockHandler： 块异常函数的名称，默认为空
 * blockHandlerClass： 指定块处理方法所在的类
 *      默认情况下， blockHandler与原始方法位于同一类中。 但是，如果某些方法共享相同的签名并打算设置相同的块处理程序，则用户可以设置存在块处理程序的类。 请注意，块处理程序方法必须是静态的。
 * fallback： 后备函数的名称，默认为空
 * defaultFallback： 默认后备方法的名称，默认为空
 * defaultFallback用作默认的通用后备方法。 它不应接受任何参数，并且返回类型应与原始方法兼容
 * fallbackClass： fallback方法所在的类（仅单个类）
 *      默认情况下， fallback与原始方法位于同一类中。 但是，如果某些方法共享相同的签名并打算设置相同的后备，则用户可以设置存在后备功能的类。 请注意，共享的后备方法必须是静态的。
 * exceptionsToTrace： 异常类的列表追查，默认 Throwable
 * exceptionsToIgnore： 要忽略的异常类列表，默认情况下为空
 *
 * sentinel系统默认提示： Blocked by Sentinel (flow limiting)
 * 注意：注解方式埋点不支持private
 */

@RestController
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult ByResource(){

        return new CommonResult(200, "按资源名称限流测试", new Payment(2020L, "seriale001"));
    }
    public CommonResult handleException(BlockException exception){

        return new CommonResult(399, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    //没写兜底方法，限流将会执行默认Blocked by Sentinel (flow limiting)
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){

        return new CommonResult(200, "按 url限流测试", new Payment(2020L, "serial002"));
    }


    //blockHandlerClass：表明用CustomerBlockHandler类的  handlerException2 方法兜底
    @GetMapping("/rateLimit/customer")
    @SentinelResource(value = "customer", blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handlerException2")
    public CommonResult customer(){

        return new CommonResult(200, "自定义测试", new Payment(2020L, "serial002"));
    }

}
