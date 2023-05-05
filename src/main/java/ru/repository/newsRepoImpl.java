package ru.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.model.news;
import ru.model.newsType;

import java.util.List;

public interface newsRepoImpl extends JpaRepository<news, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM news_v2 WHERE type = :typeName")
    List<news> findnewsByTypeName(String typeName);
}
