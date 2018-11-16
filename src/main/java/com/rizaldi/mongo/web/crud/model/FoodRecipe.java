package com.rizaldi.mongo.web.crud.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "food-recipes")
public class FoodRecipe {
    @Id
    private ObjectId id;
    private String Title;
    private String Ingredients;
    private String Steps;
    private String Loves;
    private String URL;
}
