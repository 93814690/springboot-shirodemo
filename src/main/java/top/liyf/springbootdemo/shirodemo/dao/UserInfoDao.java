package top.liyf.springbootdemo.shirodemo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import top.liyf.springbootdemo.shirodemo.entity.UserInfo;

/**
 * @Description:
 * @Author: liyf
 * @Date: Created in 2018\10\11 0011 16:23
 */
@Repository
public interface UserInfoDao extends CrudRepository<UserInfo, Long> {

    UserInfo findByUsername(String username);
}
