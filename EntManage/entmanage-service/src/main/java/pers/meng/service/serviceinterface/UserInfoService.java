package pers.meng.service.serviceinterface;

import pers.meng.domain.bean.UserInfo;

public interface UserInfoService  {
	public UserInfo getUserInfo(Integer id);
	public UserInfo getUserInfo(String userid);

	public int updateUserInfo(UserInfo userinfo);

}
