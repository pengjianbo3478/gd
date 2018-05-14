package com.gl365.gd.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "分页数据")
public class PageData<T> {
	
	@ApiModelProperty(value = "总条数", position = 0, required = true)
	private Integer totalCount;

	@ApiModelProperty(value = "当前页", position = 1, required = true)
	private Integer curPage; 

	@ApiModelProperty(value = "页大小", position = 2, required = true)
	private Integer pageSize;
	
	@ApiModelProperty(position = 3)
	private List<T> list;
	
	public PageData() {
	}
	
	public PageData(Integer totalCount, Integer curPage, Integer pageSize, List<T> list) {
		this.totalCount = totalCount;
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.list = list;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
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

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	
}
