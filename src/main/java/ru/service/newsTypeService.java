package ru.service;

import ru.model.newsType;
import ru.model.newsTypeDTO;

import java.util.List;

public interface newsTypeService {

    void save(newsType newsType);

    List<newsTypeDTO> findAll();

    newsTypeDTO findNewsType(String typeName);

    List<String> findAllTypeNews();

    void delete(String typeName);

    int update(newsType newsType, String typeName);

    newsType findnewsTypeByTypeNameAndColorType(String typeName, String colorType);
}
