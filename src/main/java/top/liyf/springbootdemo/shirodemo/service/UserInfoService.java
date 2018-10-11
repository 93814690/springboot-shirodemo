package top.liyf.springbootdemo.shirodemo.service;

import top.liyf.springbootdemo.shirodemo.entity.UserInfo;

/**
 * @Description:
 * @Author: liyf
 * @Date: Created in 2018\10\11 0011 16:21
 */
public interface UserInfoService {
    UserInfo findByUsername(String username);
}
