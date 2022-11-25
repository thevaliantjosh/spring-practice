package com.codeup.springpractice.controllers;

import com.codeup.springpractice.models.NationalPark;
import com.codeup.springpractice.repositories.ParksRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/parks")
public class ParksController {

    private ParksRepository parksDao;

    public ParksController(ParksRepository parksDao){
        this.parksDao = parksDao;
    }

    @GetMapping("/lists")
    public String allParks(Model model){
        List<NationalPark> parks = parksDao.findAll();
        model.addAttribute("parks", parks);
        return "/parks";
    }


    @GetMapping("/create")
    public String createParkForm(){
        return "/create";
    }

    @PostMapping("/create")
    public String saveThePark(@RequestParam(name="name") String name){
        NationalPark park = new NationalPark(name);
        parksDao.save(park);
        return "redirect:/parks/lists";
    }



}
