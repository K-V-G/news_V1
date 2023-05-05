package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.model.news;
import ru.model.newsDTO;
import ru.repository.newsRepoImpl;
import ru.repository.newsTypeRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class newsServiceImpl implements newsService {
    newsRepoImpl newsRepo;
    newsTypeRepo newsTypeRepo;


    @Autowired
    public newsServiceImpl(newsRepoImpl newsRepo, newsTypeRepo newsTypeRepo) {
        this.newsRepo = newsRepo;
        this.newsTypeRepo = newsTypeRepo;
    }

    @Override
    public List<newsDTO> findAll() {
        return newsRepo.findAll().stream().map(newsDTO::new).collect(Collectors.toList());
    }

    @Override
    public List<newsDTO> getAllNewsByType(String typeName) {
        return newsRepo.findnewsByTypeName(typeName).stream().map(newsDTO::new).collect(Collectors.toList());
    }

    @Override
    public newsDTO findNewsById(int id) {
        news news = newsRepo.findById(id).orElseThrow();
        return new newsDTO(news);
    }

    @Override
    public void delete(int id) {
        newsRepo.deleteById(id);
    }

    @Override
    public void save(news news) {
        newsRepo.save(news);

    }




}
