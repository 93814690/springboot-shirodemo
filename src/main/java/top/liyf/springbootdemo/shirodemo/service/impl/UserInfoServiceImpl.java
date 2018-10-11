package top.liyf.springbootdemo.shirodemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.liyf.springbootdemo.shirodemo.dao.UserInfoDao;
import top.liyf.springbootdemo.shirodemo.entity.UserInfo;
import top.liyf.springbootdemo.shirodemo.service.UserInfoService;

import javax.annotation.Resource;


/**
 * @Description:
 * @Author: liyf
 * @Date: Created in 2018\10\11 0011 16:22
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
