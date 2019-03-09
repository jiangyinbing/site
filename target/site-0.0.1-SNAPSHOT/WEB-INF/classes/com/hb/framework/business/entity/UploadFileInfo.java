package com.hb.framework.business.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 附件上传信息实体类
 * @author wkl
 *
 */
public class UploadFileInfo implements Serializable {

	/**
	 * 用户ID
	 */
	private int customer_id;
	
	/**
	 * 订单id
	 */
	private String order_id;
	
	/**
	 * 抵质押ID
	 */
	private int pledge_id;
	
	/**
	 * 文件数据
	 * 
	 */
	private String upload_file;
	
	/**
	 * 文件保存路径
	 * 
	 */
	private String upload_file_dir;
	
	/**
	 * 文件名称
	 * 
	 */
	private String upload_file_name;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 保存时间
	 *
	 */
	private Date upload_time;
	
	/**
	 * 类型
	 *
	 */
	private AttachmentType type;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public int getPledge_id() {
		return pledge_id;
	}

	public void setPledge_id(int pledgeId) {
		pledge_id = pledgeId;
	}

	public String getUpload_file() {
		return upload_file;
	}

	public void setUpload_file(String upload_file) {
		this.upload_file = upload_file;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getUpload_time() {
		return upload_time;
	}

	public void setUpload_time(Date upload_time) {
		this.upload_time = upload_time;
	}

	

	
	public AttachmentType getType() {
		return type;
	}

	
	public void setType(AttachmentType type) {
		this.type = type;
	}

	public String getUpload_file_dir() {
		return upload_file_dir;
	}

	public void setUpload_file_dir(String upload_file_dir) {
		this.upload_file_dir = upload_file_dir;
	}

	public String getUpload_file_name() {
		return upload_file_name;
	}

	public void setUpload_file_name(String upload_file_name) {
		this.upload_file_name = upload_file_name;
	}

	
	
	
}
