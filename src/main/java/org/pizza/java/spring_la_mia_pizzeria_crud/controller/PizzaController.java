package org.pizza.java.spring_la_mia_pizzeria_crud.controller;

import org.pizza.java.spring_la_mia_pizzeria_crud.model.Pizza;
import org.pizza.java.spring_la_mia_pizzeria_crud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaRepository pizzaRepository;

   @GetMapping
    public String index(Model model) {
       
        List<Pizza> pizzas = pizzaRepository.findAll();
        model.addAttribute("pizzas", pizzas);
        return "pizzas/index";
    }
}