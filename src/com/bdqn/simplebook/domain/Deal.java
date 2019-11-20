package com.bdqn.simplebook.domain;

import java.sql.Timestamp;

/**
 * @author: 赖榕
 * @date: 2019/11/19
 * @description: 交易表
 * @version: 1.0
 * @since: JDK1.8
 * @packageName: com.bdqn.simplebook.domain
 */
public class Deal {
    private Integer did; // 交易编号
    private Double money; // 交易金额
    private Integer status; // 交易状态
    private Integer uid; // 交易用户编号
    private Timestamp dealTime; // 交易时间
    private Integer dealType; // 交易类型
    private String tradeName; // 商品名称

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    public Integer getDealType() {
        return dealType;
    }

    public void setDealType(Integer dealType) {
        this.dealType = dealType;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Deal{");
        sb.append("did=").append(did);
        sb.append(", money=").append(money);
        sb.append(", status=").append(status);
        sb.append(", uid=").append(uid);
        sb.append(", dealTime=").append(dealTime);
        sb.append(", dealType=").append(dealType);
        sb.append(", tradeName='").append(tradeName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
