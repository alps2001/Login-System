package com.example.bankLogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.bankLogin.model.LoginDTO;
import com.example.bankLogin.model.UserDTO;
import com.example.bankLogin.model.ValidateDTO;
import com.example.bankLogin.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(UserDTO userDTO) {
        String message = userService.registerUser(userDTO);
        if (message.startsWith("Error")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        } else {
            return ResponseEntity.ok(message);
        }
    }

    @PostMapping("/login")
    public ModelAndView  loginUser(LoginDTO loginDTO) {
        String message = userService.loginUser(loginDTO);
        if (message.startsWith("Error")) {
        	 final ModelAndView modelAndView = new ModelAndView("error");
             return modelAndView;
        } else {
        	final ModelAndView modelAndView = new ModelAndView("login");
        	modelAndView.addObject("isValid", false);
            modelAndView.addObject("message", message);
            return modelAndView;
        }
    }
    
    @PostMapping("/validate")
    public ModelAndView validateUser(ValidateDTO validateDTO) {
        final boolean isValid = userService.isValidate(validateDTO);
        if (isValid) {
        	 final ModelAndView modelAndView = new ModelAndView("success");
             return modelAndView;
        } else {
        	final ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("message", validateDTO.getGeneratedOTP());
            modelAndView.addObject("isValid", true);
            return modelAndView;
        }
    }
}
