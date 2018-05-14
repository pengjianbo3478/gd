package com.gl365.gd.service;

import java.util.List;

import com.gl365.gd.model.AreaInfo;

public interface IAreaInfoService {

	List<AreaInfo> getSingleLevelByAreaId(Integer areaId);
	List<AreaInfo> getallLevelByAreaId(Integer areaId);
}
