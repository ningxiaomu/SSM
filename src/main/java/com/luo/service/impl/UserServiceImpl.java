package com.luo.service.impl;

/*     */

import com.github.pagehelper.PageHelper;
import com.luo.dao.UserDao;
import com.luo.domain.RoleInfo;
import com.luo.domain.UserInfo;
import com.luo.service.UserService;
import com.luo.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

import com.luo.utils.JedisPoolUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;


@Service("user")

@Transactional
public class UserServiceImpl implements UserService {
    Jedis jedis = JedisPoolUtils.getJedis();
    @Autowired
    private UserDao userDao;
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        UserInfo userInfo = null;

        try {

            userInfo = this.userDao.findByUsername(s);


            String username=userInfo.getUsername();

            String user = jedis.get("login_"+username);
            //判断是否在redis中
            if(user==null||user.length()==0){
                //redis中没有数据
                System.out.println("redis中没数据，要开始存了......");
                jedis.set("login_"+username,String.valueOf(userInfo));
                jedis.close();
            }else {
                System.out.println("redis中有数据，直接读取......");
            }

            System.out.println("springsecurity查出来的账户信息："+userInfo);

        } catch (Exception e) {

            e.printStackTrace();

        }

        User user = null;

        try {

            user = new User(userInfo.getUsername(), "{noop}" + userInfo.getPassword(), !(userInfo.getStatus().intValue() == 0), true, true, true, getAuthority(userInfo.getRoles()));

        } catch (Exception e) {

            e.printStackTrace();

        }

        return (UserDetails) user;

    }


    public List<SimpleGrantedAuthority> getAuthority(List<RoleInfo> roles) throws Exception {

        List<SimpleGrantedAuthority> list = new ArrayList<>();

        for (RoleInfo role : roles) {

            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));

        }

        System.out.println("用户角色list：" + list);

        return list;

    }


    public List<UserInfo> findAllUser() {
        return this.userDao.findAllUser();
    }


    public UserInfo findUserByName(String username) {
        return null;
    }


    public List<UserInfo> findAllUserPage(int page, int size) {

        PageHelper.startPage(page, size);

        return this.userDao.findAllUser();

    }


    public List<UserInfo> findUserDel(int page, int size) {

        PageHelper.startPage(page, size);

        return this.userDao.findDelUser();

    }


    public String getUserCount() {
        return this.userDao.getUserCount();
    }


    public String getProjectCount() {
        return this.userDao.getProjectCount();
    }


    public String getCaseCount() {
        return this.userDao.getCaseCount();
    }


    public boolean saveUser(UserInfo userInfo) {

        boolean flag;

        Integer saveBefore = this.userDao.getCount();

        try {

            this.userDao.saveUser(userInfo);

        } catch (Exception e) {

            e.printStackTrace();

        }

        Integer saveAfter = this.userDao.getCount();

        Integer num = Integer.valueOf(saveAfter.intValue() - saveBefore.intValue());

        if (num.toString().equals("1")) {

            flag = true;

        } else {

            flag = false;

        }

        return flag;

    }


    public UserInfo findUserById(String userid) {
        return this.userDao.findUserById(userid);
    }


    public List<RoleInfo> findUserOtherRole(String userid) {
        return this.userDao.findOtherRoles(userid);
    }

}

