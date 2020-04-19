package com.rocketfin.controller.user;

import com.rocketfin.business.income.IncomesService;
import com.rocketfin.controller.user.converter.UserDTOtoUserBOConverter;
import com.rocketfin.controller.user.dto.UserDTO;
import com.rocketfin.business.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "user")
public class UserRest {

    private final UserService userService;
    private final IncomesService incomesService;
    private final UserDTOtoUserBOConverter userConverter;

    public UserRest(UserService userService, IncomesService incomesService, UserDTOtoUserBOConverter userConverter) {
        this.userService = userService;
        this.incomesService = incomesService;
        this.userConverter = userConverter;
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.saveUser(userConverter.convert(dto)), HttpStatus.CREATED);
    }


}
