package ru.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "newstype_v2")
public class newsType {
    @Id
    @Column(name = "typename")
    private String typeName;
    @Column(name = "colortype")
    private String colorType;

    @OneToMany(mappedBy = "type")
    private Set<news> newsSet = new HashSet<>();

    public newsType() {
    }

    public newsType(String typeName, String colorType) {
        this.typeName = typeName;
        this.colorType = colorType;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getColorType() {
        return colorType;
    }

    public void setColorType(String colorType) {
        this.colorType = colorType;
    }

}