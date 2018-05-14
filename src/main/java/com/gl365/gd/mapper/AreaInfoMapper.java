package com.gl365.gd.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.gl365.gd.model.AreaInfo;

@Repository
public interface AreaInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AreaInfo record);

    int insertSelective(AreaInfo record);

    AreaInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AreaInfo record);

    int updateByPrimaryKey(AreaInfo record);
    
    // 获取单层下级区域
    List<AreaInfo> getSingleLevelByAreaId(@Param("areaId") Integer areaId);
    
    //获取下级区域根Path
    @Select("select CONCAT(path,'/', id) from area_info where id = #{areaId}")
    String getRootPathByAreaID(@Param("areaId") Integer areaId);
    
    //根据Path获取区域列表
    @Select("select * from area_info where path Like #{path} order by level")
    List<AreaInfo> getAreaInfoByPath(@Param("path") String path);
}