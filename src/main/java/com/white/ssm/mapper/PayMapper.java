package com.white.ssm.mapper;

import com.white.ssm.common.QueryBase;
import com.white.ssm.model.Employee;
import com.white.ssm.model.Pay;

import java.util.List;

/**
 * 工资的mapper接口
 * 和mybatis XML配置文件相匹配
 * service层通过mapper 接口调用mybatis XML文件配置的数据库查询方法
 */
public interface PayMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Pay record);

    int insertSelective(Pay record);

    Pay selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Pay record);

    int updateByPrimaryKey(Pay record);

    Long getAllPageCount(QueryBase queryBase);

    List<Pay> getAll(QueryBase queryBase);

    Long getAllPageCountByTime(QueryBase queryBase);

    List<Pay> getByYearAndMounth(QueryBase queryBase);

    List<Pay> getByeId(QueryBase queryBase);

    Long getByeIdPageCount(QueryBase queryBase);

    Long getAllPageCountByDepartAndTime(QueryBase queryBase);

    List<Pay> getByDepartAndTime(QueryBase queryBase);

    Pay getByEidAndTime(QueryBase queryBase);

    List<Pay> getByName(String name);
}