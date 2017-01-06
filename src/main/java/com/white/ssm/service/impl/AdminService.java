package com.white.ssm.service.impl;

import com.white.ssm.common.Status;
import com.white.ssm.mapper.AdminMapper;
import com.white.ssm.model.Admin;
import com.white.ssm.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * admin service 查寻数据库
 * Created by vector on 16/12/3.
 */
@Service("adminService")
public class AdminService implements IAdminService{
    @Resource
    AdminMapper adminMapper;
    public Admin getAdminByID(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    public int updateAdmin(Admin admin) {
        try{
            adminMapper.updateByPrimaryKey(admin);
            return Status.SUCCESS;
        }catch (Exception e){
            return Status.ERROR;
        }
    }

}
