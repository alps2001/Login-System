package com.example.bankLogin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidateDTO {
	String enteredOTP;	
	String generatedOTP;
}
