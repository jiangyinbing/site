package com.hb.framework.business.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.hb.framework.business.entity.Linkman;
import com.hb.framework.business.entity.LinkmanHst;
import com.hb.framework.superhelp.util.DBConnectionUtils;
import com.hb.framework.superhelp.util.IdCardValidator;
import com.hb.framework.superhelp.util.PasswordFacility;
import com.hb.framework.system.entity.User;

/**
 * 联系人业务类
 * @author lym
 *
 */
@Service
public class LinkPeopleService {
	
	/**
	 * 查询联系人
	 * @param users
	 * @param orderId
	 * @return
	 */
	public Map<String, Object> queryLinkPeople(User users, String orderId) {
		Map<String, Object> maps = new HashMap<String, Object>();
		LinkmanService linkmanService = new LinkmanService();
		List<Linkman> list = new ArrayList<Linkman>();
		
        /*String sql2 = "SELECT * from hb_linkman ";*/

		// 查询历史数据
//		if(null != orderId){
//			List<LinkmanHst> lst = linkmanHstService.getContentHstBycustId(users.getUserId(), orderId);
//			for(LinkmanHst linkmanHst : lst){
//				Linkman linkman = new Linkman();
//				linkman.setUserId(linkmanHst.getCustId());
//				linkman.setBirth(linkman.getBirth());
//				linkman.setCorpFax(linkmanHst.getCorpFax());
//				linkman.setCorpName(linkmanHst.getCorpName());
//				linkman.setCorpPosition(linkmanHst.getCorpPosition());
//				linkman.setCorpTelephNbr(linkmanHst.getCorpTelephNbr());
//				linkman.setCreateTime(linkmanHst.getCreateTime());
//				linkman.setCreateUser(linkmanHst.getCreateUser());
//				linkman.setGender(linkmanHst.getGender());
//				linkman.setIdNo(linkmanHst.getIdNo());
//				linkman.setIdType(linkmanHst.getIdType());
//				linkman.setRelationship(linkmanHst.getRelationship());
//				linkman.setOrg(linkmanHst.getOrg());
//				linkman.setName(linkmanHst.getName());
//				linkman.setMobileNo(linkmanHst.getMobileNo());
//				list.add(linkman);
//			}
//		}
		// 没有历史数据查询当前数据
//		if (list.isEmpty()) {
			list = linkmanService.getContentBycustId(users.getUserId());
//		}
//		Collections.reverse(list);
		List<Linkman> linkmanlst = new ArrayList<Linkman>();
		// 获取联系人1，联系人必输入
		if(list.size()==0){
			return null;
		}
		Linkman linkman = list.get(0);
		linkmanlst.add(linkman);
		
		if (list.size() > 1) {
			linkman = list.get(1);
			linkmanlst.add(linkman);
		}
		maps.put("linkmanLst", linkmanlst);
		return maps;
	}

	/**
	 * 添加联系人
	 * @param customer
	 * @param link1				联系人1名字
	 * @param link2				联系人2名字
	 * @param linkrelation1		与联系人1的关系
	 * @param linkrelation2		与联系人1的关系
	 * @param linkmobile1		联系人1移动号码
	 * @param linkmobile2		联系人2移动号码
	 * @param idNo1				联系人1身份证号
	 * @param idNo2				联系人2身份证号
	 * @param unitName1			联系人1单位名称
	 * @param unitName2			联系人2单位名称
	 * @param unitPhone1		联系人1单位电话
	 * @param unitPhone2		联系人2单位电话
	 * @return
	 */
                                           public String addLinkPeople(HttpServletRequest request,
                                   String link1, String link2,
			String linkrelation1, String linkrelation2,
			String linkmobile1, String linkmobile2,
			String idNo1, String idNo2,
			String unitName1, String unitName2,
			String unitPhone1, String unitPhone2){
		
		
		User users = (User) request.getSession().getAttribute("userSession");
		int custId = users.getUserId();
		
		PasswordFacility passwordFacility = new PasswordFacility();
		// 判断非空
		if ( StringUtils.isBlank(linkmobile1)
				|| linkrelation1 == null
				|| StringUtils.isBlank(link1)){
			return "联系人1必输项不能为空";
		}
		// 检测输入手机号是否符合规范
		if (!passwordFacility.isMobile(linkmobile1)) {
			System.out.println("手机号不符合规范");
			return "联系人1手机号码无效";
		}
		// 验证身份证的合法性
		IdCardValidator cardValidator = new IdCardValidator();
		if (!cardValidator.isValidate18Idcard(idNo1)) {
			System.out.println("验证身份证的合法性不合法");
			return "联系人1无效身份证号码，请重新输入";
		}
		// 最多只添加两个联系人， 不知道哪个联系人被修改，所以全部删除Linkman，在保存
		String sql = "DELETE FROM hb_linkman WHERE userId=" + custId;
		DBConnectionUtils.executeDelete(sql);

		// 添加联系人1
		String ret = mergeXjLinkman( link1,linkrelation1,
				linkmobile1,idNo1,unitName1, 
				unitPhone1,custId);
		
		// 手机，关系，姓名都不能为空
		if(linkrelation2 != null || idNo2 != null || !StringUtils.isBlank(idNo2)){
			// 判断非空
			if ( StringUtils.isBlank(linkmobile2)
					|| linkrelation2 == null
					|| StringUtils.isBlank(link2)){
				return "联系人2必输项不能为空";
			}
			// 检测输入手机号是否符合规范
			if (!passwordFacility.isMobile(linkmobile2)) {
				System.out.println("手机号不符合规范");
				return "联系人2手机号码无效";
			}
			if (!cardValidator.isValidate18Idcard(idNo2)) {
				System.out.println("验证身份证的合法性不合法");
				return "联系人2无效身份证号码，请重新输入";
			}
			ret = mergeXjLinkman(link2,linkrelation2,linkmobile2,idNo2,unitName2,
					unitPhone2, custId);
		}
		return "S";
	}
	
	/**
	 * 创建(更新)联系人信息
	 * 
	 * @param req
	 * @return
	 */
	public String mergeXjLinkman(String link,String linkrelation,
			String linkmobile,String idNo,String unitName,
			String unitPhone,int userid) {
		// 保存婚姻状况信息到客户信息表 (暂忽略)
		// 联系人不存在则new 一个，存在则修改
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String sql = "INSERT INTO hb_linkman(userId, name, relationship, mobileNo, idNo, corpName, corpTelephNbr, createTime, lstUpdTime, jpaVersion) "
				+ " VALUES('"+ userid +"', '"+ link +"', '"+ linkrelation +"', '"+ linkmobile +"', "
				+ "'"+ idNo +"', '"+ unitName +"', '"+ unitPhone +"', '"+ sdf.format(new Date()) +"', '"+ sdf.format(new Date()) +"', 0)";
		DBConnectionUtils.executeInsert(sql);
		return "SUCCESS";
	}
	
}
