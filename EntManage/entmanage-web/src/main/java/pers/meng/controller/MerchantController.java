/*
 * Copyright 2014 shengpay.com, Inc. All rights reserved.
 * shengpay.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * creator : lishaohua
 * create time : 2016年7月19日 下午1:22:43
 */
package pers.meng.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.sf.json.JSONObject;
import pers.meng.daointerface.entInfoMapper;
import pers.meng.domain.bean.entInfo;
import pers.meng.param.BaseCtrl;
import pers.meng.service.util.ConstructorMap;

/**
 * 内部接口配置列表
 */
@Controller
@RequestMapping("/ent")
public class MerchantController  extends BaseCtrl {
	public final static Logger logger = Logger.getLogger(MerchantController.class);

    @Autowired
    private entInfoMapper entInfoMapper;


    /**
     * 查询
     * @param req
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/query",produces="text/html;charset=UTF-8")
    public String  query(HttpServletRequest req,HttpServletResponse response, ModelMap model) {
    	int startIndex = Integer.parseInt(StringUtils.isEmpty(req.getParameter("iDisplayStart")) ? "1" : req
                 .getParameter("iDisplayStart"));//起始记录数
        int limit = Integer.parseInt(StringUtils.isEmpty(req.getParameter("iDisplayLength")) ? "10" : req
                 .getParameter("iDisplayLength"));//每页显示记录数

    	String entName = req.getParameter("entName");

        Map<String, String>  map=BaseCtrl.getRequestMap(req);
        map.put("pageSize", limit + "");
        map.put("pageOffset", (startIndex)*limit + "");
        logger.info(map);
        List<entInfo> entInfos = entInfoMapper.selectByContion(map);
        int i = entInfoMapper.selectCount(map);
        //设置返回记录and总记录数
        model.put("aaData", entInfos);
        model.put("iTotalRecords",  i);
        model.put("iTotalDisplayRecords",  i);
        JSONObject jsonObject = JSONObject.fromObject(model);  
        return jsonObject.toString();
    }
    /**
     * 编辑界面
     * @param req
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/edit",produces="text/html;charset=UTF-8")
    public String toInput(HttpServletRequest req,HttpServletResponse response, ModelMap modelMap) {
        Integer id = Integer.parseInt(req.getParameter("id"));
        logger.info("id:"+id);
        entInfo  pdo=null;
        boolean isEditFlag = false;
        if(id!=0)
        {
        	isEditFlag = true;
        	pdo= entInfoMapper.selectByPrimaryKey(id);
        }
        JSONObject json = JSONObject.fromObject(pdo);
        String str = json.toString();//将json对象转换为字符串  
        logger.info("entInfo:"+str);
        modelMap.addAttribute("entInfo",str);
        modelMap.addAttribute("isEdit", isEditFlag);
        String view = "pages/entinfo/entinfo";
        logger.info("showUserManagePage view url = {}"+ view);
        
        return view;
    }
    
    /**
     * 添加或更新产品配置
     * @param proconfig
     * @param req
     * @param model
     * @return
     */
    @RequestMapping(value = "/save",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String save( HttpServletRequest req,HttpServletResponse response, ModelMap model,entInfo proconfig) {
        logger.info("save user info,tbUser:{}"+ proconfig);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("msg", false);
        result.put("message", "操作失败！");
        try {
            if (proconfig.getId() == -1) {
                long id = entInfoMapper.insert(proconfig);
            } else {
            	int updateFlag = entInfoMapper.updateByPrimaryKeySelective(proconfig);
            }
            result.put("msg", true);
            result.put("message", "操作成功！");
        }  catch (Exception e) {
            logger.error("编辑产品配置异常！", e);
        }
       
        JSONObject json = JSONObject.fromObject(result);
        String str = json.toString();//将json对象转换为字符串  
        return str;
    }
}
