package br.com.ronaldo.onlineBook.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
import javax.transaction.Transactional;

import br.com.ronaldo.onlineBook.dao.AuthorDAO;
import br.com.ronaldo.onlineBook.dao.BookDAO;
import br.com.ronaldo.onlineBook.file.FileSaver;
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
	@Inject
	private FacesContext context;

	
	private Part bookCover;
	
	@Transactional
	public String salvar() throws IOException{
		
		dao.save(book);
		FileSaver fileSaver = new FileSaver();
		book.setCoverPath(fileSaver.write(bookCover, "books"));
		
		this.book = new Book();
		
		context.getExternalContext().getFlash()
					.setKeepMessages(true);
		
		context.addMessage(null, new FacesMessage("Operacao realizada com sucesso"));
		
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

	public Part getBookCover() {
		return bookCover;
	}

	public void setBookCover(Part bookCover) {
		this.bookCover = bookCover;
	}

	
}
