package com.gl365.gd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl365.gd.mapper.AreaInfoMapper;
import com.gl365.gd.model.AreaInfo;
import com.gl365.gd.service.IAreaInfoService;

@Service
public class AreaInfoServiceImpl implements IAreaInfoService {

	@Autowired
	private AreaInfoMapper areaInfoMapper;

	@Override
	public List<AreaInfo> getSingleLevelByAreaId(Integer areaId) {
		return areaInfoMapper.getSingleLevelByAreaId(areaId);
	}

	@Override
	public List<AreaInfo> getallLevelByAreaId(Integer areaId) {
		AreaInfo areaInfo = areaInfoMapper.selectByPrimaryKey(areaId);
		String path = areaInfo.getPath() + "/" + areaId + "%";
		return areaInfoMapper.getAreaInfoByPath(path);
	}
	
}
