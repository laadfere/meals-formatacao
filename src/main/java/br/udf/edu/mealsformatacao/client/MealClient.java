package br.udf.edu.mealsformatacao.client;

import br.udf.edu.mealsformatacao.dto.MealListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Meal", url = "https://www.themealdb.com/api/json/v1/1")
public interface MealClient {

    @GetMapping("/random.php")
    MealListResponse getRandom();
}