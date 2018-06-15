package ssm;

import org.family.ssm.entity.UserEntity;
import org.family.ssm.service.IUserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.istack.internal.logging.Logger;

public class UserT {
	private ClassPathXmlApplicationContext app=null;
	private IUserService userService=null;
	
	Logger log=Logger.getLogger(this.getClass());
	
	@Before
	public void test() {
		app=new ClassPathXmlApplicationContext("spring-mybatis.xml");
		userService=(IUserService)app.getBean("userService");
	}
	
	@Test
	public void selectByPrimaryKey() {
		UserEntity user=userService.selectByPrimaryKey("1");
		log.info(user.getUserName()+" "+user.getUserPassword());
	}
}
