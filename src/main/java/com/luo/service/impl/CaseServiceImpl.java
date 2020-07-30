package com.luo.service.impl;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.luo.dao.CaseDao;
import com.luo.domain.CaseInfo;
import com.luo.service.CaseService;
import com.luo.service.impl.CaseServiceImpl;
import java.util.ArrayList;
import java.util.List;

import com.luo.utils.JedisPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;


@Service("caseService")

@Transactional
public class CaseServiceImpl implements CaseService {


    @Autowired
     private CaseDao caseDao;

    public String findAllCase() {
        Jedis jedis = JedisPoolUtils.getJedis();
        String allCase = jedis.get("allCase");
        //判断allCase数据是否为null
        if(allCase==null || allCase.length()==0){
            //redis中没数据
            System.out.println("redis：没有数据");
            //数据库中获取
            List<CaseInfo> caseInfoList = caseDao.findAllCase();
            //序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                allCase = mapper.writeValueAsString(caseInfoList);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //讲数据存入到redis
            jedis.set("allCase",allCase);
            jedis.close();

        }else {
            System.out.println("redis：有数据");
        }
        return allCase;
//        return this.caseDao.findAllCase();
    }


    public boolean saveCase(CaseInfo caseInfo) {
        Integer num = this.caseDao.saveCase(caseInfo);
        boolean flag = true;
        if (num == 1) {
            flag = true;
        } else {
            flag = false;
        }
        System.out.println("flag:" + flag);
        return flag;
    }


    public CaseInfo findCaseByCaseid(String caseid) {
        return this.caseDao.findCaseByCaseid(caseid);
    }


    public String findProjectIdByName(String projectName) {
        return this.caseDao.findProjectIdByName(projectName);
    }


    public List<CaseInfo> findAppointCase(String projectId) {
        return this.caseDao.findAppointCase(projectId);
    }


    public CaseInfo findCaseByCaseName(String caseName) {
        return this.caseDao.findCaseByCaseName(caseName);
    }


    public List<CaseInfo> findAllCasePage(int page, int size) {

        PageHelper.startPage(page, size);

        return this.caseDao.findAllCase();

    }


    public List<CaseInfo> findAllSelectCasePage(String projectName, int page, int size) {
        //=================================================================================
        List<CaseInfo> list = new ArrayList<>();
        Jedis jedis = JedisPoolUtils.getJedis();
        String allCase = jedis.get("allCasePage");
        if(allCase==null || allCase.length()==0){
            System.out.println("redis：没有数据");
            //数据库中获取
            if (projectName.equals("请选择项目")) {

                PageHelper.startPage(page, size);

                list = this.caseDao.findAllCase();


            } else {

                PageHelper.startPage(page, size);

                list = this.caseDao.findAllSelectCase(projectName);

            }
//            List<CaseInfo> caseInfoList = caseDao.findAllCase();
            //序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                allCase = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //讲数据存入到redis
            jedis.set("allCasePage",allCase);
            jedis.close();
        }else{
            System.out.println("redis中有数据");
        }




        return list;

    }


    public boolean delSelectCase(String caseid) {
        boolean flag;
        Integer num = null;
        try{
             num=this.caseDao.delSelectCase(caseid);
        }catch (Exception e){

        }
        if (num == 1) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }


    public CaseInfo findCaseById(String caseid) {
        return null;
    }


    public boolean editCase(CaseInfo caseInfo) {
        Jedis jedis = JedisPoolUtils.getJedis();
        System.out.println("caseInfo:"+caseInfo);
        boolean flag;
        Integer num = null;
        String casename = "case_"+caseInfo.getCaseName();
        String edit_case = jedis.get(casename);
        try{
            num = this.caseDao.editCase(caseInfo);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(num==1){
            flag = true;
        }else {
            flag = false;
        }
        //更新：先更新数据库-》在删除redis中的老数据-》在更新新数据到redis
        //查询redis中是否有这条数据
        if(edit_case==null || edit_case.length()==0){
            //redis中没这条数据

            System.out.println("redis中没有allCasePage.....");
        }else{
            //redis中有这条数据，删除
            try{
                Long del = jedis.del("allCasePage");
                System.out.println("del:"+del);
            }catch (Exception e){
                e.printStackTrace();
            }

            System.out.println("旧的redis已删除");
        }
        //归还连接池
        jedis.close();

        return flag;

    }


    public String findProjectById(String caseid) {
        return this.caseDao.findProjectById(caseid);
    }


    public List<CaseInfo> findCaseByIdReturnJson(String caseid) {
        return this.caseDao.findCaseByIdReturnJson(caseid);
    }


    public List<CaseInfo> findConditionCase(String conditionValue, String conditionSelect, Integer page, Integer size) {

        PageHelper.startPage(page.intValue(), size.intValue());

        if (conditionSelect.equals("接口名称")) {

            conditionSelect = "caseName";

        }

        System.out.println("conditionSelect:" + conditionSelect);

        System.out.println("conditionValue:" + conditionValue);

        return this.caseDao.findConditionCase(conditionValue);

    }

}

