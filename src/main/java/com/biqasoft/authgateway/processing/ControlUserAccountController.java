/*
* Copyright (c) 2016 biqasoft.com




 */

package com.biqasoft.authgateway.processing;

import com.biqasoft.authgateway.processing.dto.UserAccountAddRequest;
import com.biqasoft.entity.dto.useraccount.UserRegisterRequest;
import com.biqasoft.entity.core.useraccount.UserAccount;
import com.biqasoft.microservice.common.MicroserviceUsersRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Nikita Bakaev, ya@nbakaev.ru
 *         Date: 10/5/2015
 *         All Rights Reserved
 */
@RestController
@Api("Control user accounts")
@RequestMapping("/accounts")
public class ControlUserAccountController {

    private final MicroserviceUsersRepository microserviceUsersRepository;

    @Autowired
    public ControlUserAccountController(MicroserviceUsersRepository microserviceUsersRepository) {
        this.microserviceUsersRepository = microserviceUsersRepository;
    }

    @GetMapping
    public List<UserAccount> getAllUserAccount() {
        return microserviceUsersRepository.unsafeFindAllUsers();
    }

    @ApiOperation(value = "update")
    @PutMapping
    public UserAccount updateUserAccount(@RequestBody UserAccount userAccount) {
        return microserviceUsersRepository.updateUserAccount(userAccount);
    }

    @ApiOperation(value = "add")
    @PostMapping
    public UserAccount addUserAccount(@RequestBody UserAccountAddRequest userAccount) {
        UserRegisterRequest requestDTO = new UserRegisterRequest(userAccount, false, userAccount.getDomain(), null);
        return microserviceUsersRepository.addUser(requestDTO);
    }

    @ApiOperation(value = "delete")
    @DeleteMapping(value = "{id}")
    public void deleteUserAccountByUsername(@PathVariable("id") String id) {
        microserviceUsersRepository.unsafeDeleteUserById(id);
    }

}


