package org.pizza.java.spring_la_mia_pizzeria_crud.controller;

import org.pizza.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.pizza.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

  
    @GetMapping("/{id}") //
    public String show(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", pizzaRepository.findById(id).get());
        return "pizzas/show";
    }

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword, Model model) {
        List<Pizza> pizzas;

        if (keyword != null && !keyword.isEmpty()) {
            pizzas = pizzaRepository.findByNameContainingIgnoreCase(keyword);
        } else {
            pizzas = pizzaRepository.findAll();
        }

        model.addAttribute("pizzas", pizzas);
        model.addAttribute("keyword", keyword);

        return "pizzas/index";
    }

}