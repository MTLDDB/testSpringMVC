package dao;



import model.User;

import java.util.List;

public interface BaseDao {

    List<User> findAllByHQL(String s, Object[] objects);

    List<User> findObjectByHQL(String s, Object[] objects);
}
