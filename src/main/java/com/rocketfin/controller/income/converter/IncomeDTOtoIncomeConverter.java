package com.rocketfin.controller.income.converter;

import com.rocketfin.controller.income.dto.IncomeDTO;
import com.rocketfin.entity.Income;
import com.rocketfin.exception.BusinessException;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IncomeDTOtoIncomeConverter implements Converter<IncomeDTO, Income> {

    private final ModelMapper modelMapper;

    public IncomeDTOtoIncomeConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Income convert(IncomeDTO incomeDTO) {
        Income income = modelMapper.map(incomeDTO,Income.class);

        if(income == null) {
            throw new BusinessException("The conversion was not possible!");
        }
        return income;
    }
}
