package com.hb.framework.business.entity;

import java.util.List;

public class Product {

	//参数ID
	private String param_id;
	//参数ID对应的名称
	private String param_name;
	//产品期数
	private String term;
	//产品期数s
	private List terms;
	
	public String getParam_id() {
		return param_id;
	}
	public void setParam_id(String paramId) {
		param_id = paramId;
	}
	public String getParam_name() {
		return param_name;
	}
	public void setParam_name(String paramName) {
		param_name = paramName;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public List getTerms() {
		return terms;
	}
	public void setTerms(List terms) {
		this.terms = terms;
	}

	
}
