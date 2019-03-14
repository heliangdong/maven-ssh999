package cn.itcast.crm.dao;

import cn.itcast.crm.dao.base.IBseDao;
import cn.itcast.crm.domain.User;

public interface IUserDao extends IBseDao<User> {
    User findUserByUsernameAndPassword(String username, String password);

}
