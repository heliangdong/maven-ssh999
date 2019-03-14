package cn.itcast.crm.service.Impl;

import cn.itcast.crm.dao.RegionDao;
import cn.itcast.crm.domain.Region;
import cn.itcast.crm.service.RegionServer;
import cn.itcast.crm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RegionServerImpl implements RegionServer {
    @Autowired
    private RegionDao regionDao;

    public void saveBeth(List<Region> list) {
        for(Region region:list){
            regionDao.saveorupdate(region);
        }

    }

    public void pageQuery(PageBean pageBean) {
        regionDao.pageQuery(pageBean);
    }

    public List<Region> listajax() {

        return regionDao.findAll();
    }

    public List<Region> listajax(String q) {
        return regionDao.findlike(q);
    }
}
