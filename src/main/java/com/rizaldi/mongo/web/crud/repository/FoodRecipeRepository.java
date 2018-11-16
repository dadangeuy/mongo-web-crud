package com.rizaldi.mongo.web.crud.repository;

import com.rizaldi.mongo.web.crud.model.FoodRecipe;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRecipeRepository extends MongoRepository<FoodRecipe, ObjectId> {
}
