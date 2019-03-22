package cn.itcast.crm.service;

import cn.itcast.crm.domain.Decidedzone;
import cn.itcast.crm.utils.PageBean;


public interface DecidedzoneServer {
    void save(Decidedzone model, String[] subareaid);

    void pageQuery(PageBean pageBean);
}

