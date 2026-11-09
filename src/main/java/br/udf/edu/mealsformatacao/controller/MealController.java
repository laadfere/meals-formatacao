package br.udf.edu.mealsformatacao.controller;

import br.udf.edu.mealsformatacao.service.FormatoService;
import br.udf.edu.mealsformatacao.service.MealService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/meal")
public class MealController {

    private final MealService mealService;
    private final FormatoService formatoService;

    public MealController(MealService mealService, FormatoService formatoService) {
        this.mealService = mealService;
        this.formatoService = formatoService;
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public String json() throws Exception {
        return formatoService.exportarJson(List.of(mealService.obterAleatorio()));
    }

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public String xml() throws Exception {
        return formatoService.exportarXml(List.of(mealService.obterAleatorio()));
    }

    @GetMapping(value = "/csv", produces = "text/csv")
    public ResponseEntity<byte[]> csv() throws Exception {
        byte[] bytes = formatoService
                .exportarCsv(List.of(mealService.obterAleatorio()))
                .readAllBytes();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=meal.csv")
                .body(bytes);
    }
}