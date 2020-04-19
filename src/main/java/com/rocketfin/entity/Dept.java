package com.rocketfin.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="DEPT")
public class Dept extends AbstractEntity{

    @Column(name="DEPT_NAME")
    private String name;

    @Column(name="DEPT_VALUE")
    private BigDecimal Value;

    @Column(name = "id_user")
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user", updatable = false, insertable = false)
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return Value;
    }

    public void setValue(BigDecimal value) {
        Value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dept dept = (Dept) o;
        return Objects.equals(name, dept.name) &&
                Objects.equals(Value, dept.Value) &&
                Objects.equals(userId, dept.userId) &&
                Objects.equals(user, dept.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, Value, userId, user);
    }

    @Override
    public String toString() {
        return "Dept{" +
                "name='" + name + '\'' +
                ", Value=" + Value +
                ", userId=" + userId +
                ", user=" + user +
                '}';
    }
}
