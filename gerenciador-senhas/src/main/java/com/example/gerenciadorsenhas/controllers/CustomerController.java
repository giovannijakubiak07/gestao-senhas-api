package com.example.gerenciadorsenhas.controllers;

import com.example.gerenciadorsenhas.models.Password;
import com.example.gerenciadorsenhas.services.PasswordGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/customer")
@Api(value="PasswordsAPI")
@CrossOrigin(origins="*")
public class CustomerController {

    @Autowired
    private PasswordGenerator passGenerator;

    @PostMapping("/newPassword")
    @ApiOperation(value="Cria nova senha.")
    public Password newPassword(@RequestParam boolean priority){
        System.out.println(priority);
        Password pass = passGenerator.newPassword(priority);
        return pass;
    }


}
