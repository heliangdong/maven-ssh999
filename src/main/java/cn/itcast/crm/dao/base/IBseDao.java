package cn.itcast.crm.dao.base;

import cn.itcast.crm.domain.Staff;
import cn.itcast.crm.utils.PageBean;
import org.hibernate.criterion.DetachedCriteria;

import java.io.Serializable;
import java.util.List;

public interface IBseDao<T> {
    public void save(T entity);
    public void delete(T entity);
    public void update(T entity);
    public T findbyid(Serializable id);
    public List<T> findAll();
    public void pageQuery(PageBean pageBean);
    public void executeUpdate(String queryName,Object...objects);
    public void saveorupdate(T entity);
    List<T> findbyCriteria(DetachedCriteria dc);
}
