package com.rocketfin.controller.user.dto;

import com.rocketfin.entity.Dept;
import com.rocketfin.entity.Income;

import java.util.List;

public class UserDTO {

    private String username;

    private String password;

    private String email;

    private List<Income> incomesList;

    private List<Dept> deptsList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Income> getIncomesList() {
        return incomesList;
    }

    public void setIncomesList(List<Income> incomesList) {
        this.incomesList = incomesList;
    }

    public List<Dept> getDeptsList() {
        return deptsList;
    }

    public void setDeptsList(List<Dept> deptsList) {
        this.deptsList = deptsList;
    }
}
