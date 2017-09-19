package pers.meng.service.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class ConstructorMap {
	public final static Logger logger = Logger.getLogger(ConstructorMap.class);
	public static Map<String, Object> productMap(Map map)
	{
		int startIndex = Integer.parseInt(
				StringUtils.isEmpty(map.get("iDisplayStart").toString()) ? "1" : map.get("iDisplayStart").toString());// 起始记录数
		int limit = Integer.parseInt(StringUtils.isEmpty(map.get("iDisplayLength").toString()) ? "50"
				: map.get("iDisplayLength").toString());// 每页显示记录数
		Map<String, Object> MapDao = new HashMap<String, Object>();
		MapDao.put("pageSize", limit + "");
		MapDao.put("pageOffset", startIndex + "");


		logger.info("processedMap" + MapDao);
		return MapDao;
	}
}
