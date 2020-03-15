package com.techelevator.log;

import java.time.LocalDateTime;

public class AuditLogEntry {

    private LocalDateTime logTimeStamp;

    private String action;

    private Object detail;

    public AuditLogEntry(LocalDateTime logTimeStamp, String action, Object detail) {
        this.logTimeStamp = logTimeStamp;
        this.action = action;
        this.detail = detail;
    }

    public AuditLogEntry(String action, Object detail) {
        this(LocalDateTime.now(), action, detail);
    }

    public AuditLogEntry(String action) {
        this(action, null);
    }

    public LocalDateTime getLogTimeStamp() {
        return logTimeStamp;
    }

    public void setLogTimeStamp(LocalDateTime logTimeStamp) {
        this.logTimeStamp = logTimeStamp;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return logTimeStamp +
                "|" + action +
                "|" + detail;
    }
}
