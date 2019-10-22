package dao;

import model.User;
import org.springframework.orm.hibernate4.HibernateTemplate;

import java.util.List;

public class BaseDaoIml extends HibernateTemplate implements BaseDao {

    public List<User> findAllByHQL(String s, Object[] objects) {
        return (List<User>) find(s,objects);
    }

    public List<User> findObjectByHQL(String s, Object[] objects) {
        return (List<User>) find(s,objects);
    }
}