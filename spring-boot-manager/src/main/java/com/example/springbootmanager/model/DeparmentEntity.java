package com.example.springbootmanager.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "deparment", schema = "table_userma", catalog = "")
public class DeparmentEntity {
    private int id;
    private int deparmentId;
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
    @Column(name = "deparment_id")
    public int getDeparmentId() {
        return deparmentId;
    }

    public void setDeparmentId(int deparmentId) {
        this.deparmentId = deparmentId;
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
        DeparmentEntity that = (DeparmentEntity) o;
        return id == that.id &&
                deparmentId == that.deparmentId &&
                Objects.equals(deparmentname, that.deparmentname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deparmentId, deparmentname);
    }
}
