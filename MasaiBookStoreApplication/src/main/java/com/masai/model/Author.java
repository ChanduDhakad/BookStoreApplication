package com.masai.model;



import java.util.ArrayList;
import java.util.List;

import jakarta.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Author {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer authorId;
	
	@NotNull(message = "first Name  cannot set as null")
	@NotEmpty(message = "first Name  cannot set as empty")
	@NotBlank(message = "first Name  cannot set as blank")
	@Pattern(regexp = "[A-Za-z]")
	private String name;
	
	@NotNull(message = "contact cannot set as null")
	@Column(unique = true)
	@Pattern(regexp = "^[789]\\d{9}$")
	private String mobileNo;
	
	@NotNull(message = "address cannot set as null")
	@NotEmpty(message = "address cannot set as empty")
	@NotBlank(message = "address cannot set as blank")
	private String address;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "author")
	private List<Book> books=new ArrayList<>();
	
	
}
