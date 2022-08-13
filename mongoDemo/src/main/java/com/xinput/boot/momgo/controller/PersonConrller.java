package com.xinput.boot.momgo.controller;

import com.xinput.boot.momgo.entity.Person;
import com.xinput.boot.momgo.repository.PersonDao;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonConrller {

  @Resource
  private PersonDao personDao;

  @GetMapping("status")
  public String status() {
    return "ok";
  }

  @GetMapping
  public List<Person> query() {
    return personDao.findAll();
  }

  @GetMapping("{id}")
  public Person get(@PathVariable("id") String id) {
    return personDao.findById(id);
  }

  @GetMapping("/insert/{id}")
  public Person insert(@PathVariable("id") int id) {
    Person person = createPerson(id);
    return personDao.insert(person);
  }

  @GetMapping("/save/{id}")
  public Person save(@PathVariable("id") int id) {
    Person person = createPerson(id);
    return personDao.save(person);
  }

  private Person createPerson(int id) {
    Person person = new Person();
    person.setUserId(String.valueOf(id));
    person.setUserName("xinput_" + id);
    person.setAddress("北京市朝阳区");
    return person;
  }
}
