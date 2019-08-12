package com.example.hours.model;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "HOURS")
public class HoursModel {
    @Id
    private Integer id;
    private String name;
    private Date createtime;
    private String memo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getMemo() {
        return memo;
    }
    public void setMemo(String memo) {
        this.memo = memo;
    }
}
