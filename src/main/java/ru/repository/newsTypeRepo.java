package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.model.newsType;

public interface newsTypeRepo extends JpaRepository<newsType, String> {
    @Query(nativeQuery = true, value = "SELECT * FROM newstype_v2 WHERE typename = :typeName")
    newsType findnewsTypeByTypeName(String typeName);

    @Query(nativeQuery = true, value = "SELECT * FROM newstype_v2 WHERE typename = :typeName AND " +
            "colortype = :colorType")
    newsType findnewsTypeByTypeNameAndColorType(String typeName, String colorType);

}
