package top.liyf.springbootdemo.shirodemo.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import top.liyf.springbootdemo.shirodemo.entity.SysPermission;
import top.liyf.springbootdemo.shirodemo.entity.SysRole;
import top.liyf.springbootdemo.shirodemo.entity.UserInfo;
import top.liyf.springbootdemo.shirodemo.service.UserInfoService;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: liyf
 * @Date: Created in 2018\10\11 16:03
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserInfo userInfo  = (UserInfo)principalCollection.getPrimaryPrincipal();
        for (SysRole role : userInfo.getRoleList()) {
            authorizationInfo.addRole(role.getRole());
            for (SysPermission p : role.getPermissions()) {
                authorizationInfo.addStringPermission(p.getPermission());
            }
        }
        return authorizationInfo;
    }


    @Override
    //重写获取用户信息的方法。
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        UserInfo userInfo = userInfoService.findByUsername(username);
        //System.out.println("----->>userInfo="+userInfo);
        if(userInfo == null){
            return null;
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                userInfo, userInfo.getPassword(),ByteSource.Util.bytes(userInfo.getCredentialsSalt()), getName()
        );
        return simpleAuthenticationInfo;
    }
}
