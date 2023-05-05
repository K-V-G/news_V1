package ru.model;

import lombok.Data;

@Data
public class newsTypeDTO {
    private String typeName;
    private String colorType;

    public newsTypeDTO(newsType newsType) {
        this.typeName = newsType.getTypeName();
        this.colorType = newsType.getColorType();
    }
}
