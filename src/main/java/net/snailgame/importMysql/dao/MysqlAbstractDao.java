package net.snailgame.importMysql.dao;

import java.util.List;

/**
 * <p>
 * Title: MysqlAbstractDao.java
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
public interface MysqlAbstractDao {
    public abstract List<Object> getDatas(String sql);

    public abstract int inserts(String sql, List<Object> paramList);
}
