package cn.jju.it.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.jju.it.mapper.CollegeMapper;
import cn.jju.it.model.College;

@Controller
@Api(value = "测试")
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	CollegeMapper mapper;

	@ApiOperation("获得所有学院json信息")
	@GetMapping("/getAll")
	@ResponseBody
	public List<College> getAll() {
		System.out.println("getAll");
		return mapper.getAll();
	}

	@ApiOperation("新增学院--实体参数")
	@PostMapping("/add")
	@ResponseBody
	public Map<String, Object> add(College obj) {
		// SpringMVC 自动创建一个Collge对象，并将传递过来的参数 赋值给对应的属性
		Map<String, Object> ret = new HashMap<>();
		int n = mapper.add(obj);
		if (n > 0) {
			ret.put("code", 1);
			ret.put("msg", "录入成功");
		} else {
			ret.put("code", 0);
			ret.put("msg", "录入失败");
		}
		return ret;
	}

	@ApiOperation("新增学院--json参数")
	@PostMapping("/add2")
	@ResponseBody
	public Map<String, Object> add2(@RequestBody College obj) {
		// SpringMVC 自动创建一个Collge对象，并将传递过来的参数 赋值给对应的属性
		Map<String, Object> ret = new HashMap<>();
		int n = mapper.add(obj);
		if (n > 0) {
			ret.put("code", 1);
			ret.put("msg", "录入成功");
		} else {
			ret.put("code", 0);
			ret.put("msg", "录入失败");
		}
		return ret;
	}
}
