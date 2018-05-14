package com.gl365.gd.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(value = "AreaInfoEx", description = "省/市/县区域信息,含下级")
public class AreaInfoEx {

	@ApiModelProperty(name = "areaInfo", required = true)
	private AreaInfo areaInfo;
	private List<AreaInfoEx> list;
	
	public AreaInfo getAreaInfo() {
		return areaInfo;
	}
	public void setAreaInfo(AreaInfo areaInfo) {
		this.areaInfo = areaInfo;
	}
	public List<AreaInfoEx> getList() {
		return list;
	}
	public void setList(List<AreaInfoEx> list) {
		this.list = list;
	}
	
	
}
