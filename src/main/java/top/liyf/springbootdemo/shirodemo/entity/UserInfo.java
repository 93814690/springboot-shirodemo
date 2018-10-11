package top.liyf.springbootdemo.shirodemo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Description:
 * @Author: liyf
 * @Date: Created in 2018\10\11 0011 10:51
 */
@Entity
@Data
public class UserInfo implements Serializable {

    @Id
    @GeneratedValue
    private Long uid;
    @Column(unique = true)
    private String username;
    private String name;
    private String password;
    private String salt;
    @ManyToMany(fetch= FetchType.EAGER)//立即从数据库中进行加载数据;
    @JoinTable(name = "SysUserRole", joinColumns = { @JoinColumn(name = "uid") }, inverseJoinColumns ={@JoinColumn(name = "roleId") })
    private List<SysRole> roleList;// 一个用户具有多个角色

    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.username+this.salt;
    }
}
