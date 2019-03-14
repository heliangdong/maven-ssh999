package cn.itcast.crm.dao;

import cn.itcast.crm.dao.base.IBseDao;
import cn.itcast.crm.dao.base.Impl.BaseDaoImpl;
import cn.itcast.crm.domain.Region;

import java.util.List;

public interface RegionDao extends IBseDao<Region> {

    List<Region> findlike(String q);
}
