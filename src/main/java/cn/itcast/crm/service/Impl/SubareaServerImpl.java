package cn.itcast.crm.service.Impl;

import cn.itcast.crm.action.SubareaAction;
import cn.itcast.crm.dao.SubareaDao;
import cn.itcast.crm.domain.Subarea;
import cn.itcast.crm.service.SubareaServer;
import cn.itcast.crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubareaServerImpl implements SubareaServer {
    @Autowired
    private SubareaDao subareaDao;

    public void save(Subarea model) {
        subareaDao.save(model);
    }

    public void pageQuery(PageBean pageBean) {
        subareaDao.pageQuery(pageBean);
    }

    public List<Subarea> getall() {

        return subareaDao.findAll();
    }

    public List<Subarea> findListNotAssociation() {
        DetachedCriteria dc=DetachedCriteria.forClass(Subarea.class);
        dc.add(Restrictions.isNull("decidedzone"));

        return     subareaDao.findbyCriteria(dc);
    }

    public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
        DetachedCriteria dc=DetachedCriteria.forClass(Subarea.class);
        dc.add(Restrictions.eq("decidedzone.id",decidedzoneId));
        return subareaDao.findbyCriteria(dc);
    }
}
