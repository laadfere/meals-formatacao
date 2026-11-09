package br.udf.edu.mealsformatacao.service;

import br.udf.edu.mealsformatacao.client.MealClient;
import br.udf.edu.mealsformatacao.dto.MealListResponse;
import br.udf.edu.mealsformatacao.dto.MealResponse;
import br.udf.edu.mealsformatacao.model.Meal;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    private final MealClient client;

    public MealService(MealClient client) {
        this.client = client;
    }

    public Meal obterAleatorio() {
        MealListResponse response = client.getRandom();
        if (response != null && response.getMeals() != null && !response.getMeals().isEmpty()) {
            MealResponse meal = response.getMeals().get(0);
            return new Meal(
                    meal.idMeal(),
                    meal.strMeal(),
                    meal.strCategory(),
                    meal.strArea(),
                    meal.strInstructions()
            );
        }
        return null;
    }
}