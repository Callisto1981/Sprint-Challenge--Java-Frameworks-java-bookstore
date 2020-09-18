package com.lambdaschool.bookstore.services;

import com.lambdaschool.bookstore.BookstoreApplication;
import com.lambdaschool.bookstore.exceptions.ResourceNotFoundException;
import com.lambdaschool.bookstore.models.Book;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookstoreApplication.class)
//**********
// Note security is handled at the controller, hence we do not need to worry about security here!
//**********
public class BookServiceImplTest
{

    @Autowired
    private BookService bookService;

    @Before
    public void setUp() throws
            Exception
    {
        MockitoAnnotations.initMocks(this);
        System.out.println("\n*** BEFORE ***");
        List<Book> mylist = bookService.findAll();
        for (Book u : mylist)
        {
            System.out.println(u.getBookid() + " " + u.getTitle());
        }
        System.out.println();
    }

    @After
    public void tearDown() throws
            Exception
    {
        System.out.println("\n*** AFTER ***");
        List<Book> mylist = bookService.findAll();
        for (Book u : mylist)
        {
            System.out.println(u.getBookid() + " " + u.getTitle());
        }
    }

    @Test
    public void findAll()
    {
     List<Book> mylist = bookService.findAll();
     System.out.println("Expect: 5");
     System.out.println("Actual: " + mylist.size());
     assertEquals(5, mylist.size());
    }


    @Test
    public void findBookById()
    {
        Book book = bookService.findBookById(27);
        System.out.println("Expect: Digital Fortress");
        System.out.println("Actual: " + book.getTitle());
        assertEquals("Digital Fortress", bookService.findBookById(27).getTitle());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void notFindBookById()
    {
    }

    @Test
    public void delete()
    {
    }

    @Test
    public void save()
    {
    }

    @Test
    public void update()
    {
    }

    @Test
    public void deleteAll()
    {
    }
}