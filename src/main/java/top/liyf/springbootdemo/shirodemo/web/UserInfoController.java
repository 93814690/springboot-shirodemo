package top.liyf.springbootdemo.shirodemo.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.liyf.springbootdemo.shirodemo.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liyf
 * @Date: Created in 2018\10\11 0011 17:55
 */
@Controller
@RequestMapping("/userInfo")
public class UserInfoController {

    @Resource
    private UserInfoService service;

    @RequestMapping("/userList")
    @RequiresPermissions("userInfo:view")//权限管理;
    public String userInfo(){
        return "userInfo";
    }
}
