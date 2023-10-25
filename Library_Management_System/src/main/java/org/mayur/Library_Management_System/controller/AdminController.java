package org.mayur.Library_Management_System.controller;

import org.mayur.Library_Management_System.models.Admin;
import org.mayur.Library_Management_System.request.CreateAdminRequest;
import org.mayur.Library_Management_System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @PostMapping("/create")
    public Admin create(@RequestBody @Valid CreateAdminRequest createAdminRequest){
        return adminService.create(createAdminRequest);
    }
}
