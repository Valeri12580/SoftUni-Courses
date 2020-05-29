package models.service;

import models.entities.Type;

public class ProductServiceModel {


    private String name;

    private String description;

    private Type type;

    public ProductServiceModel() {
    }

    public ProductServiceModel(String name, String description, Type type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
