package net.snailgame.importMysql.po;

import java.sql.Timestamp;

/**
 * <p>
 * Title: TbAAcctBalance.java
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
public class TbAAcctBalance {
    private Long acct_balance_id;
    private Long acct_id;
    private Integer balance_type_id;
    private Integer latn_id;
    private Long balance;
    private Long free_balance;
    private String balance_name;
    private Timestamp eff_date;
    private Timestamp exp_date;
    private String state;

    public Long getAcct_balance_id() {
        return acct_balance_id;
    }

    public void setAcct_balance_id(Long acct_balance_id) {
        this.acct_balance_id = acct_balance_id;
    }

    public Long getAcct_id() {
        return acct_id;
    }

    public void setAcct_id(Long acct_id) {
        this.acct_id = acct_id;
    }

    public Integer getBalance_type_id() {
        return balance_type_id;
    }

    public void setBalance_type_id(Integer balance_type_id) {
        this.balance_type_id = balance_type_id;
    }

    public Integer getLatn_id() {
        return latn_id;
    }

    public void setLatn_id(Integer latn_id) {
        this.latn_id = latn_id;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getFree_balance() {
        return free_balance;
    }

    public void setFree_balance(Long free_balance) {
        this.free_balance = free_balance;
    }

    public String getBalance_name() {
        return balance_name;
    }

    public void setBalance_name(String balance_name) {
        this.balance_name = balance_name;
    }

    public Timestamp getEff_date() {
        return eff_date;
    }

    public void setEff_date(Timestamp eff_date) {
        this.eff_date = eff_date;
    }

    public Timestamp getExp_date() {
        return exp_date;
    }

    public void setExp_date(Timestamp exp_date) {
        this.exp_date = exp_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
