package com.urfu.project.dto;


import com.urfu.project.validation.StrongPassword;
import com.urfu.project.validation.ValidPhone;

public class UserDto {

    @ValidPhone
    private String phone;

    @StrongPassword
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
