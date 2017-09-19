package pers.meng.daoimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pers.meng.daointerface.entInfoMapper;
import pers.meng.domain.bean.entInfo;

import java.util.List;
import java.util.Map;
@Repository("entInfoMapper")
public class entInfoMapperImpl implements entInfoMapper {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSessionTemplate sqlSession;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlSession.delete("pers.meng.daoinerface.entInfoMapper.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(entInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(entInfo record) {
        return sqlSession.insert("pers.meng.daoinerface.entInfoMapper.insertSelective",record);
    }

    @Override
    public entInfo selectByPrimaryKey(Integer id) {
        return (entInfo)sqlSession.selectOne("pers.meng.daoinerface.entInfoMapper.selectByPrimaryKey", id);

    }

    @Override
    public int updateByPrimaryKeySelective(entInfo record) {
        return sqlSession.update("pers.meng.daoinerface.entInfoMapper.updateByPrimaryKeySelective",record);

    }

    @Override
    public int updateByPrimaryKey(entInfo record) {
        return 0;
    }

    @Override
    public List<entInfo> selectByContion(Map map) {
        return (List<entInfo>)sqlSession.selectList("pers.meng.daointerface.entInfoMapper.selectByContion", map);
    }

    @Override
    public int selectCount(Map map) {
        return (int)sqlSession.selectOne("pers.meng.daointerface.entInfoMapper.count", map);
    }
}
