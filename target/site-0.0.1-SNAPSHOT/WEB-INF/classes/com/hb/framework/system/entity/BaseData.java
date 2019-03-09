package com.hb.framework.system.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseData implements Serializable {
	   /** @pdOid a85d0d53-0edd-4fba-8f23-81f25a02d2d1 */
	   public int id;
	   /** 类型：0顶级类型，1地区信息2
	    * 
	    */
	   public String type;
	   /** 显示名称
	    * 
	    */
	   public String name;
	   /** 数值
	    * 
	    */
	   public String value;
	   /** 花费时间
	    * 
	    */
	   public String alias;
	   /** 
	    * 
	    */
	   public String mark;
	   /** 0禁用1启用
	    * 
	    */
	   public int status;
	   
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getValue() {
			return value;
		}
		public void setValue(String value) {
			this.value = value;
		}
		public String getAlias() {
			return alias;
		}
		public void setAlias(String alias) {
			this.alias = alias;
		}
		public String getMark() {
			return mark;
		}
		public void setMark(String mark) {
			this.mark = mark;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}	   
}