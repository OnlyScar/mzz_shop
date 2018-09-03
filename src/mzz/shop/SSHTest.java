package mzz.shop;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mzz.shop.model.Category;
import com.mzz.shop.service.CategoryService;
import com.mzz.shop.service.impl.CategoryServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:beans.xml")
public class SSHTest {
	
	@Resource
	private Date date;
	
	@Test
	public void springIoc(){
		
		System.out.println(date);
	}
	
	
	@Test  //测试Hibernate的开发环境，因为没有整合，可以直接new
	public void hihernate() {
		CategoryService categoryService = new CategoryServiceImpl();
		Category category = new Category("男士休闲", true);
		categoryService.save(category);
	}

}
