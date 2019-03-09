package com.hb.framework.system.entity;

import java.io.Serializable;
import java.util.Date;
/**
* 
* 类名称：File   
* 类描述：   文件上传公用类
* 创建人：h  
* 创建时间： 
* 修改人：Administrator   
* 修改时间： 
* 修改备注：   
* @version    
*
 */
public class SysFile implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4719655444934366205L;
	private Integer id;
	private Integer type;// 文件所属类型
	private String name;// 文件原名称
	private String sysname;// 传入后，系统名称
	private String alias;// 文件说明
	private Date update;// 上传时间
	private Integer pid;// 文件所属id
	private Integer userid;// 上传人id
	private String filetype;// 文件类型
	
	private String userName;// 上传人  
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getUpdate() {
		return update;
	}

	public void setUpdate(Date update) {
		this.update = update;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
