package com.luo.controller;

;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.luo.controller.CaseController;
import com.luo.domain.CaseInfo;
import com.luo.service.CaseService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Controller
@RequestMapping({"/case"})
public class CaseController {
    @Autowired
    private CaseService caseService;

    @RequestMapping({"/findAllCase"})
    @ResponseBody
    public ModelAndView findAllCase() {
        String allCase = null;
        try{
            allCase = this.caseService.findAllCase();
        }catch (Exception e){
            e.printStackTrace();
        }

        JSONArray array = JSONArray.parseArray(allCase);
        Map<String,Object> map = new HashMap<>();
        map.put("result",array);
        System.out.println("controller_data:"+allCase);
        return new ModelAndView((View) new MappingJackson2JsonView(), map);
    }

    @RequestMapping({"/saveCase"})
    @ResponseBody
    public ModelAndView saveCase(@RequestBody CaseInfo caseInfo) {
        Map<String, Boolean> map = new HashMap<>();
        try {
            boolean flag = this.caseService.saveCase(caseInfo);
            map.put("result", Boolean.valueOf(flag));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView((View) new MappingJackson2JsonView(), map);
    }


    @RequestMapping({"/findAllSelectCase"})

    @ResponseBody
    public ModelAndView findAllSelectCase(String projectName, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {

        List<CaseInfo> list = new ArrayList<>();

        list = this.caseService.findAllSelectCasePage(projectName, page.intValue(), size.intValue());

        PageInfo pageInfo = new PageInfo(list);

        Map<String, Object> caseInfoMap = new HashMap<>();

        Map<String, Object> pageInfoMap = new HashMap<>();

        caseInfoMap.put("result", list);

        pageInfoMap.put("obj", pageInfo);

        caseInfoMap.putAll(pageInfoMap);

        return new ModelAndView((View) new MappingJackson2JsonView(), caseInfoMap);

    }


    @RequestMapping({"/findConditionCase"})

    @ResponseBody
    public ModelAndView findConditionCase(String conditionSelect, String conditionValue, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {

        List<CaseInfo> list = new ArrayList<>();

        list = this.caseService.findConditionCase(conditionValue, conditionSelect, page, size);

        PageInfo pageInfo = new PageInfo(list);

        Map<String, Object> caseinfoMap = new HashMap<>();

        Map<String, Object> pageinfoMap = new HashMap<>();

        caseinfoMap.put("result", list);

        pageinfoMap.put("obj", pageInfo);

        caseinfoMap.putAll(pageinfoMap);

        return new ModelAndView((View) new MappingJackson2JsonView(), caseinfoMap);

    }


    @RequestMapping({"/findAllSelectCaseAfterEdit"})

    @ResponseBody
    public ModelAndView findAllSelectCaseAfterEdit(String projectName, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {

        ModelAndView modelAndView = new ModelAndView();

        List<CaseInfo> list = new ArrayList<>();

        list = this.caseService.findAllSelectCasePage(projectName, page.intValue(), size.intValue());

        System.out.println("编辑过后的list:" + list);

        PageInfo pageInfo = new PageInfo(list);

        System.out.println("pageInfo:" + pageInfo);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.addObject("caselist", list);

        modelAndView.setViewName("case-list-edit");

        return modelAndView;

    }


    @RequestMapping({"/findAllSelectCaseAfterAdd"})
    public ModelAndView findAllSelectCaseAfterAdd(String projectName, @RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {

        ModelAndView modelAndView = new ModelAndView();

        List<CaseInfo> list = new ArrayList<>();

        list = this.caseService.findAllSelectCasePage(projectName, page.intValue(), size.intValue());

        PageInfo pageInfo = new PageInfo(list);

        System.out.println("pageInfo:" + pageInfo);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.addObject("caselist", list);

        modelAndView.setViewName("case-list-add");

        return modelAndView;

    }


    @RequestMapping({"/findAllCasePage"})

    @ResponseBody
    public ModelAndView findAllCasePage(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page, @RequestParam(name = "size", required = true, defaultValue = "10") Integer size) {

        List<CaseInfo> list = new ArrayList<>();

        list = this.caseService.findAllCasePage(page.intValue(), size.intValue());

        PageInfo pageInfo = new PageInfo(list);

        Map<String, Object> mp = new HashMap<>();

        mp.put("obj", pageInfo);

        System.out.println("pageInfo:" + mp);

        Map<String, Object> map = new HashMap<>();

        map.put("result", list);

        System.out.println("list:" + list);

        map.putAll(mp);

        System.out.println("最后的map" + map);

        return new ModelAndView((View) new MappingJackson2JsonView(), map);

    }


    @RequestMapping({"/delSelectCase"})

    @ResponseBody
    public ModelAndView delSelectCase(@RequestParam(value = "caseid", required = true) String caseid) {

        System.out.println("传过来的caseid:" + caseid);

        boolean result = this.caseService.delSelectCase(caseid);

        System.out.println("CaseController里的result:" + result);

        Map<String, Boolean> map = new HashMap<>();

        map.put("result", Boolean.valueOf(result));

        return new ModelAndView((View) new MappingJackson2JsonView(), map);

    }


    @RequestMapping({"/findCaseById"})
    public ModelAndView findCaseById(@RequestParam(value = "caseid", required = true) String caseid) {

        ModelAndView modelAndView = new ModelAndView();

        CaseInfo caseInfo = this.caseService.findCaseByCaseid(caseid);

        modelAndView.addObject("caseInfo", caseInfo);

        modelAndView.setViewName("case-edit");

        System.out.println("caseInfo:" + caseInfo);

        return modelAndView;

    }


    @RequestMapping({"findCaseByIdReturnJson"})
    public ModelAndView findCaseByIdReturnJson(@RequestParam(value = "caseid", required = true) String caseid) {

        List<CaseInfo> list = new ArrayList<>();

        list = this.caseService.findCaseByIdReturnJson(caseid);

        Map<String, List<CaseInfo>> map = new HashMap<>();

        map.put("result", list);

        return new ModelAndView((View) new MappingJackson2JsonView(), map);

    }


    @RequestMapping({"/editCase"})

    @ResponseBody
    public ModelAndView editCaseById(@RequestBody CaseInfo caseInfo) {
        boolean result = true;
        try {
            result = this.caseService.editCase(caseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Map<String, Boolean> map = new HashMap<>();

        map.put("result", Boolean.valueOf(result));

        return new ModelAndView((View) new MappingJackson2JsonView(), map);

    }


    @RequestMapping({"/getProjectById"})
    public String getProjectById(String caseid) {

        String project = this.caseService.findProjectById(caseid);

        return project;

    }

}


