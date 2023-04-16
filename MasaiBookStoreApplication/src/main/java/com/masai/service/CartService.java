package com.masai.service;

import com.masai.exception.BookException;
import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Cart;
import com.masai.model.User;

public  interface CartService {

public Cart removeBook(Integer cartId)throws CartException;
public String addBookInCart(Integer userId, int id) throws BookException, CartException,UserException ;

}