package com.white.ssm.service.impl;

import com.white.ssm.common.QueryBase;
import com.white.ssm.common.Status;
import com.white.ssm.mapper.PayMapper;
import com.white.ssm.model.Employee;
import com.white.ssm.model.Pay;
import com.white.ssm.model.User;
import com.white.ssm.service.IEmployeeService;
import com.white.ssm.service.IpayService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 工资service
 * 根据参数调用mybatis中的查询方法
 * Created by vector on 16/12/3.
 */
@Service("payService")
public class PayService implements IpayService{
    @Resource
    PayMapper payMapper;
    @Resource
    IEmployeeService iEmployeeService;
    public int getAll(QueryBase queryBase, List<String> depart_list) {
        try{
            queryBase.setTotalRow(this.payMapper.getAllPageCount(queryBase));
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(Pay pay : this.payMapper.getAll(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("pay", pay);
                mapLists.add(map);
                depart_list.add(this.iEmployeeService.getEmployeeDepartById(pay.geteId()));
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
     * 根据时间获取工资记录
     * @param queryBase
     * @param depart_list
     * @return
     */
    public int getByYearAndMounth(QueryBase queryBase, List<String> depart_list) {
        try{
            queryBase.setTotalRow(this.payMapper.getAllPageCountByTime(queryBase));
            System.out.println("totalRow" + queryBase.getTotalRow());
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(Pay pay : this.payMapper.getByYearAndMounth(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("pay", pay);
                mapLists.add(map);
//                System.out.println(this.iEmployeeService.getEmployeeDepartById(pay.geteId()));
                depart_list.add(this.iEmployeeService.getEmployeeDepartById(pay.geteId()));
            }
            queryBase.setResults(mapLists);
            return Status.SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }


    public int getByDepartAndTime(QueryBase queryBase, List<String> depart_list) {
        try{
            queryBase.setTotalRow(this.payMapper.getAllPageCountByDepartAndTime(queryBase));
            System.out.println("totalRow" + queryBase.getTotalRow());
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(Pay pay : this.payMapper.getByDepartAndTime(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("pay", pay);
                mapLists.add(map);
                depart_list.add(this.iEmployeeService.getEmployeeDepartById(pay.geteId()));
            }
            queryBase.setResults(mapLists);
            return Status.SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }


    public int getById(QueryBase queryBase, List<String> depart_list){
        try{
            queryBase.setTotalRow(this.payMapper.getByeIdPageCount(queryBase));
            System.out.println("totalRow" + queryBase.getTotalRow());
            Map<String, Object> map = null;
            List<Map<String, Object>> mapLists = new ArrayList<Map<String, Object>>();
            for(Pay pay : this.payMapper.getByeId(queryBase))
            {
                map = new HashMap<String, Object>();
                map.put("pay", pay);
                mapLists.add(map);
                depart_list.add(this.iEmployeeService.getEmployeeDepartById(pay.geteId()));
            }
            queryBase.setResults(mapLists);
            return Status.SUCCESS;

        }catch (Exception e){
            e.printStackTrace();
            return Status.ERROR;
        }
    }

    public Pay getPayById(int pId) {
        try{
            return payMapper.selectByPrimaryKey(pId);
        }catch (Exception e) {
            return null;
        }
    }

    public int addPay(Pay pay) {
        try{
            payMapper.insertSelective(pay);
            return Status.SUCCESS;
        }catch (Exception e)
        {
            return Status.ERROR;
        }
    }

    public Pay getByIdAndTime(QueryBase queryBase) {
        return payMapper.getByEidAndTime(queryBase);
    }

    public List<Pay> getByName(String name) {
        return payMapper.getByName(name);
    }

    public int delBypId(int pId) {
        try {
            payMapper.deleteByPrimaryKey(pId);
            return Status.SUCCESS;
        }catch (Exception e)
        {
            return Status.ERROR;
        }
    }

    public int updateBypId(Pay pay) {
        try {
            payMapper.updateByPrimaryKey(pay);
            return Status.SUCCESS;
        }catch (Exception e){
            return Status.ERROR;
        }
    }
}
