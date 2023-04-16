package com.masai.model;

import java.time.LocalDate;


import jakarta.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

	
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookId;
	
	
	
	private String name;
	
	@ManyToOne()
	private Author author;
	
	private Integer pages;
	
	private String publisher;
	
	private Integer price;
	

	private LocalDate CartAdddate;
	
	private Integer numberQuantitySale;
	
	
	
	
	
	
}
