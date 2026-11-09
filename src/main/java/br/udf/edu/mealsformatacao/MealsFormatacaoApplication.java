package br.udf.edu.mealsformatacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // <--- Adiciona esta linha!
public class MealsFormatacaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MealsFormatacaoApplication.class, args);
    }
}
