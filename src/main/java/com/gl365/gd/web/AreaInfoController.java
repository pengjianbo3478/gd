package com.gl365.gd.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl365.gd.model.AreaInfo;
import com.gl365.gd.service.IAreaInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("/gd")
@Api(value = "AreaInfoController", description="行政区域Controller")
public class AreaInfoController {

	@Autowired
	private IAreaInfoService areaInfoService;
	
	@GetMapping("/areaInfo/singleLevel/{areaId}")
	@ApiOperation(value="根据ID获取下级单层行政区域", notes = "行政区域有3级，对应省（1级）、市（2级）、县（3级）"
	+ "\n给定ID后，每次只查下级单层行政区域"
	+ "\n查询第一级 areaId=1")
	@ApiImplicitParam(name = "areaId", value = "区域ID", required = true, dataType = "int", paramType="path")
	@HystrixCommand(fallbackMethod = "getSingleLevelByAreaIdFallback")
	public List<AreaInfo> getSingleLevelByAreaId(@PathVariable("areaId") Integer areaId) {
		return areaInfoService.getSingleLevelByAreaId(areaId);
	}
	
	public List<AreaInfo> getSingleLevelByAreaIdFallback(@PathVariable("areaId") Integer areaId) throws Exception {
		throw new Exception("系统超时。");
	}
	
	@GetMapping("/areaInfo/allLevel/{areaId}")
	@ApiOperation(value="根据ID获取下级多层行政区域", notes = "行政区域有3级，对应省（1级）、市（2级）、县（3级）"
	+ "\n给定ID后，每次查下级所有层行政区域"
	+ "\n查询全部 areaId=1")
	@ApiImplicitParam(name = "areaId", value = "区域ID", required = true, dataType = "int", paramType="path")
	@HystrixCommand(fallbackMethod = "getallLevelByAreaIdFallback")
	public List<AreaInfo> getallLevelByAreaId(@PathVariable("areaId") Integer areaId) {
		return areaInfoService.getallLevelByAreaId(areaId);
	}
	
	public List<AreaInfo> getallLevelByAreaIdFallback(@PathVariable("areaId") Integer areaId) throws Exception {
		throw new Exception("系统超时。");
	}
}
