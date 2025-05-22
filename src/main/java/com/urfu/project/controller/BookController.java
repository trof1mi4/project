package com.urfu.project.controller;

import com.urfu.project.model.Book;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/books")
@Log4j2
public class BookController {
    private final Counter requestCounter;
    private final AtomicLong requestTime;
    private final Counter bookPurchaseCounter;
    private List<Book> books;

    public BookController(MeterRegistry registry) {
        this.requestCounter = registry.counter("requests.total");
        this.requestTime = registry.gauge("request.time", new AtomicLong(0));
        this.bookPurchaseCounter = registry.counter("book.purchases");
    }

    @GetMapping
    @Timed(value = "books.get.all")
    public List<Book> getAllBooks() {
        var startTime = System.currentTimeMillis();
        requestCounter.increment();

        books = Arrays.asList(
                new Book("Book1", "Author1"),
                new Book("Book2", "Author2")
        );

        var endTime = System.currentTimeMillis();
        requestTime.set(endTime - startTime);

        log.info("Возвращен список книг");
        return books;
    }

    @PostMapping("/purchase/{title}")
    public String purchaseBook(@PathVariable String title) {
        if (!books.stream().anyMatch(book -> book.getTitle().equals(title)))
            return "Такой книги нет";

        bookPurchaseCounter.increment();
        log.info("Покупка книги: {}", title);
        return "Книга '" + title + "' куплена!";
    }
}
