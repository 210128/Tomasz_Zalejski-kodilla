package com.soap.library.repository;


import com.kodilla.books.soap.Book;
import com.kodilla.books.soap.LiteraryGenre;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class BooksRepository {
    private static final Map<String, Book> books = new HashMap<>();

    @PostConstruct
    public void initData() {
        Book bookSci = new Book();
        bookSci.setReferenceNumber("SCIFI001");
        bookSci.setAuthor("Ian McDonald");
        bookSci.setTitle("River of Gods");
        bookSci.setPublicationDate(2004);
        bookSci.setLiteraryGenre(LiteraryGenre.SCI_FI);

        books.put(bookSci.getReferenceNumber(), bookSci);

        Book bookSci1 = new Book();
        bookSci1.setReferenceNumber("SCIFI002");
        bookSci1.setAuthor("Frank Herbert");
        bookSci1.setTitle("Dune");
        bookSci1.setPublicationDate(1965);
        bookSci1.setLiteraryGenre(LiteraryGenre.SCI_FI);

        books.put(bookSci1.getReferenceNumber(), bookSci1);

        Book bookFan = new Book();
        bookFan.setReferenceNumber("Fantasy001");
        bookFan.setAuthor("J.R.R. Tolkien");
        bookFan.setTitle("The Lord of the Rings");
        bookFan.setPublicationDate(1954);
        bookFan.setLiteraryGenre(LiteraryGenre.FANTASY);

        books.put(bookFan.getReferenceNumber(), bookFan);

        Book bookFan1 = new Book();
        bookFan1.setReferenceNumber("Fantasy002");
        bookFan1.setAuthor("Stephen King");
        bookFan1.setTitle("The Dark Tower");
        bookFan1.setPublicationDate(1982);
        bookFan1.setLiteraryGenre(LiteraryGenre.FANTASY);

        books.put(bookFan1.getReferenceNumber(), bookFan1);

        Book bookTech = new Book();
        bookTech.setReferenceNumber("Tech001");
        bookTech.setAuthor("John Ferguson Smart");
        bookTech.setTitle("Java Power Tool");
        bookTech.setPublicationDate(2008);
        bookTech.setLiteraryGenre(LiteraryGenre.TECH);

        books.put(bookTech.getReferenceNumber(), bookTech);

        Book bookTech1 = new Book();
        bookTech1.setReferenceNumber("Tech002");
        bookTech1.setAuthor("David Herman");
        bookTech1.setTitle(" Effective JavaScript: 68 Specific Ways to Harness the Power of JavaScript ");
        bookTech1.setPublicationDate(2013);
        bookTech1.setLiteraryGenre(LiteraryGenre.TECH);

        books.put(bookTech1.getReferenceNumber(), bookTech1);

        Book bookCri = new Book();
        bookCri.setReferenceNumber("Crime001");
        bookCri.setAuthor("Arthur Conan Doyle");
        bookCri.setTitle("The Hound of the Baskervilles");
        bookCri.setPublicationDate(1902);
        bookCri.setLiteraryGenre(LiteraryGenre.CRIME);

        books.put(bookCri.getReferenceNumber(), bookCri);

        Book bookCri1 = new Book();
        bookCri1.setReferenceNumber("Crime002");
        bookCri1.setAuthor("Agatha Christie");
        bookCri1.setTitle("The Murder of Roger Ackroyd");
        bookCri1.setPublicationDate(1926);
        bookCri1.setLiteraryGenre(LiteraryGenre.CRIME);

        books.put(bookCri1.getReferenceNumber(), bookCri1);
    }

    public Book findBook(String referenceNumber) {
        Assert.notNull(referenceNumber, "You must provide a library reference number for the book");
        return books.get(referenceNumber);
    }
}
