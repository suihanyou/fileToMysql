package net.snailgame.importMysql.po;

import java.sql.Timestamp;

public class TbUServ {

    private Long servId;
    private Long custId;
    private String accNbr;
    private Long bandId;
    private String imsiCode;
    private String basicState;
    private String extState;
    private Timestamp stateDate;
    private String offerId;
    private Integer latnId;
    private String streamCeil;
    private String isVpn;
    private Timestamp createDate;
    private Timestamp rentDate;
    private Timestamp completedDate;
    private String sn;


    public TbUServ() {

    }

    public TbUServ(Long servId, Long custId, String accNbr, Long bandId, String imsiCode, String basicState,
            Integer latnId, Timestamp createDate, String sn) {
        this.servId = servId;
        this.custId = custId;
        this.accNbr = accNbr;
        this.bandId = bandId;
        this.imsiCode = imsiCode;
        this.basicState = basicState;
        this.latnId = latnId;
        this.createDate = createDate;
        this.sn = sn;
    }


    public TbUServ(Long servId, Long custId, String accNbr, Long bandId, String imsiCode, String basicState,
            String extState, Timestamp stateDate, String offerId, Integer latnId, String streamCeil, String isVpn,
            Timestamp createDate, Timestamp rentDate, Timestamp completedDate) {
        super();
        this.servId = servId;
        this.custId = custId;
        this.accNbr = accNbr;
        this.bandId = bandId;
        this.imsiCode = imsiCode;
        this.basicState = basicState;
        this.extState = extState;
        this.stateDate = stateDate;
        this.offerId = offerId;
        this.latnId = latnId;
        this.streamCeil = streamCeil;
        this.isVpn = isVpn;
        this.createDate = createDate;
        this.rentDate = rentDate;
        this.completedDate = completedDate;
    }

    public Long getServId() {
        return servId;
    }

    public void setServId(Long servId) {
        this.servId = servId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getAccNbr() {
        return accNbr;
    }

    public void setAccNbr(String accNbr) {
        this.accNbr = accNbr;
    }

    public Long getBandId() {
        return bandId;
    }

    public void setBandId(Long bandId) {
        this.bandId = bandId;
    }

    public String getImsiCode() {
        return imsiCode;
    }

    public void setImsiCode(String imsiCode) {
        this.imsiCode = imsiCode;
    }

    public String getBasicState() {
        return basicState;
    }

    public void setBasicState(String basicState) {
        this.basicState = basicState;
    }

    public String getExtState() {
        return extState;
    }

    public void setExtState(String extState) {
        this.extState = extState;
    }

    public Timestamp getStateDate() {
        return stateDate;
    }

    public void setStateDate(Timestamp stateDate) {
        this.stateDate = stateDate;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }



    public Integer getLatnId() {
        return latnId;
    }


    public void setLatnId(Integer latnId) {
        this.latnId = latnId;
    }

    public String getStreamCeil() {
        return streamCeil;
    }

    public void setStreamCeil(String streamCeil) {
        this.streamCeil = streamCeil;
    }

    public String getIsVpn() {
        return isVpn;
    }

    public void setIsVpn(String isVpn) {
        this.isVpn = isVpn;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getRentDate() {
        return rentDate;
    }

    public void setRentDate(Timestamp rentDate) {
        this.rentDate = rentDate;
    }

    public Timestamp getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(Timestamp completedDate) {
        this.completedDate = completedDate;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}
