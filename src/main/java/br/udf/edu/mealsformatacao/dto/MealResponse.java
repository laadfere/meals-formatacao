package br.udf.edu.mealsformatacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MealResponse(
        String idMeal,
        String strMeal,
        String strCategory,
        String strArea,
        String strInstructions
) {}