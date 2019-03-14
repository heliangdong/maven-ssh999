package cn.itcast.crm.dao.base.Impl;

import cn.itcast.crm.dao.base.IBseDao;
import cn.itcast.crm.utils.PageBean;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import javax.annotation.Resource;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements  IBseDao<T> {
    //代表的是某个实体的类型
    private Class<T> entityClass;

    @Resource//根据类型注入spring工厂中的会话工厂对象sessionFactory
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    //在父类（BaseDaoImpl）的构造方法中动态获得entityClass
    public BaseDaoImpl() {
        ParameterizedType superclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获得父类上声明的泛型数组
        Type[] actualTypeArguments = superclass.getActualTypeArguments();
        entityClass = (Class<T>) actualTypeArguments[0];
    }


    public void save(T entity) {
        getHibernateTemplate().save(entity);
    }

    public void delete(T entity) {
        getHibernateTemplate().delete(entity);
    }

    public void update(T entity) {
        getHibernateTemplate().update(entity);
    }

    public T findbyid(Serializable id) {
        return getHibernateTemplate().get(entityClass, id);
    }

    public List<T> findAll() {
        String sql="FROM "+ entityClass.getSimpleName();
        return (List<T>) this.getHibernateTemplate().find(sql);
    }

    public void pageQuery(PageBean pageBean) {
        try {
            int currentPage = pageBean.getCurrentPage();
            int pageSize = pageBean.getPageSize();
            DetachedCriteria detachedCriteria = pageBean.getDetachedCriteria();
            //查询total---总数据量
            detachedCriteria.setProjection(Projections.rowCount());//指定hibernate框架发出sql的形式----》select count(*) from bc_staff;
            List<Long> countList = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
            Long count = countList.get(0);
            pageBean.setTotal(count.intValue());

            //查询rows---当前页需要展示的数据集合
            detachedCriteria.setProjection(null);//指定hibernate框架发出sql的形式----》select * from bc_staff;
            int firstResult = (currentPage - 1) * pageSize;
            int maxResults = pageSize;
            List rows = this.getHibernateTemplate().findByCriteria(detachedCriteria, firstResult, maxResults);
            pageBean.setRows(rows);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
    //执行更新
    public void executeUpdate(String queryName, Object... objects) {
        Session session = this.getSessionFactory().getCurrentSession();
        Query query = session.getNamedQuery(queryName);
        int i = 0;
        for (Object object : objects) {
            //为HQL语句中的？赋值
            query.setParameter(i++, object);
        }
        //执行更新
        query.executeUpdate();
    }

    public void saveorupdate(T entity) {
        this.getHibernateTemplate().saveOrUpdate(entity);
    }


}
