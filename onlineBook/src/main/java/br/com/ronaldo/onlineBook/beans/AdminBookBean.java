package br.com.ronaldo.onlineBook.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.ronaldo.onlineBook.dao.AuthorDAO;
import br.com.ronaldo.onlineBook.dao.BookDAO;
import br.com.ronaldo.onlineBook.models.Author;
import br.com.ronaldo.onlineBook.models.Book;

@Named
@RequestScoped
public class AdminBookBean {
	
	@Inject
	private Book book;
	 
	@Inject
	private BookDAO dao;

	@Inject
	private AuthorDAO authorDAO;
	
	private List<Integer> authorsId = new ArrayList<>();
	
	@Transactional
	public String salvar(){
		
		for (Integer authorId : authorsId) {
			book.getAuthors().add(new Author(authorId));
		}
		dao.save(book);
		
		this.book = new Book();
		this.authorsId = new ArrayList<>();
		return "/books/listBook?faces-redirect=true";
	}
	
	public List<Author> getAllAuthors(){
	
		return authorDAO.listAuthors();
	}
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Integer> getAuthorsId() {
		return authorsId;
	}

	public void setAuthorsId(List<Integer> authorsId) {
		this.authorsId = authorsId;
	}

	
}
