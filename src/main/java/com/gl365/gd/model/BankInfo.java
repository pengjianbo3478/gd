package com.gl365.gd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "银行支行信息")
public class BankInfo {
	
	@ApiModelProperty(value = "银行行号")
    private String bankNo;

	@ApiModelProperty(value = "上级银行行号")
    private String parentBankNo;

	@ApiModelProperty(value = "银行名称")
    private String name;

	@ApiModelProperty(value = "外部区域ID")
    private String deptId;

	@ApiModelProperty(value = "给乐区域ID")
    private Integer glAreaId;

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getParentBankNo() {
        return parentBankNo;
    }

    public void setParentBankNo(String parentBankNo) {
        this.parentBankNo = parentBankNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getGlAreaId() {
        return glAreaId;
    }

    public void setGlAreaId(Integer glAreaId) {
        this.glAreaId = glAreaId;
    }
}