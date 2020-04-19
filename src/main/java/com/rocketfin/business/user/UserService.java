package com.rocketfin.business.user;

import com.rocketfin.business.income.IncomesService;
import com.rocketfin.business.income.bo.IncomeBO;
import com.rocketfin.business.user.bo.UserBO;
import com.rocketfin.business.user.converter.UserBOtoUserConverter;
import com.rocketfin.entity.Income;
import com.rocketfin.entity.User;
import com.rocketfin.exception.BusinessException;
import com.rocketfin.respository.UserRepository;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserBOtoUserConverter converter;
    private final IncomesService incomesService;

    public UserService(UserRepository userRepository, UserBOtoUserConverter converter, IncomesService incomesService) {
        this.userRepository = userRepository;
        this.converter = converter;
        this.incomesService = incomesService;
    }

    public User saveUser(UserBO bo) {

        try {
            User user = converter.convert(bo);

            userRepository.save(user);

            return user;

        } catch (Exception e) {
            throw new BusinessException("Não foi possível salvar o usuário!");
        }
    }
}
