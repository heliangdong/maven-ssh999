package cn.itcast.crm.service;

import cn.itcast.crm.domain.Staff;
import cn.itcast.crm.utils.PageBean;

import java.util.List;

public interface StaffServer {
    public void save(Staff staff);

    void pageQuery(PageBean pageBean);

    void deleteBatch(String ids);

    void update(Staff staff);

    List<Staff> findListNotDelete();
}

