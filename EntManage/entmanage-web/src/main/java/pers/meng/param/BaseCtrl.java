package pers.meng.param;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;
public abstract class BaseCtrl {
	
	//(获取请求参数，以key:value的形式返回)
	public static Map<String, String> getRequestMap(HttpServletRequest request) {
		Enumeration<?> enu = request.getParameterNames();
		Map<String, String> rmap = new HashMap<String, String>();

		while (enu.hasMoreElements()) {
			String xsql = (String) enu.nextElement();
			String value = request.getParameter(xsql);
			rmap.put(xsql, value);
		}
		return rmap;
	}
}
