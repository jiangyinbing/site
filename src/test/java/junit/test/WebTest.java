package junit.test;

import org.json.JSONException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.main.webservise.controller.WebserviseController;
  
public class WebTest {
	@Test
	public void test() throws JSONException {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-*.xml");
        WebserviseController articleClient = applicationContext.getBean("WebserviseClient", WebserviseController.class);
  
        //get operate  
              System.out.println("Article: " +  articleClient.getArticle("1"));
              System.out.println(articleClient.getCategories());
              System.out.println(articleClient.getPerson().getRoleName());
              System.out.println(articleClient.postCategories());*/
	}
}  
