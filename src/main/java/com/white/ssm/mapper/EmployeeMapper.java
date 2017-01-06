package com.white.ssm.mapper;

import com.white.ssm.common.QueryBase;
import com.white.ssm.model.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer eId);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer eId);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKeyWithBLOBs(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getAll(QueryBase queryBase);

    Long getAllPageCount(QueryBase queryBase);

    Long getAllPageCountByDepart(QueryBase queryBase);

    List<Employee> getAllByDepart(QueryBase queryBase);

}