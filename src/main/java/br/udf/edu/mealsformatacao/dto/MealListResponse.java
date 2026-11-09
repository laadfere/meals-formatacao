package br.udf.edu.mealsformatacao.dto;

import java.util.List;

public class MealListResponse {

    private List<MealResponse> meals;

    public List<MealResponse> getMeals() {
        return meals;
    }

    public void setMeals(List<MealResponse> meals) {
        this.meals = meals;
    }
}