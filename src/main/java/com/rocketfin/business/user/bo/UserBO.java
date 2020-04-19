package com.rocketfin.business.user.bo;

import com.rocketfin.entity.Dept;
import com.rocketfin.entity.Income;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

public class UserBO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Email
    @NotBlank
    private String email;

    private List<Income> incomesList;

    private List<Dept> deptsList;

    public static Builder builder() {
        return new Builder();
    }

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


    public static final class Builder {
        private String username;
        private String password;
        private String email;
        private List<Income> incomesList;
        private List<Dept> deptsList;

        private Builder() {
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder incomesList(List<Income> incomesList) {
            this.incomesList = incomesList;
            return this;
        }

        public Builder deptsList(List<Dept> deptsList) {
            this.deptsList = deptsList;
            return this;
        }

        public UserBO build() {
            UserBO userBO = new UserBO();
            userBO.setUsername(username);
            userBO.setPassword(password);
            userBO.setEmail(email);
            userBO.setIncomesList(incomesList);
            userBO.setDeptsList(deptsList);
            return userBO;
        }
    }
}
