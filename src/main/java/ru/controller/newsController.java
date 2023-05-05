/*
package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.model.news;
import ru.model.newsType;
import ru.service.newsService;
import ru.service.newsTypeService;

import javax.validation.Valid;
import java.util.List;

@Controller()
public class newsController {

    newsService newsService;

    newsTypeService newsTypeService;

    @Autowired
    public newsController(newsService newsService, newsTypeService newsTypeService) {
        this.newsService = newsService;
        this.newsTypeService = newsTypeService;
    }

    @GetMapping("/mainPage")
    public String main() {
        return "initialView";
    }

    @GetMapping("/showAllNews")
    public String listNews(Model model) {
        List<news> newsList = newsService.findAll();
        model.addAttribute("newsList", newsList);
        return "indexNews";
    }

    @GetMapping("/newNews")
    public String newNews(@ModelAttribute("news") news newsA, Model model) {
        List<newsType> newsTypeList = newsTypeService.findAll();
        model.addAttribute("newsTypeList", newsTypeList);
        return "newNews";
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.POST)
    public String createNews(@ModelAttribute("news") @Valid news news,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "newNews";

        newsService.save(news);
        return "redirect:/mainPage";
    }

    @GetMapping("/news/{id}")
    public String showOneNews(@PathVariable("id") int id, Model model) {
        news news = newsService.findNewsById(id);
        String newsType = newsTypeService.findNewsTypeColorByTypeName(news.getType());
        System.out.println(newsType);
        model.addAttribute("news", news);
        model.addAttribute("color", newsType);
        return "showNews";
    }
}
*/
