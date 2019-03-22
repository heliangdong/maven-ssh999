package cn.itcast.crm.action;

import cn.itcast.crm.domain.User;
import cn.itcast.crm.service.UserServer;
import cn.itcast.crm.utils.GetUserSessionUtils;
import com.itheima.crm.service.Customer;
import com.itheima.crm.service.ICustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
@Scope("prototype")
public class UserAction  extends ActionSupport implements ModelDriven<User> {

    @Autowired
    private UserServer userService;
    @Autowired
    private ICustomerService proxy;

    User u=new User();


    public User getModel() {
        return u;
    }
    //验证码
    String checkcode;

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String login(){
        //测试代理ICustomerService proxy
        List<Customer> list = proxy.findAll();
        System.out.println("list="+list);

        List<Customer> list1 = proxy.findListNotAssociation();
        for(Customer c:list1){
            System.out.println("c="+c);
        }


        //获取session中生成的验证码
        String validatecode= (String) ServletActionContext.getRequest().getSession().getAttribute("key");
        if(checkcode!=null&&checkcode.equals(validatecode)){
            User user=userService.getuserbypassword(u);
            if(user==null){
                this.addActionError("用户不存在或者密码不正确");
                return "tologin";
            }else{
                //登录成功，把user放入到session中
                ServletActionContext.getRequest().getSession().setAttribute("user",user);
                return "tohome";
            }
        }else {
            this.addActionError("验证码不正确");
            return "tologin";
        }
    }
    //登出
    public String loginout(){
        ServletActionContext.getRequest().getSession().invalidate();
        return "tologin";
    }
    //修改密码
    public String updatepassword() throws IOException {
        //定义结果通知
        int i=1;
        //获取请求密码
        System.out.println("u="+u.getPassword());
        //获取seesion中的用户
        User user = GetUserSessionUtils.getUserSession();
        //更新密码到user对象中
        user.setPassword(u.getPassword());
        try {
            userService.updatepassword(user);
        }catch (Exception e){
            i=0;
        }
        System.out.println("i"+i);
        ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(i);


        return null;
    }
}
