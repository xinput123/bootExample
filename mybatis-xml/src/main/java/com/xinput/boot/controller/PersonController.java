package com.xinput.boot.controller;

import com.xinput.boot.domain.entity.Person;
import com.xinput.boot.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class PersonController {

  @Autowired
  private PersonMapper personMapper;

  @GetMapping("/persons")
  public List<Person> query() {
    return personMapper.query();
  }

  @PostMapping("/persons")
  public Person save(@RequestBody Person personDto) {
    Person person = new Person();
    person.setUsername(personDto.getUsername());
    person.setPassword(personDto.getPassword());
    person.setCreateTime(new Date());
    personMapper.insert(person);
    return person;
  }

  @GetMapping("/persons/{id}")
  public Person get(@PathVariable("id") int id) {
    return personMapper.selectById(id);
  }

  @PutMapping("/persons/{id}")
  public int get(@PathVariable("id") int id, @RequestBody Person personDto) {
    personDto.setId(id);
    return personMapper.updateById(personDto);
  }
}
