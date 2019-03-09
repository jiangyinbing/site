package com.hb.framework.business.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hb.framework.business.entity.Guarantor;
import com.hb.framework.business.entity.Pledge;
import com.hb.framework.business.service.GuarantorService;

/**
 * 担保人的类
 * @author lym
 *
 */
@Controller
@RequestMapping ("/biz/guarantor/")
public class GuarantorController {

	@Autowired
	private GuarantorService guarantorService;
	
	/**
	 * 获得担保
	 * @param request
	 * @return
	 * @throws JSONException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="queryGuarantor",produces="text/plain;charset=utf-8")
	public String queryPledge(HttpServletRequest request, Model model, String id) throws JSONException{
		Map<String, Object> maps = guarantorService.getGuarantorList(id);
		List<Guarantor> glst = (List<Guarantor>) maps.get("glst");
		model.addAttribute("glst", glst);
		model.addAttribute("id", id);
		System.out.println("come");
		return "/background/biz/guarantee/list";
	}
	
	
	
	/**
	 * 显示添加担保人页面
	 * @return
	 */
	@RequestMapping(value="showAddGuarantor",produces="text/plain;charset=utf-8")
	public String showAddGuarantor(Model model, String id){
		model.addAttribute("id", id);
		return "/background/biz/guarantor/add";
	}
	
	/**
	 * 添加担保人
	 * @param guarantor 担保人对象
	 * @param model
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="addGuarantor",produces="text/plain;charset=utf-8")
	public String addGuarantor(Guarantor guarantor, Model model, String id) throws JSONException{
		String ret = guarantorService.addGuarantor(id, guarantor);
		if(ret.equals("success")){
			model.addAttribute("tip", "添加成功");
			return "redirect:../guarantor/queryGuarantor.html?id="+id;
		}else{
			model.addAttribute("tip", ret);
			model.addAttribute("id", id);
			return "/background/biz/guarantor/add";
		}
	}
	
	/**
	 * 确认担保人
	 * @param guarantor 担保人对象
	 * @param model
	 * @return
	 * @throws JSONException
	 */
	@RequestMapping(value="comfortGuarantor",produces="text/plain;charset=utf-8")
	public String comfortGuarantor(Model model, String id) throws JSONException{
		String ret = guarantorService.comfortGuarantor(id);
		System.out.println(ret);
		if(ret.equals("S")){
			model.addAttribute("tip", "确认成功");
			return "redirect:../guarantor/queryGuarantor.html?id="+id;
		}else{
			model.addAttribute("tip", "确认失败");
			return "redirect:../guarantor/queryGuarantor.html?id="+id;
		}
	}

	/**
	 * 删除担保人
	 * @param guaranteeId 担保信息id
	 * @return
	 * @throws JSONException 
	 */
	@RequestMapping(value="deleteGuarantor",produces="text/plain;charset=utf-8")
	public String deleteGuarantor(String guaranteeId, Model model) throws JSONException{
		
		String result = guarantorService.deleteGuarantor(guaranteeId);
		JSONObject dataJson = new JSONObject(result);
		JSONObject service = dataJson.getJSONObject("SERVICE");
		JSONObject serHeader = service.getJSONObject("SERVICE_HEADER");
		JSONObject serBody = service.getJSONObject("SERVICE_BODY");
		JSONObject servResponse = serHeader.getJSONObject("SERV_RESPONSE");
		JSONObject response = serBody.getJSONObject("RESPONSE");
		
		// 获取返回结果	
		String status = servResponse.getString("STATUS");
		String desc = servResponse.getString("DESC");
		
		// F表示失败
		if("F".equals(status)){
			model.addAttribute("tip", desc);
			return "/background/biz/pledge/list";
		}else{	// S表示成功
			String guaranteeStatus = response.getString("GUARANTEE_STATUS");
			model.addAttribute("tip", "删除成功，担保状态：" + guaranteeStatus);
			return "/background/biz/pledge/list";
		}
	}
	
}
