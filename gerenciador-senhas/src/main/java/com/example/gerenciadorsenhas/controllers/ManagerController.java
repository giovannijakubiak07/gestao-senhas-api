package com.example.gerenciadorsenhas.controllers;

import com.example.gerenciadorsenhas.models.Password;
import com.example.gerenciadorsenhas.services.PasswordGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/manager")
@Api(value="PasswordsAPI")
@CrossOrigin(origins="*")
public class ManagerController {

    @Autowired
    private PasswordGenerator passGenerator;

    @GetMapping("/callNext")
    @ApiOperation(value="Chama próxima senha.")
    public Password callNext(){
        Password pass = passGenerator.callNext();
        return pass;
    }

    @GetMapping("/reset")
    @ApiOperation(value="Reseta as senhas.")
    public void reset(){
        passGenerator.reset();
    }

    @GetMapping("/list")
    @ApiOperation(value="Lista de senhas.")
    public ArrayList<Password> list(){
        return passGenerator.list();

    }
}
