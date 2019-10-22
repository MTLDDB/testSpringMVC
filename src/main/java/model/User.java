package model;


import sun.awt.SunHints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/*@Table(name = "t_user")
@Entity*/
public class User {

    //@Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    /** 用户名 **/
    String name;
    /** 密码 **/
    String password;
    /** 是否删除 **/
    Integer isDelete;
    /** 创建时间 **/
    Date createDate;
    //多对多用户权限表
   // @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    List<UserRole> userRoles;

    public Integer getId() {
        return id;
    }
    //@Column(name = "id")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
   // @Column(name = "name")
    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }
   // @Column(name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsDelete() {
        return isDelete;
    }
   // @Column(name = "isDelete")
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateDate() {
        return createDate;
    }
    //@Column(name = "createDate")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }
}
