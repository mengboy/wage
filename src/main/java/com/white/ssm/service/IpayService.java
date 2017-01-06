package com.white.ssm.service;

import com.white.ssm.common.QueryBase;
import com.white.ssm.model.Employee;
import com.white.ssm.model.Pay;

import java.util.List;

/**
 * 工资service
 * Created by vector on 16/12/3.
 */
public interface IpayService {
    public int getAll(QueryBase queryBase, List<String> depart_list);
    public int getByYearAndMounth(QueryBase queryBase, List<String> depart_list);
    public int getByDepartAndTime(QueryBase queryBase, List<String> depart_list);
    public int addPay(Pay pay);
    public int getById(QueryBase queryBase, List<String> depart_list);
    public Pay getPayById(int pId);
    Pay getByIdAndTime(QueryBase queryBase);
    List<Pay> getByName(String name);

    int delBypId(int pId);

    int updateBypId(Pay pay);
}
