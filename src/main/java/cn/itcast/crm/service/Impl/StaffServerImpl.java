package cn.itcast.crm.service.Impl;

import cn.itcast.crm.dao.StaffDao;
import cn.itcast.crm.domain.Staff;
import cn.itcast.crm.service.StaffServer;
import cn.itcast.crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServerImpl implements StaffServer {
    @Autowired
    private StaffDao staffDao;

    public void save(Staff staff) {
        staffDao.save(staff);
    }

    public void pageQuery(PageBean pageBean) {
        staffDao.pageQuery(pageBean);
    }

    public void deleteBatch(String ids) {
        if(ids!=null){
            String[] staffIds = ids.split(",");
            for(String id:staffIds){
                staffDao.executeUpdate("staff.delete",id);
            }
        }

    }

    public void update(Staff staff) {
        staffDao.update(staff);
    }

    public List<Staff> findListNotDelete() {
        DetachedCriteria dc=DetachedCriteria.forClass(Staff.class);
        dc.add(Restrictions.eq("deltag","1"));
        return staffDao.findbyCriteria(dc);
    }

}
