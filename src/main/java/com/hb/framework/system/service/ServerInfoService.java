package com.hb.framework.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.dao.ServerInfoDao;
import com.hb.framework.system.entity.ServerInfo;
@Transactional
@Service("serverInfoService")
public class ServerInfoService{
	@Autowired
	private ServerInfoDao serverInfoDao;

	public void add(ServerInfo serverInfo) {
		serverInfoDao.add(serverInfo);
	}

	public void delete(String id) {
		serverInfoDao.delete(id);
	}

	public ServerInfo getById(String id) {
		return serverInfoDao.getById(id);
	}
	
	//编译指令
	public PageView query(PageView pageView, ServerInfo serverInfo) {
		List<ServerInfo> list = serverInfoDao.query(pageView, serverInfo);
		pageView.setRecords(list);
		return pageView;
	}
	
	public List<ServerInfo> queryAll(ServerInfo serverInfo) {
		return serverInfoDao.queryAll(serverInfo);
	}

	public void modify(ServerInfo serverInfo) {
		serverInfoDao.modify(serverInfo);
	}
	
}