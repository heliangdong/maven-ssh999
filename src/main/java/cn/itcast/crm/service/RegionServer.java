package cn.itcast.crm.service;

import cn.itcast.crm.domain.Region;
import cn.itcast.crm.utils.PageBean;

import java.util.List;

public interface RegionServer {

    void saveBeth(List<Region> list);

    void pageQuery(PageBean pageBean);

    List<Region> listajax();

    List<Region> listajax(String q);
}
