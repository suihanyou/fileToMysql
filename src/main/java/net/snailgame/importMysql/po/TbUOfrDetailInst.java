package net.snailgame.importMysql.po;

import java.sql.Timestamp;

/**
 * <p>
 * Title: TbUOfrDetailInst.java
 * <p>
 * Description:
 * <p>
 * Copyright: Copyright (c) 2016
 * 
 * @author SHY 2016年7月14日
 * @version 1.0
 */
public class TbUOfrDetailInst implements Comparable<TbUOfrDetailInst> {
    private long ofrDetailInstId;// 销售品明细实例 bigint y n n n
    private String ofrDetailInstName;
    private long ofrDetailInstRefId;// 销售品明细实例引用标识 bigint n n n y
    private long ofrInstId;// 销售品实例标识 bigint n n n n
    private String ofrId;// 销售品标识 int n n n n
    private String ofrDetailTypeId;// 销售品明细类型 varchar(20) n n n n
    private String ofrDetailInstDesc;
    private Timestamp crtDate;
    private Timestamp effDate;// 生效时间 date n n n n
    private Timestamp expDate;// 失效时间 date n n n n
    private Timestamp modDate;
    private String effState;
    private int ofrInstLatnId;// 销售品实例本地网标识 int n n n n
    private int latnId;// 本地网标识 int n n n n
    private long ofrDetailId;// 销售品与产品关系标识 bigint n n n n
    private String newFlag;// 明细实例是否新增（0：否；1：是） char(2) n y n n
    private int sourceType;// sid数据来源标识（默认为0） int n n n n
    private long custId;// 客户标识 bigint n y n n
    private int calcPriority;


    public TbUOfrDetailInst() {

    }


    public TbUOfrDetailInst(String ofrId, long custId, Timestamp effDate, Timestamp expDate) {
        this.ofrId = ofrId;
        this.custId = custId;
        this.effDate = effDate;
        this.expDate = expDate;
    }



    public TbUOfrDetailInst(long ofrDetailInstId, String ofrDetailInstName, long ofrDetailInstRefId, long ofrInstId,
            String ofrId, String ofrDetailTypeId, String ofrDetailInstDesc, Timestamp crtDate, Timestamp effDate,
            Timestamp expDate, Timestamp modDate, int ofrInstLatnId, int latnId, String effState, long ofrDetailId,
            String newFlag, int sourceType, long custId) {
        super();
        this.ofrDetailInstId = ofrDetailInstId;
        this.ofrDetailInstName = ofrDetailInstName;
        this.ofrDetailInstRefId = ofrDetailInstRefId;
        this.ofrInstId = ofrInstId;
        this.ofrId = ofrId;
        this.ofrDetailTypeId = ofrDetailTypeId;
        this.ofrDetailInstDesc = ofrDetailInstDesc;
        this.crtDate = crtDate;
        this.effDate = effDate;
        this.expDate = expDate;
        this.modDate = modDate;
        this.ofrInstLatnId = ofrInstLatnId;
        this.latnId = latnId;
        this.effState = effState;
        this.ofrDetailId = ofrDetailId;
        this.newFlag = newFlag;
        this.sourceType = sourceType;
        this.custId = custId;
    }

    public long getOfrDetailInstId() {
        return ofrDetailInstId;
    }

    public void setOfrDetailInstId(long ofrDetailInstId) {
        this.ofrDetailInstId = ofrDetailInstId;
    }

    public String getOfrDetailInstName() {
        return ofrDetailInstName;
    }

    public void setOfrDetailInstName(String ofrDetailInstName) {
        this.ofrDetailInstName = ofrDetailInstName;
    }

    public long getOfrDetailInstRefId() {
        return ofrDetailInstRefId;
    }

    public void setOfrDetailInstRefId(long ofrDetailInstRefId) {
        this.ofrDetailInstRefId = ofrDetailInstRefId;
    }

    public long getOfrInstId() {
        return ofrInstId;
    }

    public void setOfrInstId(long ofrInstId) {
        this.ofrInstId = ofrInstId;
    }

    public String getOfrId() {
        return ofrId;
    }

    public void setOfrId(String ofrId) {
        this.ofrId = ofrId;
    }

    public String getOfrDetailTypeId() {
        return ofrDetailTypeId;
    }

    public void setOfrDetailTypeId(String ofrDetailTypeId) {
        this.ofrDetailTypeId = ofrDetailTypeId;
    }

    public String getOfrDetailInstDesc() {
        return ofrDetailInstDesc;
    }

    public void setOfrDetailInstDesc(String ofrDetailInstDesc) {
        this.ofrDetailInstDesc = ofrDetailInstDesc;
    }

    public Timestamp getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Timestamp crtDate) {
        this.crtDate = crtDate;
    }

    public Timestamp getEffDate() {
        return effDate;
    }

    public void setEffDate(Timestamp effDate) {
        this.effDate = effDate;
    }

    public Timestamp getExpDate() {
        return expDate;
    }

    public void setExpDate(Timestamp expDate) {
        this.expDate = expDate;
    }

    public Timestamp getModDate() {
        return modDate;
    }

    public void setModDate(Timestamp modDate) {
        this.modDate = modDate;
    }

    public String getEffState() {
        return effState;
    }

    public void setEffState(String effState) {
        this.effState = effState;
    }

    public int getOfrInstLatnId() {
        return ofrInstLatnId;
    }

    public void setOfrInstLatnId(int ofrInstLatnId) {
        this.ofrInstLatnId = ofrInstLatnId;
    }

    public int getLatnId() {
        return latnId;
    }

    public void setLatnId(int latnId) {
        this.latnId = latnId;
    }

    public long getOfrDetailId() {
        return ofrDetailId;
    }

    public void setOfrDetailId(long ofrDetailId) {
        this.ofrDetailId = ofrDetailId;
    }

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public int getSourceType() {
        return sourceType;
    }

    public void setSourceType(int sourceType) {
        this.sourceType = sourceType;
    }

    public long getCustId() {
        return custId;
    }

    public void setCustId(long custId) {
        this.custId = custId;
    }

    @Override
    public int compareTo(TbUOfrDetailInst o) {
        return o.getCalcPriority() - this.getCalcPriority();
    }

    public int getCalcPriority() {
        return calcPriority;
    }

    public void setCalcPriority(int calcPriority) {
        this.calcPriority = calcPriority;
    }

}
