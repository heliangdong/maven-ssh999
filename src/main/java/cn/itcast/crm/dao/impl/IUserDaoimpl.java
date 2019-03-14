package cn.itcast.crm.dao.impl;

import cn.itcast.crm.dao.IUserDao;
import cn.itcast.crm.dao.base.Impl.BaseDaoImpl;
import cn.itcast.crm.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IUserDaoimpl extends BaseDaoImpl<User> implements IUserDao  {
    public User findUserByUsernameAndPassword(String username, String password) {
        String sql="FROM User u WHERE u.username = ? AND u.password = ?";
        List<User> list= (List<User>) getHibernateTemplate().find(sql,username,password);
        if(list!=null &&list.size()>0){
            return  list.get(0);
        }
        return null;
    }


}
