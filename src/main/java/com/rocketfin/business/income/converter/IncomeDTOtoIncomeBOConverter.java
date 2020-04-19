package com.rocketfin.business.income.converter;

import com.rocketfin.business.income.bo.IncomeBO;
import com.rocketfin.controller.income.dto.IncomeDTO;
import com.rocketfin.controller.user.converter.UserDTOtoUserBOConverter;
import org.springframework.core.convert.converter.Converter;

public class IncomeDTOtoIncomeBOConverter implements Converter<IncomeDTO, IncomeBO> {

    private final UserDTOtoUserBOConverter converter;

    public IncomeDTOtoIncomeBOConverter(UserDTOtoUserBOConverter converter) {
        this.converter = converter;
    }

    @Override
    public IncomeBO convert(IncomeDTO dto) {

        return IncomeBO.builder()
                .name(dto.getName())
                .value(dto.getValue())
                .user(converter.convert(dto.getUser()))
                .build();
    }
}
