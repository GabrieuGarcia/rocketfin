package com.rocketfin.business.income.bo;

import com.rocketfin.business.user.bo.UserBO;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Objects;

public class IncomeBO {

    @NotBlank
    private String name;

    @NotBlank
    private BigDecimal value;

    @NotBlank
    private UserBO user;

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

    public UserBO getUser() {
        return user;
    }

    public void setUser(UserBO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeBO incomeBO = (IncomeBO) o;
        return Objects.equals(name, incomeBO.name) &&
                Objects.equals(value, incomeBO.value) &&
                Objects.equals(user, incomeBO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, user);
    }

    @Override
    public String toString() {
        return "IncomeBO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", user=" + user +
                '}';
    }


    public static final class Builder {
        private String name;
        private BigDecimal value;
        private UserBO user;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder value(BigDecimal value) {
            this.value = value;
            return this;
        }

        public Builder user(UserBO user) {
            this.user = user;
            return this;
        }

        public IncomeBO build() {
            IncomeBO incomeBO = new IncomeBO();
            incomeBO.setName(name);
            incomeBO.setValue(value);
            incomeBO.setUser(user);
            return incomeBO;
        }
    }
}
