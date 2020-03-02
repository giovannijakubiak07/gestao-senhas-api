package com.example.gerenciadorsenhas.services;

import com.example.gerenciadorsenhas.models.Password;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PasswordGenerator {

    private ArrayList<Password> preferencialPasswords = null;
    private ArrayList<Password> normalPasswords = null;
    private ArrayList<Password> passwords = null;


    public void reset(){
        try {
            preferencialPasswords = null;
            normalPasswords= null;
            passwords= null;
        }catch(Exception e ){
            e.printStackTrace();
        }
        normalPasswords = new ArrayList<>();
        preferencialPasswords = new ArrayList<>();
        passwords = new ArrayList<>();
    }

    public Password newPassword(boolean preferencial){
        if(preferencialPasswords == null && normalPasswords == null && passwords == null){
            reset();
        }
        Password pass = new Password();
        System.out.println("-------------"+ preferencial);
        pass.setPritorary(preferencial);
        try {
            if(pass.isPritorary()) {
                pass.setNumber(preferencialPasswords.get(preferencialPasswords.size() - 1).getNumber() + 1);
            }else{
                pass.setNumber(normalPasswords.get(normalPasswords.size() - 1).getNumber() + 1);
            }

        }catch(Exception e ){
            System.out.println("Null List: " + e);
            pass.setNumber(1);
        }
        pass.setPass(generatePassword(pass));
        if(pass.isPritorary()) {
            preferencialPasswords.add(pass);
        }else{
            normalPasswords.add(pass);
        }
        organizeList();

        return pass;
    }


    public String generatePassword(Password pass){
        String password = "";

        String passwordNumber = String.valueOf(pass.getNumber());
        int numberLength = passwordNumber.length();
        System.out.println("number: " + numberLength);

        if (pass.isPritorary()){
            password += "P";
        }else{
            password += "N";
        }

        switch (numberLength){
            case 1:
                password += "###"+passwordNumber;
                break;
            case 2:
                password += "##"+passwordNumber;
                break;
            case 3:
                password += "#"+passwordNumber;
                break;
            case 4:
                password += ""+passwordNumber;
                break;
            case 5:
                password += "ENCERRADO";
                break;
        }
        System.out.println("generatedPass "+ pass.getPass());
        return password;
    }

    public void organizeList(){
        passwords.clear();
        for (int i = 0; i < preferencialPasswords.size(); i++) {
            passwords.add(preferencialPasswords.get(i));
        }
        for (int i = 0; i < normalPasswords.size(); i++) {
            passwords.add(normalPasswords.get(i));
        }
        System.out.println(passwords.toString());
    }
    public Password callNext(){
        Password pass = passwords.get(0);
        if(pass.isPritorary()){
            preferencialPasswords.remove(pass);
        }else{
            normalPasswords.remove(pass);
        }
        normalPasswords.remove(pass);
        organizeList();
        System.out.println(pass.getPass());
        return pass;
    }
    public ArrayList<Password> list(){
        return this.passwords;
    }



}
