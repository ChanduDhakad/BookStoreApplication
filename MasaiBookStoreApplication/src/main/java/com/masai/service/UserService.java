package com.masai.service;

import javax.security.auth.login.LoginException;

import com.masai.exception.BookException;
import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Book;
import com.masai.model.LoginDto;
import com.masai.model.User;

public interface UserService {

	public User registorUser(User user) throws UserException;
	public Book addBook(Integer userId,Book book)throws BookException, CartException, LoginException, UserException;
	public String purchaseBook(Integer userId)throws CartException,UserException;
	 
	
	
}
