package ru.service;

import ru.model.news;
import ru.model.newsDTO;

import java.util.List;

public interface newsService {
    void save(news news);

    List<newsDTO> findAll();

    List<newsDTO> getAllNewsByType(String typeName);

    newsDTO findNewsById(int id);

     void delete(int id);
}
