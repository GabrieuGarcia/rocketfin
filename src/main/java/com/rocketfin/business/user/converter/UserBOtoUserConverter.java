package com.rocketfin.business.user.converter;

import com.rocketfin.business.user.bo.UserBO;
import com.rocketfin.entity.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserBOtoUserConverter implements Converter<UserBO, User> {


    @Override
    public User convert(UserBO bo) {

        return User.builder()
                .username(bo.getUsername())
                .email(bo.getEmail())
                .password(bo.getPassword())
                .incomesList(bo.getIncomesList())
                .deptsList(bo.getDeptsList())
                .build();
    }
}
