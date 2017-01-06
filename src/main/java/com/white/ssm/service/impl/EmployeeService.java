package com.white.ssm.service.impl;

import com.white.ssm.common.QueryBase;
import com.white.ssm.common.Status;
import com.white.ssm.mapper.EmployeeMapper;
import com.white.ssm.model.Employee;
import com.white.ssm.model.Pay;
import com.white.ssm.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工service
 * Created by vector on 16/12/11.
 */
@Service("employService")
public class EmployeeService implements IEmployeeService{
    @Resource
    EmployeeMapper employeeMapper;

    /**
     * 保存图片
     * @param img
     * @param eid
     * @return
     */
    public String saveImg(CommonsMultipartFile img, String eid) {
        String[] imgName = img.getOriginalFilename().split("\\.");
        int len = imgName.length;
        System.out.println(len);
        try {
            if(len >= 2) {
                //获取输出流
                File imgFile = new File("/Users/vector/IdeaProjects/wage/wage/src/main/webapp/wage/images/" + eid + "." + imgName[len - 1]);
                if(!imgFile.exists())
                {
                    imgFile.createNewFile();
                }
                OutputStream os = new FileOutputStream(imgFile);
                //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
                InputStream is = img.getInputStream();
                int temp;
                //一个一个字节的读取并写入
                while ((temp = is.read()) != (-1)) {
                    os.write(temp);
                }
                os.flush();
                os.close();
                is.close();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            return "文件不存在";
        }
        return eid + "." + imgName[len - 1];
    }

    /**
     * 获取全部员工
     * @param queryBase
     * @return
     */
    public int getAllEmploy(QueryBase queryBase) {
        try{
            queryBase.setTotalRow(this.employeeMapper.getAllPageCount(queryBase));
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(Employee employee : this.employeeMapper.getAll(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("employee", employee);
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

    /**
     * 根据部门查询
     * @param queryBase
     * @return
     */
    public int getAllByDepart(QueryBase queryBase) {
        try{
            queryBase.setTotalRow(this.employeeMapper.getAllPageCountByDepart(queryBase));
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(Employee employee : this.employeeMapper.getAllByDepart(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("employee", employee);
                mapLists.add(map);
            }
            queryBase.setResults(mapLists);
            return Status.SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }

    /**
     * 根据员工id获取员工所属部门
     * @param eid
     * @return
     */
    public String getEmployeeDepartById(int eid) {
        try{
            Employee employee = employeeMapper.selectByPrimaryKey(eid);
            return employee.geteDepart();
        }catch (Exception e)
        {
            return "查询部门失败";
        }

    }

    /**
     * 插入员工
     * @param employee
     * @return
     */
    public int saveEmploye(Employee employee) {
        try{
            employeeMapper.insert(employee);
            return Status.SUCCESS;
        }catch (Exception e)
        {
            return Status.ERROR;
        }
    }


    /**
     * 根据员工id查询
     * @param eId
     * @return
     */
    public Employee getById(int eId){
        try {
            return employeeMapper.selectByPrimaryKey(eId);
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 根据员工id更新
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee) {
        try{
            employeeMapper.updateByPrimaryKeySelective(employee);
            return Status.SUCCESS;
        }catch (Exception e)
        {
            return Status.ERROR;
        }
    }

    public int deleteEmployById(int id) {
        try {
            employeeMapper.deleteByPrimaryKey(id);
            return Status.SUCCESS;
        }catch (Exception e)
        {
            return Status.ERROR;
        }
    }
}
