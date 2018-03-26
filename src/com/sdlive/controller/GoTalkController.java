package com.sdlive.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sdlive.model.BackResult;
import com.sdlive.model.Department;
import com.sdlive.model.GoTalk;
import com.sdlive.service.impl.GoTalkServiceImpl;
import com.sdlive.utility.T_DataControl;
import com.sdlive.utility.T_DataMap2Bean;

/**
 *树袋老师
 * @author 作者 毕书富
 * @version 创建时间:2018-3-23 下午6:29:39
 * 类说明
 */
@Controller
@RequestMapping("/")
public class GoTalkController{
	private static final long serialVersionUID = -1060747765670586355L;
	
	Logger logger = Logger.getLogger(GoTalkController.class);
	@Resource(name="GoTalkServiceImpl")
	private GoTalkServiceImpl goTalkServiceImpl;
	BackResult backResult = new BackResult("信息值,默认", "请求值,默认", null);
	
	@RequestMapping("/aaGoTalk")
	  public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,String qqiu)
	      throws Exception {
	    // TODO Auto-generated method stub
	    response.setContentType("text/html;charset=utf-8");
	    PrintWriter out = response.getWriter();
	    
//	    String testqqiu = request.getParameter("qqiu");//测试handleRequest 默认获取

	    if (qqiu.equals("test") ||qqiu.equals("add") || qqiu.equals("delete") || qqiu.equals("edit")
	            || qqiu.equals("getOne") || qqiu.equals("on_off")) {
	        T_DataControl t_data = new T_DataControl();
	        String str = t_data.getRequestPayload(request);
	        GoTalk goTalk = new GoTalk();
	        if (str != null && str != "" && str.length() != 0) {
	            Map<String, Object> map = t_data.JsonStrToMap(str);
	            T_DataMap2Bean t_map2bean = new T_DataMap2Bean();
	            goTalk = t_map2bean.MapToGoTalk(map);
	            goTalk.setOpenAndclose((String) map.get("openAndclose"));
	        } else {
	            System.out.println("前台传入数据为空，请联前台传入post请求体数系管理员！");
	        }
	        qqiuchocie(qqiu, goTalk);
	    } else if (qqiu.equals("list")) {
	       /* ArrayList<Department> resultList = departmentService.getList();
	        backResult.setMessage("信息值：成功");
	        backResult.setQingqiu("list查询列表");
	        backResult.setData(resultList);*/
	    } else {
	        System.out.println("qqiu请求参数  " + qqiu + "  不规范");
	    }
	    Gson gson = new Gson();
	    // 4 执行完qqiuChoice里面操作后的全局返回值backResult对象,转成json格式
	    String back = gson.toJson(backResult);
	    System.out.println("最后back值是：" + back);
	    // 5 将json格式的back传给前台
	    out.write(back);
	    out.flush();
	    out.close();
	    
//	    return null;
	    ModelAndView mview = new ModelAndView(back);
	    return mview;

	  }//end method ModelAndView
	  
	  private void qqiuchocie(String qqiu, GoTalk goTalk) {
		boolean test = false;
	    boolean add = false;
	    boolean delete = false;
	    boolean edit = false;
	    boolean getOne = false;
	    boolean on_off = false;
	    
	    test = qqiu.equals("test");
	    add = qqiu.equals("add");
	    delete = qqiu.equals("delete");
	    edit = qqiu.equals("edit");
	    getOne = qqiu.equals("getOne");
	    on_off = qqiu.equals("on_off");

	    if (test) {
	        logger.error("日志打印测试YXRecordController测试test方法,测试成功");      
	        backResult.setMessage("信息值,默认");
	        backResult.setQingqiu("请求值,默认");
	    }
	    if (add) {
	    	goTalkServiceImpl.insert(goTalk);
	        logger.error("日志打印测试YXRecordController测试test方法,测试成功");      
	        backResult.setMessage("信息值,新增成功");
	        backResult.setQingqiu("请求值,默认");
	    }
	    
	}
	}//end class
