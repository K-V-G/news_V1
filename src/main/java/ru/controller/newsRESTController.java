package ru.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.model.news;
import ru.model.newsDTO;
import ru.model.newsType;
/*import ru.service.MainService;*/
import ru.repository.newsTypeRepo;
import ru.service.newsService;
import ru.service.newsTypeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController

public class newsRESTController {
    newsService newsService;
    newsTypeService newsTypeService;

    @Autowired
    public newsRESTController(newsService service, newsTypeService newsTypeService) {
        this.newsService = service;
        this.newsTypeService = newsTypeService;
    }

    @GetMapping("/allNews")
    public ResponseEntity<List<newsDTO>> findAllNews() {
        List<newsDTO> newsList = newsService.findAll();
        return new ResponseEntity<>(newsList, HttpStatus.OK);

    }

    @GetMapping("/getOneNews/{id}")
    public ResponseEntity<newsDTO> getOne(@PathVariable("id") Integer id) {
        try {
            newsDTO news = newsService.findNewsById(id);
            return new ResponseEntity<>(news, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(value = "/deleteNews/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<newsType> deleteNewsType(@PathVariable("id") Integer id) {
        newsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/saveNews")
    public ResponseEntity<newsType> createNewsType(@RequestBody String json) {
        JSONObject jsonObject = new JSONObject(json);
        String name = jsonObject.getString("name");
        String shortDescription = jsonObject.getString("shortDescription");
        String fullDescription = jsonObject.getString("fullDescription");

        JSONObject typeObject = jsonObject.getJSONObject("type");
        String typeName = typeObject.getString("typeName");
        String colorType = typeObject.getString("colorType");

        newsType type = newsTypeService.findnewsTypeByTypeNameAndColorType(typeName, colorType);
        if (type != null) {
            news news = new news(name, shortDescription, fullDescription, type);

            newsService.save(news);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @GetMapping("/getAllNewsByType/{typeNews}")
    public ResponseEntity<List<newsDTO>> getAllNewsByType(@PathVariable("typeNews") String typeNews) {
        try {
            List<newsDTO> newsDTOList = newsService.getAllNewsByType(typeNews);
            if (newsDTOList.size() != 0) {
                return new ResponseEntity<>(newsDTOList, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
