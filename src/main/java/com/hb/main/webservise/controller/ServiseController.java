package com.hb.main.webservise.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.framework.system.entity.User;
import com.hb.framework.system.service.UserService;

/** 
 * 基于Restful风格架构测试 
 *  
 * @author  
 * @since 
 * @version V1.0 
 * @history 
 */  
@Controller 
@RequestMapping("/cxf/")
public class ServiseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "hello")  
    public @ResponseBody String hello() {  
        return "你好！hello";  
    }
	
	@RequestMapping(value = "person/{id}", method = RequestMethod.GET)  
    public @ResponseBody User getPerson(@PathVariable(value = "id")String id) {  
		User user = userService.getById(id); 
        return user;  
    } 
    @RequestMapping(value = "person", method = RequestMethod.POST)  
    public @ResponseBody Map<String,String> addPerson(@RequestBody User person) throws JSONException {  
    	System.out.println(person.getUserName());
    	Map<String, String> uriVariables = new HashMap<String, String>();   
    	uriVariables.put("msg", "注册人员信息成功");  
        return uriVariables;  
    } 
//	    @RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")  
//	    public @ResponseBody  
//	    String hello() {  
//	        return "你好！hello";  
//	    }  
//	  
//	    @RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")  
//	    public @ResponseBody  
//	    String say(@PathVariable(value = "msg") String msg) {  
//	        return "{\"msg\":\"you say:'" + msg + "'\"}";  
//	    }  
//	  
//	    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.GET)  
//	    public @ResponseBody  
//	    Person getPerson(@PathVariable("id") int id) {  
//	        logger.info("获取人员信息id=" + id);  
//	        Person person = new Person();  
//	        person.setName("张三");  
//	        person.setSex("男");  
//	        person.setAge(30);  
//	        person.setId(id);  
//	        return person;  
//	    }  
//	  
//	    @RequestMapping(value = "/person/{id:\\d+}", method = RequestMethod.DELETE)  
//	    public @ResponseBody  
//	    Object deletePerson(@PathVariable("id") int id) {  
//	        logger.info("删除人员信息id=" + id);  
//	        JSONObject jsonObject = new JSONObject();  
//	        jsonObject.put("msg", "删除人员信息成功");  
//	        return jsonObject;  
//	    }  
//	  
//	    @RequestMapping(value = "/person", method = RequestMethod.POST)  
//	    public @ResponseBody  
//	    Object addPerson(Person person) {  
//	        logger.info("注册人员信息成功id=" + person.getId());  
//	        JSONObject jsonObject = new JSONObject();  
//	        jsonObject.put("msg", "注册人员信息成功");  
//	        return jsonObject;  
//	    }  
//	  
//	    @RequestMapping(value = "/person", method = RequestMethod.PUT)  
//	    public @ResponseBody  
//	    Object updatePerson(Person person) {  
//	        logger.info("更新人员信息id=" + person.getId());  
//	        JSONObject jsonObject = new JSONObject();  
//	        jsonObject.put("msg", "更新人员信息成功");  
//	        return jsonObject;  
//	    }  
//	  
//	    @RequestMapping(value = "/person", method = RequestMethod.PATCH)  
//	    public @ResponseBody  
//	    List<Person> listPerson(@RequestParam(value = "name", required = false, defaultValue = "") String name) {  
//	  
//	        logger.info("查询人员name like " + name);  
//	        List<Person> lstPersons = new ArrayList<Person>();  
//	  
//	        Person person = new Person();  
//	        person.setName("张三");  
//	        person.setSex("男");  
//	        person.setAge(25);  
//	        person.setId(101);  
//	        lstPersons.add(person);  
//	  
//	        Person person2 = new Person();  
//	        person2.setName("李四");  
//	        person2.setSex("女");  
//	        person2.setAge(23);  
//	        person2.setId(102);  
//	        lstPersons.add(person2);  
//	  
//	        Person person3 = new Person();  
//	        person3.setName("王五");  
//	        person3.setSex("男");  
//	        person3.setAge(27);  
//	        person3.setId(103);  
//	        lstPersons.add(person3);  
//	  
//	        return lstPersons;  
//	    }  
	  
}  
