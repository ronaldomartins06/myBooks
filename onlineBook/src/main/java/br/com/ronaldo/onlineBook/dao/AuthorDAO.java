package br.com.ronaldo.onlineBook.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.ronaldo.onlineBook.models.Author;

public class AuthorDAO {

	@PersistenceContext
	EntityManager manager;
	
	public List<Author> listAuthors(){
		return manager.createQuery("SELECT a FROM Author a", Author.class).getResultList();
	}
}
