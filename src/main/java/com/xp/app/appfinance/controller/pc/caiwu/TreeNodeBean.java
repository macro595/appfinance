package com.xp.app.appfinance.controller.pc.caiwu;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeBean {
	public String id;
	public String parentCode;
	public String name;
	public String sort;
	public List children = new ArrayList();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentCode() {
		return parentCode;
	}
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
