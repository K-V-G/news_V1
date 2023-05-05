package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.model.newsType;
import ru.model.newsTypeDTO;
import ru.service.newsTypeService;

import java.util.List;

@RestController

public class NewsTypeRESTController {

    newsTypeService service;

    @Autowired
    public NewsTypeRESTController(newsTypeService service) {
        this.service = service;
    }


    @PostMapping("/saveNewsType")
    public ResponseEntity<newsType> createNewsType(@RequestBody newsType newsType) {
        service.save(newsType);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/allType")
    public ResponseEntity<List<newsTypeDTO>> findAllNewsType(){
        List<newsTypeDTO> list = service.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/getOneType/{typeName}")
    public ResponseEntity<newsTypeDTO> findOneNewsType(@PathVariable("typeName") String typeName){
        newsTypeDTO typeDTO = service.findNewsType(typeName);
        if (typeDTO != null) {
            return new ResponseEntity<>(typeDTO, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/deleteNewsType/{typeName}", method = RequestMethod.DELETE)
    public ResponseEntity<newsType> deleteNewsType(@PathVariable("typeName") String typeName) {
        service.delete(typeName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/updateNewsType/{typeName}", method = RequestMethod.PUT)
    public ResponseEntity<newsType> updateNewsType(@RequestBody newsType newsType,
                                                   @PathVariable("typeName") String typeName) {
        int status = service.update(newsType, typeName);
        if (status == 1) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/allTypeString")
    public ResponseEntity<List<String>> getAllNewsType(){
        List<String> list = service.findAllTypeNews();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
