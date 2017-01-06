package com.white.ssm.service.impl;

import com.white.ssm.common.QueryBase;
import com.white.ssm.common.Status;
import com.white.ssm.mapper.IUserMapper;
import com.white.ssm.model.User;
import com.white.ssm.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User service
 * Created by admin on 2016/11/2.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    IUserMapper userMapper;

    public User getUserById(int userId) {
        return this.userMapper.selectByPrimaryKey(userId);
    }

    public int getAll(QueryBase queryBase)
    {
        try{
            queryBase.setTotalRow(this.userMapper.getAllPageCount(queryBase));
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(User user : this.userMapper.selectAll(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("user", user);
                mapLists.add(map);
            }
            System.out.println("pagesize" + queryBase.getLimit_start());
            System.out.println("pagesize" + queryBase.getPageSize());
            queryBase.setResults(mapLists);
            return Status.SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }

    public int getAllByPass(QueryBase queryBase) {
        try{
            queryBase.setTotalRow(this.userMapper.getAllPageCountByPass(queryBase));
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(User user : this.userMapper.selectAllByPass(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("user", user);
                mapLists.add(map);
            }
            System.out.println("pagesize" + queryBase.getLimit_start());
            System.out.println("pagesize" + queryBase.getPageSize());
            queryBase.setResults(mapLists);
            return Status.SUCCESS;
        }catch (Exception e)
        {
            e.printStackTrace();
            return Status.ERROR;
        }
    }


}
