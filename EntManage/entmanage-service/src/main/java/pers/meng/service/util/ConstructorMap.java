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
		MapDao.put("sort", "stock_code");
		MapDao.put("order", "desc");
		if (!StringUtils.isEmpty(map.get("stockCode")==null?null:map.get("stockCode").toString())) {
			MapDao.put("stockCode", map.get("stockCode"));
		}
		if (!StringUtils.isEmpty(map.get("stockName")==null?null:map.get("stockName").toString())) {
			MapDao.put("stockName", map.get("stockName"));
		}
		if (!StringUtils.isEmpty(map.get("volumedate")==null?null:map.get("volumedate").toString())) {
			MapDao.put("volumedate", map.get("volumedate"));
		}
		logger.info("processedMap" + MapDao);
		return MapDao;
	}
}
