package com.xinput.boot.controller;

import com.google.common.collect.Maps;
import com.xinput.boot.domain.Book;
import com.xinput.boot.domain.BookDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
public class BookController {

  private static Map<Long, Book> bookMap = Maps.newConcurrentMap();

  static {
    bookMap.put(1L, new Book(1L, "《红楼梦》", "曹雪芹"));
    bookMap.put(2L, new Book(2L, "《西游记》", "吴承恩"));
    bookMap.put(3L, new Book(2L, "《水浒传》", "施耐庵"));
    bookMap.put(4L, new Book(3L, "《三国演义》", "罗贯中"));
  }

  private AtomicLong atomicLong = new AtomicLong(bookMap.size());

  @PostMapping("/books")
  public Book save(@RequestBody BookDto bookDto) {
    Book book = new Book();
    book.setBookId(atomicLong.incrementAndGet());
    book.setBookName(bookDto.getBookName());
    book.setAuthor(bookDto.getAuthor());

    bookMap.put(book.getBookId(), book);
    return book;
  }

  @GetMapping("/books")
  public List<Book> query() {
    return bookMap.values().stream()
        .sorted(Comparator.comparing(Book::getBookId))
        .collect(Collectors.toList());
  }

  @GetMapping("/books/{id}")
  public Book get(@PathVariable("id") long id) {
    return bookMap.get(id);
  }

  @PutMapping("/books/{id}")
  public Book edit(@PathVariable("id") long id, @RequestBody BookDto bookDto) {
    Book book = bookMap.get(id);
    if (Objects.isNull(book)) {
      book = new Book();
      book.setDesc("书籍不存在. id:" + id);
      return book;
    }

    if (StringUtils.isNotBlank(bookDto.getBookName())) {
      book.setBookName(bookDto.getBookName());
    }

    if (StringUtils.isNotBlank(bookDto.getAuthor())) {
      book.setAuthor(bookDto.getAuthor());
    }

    bookMap.put(id, book);
    return book;
  }
}
