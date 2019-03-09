package com.hb.framework.business.controller;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.hb.framework.business.service.UserLimitService;
import com.hb.framework.superhelp.util.Common;
import com.hb.framework.superhelp.util.FileUtil;
import com.hb.framework.superhelp.util.PageIndex;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.User;
import com.hb.framework.system.entity.UserLimit;

/**订单
 * @author sjl
 *
 */
@Controller
@RequestMapping("/background/system/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private CustomerInfoService customerInfoService;
	private String msg;
	
	
	@Autowired 
	private UserLimitService userLimitService;
	
	
	

	/**创建订单
	 * @param order
	 * @return
	 * @throws JSONException 
	 */
	@RequestMapping(value="/mkorder",produces="text/plain;charset=utf-8")
	public String makeOrder(Order order,HttpServletRequest request, Model model) throws JSONException{
		Random random = new Random();
		int nextInt = random.nextInt(1000000000);
		order.setHb_orderId(nextInt);
		
		String callback = orderService.makeOrder(order, request);
		
		/*if(callback.equals("S")){
			System.out.println("111111");
			msg = "成功创建订单";
			return "redirect:/background/biz/linkPeople/add";
		}else{
			request.setAttribute("msg", "添加失败，" + callback);
			return "/background/system/order/makeOder";
		}*/
 
		if(callback.equals("S")){
			msg = "成功创建订单";
			return "redirect:query.html";
		}
		msg = callback;
		model.addAttribute("msg", callback);
		return null;
	}

	/**跳转到创建订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/gotoOrderMake")
	public String gotoOrderMake(HttpServletRequest request){
		return "/background/system/order/makeOrder";
	}
	
	/**跳转到查询订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/gotoOrderList")
	public String gotoOrderList(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("userSession");
		request.setAttribute("customerType", user.getCustomerType());
		
		return "/background/system/order/orderlist";
	}
	
	/*@RequestMapping(value="/gotoOrderList")
	@RequestMapping(value="/list",produces="text/plain;charset=utf-8")*/
	/*public String queryOrder1(HttpServletRequest request ,String customer_name,String pageNow, Model model){
		if (Common.isEmpty(pageNow)) {
			pageNow="1";
		} 
		int currpage = Integer.parseInt(pageNow);
		if(currpage<=0){
			currpage=1;
		}
		User user = (User) request.getSession().getAttribute("userSession");
		int userId = user.getUserId();
		//List<Order> lst = orderService.queryOrder(userId,orderId,currpage);

		List<UserLimit> lst = userLimitService.queryOrder1(customer_name,currpage);
		
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView.setRecords(lst);
		pageView.setRowCount(userLimitService.getOrderTotalCount(customer_name));
		pageView.setPageCount((long) Math.ceil(Double.valueOf(pageView.getRowCount()/2.0)));
		pageView.setPageNow(currpage);
		pageView.setPageSize(2);
		PageIndex pageIndex=new PageIndex(1, pageView.getPageCount());
		model.addAttribute("pageView", pageView);
		model.addAttribute("msg", msg);
        //return "/background/biz/userLimit/userLimit";
			return "/background/system/order/orderlist";
	}*/
	/**查询订单
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/query",produces="text/plain;charset=utf-8")
	public String queryOrder(HttpServletRequest request ,String orderId,String pageNow, Model model){
		if (Common.isEmpty(pageNow)) {
			pageNow="1";
		} 
		int currpage = Integer.parseInt(pageNow);
		if(currpage<=0){
			currpage=1;
		}
		User user = (User) request.getSession().getAttribute("userSession");
		
		int userId = user.getUserId();
		List<Order> lst = orderService.queryOrder(userId,orderId,currpage);
		PageView pageView = null;
		if(Common.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
			
		pageView.setRecords(lst);
		pageView.setRowCount(orderService.getOrderTotalCount(userId,orderId));
		pageView.setPageCount((long) Math.ceil(Double.valueOf(pageView.getRowCount()/8.0)));
		pageView.setPageNow(currpage);
		pageView.setPageSize(8);
		PageIndex pageIndex=new PageIndex(1, pageView.getPageCount());
		model.addAttribute("pageView", pageView);
		model.addAttribute("msg", msg);
	    //String PageView = orderService.queryOrder(PageView pageView,Order order )
 		return "/background/system/order/orderlist";
		
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

	/**跳转到信息授权
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/gotocodeOrderMake")
	public String gotocodeOrderMake(Model model, HttpServletRequest request, String id ){
		model.addAttribute("id", id);
		return "/background/system/order/makecodeOrder";
	}
	
	/**信息授权
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/codeOrder",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String codeOrder(HttpServletRequest request ,String code ,String id ){
		String callback = "";
		if(code != null ||code != ""){
			if(!code.equals("all")){
				User user = (User) request.getSession().getAttribute("userSession");
				String mobile = user.getUserPhone();
				callback = orderService.codeOrder(code,mobile,id);
			}else{
				User user = (User) request.getSession().getAttribute("userSession");
				String mobile = user.getUserPhone();
				orderService.signOrder("ENC_01",mobile,id);
				orderService.signOrder("ENC_03",mobile,id);
				callback = orderService.signOrder("ENC_04",mobile,id);
			}
		}
		return callback;
	}
	
	
	
	/**放款
	 * @param order
	 * @return
	 */
	@RequestMapping(value="/acctSetup",produces="text/plain;charset=utf-8")
	@ResponseBody
	public String acctSetup(Order order,CustomerInfo info,HttpServletRequest request) throws JSONException{
		//调用查询用户信息接口拿身份证
//		CustomerInfo customerinfo = customerInfoService.queryInfo(info,request);
		CustomerInfo customerinfo = customerInfoService.queryInfo(request);
		User user = (User) request.getSession().getAttribute("userSession");
//		order.setCustomerbasic_id(user.getUserId());
//		order.setMobile_no(user.getUserPhone());
//		order.setName(user.getUserNickname());
		String callback = orderService.acctSetup(order,customerinfo.getID_NO(),request);
		
		return callback;
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
	 */
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

		String[] newname = name.split("\\.");
		int sum = newname.length;
		//获取保存时间
		Date date = new Date();
		
		FileUtil fileUtil = new FileUtil();
		
		String filepath = fileUtil.uploadFile(null, date, upload_img, "."+newname[sum-1], "person", request);
		
		UploadFileInfo info = new UploadFileInfo();
		User user = (User) request.getSession().getAttribute("userSession");
		//文件名称为保存时间加后缀名
		info.setOrder_id(id);
		
		info.setUpload_file_dir(filepath);
		info.setUpload_time(date);
		System.out.println("标题1："+title);
		title = java.net.URLDecoder.decode(title,"UTF-8");
		System.out.println("标题2："+title);
		info.setTitle(title);
		
		
		info.setUpload_file(filedata);
		info.setUpload_file_name(name);
		
        info.setType(AttachmentType.I);
        String callback = orderService.uploadFileImg(info);
        
        return callback;  
        
        
	}
	
	
	/**跳转附件上传
	 * @param gotouploadfile
	 * @return
	 */
	@RequestMapping(value="/gotouploadfile")
	public String gotouploadfile(Model model,HttpServletRequest request , String id){
		model.addAttribute("id", id);
		return "/background/system/order/uploadfile";
	}
	
	/**跳转影像信息附件上传
	 * @param gotouploadfile
	 * @return
	 */
	@RequestMapping(value="/gotouploadfileimg")
	public String gotouploadfileimg(Model model,HttpServletRequest request , String id){
		model.addAttribute("id", id);
		return "/background/system/order/uploadfileimg";
	}
	
	/**查询附件信息
	 * @param filelist
	 * @throws Exception 
	 */
	@RequestMapping(value="/filelist")
	@ResponseBody
	public  List<UploadFileInfo> filelist(HttpServletRequest request,String orderId) throws Exception{
		User user = (User) request.getSession().getAttribute("userSession");
		List<UploadFileInfo> callback = new ArrayList<>();
		if(orderId == null){
			callback = orderService.listFile(user.getUserId()+"",AttachmentType.P.toString());
		}else{
			callback = orderService.listFile(orderId+"",AttachmentType.I.toString());
		}
        
        return callback; 
	}
	
	/**文件下载
	 * @param filedown
	 * @throws Exception 
	 */
	@RequestMapping(value="/filedown")
	@ResponseBody
	public void filedown(HttpServletRequest request,HttpServletResponse response,String filename,String filedir, int id) throws Exception{

		System.out.println("文件路径："+filename+"============"+id);
		FileUtil fileUtil = new FileUtil();
		String callback = orderService.down(id);
		System.out.println(callback);
		JSONObject dataJson=new JSONObject(callback);
		JSONObject resp=dataJson.getJSONObject("SERVICE");
		JSONObject data=resp.getJSONObject("SERVICE_BODY");
		JSONObject dd = data.getJSONObject("RESPONSE");
		String filedata = dd.get("FILE_DATA").toString();
		BASE64Decoder decoder = new BASE64Decoder(); 
	    byte[] b = decoder.decodeBuffer(filedata);
		InputStream sbs = new ByteArrayInputStream(b); 
		fileUtil.download(filename, filedir, sbs, request, response);
	}
	

}
