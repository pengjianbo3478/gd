package com.gl365.gd.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl365.gd.common.JsonUtils;
import com.gl365.gd.dto.condition.GetBankInfoByAreaId;
import com.gl365.gd.model.BankInfo;
import com.gl365.gd.model.PageData;
import com.gl365.gd.service.IBankInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/gd")
@Api(value = "BankInfoController", description="银行支行Controller")
public class BankInfoController {

	private static final Logger log = LoggerFactory.getLogger(BankInfoController.class);
	@Autowired
	private IBankInfoService bankInfoService;
	
	@PostMapping("/bankInfo/city")
	@ApiOperation(value="根据市级区域ID获取银行支行", notes = "区域ID只能是2级市级区域,查询结果包含县级支行")
	@HystrixCommand(fallbackMethod = "getBankInfoByAreaIdAndBankNoFallback")
	public PageData<BankInfo> getBankInfoByAreaIdAndBankNo(@RequestBody GetBankInfoByAreaId condition) {
		log.info("根据区域ID获取银行支行>>>入参：{}", JsonUtils.toJsonString(condition));
		condition.setCurPage((condition.getCurPage()<=0)? 1: condition.getCurPage());
		return bankInfoService.getBankInfoByAreaId(condition);
	}
	
	public PageData<BankInfo> getBankInfoByAreaIdAndBankNoFallback(@RequestBody GetBankInfoByAreaId condition) throws Exception {
		throw new Exception("系统超时。");
	}
}
