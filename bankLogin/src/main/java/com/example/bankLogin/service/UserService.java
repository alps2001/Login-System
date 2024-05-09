package com.example.bankLogin.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.bankLogin.model.LoginDTO;
import com.example.bankLogin.model.User;
import com.example.bankLogin.model.UserDTO;
import com.example.bankLogin.model.ValidateDTO;
import com.example.bankLogin.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private JavaMailSender javaMailSender;

    public String registerUser(UserDTO userDTO) {
        if (!isValidEmail(userDTO.getEmail())) {
            return "Error: Invalid email format";
        }
        if (!isValidMobileNumber(userDTO.getMobileNo())) {
            return "Error: Invalid mobile number";
        }

        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setMobileNo(userDTO.getMobileNo());
        user.setUserName(userDTO.getUserName());

        userRepository.save(user);

        return "User successfully registered";
    }

    public String loginUser(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user == null) {
            return "Error: Email not found";
        }

        String otp = generateOTP();

        String result = sendOTPByEmail(loginDTO.getEmail(), otp);
        System.err.println("innn=-=-=");
        if (result.startsWith("Failed")) {
            return "Error: Failed to send OTP";
        }

        return otp;
    }
    
    public boolean isValidate(ValidateDTO validateDTO) {
    	if(validateDTO != null && validateDTO.getEnteredOTP() != null && validateDTO.getGeneratedOTP() != null) {
    		return validateDTO.getEnteredOTP().equalsIgnoreCase(validateDTO.getGeneratedOTP());}
    	else {
    		return false;
    	}
    }


    private String generateOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);
    }

    public String sendOTPByEmail(String email, String otp) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("projectfor202324@gmail.com"); // Set your email address
            message.setTo(email);
            message.setSubject("OTP for Login");
            message.setText("Your OTP for login is: " + otp);
            javaMailSender.send(message);
            return "OTP sent successfully to " + email;
        } catch (Exception e) {
            return "Failed to send OTP: " + e.getMessage();
        }
    }

    private boolean isValidEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    private boolean isValidMobileNumber(String mobileNo) {
        return mobileNo != null && mobileNo.matches("^[6-9]\\d{9}$");
    }
}
