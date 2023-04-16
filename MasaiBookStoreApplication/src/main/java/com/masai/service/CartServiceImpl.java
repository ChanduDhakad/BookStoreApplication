package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookException;
import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Book;
import com.masai.model.Cart;
import com.masai.model.User;
import com.masai.repository.AuthorRepository;
import com.masai.repository.BookRepository;
import com.masai.repository.CartRepository;
import com.masai.repository.UserRepository;

@Service
public class CartServiceImpl  implements CartService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	

	
	@Override
	public Cart removeBook(Integer cartId) throws CartException {
		
		return null;
	}

	@Override
	public String addBookInCart(Integer userId, int id) throws BookException, CartException, UserException {


		

        String result = "Not Sccsesfully";
        Optional<Book> existbook = bookRepository.findById(id);
        Optional<User>  opt = userRepository.findById(userId);
        if(opt.isPresent()) {
            if (existbook .isPresent()) {
            	
            User user=opt.get();
           Book addBookObj=existbook .get(); 	
            	if(user.getCart()!=null) {
            	List<Book> list=user.getCart().getBooks();
             
            	boolean b=false;
            	for(Book book:list) {
            	if(book.getBookId()==addBookObj.getBookId()) {
            		b=true;
            		break;
            	}
            	}
            	
            	if(b==false) {
            		
            		user.getCart().getBooks().add(addBookObj);
            		userRepository.save(user);
            	}
            	}
            	else {
            		
            		Cart cart=new Cart();
            		cart.getBooks().add(addBookObj);
            		cart.setTotal(addBookObj.getPrice());
            		cart.setUser(user);
            		
            		userRepository.save(user);
            	
            	}
           
            } else { 
            	throw new BookException("Book is not present With bookId " + id);
            }
            }
        else {
        	
        	throw new UserException("User is not present With User Id " + id);
        }
        
        
        return result;

		

	}



}
