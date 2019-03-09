//package com.hb.framework.business.controller;
//
//import java.io.ByteArrayOutputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.json.JSONException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import sun.misc.BASE64Encoder;
//
//import com.hb.framework.business.entity.Guarantor;
//import com.hb.framework.business.entity.Pledge;
//import com.hb.framework.business.entity.UploadFileInfo;
//import com.hb.framework.business.service.OrderService;
//import com.hb.framework.business.service.PledgeService;
//import com.hb.framework.system.entity.User;
//
///**
// * 担保和抵押信息的类
// * @author lym
// *
// */
//@Controller
//@RequestMapping ("/biz/pledge/")
//public class PledgeController {
//
//	@Autowired
//	private PledgeService pledgeService;
//	@Autowired
//	private OrderService orderService;
//	
//	private String msg;			// 提示
//	private String id;			// 订单编号
//	
//	/**
//	 * 获得担保和抵押信息
//	 */
//	@RequestMapping(value="queryPledge",produces="text/plain;charset=utf-8")
//	public String queryPledge(HttpServletRequest request, Model model, String id) throws JSONException{
//		Map<String, Object> maps = pledgeService.getPGList(id);
//		List<Guarantor> glst = (List<Guarantor>) maps.get("glst");
//		List<Pledge> plst = (List<Pledge>) maps.get("plst");
//		model.addAttribute("glst", glst);
//		model.addAttribute("plst", plst);
//		model.addAttribute("id", id);
//		request.setAttribute("msg", msg);
//		msg = "";//传输完之后清空
//		return "/background/biz/pledge/list";
//	}
//
//	/**
//	 * 添加抵质押信息
//	 */
//	@RequestMapping(value="addPledge",produces="text/plain;charset=utf-8")
//	public String addPledge(HttpServletRequest request, Model model, Pledge pledge, @RequestParam("upload") MultipartFile upload) throws JSONException, IOException{
//		byte[] in_b = new byte[1024];
//		String filedata = "";
//		InputStream is = null;
//		try {
//			is = upload.getInputStream();
//			
//			ByteArrayOutputStream swapStream = new ByteArrayOutputStream(); 
//			byte[] buff = new byte[100]; //buff用于存放循环读取的临时数据 
//			int rc = 0; 
//			while ((rc = is.read(buff, 0, 100)) > 0) { 
//				swapStream.write(buff, 0, rc); 
//			} 
//			in_b = swapStream.toByteArray(); //in_b为转换之后的结果 
//			BASE64Encoder encoder = new BASE64Encoder();
//			filedata = encoder.encode(in_b);
//		
//		}catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if (is != null) {
//					is.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
//		//获得文件名 name
//		String name = upload.getOriginalFilename();
//		//获取保存时间
//		Date date = new Date();
//		
//		UploadFileInfo info = new UploadFileInfo();
//		User user = (User) request.getSession().getAttribute("userSession");
//		info.setCustomer_id(user.getUserId());
//		//文件名称为保存时间加后缀名
//		info.setOrder_id(id);
//		
//		info.setUpload_time(date);
//		info.setTitle(name);
//		
//		info.setUpload_file(filedata);
//		info.setUpload_file_name(name);
//		info.setType("pledge");
//		pledge.setFileName(name);
//		
//		Map<String, Object> maps = pledgeService.addPledge(pledge);
//		String status = maps.get("status").toString();	// 添加返回状态
//		String desc = maps.get("desc").toString();		// 添加成功或失败返回的信息
//		id = pledge.getXj_order_id();					// 添加抵质押后生成的ID
//		
//		if(status!=null && !"".equals(status) && "F".equals(status)){// 添加失败时，需要回显所填数据
//			model.addAttribute("msg", "添加失败：" + desc);
//			model.addAttribute("id", id);
//			return "/background/biz/pledge/add";
//		}else{
//			Integer pledgeId = (Integer) maps.get("pledgeId");
//			if(pledge!=null){
//				info.setPledge_id(pledgeId);
//				orderService.uploadFile(info);
//				String callback = orderService.uploadFile(info);
//			}
//			msg = "添加成功!";
//			model.addAttribute("msg", msg);
//			return queryPledge(request, model, id);
//		}
//	}	
//	
//	/**
//	 * 跳转到添加抵质押页面
//	 */
//	@RequestMapping(value="showPledgeAddPage",produces="text/plain;charset=utf-8")
//	public String showPledgeAddPage(String id, Model model) throws JSONException{
//		model.addAttribute("id", id);
//		return "/background/biz/pledge/add";
//	}
//	
//	public String getMsg() {
//		return msg;
//	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	
//	
//}
