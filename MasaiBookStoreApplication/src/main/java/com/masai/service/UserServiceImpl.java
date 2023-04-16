package com.masai.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookException;
import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.Book;

import com.masai.model.LoginDto;
import com.masai.model.User;
import com.masai.repository.AuthorRepository;
import com.masai.repository.BookRepository;
import com.masai.repository.CartRepository;

import com.masai.repository.UserRepository;


import ch.qos.logback.core.testUtil.RandomUtil;



@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
;
	

	@Override
	public User registorUser(User user) throws UserException {

		Optional<User> userDataBase=userRepository.findByMobileNumber(user.getMobileNumber());
       User user2=null;
		if(userDataBase.isPresent()) {
			user2=userRepository.save(user);
		}
		else {		
			throw new UserException("User Is Already Registered");
		}
	
		return user2;
		
	}

	@Override
	public Book addBook(Integer userId, Book book) throws BookException,CartException,LoginException,UserException{

		
		
		
		
		
		Optional<User> opt=userRepository.findById(userId);
		if(opt.isPresent()) {
			User existing=opt.get();
			

				
				List<Book> list=existing.getCart().getBooks();
				if(list.size()!=0) {
					for(Book b:list) {
						if(b==book)
							throw new CartException("Book is already added");
					}
					
				}else {
					list.add(book);
					int newtotal=existing.getCart().getTotal();
					existing.getCart().setTotal(newtotal+1);
					
				}
				return book;
			
		}else {
			throw new UserException("User is not found");
		}
		
		
	
	}

	@Override
	public String purchaseBook(Integer userId) throws CartException,UserException {
	 String result="Due TO low Balance You Cannot Purchase";
		Optional<User> optUser=userRepository.findById(userId);
		
		
		if(optUser.isPresent()) {
			User user=optUser.get();
		
			List<Book> books=user.getCart().getBooks();
		if(books!=null) {
			Integer total=0;
			for(Book book:books) {
				total=total+book.getPrice();
			}
			
			
	      if(user.getBudget()>=total) {
	    	
	    	  for(Book book:books) {
	    		  book.setNumberQuantitySale((book.getNumberQuantitySale()+1));
					bookRepository.save(book);
				}
	    	  
	    	  List<Book> booksList=new ArrayList<>();
	    	  user.getCart().setBooks(booksList);
	    	   
	    	  userRepository.save(user);
	    	  result="Your Order Successfully Place";
	    	  
	       }
	      
		}
		else {
			
			throw new CartException("Cart Is Empty");
			
		}
			
		}
		else {
			
			throw new UserException("User Is Not Present By Given Id");
		}
		
		
		return result;
	}

}
