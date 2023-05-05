package ru.model;

import lombok.Data;

@Data
public class newsDTO {

    private String name;
    private String shortDescription;
    private String fullDescription;

    private newsTypeDTO type;

    public newsDTO(news news) {
        this.name = news.getName();
        this.shortDescription = news.getShortDescription();
        this.fullDescription = news.getFullDescription();
        this.type = new newsTypeDTO(news.getType());
    }

}
