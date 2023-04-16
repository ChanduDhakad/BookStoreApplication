package com.masai.model;

import jakarta.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer userId;
	@NotNull(message = "first Name  cannot set as null")
	@NotEmpty(message = "first Name  cannot set as empty")
	@NotBlank(message = "first Name  cannot set as blank")
	@Pattern(regexp = "[A-Za-z]")
	private String firstName;
	
	
	@NotNull(message = "last Name  cannot set as null")
	@NotEmpty(message = "last Name cannot set as empty")
	@NotBlank(message = "last Name cannot set as blank")
	@Pattern(regexp = "[A-Za-z]")
	private String lastName;
	
	
	
	  
	    
	    private String email;
	@NotNull(message = "contact cannot set as null")
	@Column(unique = true)
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNumber;
	
	
	@NotNull(message = "address cannot set as null")
	@NotEmpty(message = "address cannot set as empty")
	@NotBlank(message = "address cannot set as blank")
	private String address;
	
	@NotNull(message = "age cannot set as null")
	@NotEmpty(message = "age cannot set as empty")
	@NotBlank(message = "age cannot set as blank")
	@Min(value = 12,message = "Age Must Greater Than 12 Year")
	private String age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@NotNull(message = "password cannot set as null")
	@NotEmpty(message = "password cannot set as empty")
	@NotBlank(message = "password cannot set as blank")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{6, 12}$")
	private String password;
	
	
	private Integer budget;
	

	@OneToOne(cascade = CascadeType.ALL)
	private Cart cart;
	
}

