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
	public String showUser(String userId,Model m) {
		m.addAttribute("user", userService.selectByPrimaryKey(userId));
		return "showUser";
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
}