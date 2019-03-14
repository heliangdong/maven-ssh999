package cn.itcast.crm.service;

import cn.itcast.crm.domain.User;

public interface UserServer {
    public User getuserbypassword(User u);

    void updatepassword(User user);
}
