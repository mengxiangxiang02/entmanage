package pers.meng.daoimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pers.meng.daointerface.UserInfoMapper;
import pers.meng.domain.bean.UserInfo;

import java.util.List;
import java.util.Map;

@Repository("userInfoMapper")
public class UserInfoMapperImpl implements UserInfoMapper {
	@Autowired
	@Qualifier("sqlSession")
	private SqlSessionTemplate sqlSession;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(UserInfo record) {
		// TODO Auto-generated method stub

		return sqlSession.insert("pers.meng.daointerface.UserInfoMapper.insertSelective",record);
	}

	@Override
	public UserInfo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return (UserInfo)sqlSession.selectOne("pers.meng.daointerface.UserInfoMapper.selectByPrimaryKey", id);
	}

	
	
	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		return sqlSession.update("pers.meng.daointerface.UserInfoMapper.updateByPrimaryKeySelective",record);
	}

	@Override
	public int updateByPrimaryKey(UserInfo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectByUserid(String userid) {
		// TODO Auto-generated method stub
		return (UserInfo)sqlSession.selectOne("pers.meng.daointerface.UserInfoMapper.selectByUserid", userid);
	}
	@Override
	public List<UserInfo> selectByContion(Map map) {
		return (List<UserInfo>)sqlSession.selectList("pers.meng.daointerface.UserInfoMapper.selectByContion", map);
	}

	@Override
	public int selectCount(Map map) {
		return (int)sqlSession.selectOne("pers.meng.daointerface.UserInfoMapper.count", map);
	}
}
