package cn.itcast.crm.utils;

import cn.itcast.crm.domain.User;
import org.apache.struts2.ServletActionContext;

public class GetUserSessionUtils {
    public static User getUserSession(){
        User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
        return user;
    }
}
