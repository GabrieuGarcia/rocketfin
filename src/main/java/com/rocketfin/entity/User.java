package com.rocketfin.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TB_USER")
public class User extends AbstractEntity {

    @Column(name="USERNAME")
    private String username;

    @NotBlank
    @Column(name="PASSWORD")
    private String password;

    @Email
    @NotBlank
    @Column(name="EMAIL")
    private String email;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Income> incomesList;

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, orphanRemoval = true)
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(incomesList, user.incomesList) &&
                Objects.equals(deptsList, user.deptsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), username, password, email, incomesList, deptsList);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", incomesList=" + incomesList +
                ", deptsList=" + deptsList +
                '}';
    }

    public static final class Builder {
        private Long id;
        private String username;
        private String password;
        private String email;
        private List<Income> incomesList;
        private List<Dept> deptsList;

        private Builder() {
        }


        public Builder id(Long id) {
            this.id = id;
            return this;
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

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setIncomesList(incomesList);
            user.setDeptsList(deptsList);
            return user;
        }
    }
}
