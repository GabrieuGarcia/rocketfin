package com.rocketfin.controller.user.converter;

import com.rocketfin.business.user.bo.UserBO;
import com.rocketfin.controller.user.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOtoUserBOConverter implements Converter<UserDTO, UserBO> {

    @Override
    public UserBO convert(UserDTO dto) {

        return UserBO.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .incomesList(dto.getIncomesList())
                .deptsList(dto.getDeptsList())
                .build();
    }
}
