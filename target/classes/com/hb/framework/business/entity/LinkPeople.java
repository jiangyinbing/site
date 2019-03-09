package com.hb.framework.business.entity;

import java.io.Serializable;

/**
 * 紧急联系人实体类
 * @author lym
 *
 */
public class LinkPeople implements Serializable{

	/**
	 * 联系人姓名
	 */
	private String link;
	/**
	 * 关系
	 */
	private String linkrelation;
	/**
	 * 联系人电话
	 */
	private String linkmobile;
	
	public LinkPeople() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LinkPeople(String link, String linkrelation, String linkmobile) {
		super();
		this.link = link;
		this.linkrelation = linkrelation;
		this.linkmobile = linkmobile;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLinkrelation() {
		return linkrelation;
	}

	public void setLinkrelation(String linkrelation) {
		this.linkrelation = linkrelation;
	}

	public String getLinkmobile() {
		return linkmobile;
	}

	public void setLinkmobile(String linkmobile) {
		this.linkmobile = linkmobile;
	}
	
}
