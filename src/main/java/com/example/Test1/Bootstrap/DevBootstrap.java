package com.example.Test1.Bootstrap;

import com.example.Test1.Models.Author;
import com.example.Test1.Models.Book;
import com.example.Test1.Models.Publisher;
import com.example.Test1.Repository.AuthorRepository;
import com.example.Test1.Repository.BookRepository;
import com.example.Test1.Repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorbookrepository;
    private BookRepository bookrepository;
    private PublisherRepository publisherRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initdata();
    }

    public DevBootstrap(AuthorRepository authorbookrepository, BookRepository bookrepository, PublisherRepository publisherRepository) {
        this.authorbookrepository = authorbookrepository;
        this.bookrepository = bookrepository;
        this.publisherRepository = publisherRepository;
    }

    private void initdata(){

        Publisher publisher=new Publisher();
        publisher.setName("foo");
        publisherRepository.save(publisher);

        Publisher publisher2=new Publisher();
        publisher2.setName("amine");
        publisherRepository.save(publisher2);
        //eric
        Author eric= new Author("eric", "evan");
        Book ddd=new Book("domain driven design", "1234" , publisher);
        eric.getBooks().add(ddd);

        authorbookrepository.save(eric);
        bookrepository.save(ddd);

        //rod
        Author rod=new Author("rod","johnson");
        Book noEjb=new Book("J2EE without EJB","2344",publisher2);
        rod.getBooks().add(noEjb);

        authorbookrepository.save(rod);
        bookrepository.save(noEjb);

    }
}
