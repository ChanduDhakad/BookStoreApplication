package com.masai.controller;



import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.masai.exception.AuthorException;
import com.masai.exception.BookException;
import com.masai.exception.CartException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.LoginDto;
import com.masai.model.User;
import com.masai.service.AuthorService;
import com.masai.service.CartService;
import com.masai.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
 

    @Autowired
    private CartService cartService;
    @Autowired
    private AuthorService  authorService;

    


	@Autowired
	private PasswordEncoder passwordEncoder;

	
	@PostMapping("/users")
	public ResponseEntity<User> saveUserHandler(@RequestBody User User) throws UserException{
		
		User.setPassword(passwordEncoder.encode(User.getPassword()));
		
		User registeredUser= userService.registorUser(User);
		
		return new ResponseEntity<>(registeredUser,HttpStatus.ACCEPTED);
		
	}

    
    @GetMapping("/masaibook/user/cart/{bookId}")
    public ResponseEntity<String> addToCartHandle(@PathVariable int bookId,@RequestParam Integer userId) throws BookException, CartException, UserException{
        return new ResponseEntity<>(cartService.addBookInCart(userId,bookId),HttpStatus.OK);
    }

    @GetMapping("/masaibbok/user/cart/purchase/{bookId}")
    public ResponseEntity<String> purchaseBookHandle(@PathVariable int bookId) throws CartException, UserException {
        return new ResponseEntity<>(userService.purchaseBook(bookId), HttpStatus.OK);
    }

    @GetMapping("/masaibook/athor")

    public ResponseEntity<List<Author>> mostPopularHandle() throws AuthorException {
        return new ResponseEntity<>(authorService.getpopularAuthors(), HttpStatus.OK);
    }
    
  


}
