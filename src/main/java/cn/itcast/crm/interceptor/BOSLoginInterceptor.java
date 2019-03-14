package cn.itcast.crm.interceptor;

import cn.itcast.crm.domain.User;
import cn.itcast.crm.utils.GetUserSessionUtils;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class BOSLoginInterceptor extends MethodFilterInterceptor {

    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        ActionProxy proxy = actionInvocation.getProxy();
        String actionName = proxy.getActionName();
        String namespace = proxy.getNamespace();
        String url=namespace+actionName;
        System.out.println("url"+url);
        //从session中获取对象
        User user = GetUserSessionUtils.getUserSession();
        if(user==null){
            //没有登录，跳转到登录页面
            return "login";
        }
        return actionInvocation.invoke();

    }
}
