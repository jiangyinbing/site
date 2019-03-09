package com.hb.framework.system.service;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hb.framework.superhelp.base.BusinessException;
import com.hb.framework.superhelp.util.ExcelHelp;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.dao.UserLoginListDao;
import com.hb.framework.system.entity.UserLoginList;
@Transactional
@Service("userLoginListService")
public class UserLoginListService{
	@Autowired
	private UserLoginListDao userLoginListDao;
	public List<Map<String, Object>> getMap( ){
		return userLoginListDao.getMap();
	}
	public PageView query(PageView pageView, UserLoginList userLoginList) {
		List<UserLoginList> list = userLoginListDao.query(pageView, userLoginList);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(UserLoginList userLoginList) {
		userLoginListDao.add(userLoginList);
	}

    public void exportExcel(String fileName, ServletOutputStream outputStream,PageView pageView, UserLoginList userLoginList)throws BusinessException {  
    	List<UserLoginList> list = userLoginListDao.query(pageView, userLoginList);
    	ExcelHelp<UserLoginList> ex = new ExcelHelp<UserLoginList>(UserLoginList.class);
        try {
			ex.exportExcel(fileName, list, outputStream);
		} catch (Exception e) {
			throw new BusinessException("文件格式不对或不存在！");
		}
    }

	public void readExcel(InputStream inputStream,String fileName) throws BusinessException {
    	ExcelHelp<UserLoginList> ex = new ExcelHelp<UserLoginList>(UserLoginList.class);
    	Collection<UserLoginList> list=null;
		try {
			list = ex.importExcel(inputStream,fileName,1,2);
		} catch (Exception e) {
			 throw new BusinessException("文件格式不对或不存在！");
		}
    	for (UserLoginList userLoginList : list) {
    		userLoginListDao.add(userLoginList);
		}
	} 

	
}
