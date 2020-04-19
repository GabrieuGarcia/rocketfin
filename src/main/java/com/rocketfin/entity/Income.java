package com.rocketfin.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="INCOME")
public class Income extends AbstractEntity{

    @Column(name="INCOME_NAME")
    private String name;

    @Column(name="INCOME_VALUE")
    private BigDecimal value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_USER")
    private User user;

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
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
        Income income = (Income) o;
        return Objects.equals(name, income.name) &&
                Objects.equals(value, income.value) &&
                Objects.equals(user, income.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, value, user);
    }

    @Override
    public String toString() {
        return "Income{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", user=" + user +
                '}';
    }


    public static final class Builder {
        private String name;
        private Long id;
        private BigDecimal value;
        private User user;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Income build() {
            Income income = new Income();
            income.setName(name);
            income.setId(id);
            income.setValue(value);
            income.setUser(user);
            return income;
        }
    }
}
