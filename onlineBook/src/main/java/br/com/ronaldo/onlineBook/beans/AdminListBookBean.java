package br.com.ronaldo.onlineBook.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.ronaldo.onlineBook.dao.BookDAO;
import br.com.ronaldo.onlineBook.models.Book;

@Model
public class AdminListBookBean {

	@Inject
	private BookDAO bookDAO;
	
	private List<Book> books = new ArrayList<>();

	public List<Book> getBooks() {
		this.books = bookDAO.listAllBooks();
		
		return books;
	}
}
