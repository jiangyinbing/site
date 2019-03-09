package com.hb.framework.superhelp.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Decoder;




/**
 * 
 * 文件工具类
 * 负责处理文件的拷贝、上传、下载
 * @author h
 * @version 1.0 
 * 
 */
public class FileUtil {

	/**
	 * Method 递规创建文件夹
	 * @param folderPath
	 * @param targetPath
	 * @return String
	 */
	public static String createFolders(String folderPath, String targetPath) {
		String txts = targetPath;
		try {
			String txt = "";
			StringTokenizer st = new StringTokenizer(folderPath, "/");
			for (int i = 0; st.hasMoreTokens(); i++) {
				txt = st.nextToken().trim();
				txts = createFolder(txts + "/" + txt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txts;
	}

	/**
	 * Method 递规创建文件夹
	 * @param folderPath
	 * @return String
	 */
	private static String createFolder(String folderPath) {
		String txt = folderPath;
		try {
			File file = new File(txt);
			txt = folderPath;
			if (!file.exists()) {
				file.mkdir();
			}
			file = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}
	
	/**
	 * 获取文件扩展名
	 * @param fileName
	 * @return
	 */
	public String getExtendFileName(String fileName) {
		int i = fileName.lastIndexOf(".");
		String extName = "";//文件扩展名
		if (i > 0) {
			extName = fileName.substring(i + 1).trim().toLowerCase();
		}
		return extName;
	}

	/**
	 * 获取文件名(不含扩展名)
	 * @param fileName
	 * @return
	 */
	public String getMainFileName(String fileName) {
		int i =  fileName.lastIndexOf(".");
		String name = "";
		if (i > 0) {
			name = fileName.substring(0, i).trim();
		}
		return name;
	}

	/**
	 * 文件拷贝
	 * @param sourFileName 源文件(含文件和路径)
	 * @param descFileName 目标文件(含文件和路径)
	 * @return
	 */
	public boolean copyFile(String sourFileName, String descFileName) {
		File sourFile = new File(sourFileName);
		File descFile = new File(descFileName);
		if (sourFile.exists()) {
			if (descFile.exists()){
				descFile.delete();//如果目标文件存在,删除目标文件
			}
			FileInputStream in = null;
			FileOutputStream out = null;
			try {
				in = new FileInputStream(sourFile);
				out = new FileOutputStream(descFile);
				byte[] bytes = new byte[1024];
				int c;
				while ((c = in.read(bytes)) != -1) {
					out.write(bytes, 0, c);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}finally{
				try {
					if(in!= null){
						in.close();
					}
					if(out!=null){
						out.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	/**
	 * 文件上传
	 * @param fileObject 要上传的文件对象
	 * @param uploadTime 上传时间
	 * @param multipartFile 要上传的文件对象（通过spring mvc模式上传的文件对象，fileObject和multipartFile二选一，其中一个为空）
	 * @param fileName 要上传的文件名(不含路径，只有文件名称)
	 * @param fileType 文件类型(person：个人信息附件;image：影像信息附件;archive：档案附件;business：业务附件)
	 * @param request 请求对象
	 * @return 保存后的文件目录
	 */
	public String uploadFile(String filedata, Date uploadTime, MultipartFile multipartFile, String fileName,String fileType,HttpServletRequest request) {
		if ((filedata == null && multipartFile == null) || (filedata != null && multipartFile != null)) {
			return null;
		}
		//保存真实路径
		String upload_file_dir = request.getSession().getServletContext().getRealPath("/upload_file_dir");
		//String upload_file_dir = "../upload_file_dir";//本机系统目录路径
		//String upload_file_dir = "../../../../upload_file_dir";//Linux保存根目录路径
		
		upload_file_dir += "/" + fileType; 
		
		
		//获取保存时间(年-月-日),用于创建目录
		String date = new SimpleDateFormat("yyyy-MM-dd").format(uploadTime);
		//创建目录
		upload_file_dir += "/" + date;
		System.out.println("保存路径"+upload_file_dir);
		File dateDir = new File(upload_file_dir);
		if (!dateDir.exists()) {
			dateDir.mkdirs();//创建目录(含多级目录)
		}
		String saveFileName = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			if(multipartFile != null){
				is = multipartFile.getInputStream();
			}else if(filedata != null){
				BASE64Decoder decoder = new BASE64Decoder(); 
			    byte[] b = decoder.decodeBuffer(filedata);  
				InputStream sbs = new ByteArrayInputStream(b); 
				is = sbs;
			}
		
			//获取保存时间
			String currentTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss").format(uploadTime);
			//构造新的文件名
			//String rebuildFileName = currentTime+"_"+CharacterUtils.getRandomInteger(1000) + CharacterUtils.getSuffix(fileName);
			String rebuildFileName = currentTime+fileName;
			//构造要上传的文件
			File toFile = new File(upload_file_dir, rebuildFileName);
			os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			saveFileName = date + "/" + rebuildFileName;
			saveFileName = saveFileName.replace('\\', '/');
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String dir = "upload_file_dir"+ "/" + fileType + "/" + date;
		return dir;
	}
	
	/**
	 * 文件上传
	 * @param fileObject 要上传的文件对象
	 * @param multipartFile 要上传的文件对象（通过spring mvc模式上传的文件对象，fileObject和multipartFile二选一，其中一个为空）
	 * @param fileName 要上传的文件名(不含路径，只有文件名称)
	 * @param fileType 文件类型(archive：档案附件;business：业务附件)
	 * @param request 请求对象
	 * @return 保存后的文件名(经过处理的文件名)
	 */
	public String uploadFile2(File fileObject, FileInputStream fis, String fileName,String fileType,HttpServletRequest request) {
	
		String upload_file_dir = request.getSession().getServletContext().getRealPath("/upload_file_dir");
		
		upload_file_dir += "/" + fileType; 
		
		//获取时间(年-月-日),用于创建目录
		String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		//创建目录
		upload_file_dir += "/" + date;
		File dateDir = new File(upload_file_dir);
		if (!dateDir.exists()) {
			dateDir.mkdirs();//创建目录(含多级目录)
		}
		String saveFileName = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			if(fis != null){
				is = fis;
			}else if(fileObject != null){
				is = new FileInputStream(fileObject);
			}
		
			//获取当前时间
			String currentTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss").format(new Date());
			//构造新的文件名
			String rebuildFileName = currentTime+"_"+CharacterUtils.getRandomInteger(1000) + CharacterUtils.getSuffix(fileName);
			//构造要上传的文件
			File toFile = new File(upload_file_dir, rebuildFileName);
			os = new FileOutputStream(toFile);
			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
			saveFileName = date + "/" + rebuildFileName;
			saveFileName = saveFileName.replace('\\', '/');
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return saveFileName;
	}
	
	/**
	 * 文件下载
	 * @param fileName 文件名称(不含路径，如：说明.txt)
	 * @param filePath 文件路径(含文件名称，如：d:/2014/说明.txt)
	 * @param request 请求对象
	 * @param response 响应对象
	 */
	@SuppressWarnings("null")
	public void download(String fileName,String filePath,InputStream filedata,HttpServletRequest request,HttpServletResponse response){

		//文件输入流对象
		InputStream inStream = null;
		OutputStream os = null;
		String type = "application/x-msdownload";
		//文件扩展名
		String extendName = "."+getExtendFileName(fileName);
		//判断是否有后缀名
		if (!extendName.equals("")) {
			if (extendName.equalsIgnoreCase(".pdf")) {
				type = "application/pdf";
			} else if (extendName.equalsIgnoreCase(".doc") || extendName.equalsIgnoreCase(".docx")) {
				type = "application/x-word";
			} else if (extendName.equalsIgnoreCase(".xls") || extendName.equalsIgnoreCase(".xlsx")) {
				type = "application/vnd.ms-excel";
			} else if (extendName.equalsIgnoreCase(".bmp")) {
				type = "image/bmp";
			} else if (extendName.equalsIgnoreCase(".gif")) {
				type = "image/gif";
			} else if (extendName.equalsIgnoreCase(".jpe")|| extendName.equalsIgnoreCase(".jpeg")|| extendName.equalsIgnoreCase(".jpg")) {
				type = "image/jpeg";
			} else if (extendName.equalsIgnoreCase(".png")) {
				type = "image/png";
			} else if (extendName.equalsIgnoreCase(".txt")) {
				type = "text/plain";
			} else if (extendName.equalsIgnoreCase(".wps")) {
				type = "application/x-word";
			} else {
				type = "application/x-msdownload";
			}
		}
		try {
			//缓冲区大小
			int bufferSize = 1024;
			if(filedata!=null){//判断文件是否存在
				inStream = filedata;
				
				if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
					//firefox浏览器
					fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
				}else{
					if(request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0){
						//IE浏览器
						fileName = URLEncoder.encode(fileName, "UTF-8");
					}else{//谷歌浏览器
						fileName = URLEncoder.encode(fileName, "UTF-8");
					}
				}  
				response.reset();
				//设置文件内容类型
				response.setContentType(type);
				response.setHeader("Location",fileName);
				response.setHeader("Cache-Control", "max-age=0" );
				//online用于页面打开文件;attachment则下载附件 
				response.setHeader("Content-Disposition","attachment; filename="+ fileName );
				os = response.getOutputStream();
				int c;
		        while((c=inStream.read())!=-1)
		        {
		        	os.write(c);
		        }
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 在线预览文件
	 * 下载与在线预览的区别是设置不同的响应头时
	 * online用于页面打开文件;attachment则下载附件
	 * response.setHeader("Content-Disposition","online; filename=" + fileName);
	 * @param fileName 文件名称(不含路径，如：说明.txt)
	 * @param filePath 文件路径(含文件名称，如：d:/2014/说明.txt)
	 * @param request 请求对象
	 * @param response 响应对象
	 */
	public void readOnLine(String fileName,String filePath,HttpServletRequest request,HttpServletResponse response){
		if(fileName==null || filePath==null){
			return;
		}
		//文件输入流对象
		FileInputStream inStream = null;
		OutputStream os = null;
		String type = "application/x-msdownload";
		//文件扩展名
		String extendName = "."+getExtendFileName(fileName);
		//判断是否有后缀名
		if (!extendName.equals("")) {
			if (extendName.equalsIgnoreCase(".pdf")) {
				type = "application/pdf";
			} else if (extendName.equalsIgnoreCase(".doc") || extendName.equalsIgnoreCase(".docx")) {
				type = "application/x-word";
			} else if (extendName.equalsIgnoreCase(".xls") || extendName.equalsIgnoreCase(".xlsx")) {
				type = "application/vnd.ms-excel";
			} else if (extendName.equalsIgnoreCase(".bmp")) {
				type = "image/bmp";
			} else if (extendName.equalsIgnoreCase(".gif")) {
				type = "image/gif";
			} else if (extendName.equalsIgnoreCase(".jpe")|| extendName.equalsIgnoreCase(".jpeg")|| extendName.equalsIgnoreCase(".jpg")) {
				type = "image/jpeg";
			} else if (extendName.equalsIgnoreCase(".png")) {
				type = "image/png";
			} else if (extendName.equalsIgnoreCase(".txt")) {
				type = "text/plain";
			} else {
				type = "application/x-msdownload";
			}
		}
		try {
			//缓冲区大小
			int bufferSize = 1024;
			File file = new File(filePath);
			if(file!=null && file.exists()){//判断文件是否存在
				inStream = new FileInputStream(file);
				//文件长度
				long len = file.length();
				if (len == 0) {
					len = 1;
				}
				byte buffer[] = new byte[bufferSize];
				if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0){
					//firefox浏览器
					fileName = new String(fileName.getBytes("UTF-8"), "ISO8859-1");
				}else{
					if(request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0){
						//IE浏览器
						fileName = URLEncoder.encode(fileName, "UTF-8");
					}else{//谷歌浏览器
						fileName = URLEncoder.encode(fileName, "UTF-8");
					}
				}  
				response.reset();
				//设置文件内容类型
				response.setContentType(type);
				response.setHeader("Location",fileName);
				response.setHeader("Cache-Control", "max-age=0" );
				//注意：online用于页面打开文件;attachment则下载附件
				response.setHeader("Content-Disposition","online; filename=" + fileName);
				os = response.getOutputStream();
				int k = 0;
				while (k < len) {
					//已读部分
					int redLen = inStream.read(buffer, 0, bufferSize);
					k += redLen;
					if (redLen == -1) {
						os.write(buffer, 0, 1);
						k = 1;
					} else{
						os.write(buffer, 0, redLen);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
				}
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 删除文件夹里子文件
	 * @param foldName 文件夹名称
	 * @return
	 */
	public boolean deleteChildFile(String foldName) {
		File foldFile = new File(foldName);
		File[] fileList = foldFile.listFiles();
		try {
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isDirectory()) { // 如果是文件夹,则递归
					String str = fileList[i].getPath() + "/" + fileList[i].getName();
					deleteFold(str); //递归
				} else { //如果是文件
					fileList[i].delete();
				}
			}
			//foldFile.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 删除文件夹 
	 * @param fileName 要删除的文件夹名称
	 * @return
	 */
	public boolean deleteFold(String fileName) {
		File foldFile = new File(fileName);
		File[] fileList = foldFile.listFiles();
		try {
			for (int i = 0; i < fileList.length; i++) {
				if (fileList[i].isDirectory()) { // 如果是文件夹,则递归
					String str = fileList[i].getPath() + "/" + fileList[i].getName();
					deleteFold(str); // 递归
				} else { // 如果是文件
					fileList[i].delete();
				}
			}
			foldFile.delete();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 删除文件
	 * 
	 * @return
	 */
	public boolean deleteFile(String filePath) {
		File file = new File(filePath);		
		try {			
			if (file.exists()) {
				file.delete();
			}			
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	
}
