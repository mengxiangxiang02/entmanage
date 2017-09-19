package pers.meng.daoimpl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pers.meng.daointerface.ClassInfoMapper;
import pers.meng.domain.bean.ClassInfo;

import java.util.List;
import java.util.Map;
@Repository("ClassInfoMapper")
public class ClassInfoMapperImpl implements ClassInfoMapper {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSessionTemplate sqlSession;
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sqlSession.delete("pers.meng.daoinerface.ClassInfoMapper.deleteByPrimaryKey", id);
    }

    @Override
    public int insert(ClassInfo record) {
        return 0;
    }

    @Override
    public int insertSelective(ClassInfo record) {
        return sqlSession.insert("pers.meng.daoinerface.ClassInfoMapper.insertSelective",record);
    }

    @Override
    public ClassInfo selectByPrimaryKey(Integer id) {
        return (ClassInfo)sqlSession.selectOne("pers.meng.daoinerface.ClassInfoMapper.selectByPrimaryKey", id);
    }

    @Override
    public int updateByPrimaryKeySelective(ClassInfo record) {
        return sqlSession.update("pers.meng.daoinerface.ClassInfoMapper.updateByPrimaryKeySelective",record);
    }

    @Override
    public int updateByPrimaryKey(ClassInfo record) {
        return 0;
    }

    @Override
    public List<ClassInfo> selectByContion(Map map) {
        return (List<ClassInfo>)sqlSession.selectList("pers.meng.daointerface.ClassInfoMapper.selectByContion", map);
    }

    @Override
    public int selectCount(Map map) {
        return (int)sqlSession.selectOne("pers.meng.daointerface.ClassInfoMapper.count", map);
    }
}
