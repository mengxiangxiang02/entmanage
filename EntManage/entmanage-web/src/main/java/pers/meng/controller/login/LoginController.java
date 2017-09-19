/*
 * Copyright 2014 shengpay.com, Inc. All rights reserved.
 * shengpay.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * creator : lishaohua
 * create time : 2016年7月19日 下午1:22:43
 */
package pers.meng.controller.login;

import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pers.meng.domain.bean.UserInfo;
import pers.meng.domain.util.MD5;
import pers.meng.param.BaseCtrl;
import pers.meng.service.serviceinterface.UserInfoService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 内部接口配置列表
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseCtrl{
	public final static Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    @Qualifier("userInfoService") 
    private UserInfoService userInfoService;
    
    /**
     * 登录校验成功跳转到index页面，否则跳转到登录页面
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/validate")
    public String  validate(HttpServletRequest req,HttpServletResponse response, ModelMap model) {
    	try{
    		Map<String, String> map=getRequestMap(req);
    		String userName=null;
    		if(map.containsKey("userName"))
    		{
    			userName=map.get("userName");
    		}
    		logger.info(map);
    		//检查userName是否合法
    		boolean result=match(userName);
    		if(result==false)
    		{
    			 return "redirect:/login.jsp";
    		}
        	String password=req.getParameter("shawpassWord");
        	if(password==null)
        	{
        		return "redirect:/login.jsp";
        	}
        	UserInfo userinfo=userInfoService.getUserInfo(userName);
        	logger.info("passowrd"+password.toUpperCase());
        	if(userinfo!=null&&password.toUpperCase().equals(userinfo.getPassword()))
        	 {
        		 req.getSession().setAttribute("userName",userName);

        		 Cookie cookie=new Cookie("userName", userName);
        		 //设置cookie时间 单位秒
        		 cookie.setMaxAge(36000);
        		//设置路径，这个路径即该工程下都可以访问该cookie 如果不设置路径，那么只有设置该cookie路径及其子路径可以访问
        		 cookie.setPath("/");
        		 response.addCookie(cookie);
        		 return "redirect:/index.jsp"; 
        	 }else
        	 {
        		 return "redirect:/login.jsp";
        	 }
    	}catch(Exception e)
    	{
    		logger.error("请求失败", e);
    		e.printStackTrace();
    		return "redirect:/login.jsp";
    	}
    	
    }

	@RequestMapping(value = "/updatepassword" ,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String  updatepassword(String userName,String pass,String oldpass)
	{
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", false);
		result.put("message", "操作失败！");
		if(userName==null||pass==null||oldpass==null)
		{
			result.put("msg", false);
			result.put("message", "操作失败！");
			JSONObject json = JSONObject.fromObject(result);
			String str = json.toString();//将json对象转换为字符串
			return str;
		}
		logger.info("username"+userName+"oldpass"+oldpass+"pass"+pass);

		try{
			String md5pass=MD5.md5(oldpass);
			String newpass=MD5.md5(pass);
			UserInfo userinfo=userInfoService.getUserInfo(userName);
			if(userinfo!=null&&md5pass.toUpperCase().equals(userinfo.getPassword()))
			{
				userinfo.setPassword(newpass);
				int i=userInfoService.updateUserInfo(userinfo);
				result.put("msg", true);
				result.put("message", "操作成功！");
			}


		}catch(Exception e)
		{
			logger.error("更新密码失败！", e);
		}

		JSONObject json = JSONObject.fromObject(result);
		String str = json.toString();//将json对象转换为字符串
		return str;
	}

    public  boolean match(String name) {
    	if(StringUtils.isBlank(name))
    	{
    		return false;
    	}
        // 要验证的字符串
        String regEx = "[a-zA-Z]{1}([a-zA-Z0-9]|[._]){3,50}";
        // 编译正则表达式
        Pattern pattern = Pattern.compile(regEx);
        // 忽略大小写的写法
        // Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        // 字符串是否与正则表达式相匹配
        boolean rs = matcher.matches();
        return rs;
    }
}
