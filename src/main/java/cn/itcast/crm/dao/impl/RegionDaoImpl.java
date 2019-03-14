package cn.itcast.crm.dao.impl;

import cn.itcast.crm.dao.RegionDao;
import cn.itcast.crm.dao.base.Impl.BaseDaoImpl;
import cn.itcast.crm.domain.Region;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegionDaoImpl extends BaseDaoImpl<Region> implements RegionDao {
    public List<Region> findlike(String q) {
        String sql="FROM Region where citycode LIKE ?";
        List<Region> list = (List<Region>) this.getHibernateTemplate().find(sql,'%'+q+'%');
        return list;
    }
}
