package com.example.demo.controller;

import com.example.demo.dao.AccessRepository;
import com.example.demo.model.Access;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-09-24
 * Time: 13:33
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
@Controller("/")
public class IndexController {
    @Autowired
    private AccessRepository accessRepository;

    @RequestMapping(value = "/")
    public String test(HttpServletRequest request, HttpServletResponse response, Model model){
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        String deviceType = userAgent.getOperatingSystem().getDeviceType().getName();
        String os = userAgent.getOperatingSystem().getName();
        List<Access> findAccessList = accessRepository.findByUserIpAndDevice(request.getRemoteHost(),deviceType);
        if(accessRepository.findByUserIpAndDevice(request.getRemoteHost(),deviceType).size() == 0){
            Access access = new Access();
            access.setDevice(deviceType);
            access.setAgent(request.getHeader("User-Agent"));
            access.setOs(os);
            access.setCount(1);
            access.setCountry(response.getLocale().getDisplayCountry());
            access.setUserIp(request.getRemoteHost());
            accessRepository.save(access);
        }else {
            for(Access access : findAccessList){
                access.setUpdateTime(new Date());
                access.setCount( access.getCount() + 1);
                accessRepository.save(access);
            }
        }
        model.addAttribute("ip",request.getRemoteHost());
        return "Index";
    }
}
