package com.example.springbootmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "staff", schema = "table_userma", catalog = "")
public class StaffEntity {
    private int id;
    private Integer staffid;
    private String staffname;
    private String deparmentname;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "staffid")
    public Integer getStaffid() {
        return staffid;
    }

    public void setStaffid(Integer staffid) {
        this.staffid = staffid;
    }

    @Basic
    @Column(name = "staffname")
    public String getStaffname() {
        return staffname;
    }

    public void setStaffname(String staffname) {
        this.staffname = staffname;
    }

    @Basic
    @Column(name = "deparmentname")
    public String getDeparmentname() {
        return deparmentname;
    }

    public void setDeparmentname(String deparmentname) {
        this.deparmentname = deparmentname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaffEntity that = (StaffEntity) o;
        return id == that.id &&
                Objects.equals(staffid, that.staffid) &&
                Objects.equals(staffname, that.staffname) &&
                Objects.equals(deparmentname, that.deparmentname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staffid, staffname, deparmentname);
    }
}
