package ru.msaggik.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.msaggik.spring.dao.PeopleDAO;
import ru.msaggik.spring.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {
    // внедрение бина PeopleDAO в данный контроллер
    private final PeopleDAO peopleDAO;
    @Autowired
    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }
    // получение списка всех пользователей из DAO и передача его в представление
    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", peopleDAO.index());
        return "people/index";
    }
    // получение информации одного пользователя по id из DAO и передача её в представление
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", peopleDAO.show(id));
        return "people/show";
    }
    // возврат html формы для создания информации о новом пользователе
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "people/new";
    }
    // принимает POST запрос и отправляет данные в БД для создания информации о пользователе
    @PostMapping()
    public String create(@ModelAttribute("person") Person person) {
        peopleDAO.save(person);
        return "redirect:/people"; // redirect - переброска на другой домен
    }
}
