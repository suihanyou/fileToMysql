package net.snailgame.importMysql.dao.impl;

/**
 * <p>
 * Title: MysqlAbstractDaoImpl.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2017
 * </p>
 * 
 * @author SHY 2017年11月20日
 * @version 1.0
 */
import java.util.List;

import net.snailgame.importMysql.dao.MysqlAbstractDao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

@org.springframework.stereotype.Service
public class MysqlAbstractDaoImpl extends SqlSessionDaoSupport implements MysqlAbstractDao {
    public MysqlAbstractDaoImpl() {
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<Object> getDatas(String sql) {
        return getSqlSession().selectList(sql);
    }

    public int inserts(String sql, List<Object> list) {
        return getSqlSession().insert(sql, list);
    }
}
