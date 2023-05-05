/*
package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.model.newsType;
import ru.service.newsService;
import ru.service.newsTypeService;

import javax.validation.Valid;
import java.util.List;

@Controller()
public class newsTypeController {
    ru.service.newsService newsService;

    ru.service.newsTypeService newsTypeService;

    @Autowired
    public newsTypeController(newsService newsService, newsTypeService newsTypeService) {
        this.newsService = newsService;
        this.newsTypeService = newsTypeService;
    }

    @GetMapping("/newNewsType")
    public String newNewsType(@ModelAttribute("newsType") newsType newsTypeA) {
        return "newNewsType";
    }

    @RequestMapping(value = "/mainPage2", method = RequestMethod.POST)
    public String createNewsType(@ModelAttribute("newsType") @Valid newsType newsType,
                                 BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newNewsType";

        newsTypeService.save(newsType);
        return "redirect:/mainPage";
    }

    @GetMapping("/showAllNewsType")
    public String listNews(Model model) {
        List<newsType> newsTypeList = newsTypeService.findAll();
        model.addAttribute("newsTypeList", newsTypeList);
        return "indexNewsType";
    }

    @GetMapping("/newsType/{id}")
    public String showOneNewsType(@PathVariable("id") int id, Model model) {
        newsType newsType = newsTypeService.findNewsType(id);
        model.addAttribute("newsType", newsType);
        return "showNewsType";
    }

}
*/
