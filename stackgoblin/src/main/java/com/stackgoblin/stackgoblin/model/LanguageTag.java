package com.stackgoblin.stackgoblin.model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="LanguageTag")
public class LanguageTag {

    public enum TYPE {
        PROGRAMMING, FRAMEWORK, DATABASE
    }

    private ObjectId id;
    private String name;
    private String displayName;
    private String description;
    private TYPE type;

    public LanguageTag() {}

    public LanguageTag(String name, String displayName, String description, TYPE type) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.type = type;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \n, Display Name: %s, Description: %s, Type: %s", this.name, this.displayName, this.description, this.type);
    }
}
