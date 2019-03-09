package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hb.framework.superhelp.util.Md5Tool;
import com.hb.framework.superhelp.util.PageView;
import com.hb.framework.system.entity.BaseData;
import com.hb.framework.system.service.BaseDataService;
import com.hb.framework.system.service.ResourcesService;

public class ResourcesServiceImplTest {

	private ResourcesService resourcesService;

	@Test
	public void test() {
		        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-*.xml");  
		       /* ResourcesService bean = (ResourcesService)ctx.getBean("resourcesService");
		        bean.findAll();
		        bean.getById("1");
		        bean.getUserResources("1");
		        
		        BaseDataService beans = (BaseDataService)ctx.getBean("baseDataService");
		        PageView pageView=new PageView(10,1);
		        beans.query(pageView, new BaseData());
		        //List lists=list.getRecords();
		        System.out.println(Md5Tool.getMd5("admin"));
		        System.out.println(Md5Tool.getMd5("123"));
		        System.out.println(Md5Tool.getMd5("hsc"));*/
	}

}
