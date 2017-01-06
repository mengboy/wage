package com.white.ssm.service;

import com.white.ssm.common.QueryBase;
import com.white.ssm.model.Employee;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * 员工service层接口
 * Created by vector on 16/12/11.
 */
public interface IEmployeeService {
    public String saveImg(CommonsMultipartFile img, String eid);
    public int saveEmploye(Employee employee);
    public int getAllEmploy(QueryBase queryBase);
    public int getAllByDepart(QueryBase queryBase);
    public String getEmployeeDepartById(int eid);

    public Employee getById(int eId);

    public int updateEmployee(Employee employee);
    public int deleteEmployById(int id);
}
