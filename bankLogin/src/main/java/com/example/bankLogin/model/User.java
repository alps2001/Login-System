package com.example.bankLogin.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@Table(name = "user_tbl")
public class User{
	
	@Id
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq",schema = "public",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "mobile_no")
    private String mobileNo;
	
	@Column(name = "user_name")
    private String userName;

    // Getters and setters
}
