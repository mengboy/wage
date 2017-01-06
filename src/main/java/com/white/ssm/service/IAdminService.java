package com.white.ssm.service;

import com.white.ssm.model.Admin;

/**
 * Created by vector on 16/12/3.
 */
public interface IAdminService {
    public Admin getAdminByID(int id);

    public int updateAdmin(Admin admin);
}
