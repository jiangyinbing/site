package com.hb.framework.business.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.hb.framework.business.entity.AttachmentType;
import com.hb.framework.business.entity.CustomerInfo;
import com.hb.framework.business.entity.Order;
import com.hb.framework.business.entity.UploadFileInfo;
import com.hb.framework.business.service.CustomerInfoService;
import com.hb.framework.business.service.OrderService;
import com.hb.framework.business.service.SignOnService;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.FileUtil;
import com.hb.framework.system.entity.User;

/**订单
 * @author sjl
 *
 */
@Controller
@RequestMapping("/background/biz/signOn")
public class SignOnController {
	
	@Autowired
	private SignOnService signOnService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerInfoService customerInfoService;
	private String msg;
	
	
	
	/**跳转到查询订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/list")
	public String gotoOrderList(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("userSession");
		request.setAttribute("customerType", user.getCustomerType());
		return "/background/system/signOn/signOnlist";
	}
	
	/**查询订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/query",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String queryOrder(HttpServletRequest request ,String pageNow, Model model){
		if (Common.isEmpty(pageNow)) {
			pageNow="1";
		} 
		int currpage = Integer.parseInt(pageNow);
		if(currpage<=0){
			currpage=1;
		}
		User user = (User) request.getSession().getAttribute("userSession");
		String phone = user.getUserName();
		String idCard = user.getIdNo();
		
		String callback = signOnService.querySignOn(phone, idCard, (currpage-1)*10+"", currpage*10-1+"");
		System.out.println(callback);
 		return callback;
	}

	/**确认订单
	 * @param order
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/confirmOrder",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String confirmOrder(Order order,HttpServletRequest request){	
		String response = orderService.confirmOrder(order, request);
		return response;
	}
	
	/**撤销订单
	 * @param order
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/cancelOrder",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String cancelOrder(Order order){	
		String response = orderService.cancelOrder(order);
		return response;
	}
	
	
	/**增加基础信息
	 * @param addpersonimg
	 * @throws Exception 
	 *//*
	@RequestMapping(value="/addpersonimg")
	@ResponseBody
	public String addpersonimg(HttpServletRequest request,@RequestParam("upload") MultipartFile upload, String id,String title) throws Exception{
		System.out.println("##########"+upload.getOriginalFilename()+id);
		
		byte[] in_b = new byte[1024];
		String filedata = "";
		InputStream is = null;
		try {
		
			is = upload.getInputStream();
			
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
			byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据 
			int rc = 0; 
			while ((rc = is.read(buff, 0, 100)) > 0) { 
				swapStream.write(buff, 0, rc); 
			} 
			in_b = swapStream.toByteArray(); //in_b为转换之后的结果 
			BASE64Encoder encoder = new BASE64Encoder();
			filedata = encoder.encode(in_b);
		
		}catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
			try {
				if (is != null) {
					is.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//获得文件名 name
		String name = upload.getOriginalFilename();
		//获取保存时间
		Date date = new Date();
		
		UploadFileInfo info = new UploadFileInfo();
		User user = (User) request.getSession().getAttribute("userSession");
		info.setCustomer_id(user.getUserId());
		//文件名称为保存时间加后缀名
		info.setOrder_id(id);
		
		info.setUpload_time(date);
		System.out.println("标题1："+title);
		title = java.net.URLDecoder.decode(title,"UTF-8");
		System.out.println("标题2："+title);
		info.setTitle(title);
		
		
		info.setUpload_file(filedata);
		info.setUpload_file_name(name);
		
        info.setType("uploadperson");
        String callback = orderService.uploadFile(info);
        
        return callback;  
        
	}*/
	/**增加基础信息
	 * @param addpersonimg
	 * @throws Exception 
	 */
	@RequestMapping(value="/addpersonimg")
	@ResponseBody
	public String addpersonimg(HttpServletRequest request,@RequestParam("upload") MultipartFile upload, String id,String title) throws Exception{
		System.out.println("##########"+upload.getOriginalFilename()+id);
		
		//获得文件名 name
		String name = upload.getOriginalFilename();
		String[] newname = name.split("\\.");
		int sum = newname.length;
		//获取保存时间
		Date date = new Date();
		
		FileUtil fileUtil = new FileUtil();
		
		String filepath = fileUtil.uploadFile(null, date, upload, "."+newname[sum-1], "person", request);
		
		UploadFileInfo info = new UploadFileInfo();
		User user = (User) request.getSession().getAttribute("userSession");
		info.setCustomer_id(user.getUserId());
		//文件名称为保存时间加后缀名
		
		info.setUpload_time(date);
		System.out.println("标题1："+title);
		title = java.net.URLDecoder.decode(title,"UTF-8");
		System.out.println("标题2："+title);
		info.setTitle(title);
		
		info.setUpload_file_dir(filepath);
		String currentTime = new SimpleDateFormat("yyyyMMdd-HH-mm-ss").format(date);
		
		info.setUpload_file_name(currentTime+"."+newname[sum-1]);
		
        info.setType(AttachmentType.P);
        String callback = orderService.uploadFile(info);
        
        return callback;  
        
	}
	
	/**增加影像信息
	 * @param addpimg
	 * @throws Exception 
	 *//*
	@RequestMapping(value="/addimg")
	@ResponseBody
	public String addimg(HttpServletRequest request,@RequestParam("upload") MultipartFile upload_img, String id,String title) throws Exception{
System.out.println("##########"+upload_img.getOriginalFilename()+id);
		
		byte[] in_b = new byte[1024];
		String filedata = "";
		InputStream is = null;
		try {
		
			is = upload_img.getInputStream();
			
			ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
			byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据 
			int rc = 0; 
			while ((rc = is.read(buff, 0, 100)) > 0) { 
				swapStream.write(buff, 0, rc); 
			} 
			in_b = swapStream.toByteArray(); //in_b为转换之后的结果 
			BASE64Encoder encoder = new BASE64Encoder();
			filedata = encoder.encode(in_b);
		
		}catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
			try {
				if (is != null) {
					is.close();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//获得文件名 name
		String name = upload_img.getOriginalFilename();
		//获取保存时间
		Date date = new Date();
		
		UploadFileInfo info = new UploadFileInfo();
		User user = (User) request.getSession().getAttribute("userSession");
		info.setCustomer_id(user.getUserId());
		//文件名称为保存时间加后缀名
		info.setOrder_id(id);
		
		info.setUpload_time(date);
		System.out.println("标题1："+title);
		title = java.net.URLDecoder.decode(title,"UTF-8");
		System.out.println("标题2："+title);
		info.setTitle(title);
		
		
		info.setUpload_file(filedata);
		info.setUpload_file_name(name);
		
        info.setType("uploadimg");
        String callback = orderService.uploadFile(info);
        
        return callback;  
        
        
	}*/
	

}
