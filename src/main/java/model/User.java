package model;


import org.hibernate.annotations.GenericGenerator;
import sun.awt.SunHints;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_user")
@Entity
public class User {
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
    //List<Role> roles;
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    String user_id;

     public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }


    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Date getCreateDate() {
        return createDate;
    }

}
