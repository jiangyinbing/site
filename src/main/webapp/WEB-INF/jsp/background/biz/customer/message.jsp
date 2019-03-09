<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@include file="../../../common/common-js.jsp"%>
		<%@include file="../../../common/validator.jsp"%>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link id="cssMiddle" type="text/css" rel="stylesheet"
			href="${pageContext.servletContext.contextPath }/css/public_index${userSession.style}.css" media="all" />
		<title>客户信息</title>
	</head>
	<body>
		<form action="${pageContext.servletContext.contextPath }/background/business/customerinfo/update.html" method="post">
			<div class="main_page">
				<div class="main_con">
					<div class="position">
						现在的位置:
						<!--<a href="#">业务列表</a>-->
						>>
						<a href="#">
							<c:if test="${customerinfo.CUSTOMER_TYPE eq '1'}">企业信息</c:if>
							<c:if test="${customerinfo.CUSTOMER_TYPE eq '2'}">个人信息</c:if>
						</a>
						<font color="red">${msg}</font>
					</div>
					<!--列表内容 -->
					<input type="hidden" name="CUSTOMER_BASIC_ID"
						value="${customerinfo.CUSTOMER_BASIC_ID}">
					<input type="hidden" name="CUSTOMER_TYPE"
						value="${customerinfo.CUSTOMER_TYPE}">
						<table class="table_style table_font_center" width="100%"
							border="0" cellspacing="0" cellpadding="0">
							<c:if test="${customerinfo.CUSTOMER_TYPE eq '1'}">
							<tr>
								<td height="30" colspan="4">
									<h2>公司信息</h2>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司名：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="UNIT_NAME" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司名."
											value="${customerinfo.UNIT_NAME}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司规模：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="SCALE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司规模."
											value="${customerinfo.SCALE}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司性质：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="PROPERTY_ID" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司性质."
											value="${customerinfo.PROPERTY_ID}" />
									</div>
								</td>
								
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司人数：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="EMPLOYEES" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司人数."
											value="${customerinfo.EMPLOYEES}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">产业类型：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select name="UNIT_TYPE">
											<option value="A"
												<c:if test="${customerinfo.UNIT_TYPE eq 'A'}">selected="selected"</c:if>>
												机关事业单位
											</option>
											<option value="B"
												<c:if test="${customerinfo.UNIT_TYPE eq 'B'}">selected="selected"</c:if>>
												国有企业
											</option>
											<option value="C"
												<c:if test="${customerinfo.UNIT_TYPE eq 'C'}">selected="selected"</c:if>>
												集体企业
											</option>
											<option value="D"
												<c:if test="${customerinfo.UNIT_TYPE eq 'D'}">selected="selected"</c:if>>
												有限责任公司
											</option>
											<option value="E"
												<c:if test="${customerinfo.UNIT_TYPE eq 'E'}">selected="selected"</c:if>>
												股份有限公司
											</option>
											<option value="F"
												<c:if test="${customerinfo.UNIT_TYPE eq 'F'}">selected="selected"</c:if>>
												私营企业
											</option>
											<option value="G"
												<c:if test="${customerinfo.UNIT_TYPE eq 'G'}">selected="selected"</c:if>>
												外商投资企业（含港、澳、台）
											</option>
											<option value="H"
												<c:if test="${customerinfo.UNIT_TYPE eq 'H'}">selected="selected"</c:if>>
												中外合资经营企业（含港、澳、台）
											</option>
											<option value="I"
												<c:if test="${customerinfo.UNIT_TYPE eq 'I'}">selected="selected"</c:if>>
												中外合作经营企业（含港、澳、台）
											</option>
											<option value="J"
												<c:if test="${customerinfo.UNIT_TYPE eq 'J'}">selected="selected"</c:if>>
												外资企业（含港、澳、台）
											</option>
											<option value="K"
												<c:if test="${customerinfo.UNIT_TYPE eq 'K'}">selected="selected"</c:if>>
												外商投资股份有限公司（含港、澳、台）
											</option>
											<option value="L"
												<c:if test="${customerinfo.UNIT_TYPE eq 'L'}">selected="selected"</c:if>>
												个体经营
											</option>
											<option value="M"
												<c:if test="${customerinfo.UNIT_TYPE eq 'M'}">selected="selected"</c:if>>
												其他
											</option>
										</select>
									</div>
								</td>
								
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司电话：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="UNIT_PHONE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司电话."
											value="${customerinfo.UNIT_PHONE}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">组织机构代码证：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="INDUST_NO" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入组织机构代码证."
											value="${customerinfo.INDUST_NO}" />
									</div>
								</td>
							
								<td height="30" width="12%">
									<div align="right" class="STYLE1">公司注册登记号：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REGISTER_NO" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司注册登记号."
											value="${customerinfo.REGISTER_NO}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">工商注册登记机关：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REGISTER_ORG" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入工商注册登记机关."
											value="${customerinfo.REGISTER_ORG}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">工商注册登记日期 ：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REGISTER_DATE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入工商注册登记日期 ."
											value="${customerinfo.REGISTER_DATE}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">国税税务登记号：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="COUNTRY_TAX_NO" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入国税税务登记号."
											value="${customerinfo.COUNTRY_TAX_NO}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">地税税务登记号 ：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="CITY_TAX_NO" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入地税税务登记号."
											value="${customerinfo.CITY_TAX_NO}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">开户行号：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="OPEN_BANK_ID" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入开户行号."
											value="${customerinfo.OPEN_BANK_ID}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">对公账号 ：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="CARD_NO" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入对公账号."
											value="${customerinfo.CARD_NO}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">预留手机号：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="BANK_RESERVE_PHONE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入预留手机号."
											value="${customerinfo.BANK_RESERVE_PHONE}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">合同号：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="CONTR_NBR" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入合同号."
											value="${customerinfo.CONTR_NBR}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										未结清贷款总额：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="TOTAL_LOAN"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入未结清贷款总额."
											value="${customerinfo.TOTAL_LOAN}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										月还贷金额：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="MONTH_REPAY"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入月还贷金额."
											value="${customerinfo.MONTH_REPAY}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">成立日期：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="FOUNDED_DATE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入成立日期."
											value="${customerinfo.FOUNDED_DATE}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">实际控制人：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REAL_GOVERN" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入实际控制人."
											value="${customerinfo.REAL_GOVERN}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">营业执照号：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="BUSINESS_LICENSE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入营业执照号."
											value="${customerinfo.BUSINESS_LICENSE}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">注册资本：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REGISTERED_CAPITAL" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入注册资本."
											value="${customerinfo.REGISTERED_CAPITAL}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">营业执照截止日期 ：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="BUSINESS_DATE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入营业执照截止日期."
											value="${customerinfo.BUSINESS_DATE}" />
									</div>
								</td>
								
								<td height="30" width="10%">
									<div align="right" class="STYLE1">经营范围 ：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="BUSIAREA" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入经营范围."
											value="${customerinfo.BUSIAREA}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司注册地址：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REGIST_ADDRESS" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司注册地址."
											value="${customerinfo.REGIST_ADDRESS}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司通讯地址：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="REAL_ADDRESS" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司通讯地址."
											value="${customerinfo.REAL_ADDRESS}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司邮政编码：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="POST_CODE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司邮政编码."
											value="${customerinfo.POST_CODE}" />
									</div>
								</td>
							
								<td height="30" width="10%">
									<div align="right" class="STYLE1">联系人：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="LINK_MAN" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入联系人."
											value="${customerinfo.LINK_MAN}" />
									</div>
								</td>
							</tr>
							
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司邮箱：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="COMPANY_EMAIL"
											value="${customerinfo.COMPANY_EMAIL}"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司email."
											data-validator-email="email格式不对." />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司传真：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="FAX" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司传真."
											value="${customerinfo.FAX}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">公司网址：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="WEB_URL" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司网址."
											value="${customerinfo.WEB_URL}" />
									</div>
								</td>
									<td height="30" width="10%">
									<div align="right" class="STYLE1">场地面积：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="FLOOR_SPACE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入场地面积."
											value="${customerinfo.FLOOR_SPACE}" />
									</div>
								</td>
							</tr>
								<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">年营业额：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="ANNUAL_TURNOVER" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入公司年营业额."
											value="${customerinfo.ANNUAL_TURNOVER}" />
									</div>
								</td>
								<td height="30" width="10%" colspan="2"></td>
							</tr>
							<tr>
								<td height="30" colspan="4">
									<h2>法人信息</h2>
								</td>
							</tr>
							</c:if>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">姓名：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px; display: none"
											name="NAME" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入用户名."
											value="${userSession.userRealname}" />
										${userSession.userRealname}
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">性别：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input type="radio" disabled="disabled" value="F"
											<c:if test="${customerinfo.GENDER eq 'F'}">checked="checked"</c:if> />
										女&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="radio" disabled="disabled" value="M"
											<c:if test="${customerinfo.GENDER eq 'M'}">checked="checked"</c:if> />
										男
										<input name="GENDER" value="${customerinfo.GENDER}"
											type="hidden">
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">民族：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="CORPORATION_NATION" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入民族."
											value="${customerinfo.CORPORATION_NATION}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">籍贯：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="CORPORATION_NATIVE" data-validator-group="customValidatorGroupName"
											data-validator-required="请输入籍贯."
											value="${customerinfo.CORPORATION_NATIVE}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										婚姻状况：
									</div>
								</td>
								<td colspan="3">
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select name="MARRAGE_STATUS">
											<option value="B" <c:if test="${customerinfo.MARRAGE_STATUS eq 'B'}">selected="selected"</c:if>>未婚</option>
											<option value="A" <c:if test="${customerinfo.MARRAGE_STATUS eq 'A'}">selected="selected"</c:if>>已婚</option>
											<option value="C" <c:if test="${customerinfo.MARRAGE_STATUS eq 'C'}">selected="selected"</c:if>>其他</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										证件类型：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select disabled="disabled">
											<option value="I"
												<c:if test="${customerinfo.ID_TYPE eq 'I'}">selected="selected"</c:if>>
												身份证
											</option>
										</select>
										<input name="ID_TYPE" value="${customerinfo.ID_TYPE}"
											type="hidden">
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										证件号码：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px; display: none"
											name="ID_NO" value="${customerinfo.ID_NO}" />
										${customerinfo.ID_NO}
									</div>	
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">邮箱：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="EMAIL"
											value="${customerinfo.EMAIL}"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入email."
											data-validator-email="email格式不对." />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										省份：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="STATE" 
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入省份."
											value="${customerinfo.STATE}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										城市：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="CITY"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入城市."
											value="${customerinfo.CITY}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										区县：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="DISTRICT"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入区县."
											value="${customerinfo.DISTRICT}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										地址：
									</div>
								</td>
								<td colspan="3">
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 580px" name="ADDRESS"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入地址."
											value="${customerinfo.ADDRESS}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										手机号码：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="MOBILE_NO"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入手机号码."
											value="${customerinfo.MOBILE_NO}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										岗位：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="POST"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入岗位."
											value="${customerinfo.POST}" />
									</div>
								</td>
							</tr>
							<c:if test="${customerinfo.CUSTOMER_TYPE eq '2'}">
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										单位名称：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="UNIT_NAME"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入单位名称."
											value="${customerinfo.UNIT_NAME}" />
									</div>
								</td>
								
								<td height="30" width="10%">
									<div align="right" class="STYLE1">单位类型：</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select name="UNIT_TYPE">
											<option value="A"
												<c:if test="${customerinfo.UNIT_TYPE eq 'A'}">selected="selected"</c:if>>
												机关事业单位
											</option>
											<option value="B"
												<c:if test="${customerinfo.UNIT_TYPE eq 'B'}">selected="selected"</c:if>>
												国有企业
											</option>
											<option value="C"
												<c:if test="${customerinfo.UNIT_TYPE eq 'C'}">selected="selected"</c:if>>
												集体企业
											</option>
											<option value="D"
												<c:if test="${customerinfo.UNIT_TYPE eq 'D'}">selected="selected"</c:if>>
												有限责任公司
											</option>
											<option value="E"
												<c:if test="${customerinfo.UNIT_TYPE eq 'E'}">selected="selected"</c:if>>
												股份有限公司
											</option>
											<option value="F"
												<c:if test="${customerinfo.UNIT_TYPE eq 'F'}">selected="selected"</c:if>>
												私营企业
											</option>
											<option value="G"
												<c:if test="${customerinfo.UNIT_TYPE eq 'G'}">selected="selected"</c:if>>
												外商投资企业（含港、澳、台）
											</option>
											<option value="H"
												<c:if test="${customerinfo.UNIT_TYPE eq 'H'}">selected="selected"</c:if>>
												中外合资经营企业（含港、澳、台）
											</option>
											<option value="I"
												<c:if test="${customerinfo.UNIT_TYPE eq 'I'}">selected="selected"</c:if>>
												中外合作经营企业（含港、澳、台）
											</option>
											<option value="J"
												<c:if test="${customerinfo.UNIT_TYPE eq 'J'}">selected="selected"</c:if>>
												外资企业（含港、澳、台）
											</option>
											<option value="K"
												<c:if test="${customerinfo.UNIT_TYPE eq 'K'}">selected="selected"</c:if>>
												外商投资股份有限公司（含港、澳、台）
											</option>
											<option value="L"
												<c:if test="${customerinfo.UNIT_TYPE eq 'L'}">selected="selected"</c:if>>
												个体经营
											</option>
											<option value="M"
												<c:if test="${customerinfo.UNIT_TYPE eq 'M'}">selected="selected"</c:if>>
												其他
											</option>
										</select>
									</div>
								</td>
							</tr>
							
							<tr>
								
								<td height="30" width="10%">
									<div align="right" class="STYLE1">单位电话：</div>
								</td>
								<td colspan="3">
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px;"
											name="UNIT_PHONE" 
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入单位电话."
											value="${customerinfo.UNIT_PHONE}" />
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										未结清贷款总额：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="TOTAL_LOAN"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入未结清贷款总额."
											value="${customerinfo.TOTAL_LOAN}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										月还贷金额：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="MONTH_REPAY"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入月还贷金额."
											value="${customerinfo.MONTH_REPAY}" />
									</div>
								</td>
							</tr>
							</c:if>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										任职部门：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="DEPARTMENT"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入任职部门."
											value="${customerinfo.DEPARTMENT}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										专业：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select name="PROFESSION">
											<option value="A"
												<c:if test="${customerinfo.PROFESSION eq 'A'}">selected="selected"</c:if>>
												行政机构，企事业单位负责人或高管
											</option>
											<option value="B"
												<c:if test="${customerinfo.PROFESSION eq 'B'}">selected="selected"</c:if>>
												行政机构，企事业单位管理人员
											</option>
											<option value="C"
												<c:if test="${customerinfo.PROFESSION eq 'C'}">selected="selected"</c:if>>
												专业技术人才
											</option>
											<option value="D"
												<c:if test="${customerinfo.PROFESSION eq 'D'}">selected="selected"</c:if>>
												经济，金融，法律，教育从业人员
											</option>
											<option value="E"
												<c:if test="${customerinfo.PROFESSION eq 'E'}">selected="selected"</c:if>>
												公务员、行政机构办事人员和有关人员
											</option>
											<option value="F"
												<c:if test="${customerinfo.PROFESSION eq 'F'}">selected="selected"</c:if>>
												商业，服务业人员
											</option>
											<option value="G"
												<c:if test="${customerinfo.PROFESSION eq 'G'}">selected="selected"</c:if>>
												销售/中介/业务代表/促销
											</option>
											<option value="H"
												<c:if test="${customerinfo.PROFESSION eq 'H'}">selected="selected"</c:if>>
												保安/防损
											</option>
											<option value="I"
												<c:if test="${customerinfo.PROFESSION eq 'I'}">selected="selected"</c:if>>
												农，林，牧，渔，水利业生成人员
											</option>
											<option value="J"
												<c:if test="${customerinfo.PROFESSION eq 'J'}">selected="selected"</c:if>>
												工人(生产，加工，运输设备操作人员)
											</option>
											<option value="K"
												<c:if test="${customerinfo.PROFESSION eq 'K'}">selected="selected"</c:if>>
												军人
											</option>
											<option value="L"
												<c:if test="${customerinfo.PROFESSION eq 'L'}">selected="selected"</c:if>>
												个体工商户
											</option>
											<option value="M"
												<c:if test="${customerinfo.PROFESSION eq 'M'}">selected="selected"</c:if>>
												其他
											</option>
									</div>
								</td>
							</tr>
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										工作年限：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="WORK_YEAR"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入工作年限."
											value="${customerinfo.WORK_YEAR}" />
										年
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										月收入：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="MONTH_AMT"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入月收入."
											value="${customerinfo.MONTH_AMT}" />
									</div>
								</td>
							</tr>
							
							<tr>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										住宅电话：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<input style="height: 20px; width: 200px" name="HOME_PHONE"
											data-validator-group="customValidatorGroupName"
											data-validator-required="请输入住宅电话."
											value="${customerinfo.HOME_PHONE}" />
									</div>
								</td>
								<td height="30" width="10%">
									<div align="right" class="STYLE1">
										学历：
									</div>
								</td>
								<td>
									<div align="left" class="STYLE1" style="padding-left: 10px;">
										<select name="EDUCATION">
											<option value="A"
												<c:if test="${customerinfo.EDUCATION eq 'A'}">selected="selected"</c:if>>
												博士及其以上
											</option>
											<option value="B"
												<c:if test="${customerinfo.EDUCATION eq 'B'}">selected="selected"</c:if>>
												硕士
											</option>
											<option value="C"
												<c:if test="${customerinfo.EDUCATION eq 'C'}">selected="selected"</c:if>>
												大学本科
											</option>
											<option value="D"
												<c:if test="${customerinfo.EDUCATION eq 'D'}">selected="selected"</c:if>>
												大学专科/专科学校
											</option>
											<option value="E"
												<c:if test="${customerinfo.EDUCATION eq 'E'}">selected="selected"</c:if>>
												高中/中专/技校
											</option>
											<option value="F"
												<c:if test="${customerinfo.EDUCATION eq 'F'}">selected="selected"</c:if>>
												初中
											</option>
											<option value="G"
												<c:if test="${customerinfo.EDUCATION eq 'G'}">selected="selected"</c:if>>
												初中以下
											</option>
										</select>
									</div>
								</td>
							</tr>
							<tr>
								<td colspan="4" style="padding: 10px">
									<div align="center">
										<input type="button" value="上传附件" class="btn" onclick="upload()"/> 
					<input type="submit" value="保存" class="btn" onclick="return validate('customValidatorGroupName');"/> 
					<input id="backBt" type="button" value="　返　回　" class="btn" onclick="javascript:window.location.href='javascript:history.go(-1)'" />
				</div>
			</td>
		</tr>
</tbody>
</table>
</div>
</div>
</form>
</body>
<script type="text/javascript">
		function upload(){ 
			window.location.href='${pageContext.servletContext.contextPath }/background/system/order/gotouploadfile.html';
		}
		     
	</script>
</html>