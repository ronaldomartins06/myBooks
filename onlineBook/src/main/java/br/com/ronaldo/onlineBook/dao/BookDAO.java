package br.com.ronaldo.onlineBook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ronaldo.onlineBook.models.Book;

public class BookDAO {
	
	
	@PersistenceContext
	private EntityManager manager;

	public void save(Book book){
		manager.persist(book);
	
	}

	public List<Book> listAllBooks() {
		String jpql = "select distinct(b) from Book b join fetch b.authors";
		
		return manager.createQuery(jpql, Book.class).getResultList();
	}
}
