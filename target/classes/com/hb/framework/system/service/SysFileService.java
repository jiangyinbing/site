package com.hb.framework.system.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.hb.framework.superhelp.base.BusinessException;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.superhelp.util.PropertiesUtils;
import com.hb.framework.system.dao.SysFileDao;
import com.hb.framework.system.entity.SysFile;

@Transactional
@Service("sysFileService")
public class SysFileService {
	private static final String UPLOADDIR = "uploadDir\\";
	private static final String CONTENTTYPE = "application/octet-stream";
	
	@Autowired
	private SysFileDao sysFileDao;
	
	public void add(SysFile file) {
		sysFileDao.add(file);
		
	}
	public PageView query(PageView pageView, SysFile file) {
		List<SysFile> list = sysFileDao.query(pageView, file);
		pageView.setRecords(list);
		return pageView;
	}
	public void delete(HttpServletRequest request,String id,String sysname,String dir) {
		//组装路径
       String uploadDir = request.getSession().getServletContext().getRealPath("/")+UPLOADDIR+dir+sysname;  
       File file = new File(uploadDir);  
       if (file.exists()) {  
           file.delete();  
       }
	   sysFileDao.delete(id);
	}

	public SysFile getById(String id) {
		return sysFileDao.getById(id);
	}

	public void modify(SysFile file) {
		sysFileDao.modify(file);
	}
	
	
	  /** 
	  * 上传文件（支持多个） 
	  * @param name HttpServletRequest request,
	  * Integer userid 上传者的id,
	  * Integer pid 所属者 id,
	  * Integer type 文件所属的模块,
	  * String dir 自定义上传服务器的目录 
	  * @return 
	  */ 
   public  void upload(HttpServletRequest request,Integer userid,Integer pid,Integer type,String dir)throws BusinessException{  
       //获取文件说明
       String [] params=ServletRequestUtils.getStringParameters(request,"alias");
       //获取文件
       MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;  
       Map<String, MultipartFile> fileMap = mRequest.getFileMap();  
       //组装路径
       String uploadDir = request.getSession().getServletContext().getRealPath("/")+UPLOADDIR+dir;  
       File file = new File(uploadDir);  
       if (!file.exists()) {  
           file.mkdirs();  
       }  
 
       String fileName = null;  
       int i = 0;  
       for (Iterator<Map.Entry<String, MultipartFile>> it = fileMap.entrySet().iterator(); it.hasNext(); i++) {  
           Map.Entry<String, MultipartFile> entry = it.next();  
           MultipartFile mFile = entry.getValue();  
           fileName = mFile.getOriginalFilename();  
           String storeName = Common.rename(fileName);  
//           String noZipName = uploadDir + storeName;  
//           String zipName = zipName(noZipName);  
 
           // 上传成为压缩文件  
//           ZipOutputStream outputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipName)));  
//           outputStream.putNextEntry(new ZipEntry(fileName));  
           //上传到服务器
           try{
			 FileCopyUtils.copy(mFile.getInputStream(), new FileOutputStream(uploadDir+storeName));
		    }catch (Exception e) {
			 throw new BusinessException("文件不存在！");
		    } 
           SysFile sysfile=new SysFile();
           sysfile.setName(fileName);
           sysfile.setSysname(storeName);
           sysfile.setFiletype(fileName==null?"notype":fileName.substring(fileName.lastIndexOf("."),fileName.length()));
           sysfile.setUserid(userid);
           sysfile.setPid(pid);
           sysfile.setType(type);
           sysfile.setAlias(params[i]);
           sysFileDao.add(sysfile);
       }  
   }
   
   
   /** 
    * 下载 
    * @param request HttpServletRequest
    * @param response HttpServletResponse
    * @param storeName 服务器存储名称
    * @param contentType 内容类型
    * @param realName 文件真实名称
 * @throws BusinessException 
    * @throws Exception 
    */  
   public  void download(HttpServletRequest request,HttpServletResponse response, String sysname,String name,String dir) throws BusinessException{  
	       BufferedInputStream bis = null;  
	       BufferedOutputStream bos = null;  
	    try{
	       response.setContentType("text/html;charset=UTF-8");  
		   request.setCharacterEncoding("UTF-8");  
	       String ctxPath = request.getSession().getServletContext().getRealPath("/")+ UPLOADDIR+dir;  
	       String downLoadPath = ctxPath + sysname;
	       File file =new File(downLoadPath);
	       if (!file.exists()) {  
	    	   throw new Exception();
	       } 
	       long fileLength = file.length();  
	 
	       response.setContentType(CONTENTTYPE);  
	       response.setHeader("Content-disposition", "attachment; filename="+new String((name).getBytes(), "ISO8859_1"));  
	       response.setHeader("Content-Length", String.valueOf(fileLength));  
	 
	       bis = new BufferedInputStream(new FileInputStream(downLoadPath));  
	       bos = new BufferedOutputStream(response.getOutputStream());  
	       byte[] buff = new byte[2048];  
	       int bytesRead;  
	       while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {  
	           bos.write(buff, 0, bytesRead);  
	       }
	       bos.flush();
	       bis.close();  
	       bos.close();
	   }catch (Exception e) {
		  throw new BusinessException("文件："+name+"不存在！");
	   }finally{
		   bos=null;
		   bis=null;
	   }
   } 
	
   
	/**
	 * 
	 * @param request
	 * @param userid
	 */
	public void back(HttpServletRequest request,Integer userid)throws BusinessException{
		String username = PropertiesUtils.findPropertiesKey("mysql_username");
		String password = PropertiesUtils.findPropertiesKey("mysql_password");
		// 得到MYSQL的用户名密码后调用 mysql 的 cmd:
		String databaseName = PropertiesUtils.findPropertiesKey("mysql_databaseName");
		String dostype = PropertiesUtils.findPropertiesKey("hostype");
		String mysqlip = PropertiesUtils.findPropertiesKey("mysql_ip");
		String sqlpath =request.getSession().getServletContext().getRealPath("/")+UPLOADDIR+"Mysqlback\\";
		String sqlname = Common.rename("test.sql");
		File backupath = new File(sqlpath);
		if (!backupath.exists()) {
			backupath.mkdirs();
		}
		sqlpath=sqlpath+sqlname;
		StringBuffer sb = new StringBuffer();
		sb.append("mysqldump -h");
		sb.append(mysqlip);
		sb.append(" --user=");
		sb.append(username);
		sb.append(" --password=");
		sb.append(password).append(" --opt ");
		sb.append(databaseName);
		sb.append(">");
		sb.append(sqlpath);
		try {
			if("1".equals(dostype)){
			 Runtime.getRuntime().exec("cmd /c "+sb.toString());
			}else{
		     Runtime.getRuntime().exec(new String[] { "sh", "-c", sb.toString() });
			}
			SysFile sysfile=new SysFile();
	           sysfile.setName(sqlname);
	           sysfile.setSysname(sqlname);
	           sysfile.setFiletype(sqlname==null?"notype":sqlname.substring(sqlname.lastIndexOf("."),sqlname.length()));
	           sysfile.setUserid(userid);
	           sysfile.setPid(1);
	           sysfile.setType(100);
	           sysfile.setAlias("MySQL备份");
	           sysFileDao.add(sysfile);
		} catch (IOException e) {
			throw new BusinessException("备份失败");
		}
	}

	public  void regain(HttpServletRequest request,String sqlname) throws BusinessException {
		String username = PropertiesUtils.findPropertiesKey("mysql_username");
		String password = PropertiesUtils.findPropertiesKey("mysql_password");
		// 得到MYSQL的用户名密码后调用 mysql 的 cmd:
		String databaseName = PropertiesUtils.findPropertiesKey("mysql_databaseName");
		String dostype = PropertiesUtils.findPropertiesKey("hostype");
		String mysqlip = PropertiesUtils.findPropertiesKey("mysql_ip");
		String sqlpath =request.getSession().getServletContext().getRealPath("/")+UPLOADDIR+"Mysqlback\\";
		sqlpath=sqlpath+sqlname;
		StringBuffer sb = new StringBuffer();
		sb.append("mysql -h");
		sb.append(mysqlip);
		sb.append(" --user=");
		sb.append(username);
		sb.append(" -p");
		sb.append(password).append(" ");
		sb.append(databaseName);
		sb.append("<");
		sb.append(sqlpath);
		try {
			if("1".equals(dostype)){
			 Runtime.getRuntime().exec("cmd /c "+sb.toString());
			}else{
		     Runtime.getRuntime().exec(new String[] { "sh", "-c", sb.toString() });
			}
		} catch (IOException e) {
			throw new BusinessException("恢复失败");
		}

	}
}

