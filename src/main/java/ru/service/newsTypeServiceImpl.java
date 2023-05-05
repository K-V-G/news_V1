package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.model.newsType;
import ru.model.newsTypeDTO;
import ru.repository.newsTypeRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class newsTypeServiceImpl implements newsTypeService {

    newsTypeRepo newsTypeRepo;

    @Autowired
    public newsTypeServiceImpl(newsTypeRepo newsTypeRepo) {
        this.newsTypeRepo = newsTypeRepo;
    }

    @Override
    public void save(newsType newsType) {
        newsTypeRepo.save(newsType);
    }

    @Override
    public List<newsTypeDTO> findAll() {
        return newsTypeRepo.findAll().stream().map(newsTypeDTO::new).collect(Collectors.toList());
    }

    @Override
    public newsTypeDTO findNewsType(String typeName) {
        newsType newsType = newsTypeRepo.findnewsTypeByTypeName(typeName);
        if (newsType != null) {
            return new newsTypeDTO(newsType);
        }
       return null;
    }

    @Override
    public List<String> findAllTypeNews() {
        List<newsTypeDTO> newsTypeDTOList = findAll();
        List<String> types = new ArrayList<>();
        for (newsTypeDTO newsTypeDTO : newsTypeDTOList) {
            types.add(newsTypeDTO.getTypeName());
        }
        return types;
    }

    @Override
    public void delete(String typeName) {
        newsTypeRepo.deleteById(typeName);
    }

    @Override
    public int update(newsType newsTypeValue, String typeName) {
        newsType newsType = newsTypeRepo.findnewsTypeByTypeName(typeName);
        if (newsType != null) {
            newsType.setColorType(newsTypeValue.getColorType());
            newsTypeRepo.save(newsType);
            return 1;
        }
        return 0;
    }

    @Override
    public newsType findnewsTypeByTypeNameAndColorType(String typeName, String colorType) {
        return newsTypeRepo.findnewsTypeByTypeNameAndColorType(typeName, colorType);
    }
}
