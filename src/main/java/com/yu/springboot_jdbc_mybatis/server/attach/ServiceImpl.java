package com.yu.springboot_jdbc_mybatis.server.attach;

import com.yu.springboot_jdbc_mybatis.mappers.ApplicationMapper;
import com.yu.springboot_jdbc_mybatis.pojo.ApplicationUser;
import com.yu.springboot_jdbc_mybatis.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 二十九
 * 附加功能
 */
@Service
public class ServiceImpl implements com.yu.springboot_jdbc_mybatis.server.attach.Service {
    private ApplicationMapper applicationMapper;
        @Autowired
    public void setApplicationMapper(ApplicationMapper applicationMapper) {
        this.applicationMapper = applicationMapper;
    }

    @Override
    public List<ApplicationUser> queryall() {
        return applicationMapper.queryall();
    }

    @Override
    public int queryAppUser(String applicationid) {
        return applicationMapper.queryAppUser(applicationid);
    }

    @Override
    public int addAppUser(ApplicationUser user) {
        return applicationMapper.addAppUser(user);
    }

    @Override
    public int updatePower(String upower, String uname) {
        return applicationMapper.updatePower(upower,uname);
    }

    @Override
    public int updatePass(String remark1,String applicationid) {
        return applicationMapper.updatePass(remark1,applicationid);
    }

    @Override
    public List<Menu> queryMenuNo(String Review) {
        return applicationMapper.queryMenuNo(Review);
    }

    @Override
    public Menu queryMenuOnle(String menuid) {
        return applicationMapper.queryMenuOnle(menuid);
    }

    @Override
    public int passMenu(String menuid) {
        return applicationMapper.passMenu(menuid);
    }

    @Override
    public int deleteAppUser(String applicationid) {
        return applicationMapper.deleteAppUser(applicationid);
    }

    @Override
    public List<Menu> queryMenu(String applicationid,int start,int end) {
        return applicationMapper.queryMenu(applicationid,start,end);
    }

    @Override
    public int total(String applicationid) {
        return applicationMapper.total(applicationid);
    }

    @Override
    public int deleteAppMenu(int menuid) {
        return applicationMapper.deleteAppMenu(menuid);
    }

    @Override
    public int updateAppMenu(Menu menu) {
        return applicationMapper.updateAppMenu(menu);
    }
}
