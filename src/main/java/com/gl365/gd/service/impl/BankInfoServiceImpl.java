package com.gl365.gd.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl365.gd.dto.condition.GetBankInfoByAreaId;
import com.gl365.gd.mapper.AreaInfoMapper;
import com.gl365.gd.mapper.BankInfoMapper;
import com.gl365.gd.model.AreaInfo;
import com.gl365.gd.model.BankInfo;
import com.gl365.gd.model.PageData;
import com.gl365.gd.service.IBankInfoService;

@Service
public class BankInfoServiceImpl implements IBankInfoService {

	@Autowired
	private BankInfoMapper bankInfoMapper;

	@Autowired
	private AreaInfoMapper areaInfoMapper;
	@Override
	public PageData<BankInfo> getBankInfoByAreaId(GetBankInfoByAreaId condition) {
		AreaInfo areaInfo = areaInfoMapper.selectByPrimaryKey(condition.getAreaId());
		if (areaInfo == null) {
			return null;
		}
		String path = areaInfo.getPath() + "/" + areaInfo.getId() + "%";
		String bankName = condition.getBankName();
		
		if (StringUtils.isBlank(bankName)) {
			return getBankInfoByAreaId(path, condition.getAreaId(), condition.getBankNo(), condition.getCurPage(), condition.getPageSize());
		} else {
			return getBankInfoByAreaId(path, condition.getAreaId(), condition.getBankNo(), bankName,  condition.getCurPage(), condition.getPageSize());
		}

	}
	
	public PageData<BankInfo> getBankInfoByAreaId(String path, int areaId, String bankNo, int curPage, int pageSize) {
		Integer totalSize = bankInfoMapper.selectCountByGlAreaId(areaId, bankNo + "%") 
				+ bankInfoMapper.selectCountByPath(path, bankNo + "%");
		
		List<BankInfo> list = bankInfoMapper.selectByGlAreaIdAndPath(areaId, path, bankNo + "%",
				(curPage - 1) * pageSize, pageSize);
		PageData<BankInfo> result = new PageData<BankInfo>(totalSize, curPage, pageSize, list);
		return result; 
	}
	
	public PageData<BankInfo> getBankInfoByAreaId(String path, int areaId, String bankNo, String bankName, int curPage, int pageSize) {
		Integer totalSize = bankInfoMapper.selectCountByGlAreaIdBlur(areaId, bankNo + "%", "%" + bankName + "%") 
				+ bankInfoMapper.selectCountByPathBlur(path, bankNo + "%", "%" + bankName + "%");
		
		List<BankInfo> list = bankInfoMapper.selectByGlAreaIdAndPathBlur(areaId, path, bankNo + "%", "%" + bankName + "%",
				(curPage - 1) * pageSize, pageSize);
		PageData<BankInfo> result = new PageData<BankInfo>(totalSize, curPage, pageSize, list);
		return result; 
	}
	
	public void InsertBankInfo(BankInfo bankInfo) {
		bankInfoMapper.insert(bankInfo);
	}
}
