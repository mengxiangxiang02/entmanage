package pers.meng.service.serviceimpl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pers.meng.daointerface.UserInfoMapper;
import pers.meng.domain.bean.UserInfo;
import pers.meng.service.serviceinterface.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService{
	public final static Logger logger = Logger.getLogger(UserInfoServiceImpl.class);

	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	public UserInfo getUserInfo(Integer id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public UserInfo getUserInfo(String userid) {
		// TODO Auto-generated method stub
		logger.info(userid);
		return userInfoMapper.selectByUserid(userid);
	}

	@Override
	public int updateUserInfo(UserInfo userinfo) {
		int i = userInfoMapper.updateByPrimaryKeySelective(userinfo);
		return i;
	}


}
