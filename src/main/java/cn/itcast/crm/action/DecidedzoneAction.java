package cn.itcast.crm.action;

import cn.itcast.crm.action.base.BaseAction;
import cn.itcast.crm.domain.Decidedzone;
import cn.itcast.crm.service.DecidedzoneServer;
import com.itheima.crm.service.Customer;
import com.itheima.crm.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Scope("prototype")
public class DecidedzoneAction extends BaseAction<Decidedzone> {
    @Autowired
    private DecidedzoneServer decidedzoneServer;

    private String[] subareaid;

    public String add(){
        decidedzoneServer.save(model,subareaid);
        return  null;
    }

    public String pageQuery(){
        decidedzoneServer.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"currentPage","detachedCriteria",
                "pageSize","subareas","decidedzones"});
        return null;

    }

    //注入crm代理对象
    @Autowired
    private ICustomerService proxy;

    public String findListNotAssociation(){
        List<Customer> list = proxy.findListNotAssociation();
        for(Customer c:list){
            System.out.println("c="+c);
        }
        this.java2Json(list,new String[]{});
        return null;

    }

    public String findListHasAssociation(){
        String id=model.getId();
        List<Customer> list = proxy.findListHasAssociation(id);
        this.java2Json(list,new String[]{});
        return null;
    }

    /**
     * 远程调用crm服务，将客户关联到定区
     */
    private List<Integer> customerIds;
    public String assigncustomerstodecidedzone(){
        System.out.println("id="+model.getId());
        for(Integer i:customerIds){
            System.out.println("customerIds="+i);
        }
        proxy.assigncustomerstodecidedzone(model.getId(), customerIds);
        return LIST;
    }




    public String[] getSubareaid() {
        return subareaid;
    }

    public void setSubareaid(String[] subareaid) {
        this.subareaid = subareaid;
    }

    public List<Integer> getCustomerIds() {
        return customerIds;
    }

    public void setCustomerIds(List<Integer> customerIds) {
        this.customerIds = customerIds;
    }
}
