package com.masai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.AuthorException;
import com.masai.exception.UserException;
import com.masai.model.Author;
import com.masai.model.Book;
import com.masai.model.User;
import com.masai.repository.AuthorRepository;
import com.masai.repository.BookRepository;
import com.masai.repository.CartRepository;
import com.masai.repository.UserRepository;

@Service
public class AuthorServiceImpl implements AuthorService {

	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired 
	private CartRepository cartRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	@Override
	public List<Author> getpopularAuthors() throws AuthorException {
		List<Author> list=authorRepository.findAll();
		List<Author> popularAuthors=new ArrayList<>();
		Integer max=0;
		for(Author author:list) {
		     Integer sum=0; 
			List<Book> books=author.getBooks();
			for(Book book:books) {
		     		sum=sum+book.getNumberQuantitySale();
			}
			if(sum>max) {
				max=sum;
			}}
		for(Author a:list) {
		     Integer sum=0; 
				List<Book> books1=a.getBooks();
				for(Book book:books1) {
			     		sum=sum+book.getNumberQuantitySale();
				}
				if(max==sum) {
					popularAuthors.add(a);			
				}
		}
		return popularAuthors;
	}

	@Override
	public Author deleteAuthor(Integer authorId) throws AuthorException {
	   Author author=null;
		Optional<Author> opt=authorRepository.findById(authorId);
		
		if(opt.isPresent()) {
          
		   author=opt.get();
			
		   authorRepository.delete(author);
		}
		else {
			
			throw new AuthorException("Author Is Not found by  "+authorId);
			
		}
		return author; 
		
	}


}
