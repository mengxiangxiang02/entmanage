package pers.meng.daointerface;

import pers.meng.domain.bean.ClassInfo;
import pers.meng.domain.bean.entInfo;

import java.util.List;
import java.util.Map;

public interface ClassInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbggenerated
     */
    int insert(ClassInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbggenerated
     */
    int insertSelective(ClassInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbggenerated
     */
    ClassInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ClassInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table class_info
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ClassInfo record);

    List<ClassInfo> selectByContion(Map map);

    int  selectCount(Map map);
}