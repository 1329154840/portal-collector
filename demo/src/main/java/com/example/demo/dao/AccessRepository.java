package com.example.demo.dao;

import com.example.demo.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Description:  ---——require需求|ask问题|jira
 * Design :  ----the  design about train of thought 设计思路
 * User: yezuoyao
 * Date: 2019-10-02
 * Time: 20:51
 * Email:yezuoyao@huli.com
 *
 * @author yezuoyao
 * @since 1.0-SNAPSHOT
 */
public interface AccessRepository extends JpaRepository<Access, Long> {
    List<Access> findByUserIpAndDevice( String userIp, String device);
}
