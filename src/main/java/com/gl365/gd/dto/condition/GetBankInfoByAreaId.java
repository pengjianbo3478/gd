package com.gl365.gd.dto.condition;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "通过区域ID获取指定银行支行列表条件")
public class GetBankInfoByAreaId {
	
	@ApiModelProperty(value="区域 ID", required = true)
	private Integer areaId;
	
	@ApiModelProperty(value="银行总行编码", required = true)
	private String bankNo;
	
	@ApiModelProperty(value="支行名称（模糊查询）", required = false)
	private String bankName;
	
	@ApiModelProperty(value = "当前页", required = true)
	private Integer curPage;
	@ApiModelProperty(value = "每页行数, 默认每页10行", required = false)
	private Integer pageSize = 10;
	
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public Integer getCurPage() {
		return curPage;
	}
	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public String getBankNo() {
		return bankNo;
	}
	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
}
