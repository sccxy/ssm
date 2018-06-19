package org.family.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.family.ssm.entity.UserEntity;
import org.family.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 通过用户ID查询用户详情
	 * @param userId 用户ID
	 * @param m 视图对象
	 * @return	用户详情页面
	 */
	@RequestMapping("showUser")
	public String showUser(String userId,String typeId,Model m) {
		m.addAttribute("user", userService.selectByPrimaryKey(userId));
		if("1".equals(typeId)) {
			return "showUser";
		}
		return "updateUser";
	}
	
	/**
	 * 分页查询所用用户
	 * @param map 存放分页查询内容
	 * @param pageNo 页码
	 * @return 跳转到分页显示页面
	 */
	@RequestMapping(value="showAllUserList")
    public String pageList(ModelMap map,@RequestParam(defaultValue="1",required=true,value="pageNo") Integer pageNo){
        Integer pageSize=5;//每页显示记录数
        //分页查询
        PageHelper.startPage(pageNo, pageSize);
        List<UserEntity> userList = userService.getAllUserList();//获取所有用户信息
        PageInfo<UserEntity> pageInfo=new PageInfo<UserEntity>(userList);
        map.addAttribute("pageInfo", pageInfo);
        return "userManage";
    }
	
	/**
	 * 添加用户对象
	 * @param record 用户对象
	 * @return 添加成功重定向到showAllUserList显示所用分页用户页面，
	 * 		      添加失败，返回错误提示信息。
	 */
	@RequestMapping("insertUser")
	public ModelAndView insertUser(UserEntity record) {
		int n=userService.insert(record);
		if(n>0) { //添加成功
			ModelAndView m=new ModelAndView("redirect:/showAllUserList");
			return m;
		}else { //添加失败
			ModelAndView m=new ModelAndView();
			m.setViewName("insertUser");
			return m;
		}
	}
	
	/**
	 * 根据用户ID删除用户对象
	 * @param id 用户ID
	 * @return 删除成功重定向到showAllUserList显示所用分页用户页面，
	 * 		   删除失败当前也提示删除失败。
	 */
	@RequestMapping("deleteUser")
	public ModelAndView deleteUser(String userId) {
		int n=userService.deleteByPrimaryKey(userId);
		if(n>0) { //删除成功
			ModelAndView m=new ModelAndView("redirect:/showAllUserList");
			return m;
		}else { //删除失败
			ModelAndView m=new ModelAndView();
			m.setViewName("insertUser");
			return m;
		}
	}
	
	/**
	 * 通过用户对象修改用户信息
	 * @param record 用户对象
	 * @return 修改成功返回分页显示所有用户页面，修改失败，返回修改页面。
	 */
	@RequestMapping("updateUser")
	public ModelAndView updateUser(UserEntity record) {
		int n=userService.updateByPrimaryKey(record);
		if(n>0) { //修改成功
			ModelAndView m=new ModelAndView("redirect:/showAllUserList");
			return m;
		}else { //修改失败
			ModelAndView m=new ModelAndView();
			m.setViewName("updateUser");
			return m;
		}
	}
}