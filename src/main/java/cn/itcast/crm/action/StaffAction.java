package cn.itcast.crm.action;

import cn.itcast.crm.action.base.BaseAction;
import cn.itcast.crm.domain.Staff;
import cn.itcast.crm.service.StaffServer;
import cn.itcast.crm.utils.PageBean;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.event.service.spi.DuplicationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;


@Controller
@Scope("prototype")
public class StaffAction extends BaseAction<Staff> {
    @Autowired
    private StaffServer staffServer;

    public String save(){
        staffServer.save(model);
        return null;
    }

    //属性驱动，接收页面提交的分页参数
    private int page;
    private int rows;
    //分页查询
    public String pageQuery() throws IOException {
        PageBean pageBean=new PageBean();
        pageBean.setCurrentPage(page);
        pageBean.setPageSize(rows);
        //创建离线查询条件
        DetachedCriteria dc = DetachedCriteria.forClass(Staff.class);
        pageBean.setDetachedCriteria(dc);
        staffServer.pageQuery(pageBean);

        //将数组或者集合转换为JSON对象
        JsonConfig jsonConfig=new JsonConfig();
        //指定哪些熟悉不需要转JSON
        jsonConfig.setExcludes(new String[]{"currentPage","detachedCriteria","pageSize"});
        String json=JSONObject.fromObject(pageBean,jsonConfig).toString();
        ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
        ServletActionContext.getResponse().getWriter().print(json);
        return NONE;
    }
    //批量删除
    private String ids;
    public String  deleteBatch(){
        System.out.println("ids"+ids);
        staffServer.deleteBatch(ids);
        return  "tolist";
    }
    //更新操作
    public String update(){
        Staff staff=new Staff();
        staff.setId(model.getId());
        staff.setName(model.getName());
        staff.setTelephone(model.getTelephone());
        staff.setHaspda(model.getHaspda());
        staff.setStandard(model.getStandard());
        staff.setStation(model.getStation());
        staffServer.update(staff);
        return "tolist";
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
