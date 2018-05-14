package com.gl365.gd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.gl365.gd.model.BankInfo;

@Repository
public interface BankInfoMapper {
    int deleteByPrimaryKey(String bankNo);

    int insert(BankInfo record);

    int insertSelective(BankInfo record);

    BankInfo selectByPrimaryKey(String bankNo);

    int updateByPrimaryKeySelective(BankInfo record);

    int updateByPrimaryKey(BankInfo record);
    
    int selectCountByGlAreaId(@Param("glAreaId") Integer glAreaId, @Param("bankNo") String bankNo);
    int selectCountByPath(@Param("path") String path, @Param("bankNo") String bankNo);
    
    int selectCountByGlAreaIdBlur(@Param("glAreaId") Integer glAreaId, @Param("bankNo") String bankNo,
    		@Param("bankName") String bankName);
    int selectCountByPathBlur(@Param("path") String path, @Param("bankNo") String bankNo,
    		@Param("bankName") String bankName);
    
    List<BankInfo> selectByGlAreaIdAndPath(@Param("glAreaId") Integer glAreaId, @Param("path") String path,
    		@Param("bankNo") String bankNo, @Param("beginNum") Integer beginNum, @Param("pageSize") Integer pageSize);
    List<BankInfo> selectByGlAreaIdAndPathBlur(@Param("glAreaId") Integer glAreaId, @Param("path") String path,
    		@Param("bankNo") String bankNo, @Param("bankName") String bankName,
    		@Param("beginNum") Integer beginNum, @Param("pageSize") Integer pageSize);
}