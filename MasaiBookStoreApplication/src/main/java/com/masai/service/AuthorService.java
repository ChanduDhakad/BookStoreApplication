package com.masai.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.exception.AuthorException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.User;

public interface AuthorService {

	public List<Author>  getpopularAuthors() throws AuthorException;
	
	public Author deleteAuthor(Integer authorId) throws AuthorException;
	
	
	
	
	
}
