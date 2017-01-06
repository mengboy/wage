package com.white.ssm.service;

import com.white.ssm.common.QueryBase;
import com.white.ssm.model.User;

import java.util.List;

/**
 * Created by admin on 2016/11/2.
 */
public interface IUserService {
    public User getUserById(int userId);
    public int getAll(QueryBase queryBase);
    public int getAllByPass(QueryBase queryBase);
}
