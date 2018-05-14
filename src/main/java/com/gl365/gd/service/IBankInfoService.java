package com.gl365.gd.service;

import com.gl365.gd.dto.condition.GetBankInfoByAreaId;
import com.gl365.gd.model.BankInfo;
import com.gl365.gd.model.PageData;

public interface IBankInfoService {
	PageData<BankInfo> getBankInfoByAreaId(GetBankInfoByAreaId condition);
}
