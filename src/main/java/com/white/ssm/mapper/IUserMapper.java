package com.white.ssm.mapper;


import com.white.ssm.common.QueryBase;
import com.white.ssm.model.User;

import java.util.List;

public interface IUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectAll(QueryBase queryBase);

    Long getAllPageCount(QueryBase queryBase);

    List<User> selectAllByPass(QueryBase queryBase);

    Long getAllPageCountByPass(QueryBase queryBase);
}