package com.hb.main.webservise.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hb.framework.system.entity.User;
/**
 * 
* 访问外部接口   
* 类名称：WebserviseController   
* 类描述：   
* 创建人：h   
* 修改人：Administrator     
* @version    
*
 */
@Component("WebserviseClient") 
public class WebserviseController {
	@Autowired  
    protected RestTemplate restTemplate;  
  
    private final static String articleServiceUrl = "http://www.bodaph.com/cxf/rest/";
    private final static String articleServiceUrltest = "http://127.0.0.1:8080/wuhan_power/API/cxf/";
    public String getCategories() {  
        return restTemplate.getForObject(articleServiceUrltest +"hello", String.class);  
    }  
  
    public String getArticle(String id) {
    	String j=restTemplate.getForObject(articleServiceUrl + "account/wdjf/22/1/1",String.class);
        return j;  
    }  
  
    public User getPerson() {  
       User user=restTemplate.getForObject(articleServiceUrltest +"person/1", User.class);
       return user;  
    }  
  
    @SuppressWarnings("unchecked")
	public Map<String, String> postCategories() throws JSONException {  
    	Map<String, String> uriVariables = new HashMap<String, String>(); 
    	uriVariables.put("userName", "jizhong");  
    	uriVariables.put("userPassword", "jizhong");
    	 HttpHeaders headers =new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         HttpEntity<Map<String, String>> request=new HttpEntity<Map<String, String>>(uriVariables, headers);
         Map<String, String> postForObject = restTemplate.postForObject(articleServiceUrltest + "person?apiName=hsc&apiPwd=hsc",  request,uriVariables.getClass());
         return postForObject;
    }  
}
