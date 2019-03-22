package cn.itcast.crm.service;

import cn.itcast.crm.action.SubareaAction;
import cn.itcast.crm.domain.Subarea;
import cn.itcast.crm.utils.PageBean;

import java.util.List;

public interface SubareaServer {

    void save(Subarea model);

    void pageQuery(PageBean pageBean);

    List<Subarea> getall();

    List<Subarea> findListNotAssociation();

    List<Subarea> findListByDecidedzoneId(String decidedzoneId);
}
