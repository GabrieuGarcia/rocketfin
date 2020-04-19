package com.rocketfin.controller.income.dto;

import com.rocketfin.controller.user.dto.UserDTO;
import com.rocketfin.entity.User;

import java.math.BigDecimal;
import java.util.Objects;

public class IncomeDTO {

    private String name;

    private BigDecimal value;

    private UserDTO user;


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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeDTO incomeDTO = (IncomeDTO) o;
        return Objects.equals(name, incomeDTO.name) &&
                Objects.equals(value, incomeDTO.value) &&
                Objects.equals(user, incomeDTO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value, user);
    }

    @Override
    public String toString() {
        return "IncomeDTO{" +
                "name='" + name + '\'' +
                ", value=" + value +
                ", user=" + user +
                '}';
    }
}
