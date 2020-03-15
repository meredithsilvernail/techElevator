package com.techelevator.data;

import com.techelevator.entity.Vendable;

import java.util.Date;

public class AuditLogEntry {

    private Date logTimeStamp;

    private String action;

    private Vendable item;

    private Object detail;

    public AuditLogEntry(Date logTimeStamp, String action, Vendable item, Object detail) {
        this.logTimeStamp = logTimeStamp;
        this.action = action;
        this.item = item;
        this.detail = detail;
    }

    public AuditLogEntry(String action, Vendable item, Object detail) {
        this(new Date(), action, item, detail);
    }

    public AuditLogEntry(String action, Vendable item) {
        this(new Date(), action, item, null);
    }

    public Date getLogTimeStamp() {
        return logTimeStamp;
    }

    public void setLogTimeStamp(Date logTimeStamp) {
        this.logTimeStamp = logTimeStamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Vendable getItem() {
        return item;
    }

    public void setItem(Vendable item) {
        this.item = item;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return logTimeStamp.getTime() +
                "|" + action +
                "|" + item +
                "|" + detail;
    }
}
