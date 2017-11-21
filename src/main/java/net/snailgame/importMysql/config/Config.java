package net.snailgame.importMysql.config;

/**
 * <p>
 * Title: Config.java
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
public class Config {
    private EnumRunType runType;
    private String dataFilePath;
    private String doingFilePath;
    private String finishPath;
    private int sendNumMin;
    private String sendMqTopic;
    private String userAttrTag;
    private String acctRelTag;
    private String userOrderTag;
    private int insertDbThreadNum = 10;
    private int sendMqThreadNum = 10;
    private EnumTableName tableName;

    public String getDataFilePath() {
        return dataFilePath;
    }

    public void setDataFilePath(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }

    public int getSendNumMin() {
        return sendNumMin;
    }

    public void setSendNumMin(int sendNumMin) {
        this.sendNumMin = sendNumMin;
    }

    public String getSendMqTopic() {
        return sendMqTopic;
    }

    public void setSendMqTopic(String sendMqTopic) {
        this.sendMqTopic = sendMqTopic;
    }

    public String getUserAttrTag() {
        return userAttrTag;
    }

    public void setUserAttrTag(String userAttrTag) {
        this.userAttrTag = userAttrTag;
    }

    public String getAcctRelTag() {
        return acctRelTag;
    }

    public void setAcctRelTag(String acctRelTag) {
        this.acctRelTag = acctRelTag;
    }

    public String getUserOrderTag() {
        return userOrderTag;
    }

    public void setUserOrderTag(String userOrderTag) {
        this.userOrderTag = userOrderTag;
    }

    public String getFinishPath() {
        return finishPath;
    }

    public void setFinishPath(String finishPath) {
        this.finishPath = finishPath;
    }

    public int getInsertDbThreadNum() {
        return insertDbThreadNum;
    }

    public void setInsertDbThreadNum(int insertDbThreadNum) {
        this.insertDbThreadNum = insertDbThreadNum;
    }

    public int getSendMqThreadNum() {
        return sendMqThreadNum;
    }

    public void setSendMqThreadNum(int sendMqThreadNum) {
        this.sendMqThreadNum = sendMqThreadNum;
    }

    public EnumRunType getRunType() {
        return runType;
    }

    public void setRunType(String runType) {
        this.runType = EnumRunType.valueOf(runType.toUpperCase());
    }

    public EnumTableName getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = EnumTableName.valueOf(tableName.toUpperCase());
    }

    public String getDoingFilePath() {
        return doingFilePath;
    }

    public void setDoingFilePath(String doingFilePath) {
        this.doingFilePath = doingFilePath;
    }
}
