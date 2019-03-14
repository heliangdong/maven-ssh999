package cn.itcast.crm.service.Impl;

import cn.itcast.crm.dao.IUserDao;
import cn.itcast.crm.dao.impl.IUserDaoimpl;
import cn.itcast.crm.domain.User;
import cn.itcast.crm.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServerImple implements UserServer {
    @Autowired
    private IUserDao iUserDao;

    public User getuserbypassword(User u) {
        User user=iUserDao.findUserByUsernameAndPassword(u.getUsername(),u.getPassword());
        return user;
    }

    public void updatepassword(User user) {
        iUserDao.update(user);
    }


}
