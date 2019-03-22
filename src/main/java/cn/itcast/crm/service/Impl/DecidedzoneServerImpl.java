package cn.itcast.crm.service.Impl;

import cn.itcast.crm.dao.DecidedzoneDao;
import cn.itcast.crm.dao.SubareaDao;
import cn.itcast.crm.domain.Decidedzone;
import cn.itcast.crm.domain.Subarea;
import cn.itcast.crm.service.DecidedzoneServer;
import cn.itcast.crm.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DecidedzoneServerImpl implements DecidedzoneServer {

    @Autowired
    private DecidedzoneDao decidedzoneDao;
    @Autowired
    private SubareaDao subareaDao;

    public void save(Decidedzone model, String[] subareaid) {
        decidedzoneDao.save(model);
        for(String id:subareaid){
            Subarea subarea=subareaDao.findbyid(id);
            subarea.setDecidedzone(model);
        }
    }

    public void pageQuery(PageBean pageBean) {
        subareaDao.pageQuery(pageBean);
    }
}
