package com.gl365.gd.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AreaInfo", description="省/市/县区域信息")
public class AreaInfo {
	
	@ApiModelProperty(value = "主键ID", position = 0, required = true)
    private Integer id;

	@ApiModelProperty(value = "上级ID", position = 1, required = true)
    private Integer parentId;

	@ApiModelProperty(value = "区域名称", position = 2, required = true)
    private String name;

	@ApiModelProperty(value = "区域层级 1省 2市 3县", position = 3, required = true)
    private Integer level;

	@ApiModelProperty(value = "外部区域ID", position = 4)
    private String deptId;
	
	@ApiModelProperty(value = "冗余路径", position = 5)
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
    
    
}