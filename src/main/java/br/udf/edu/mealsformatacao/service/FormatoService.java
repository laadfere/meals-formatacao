package br.udf.edu.mealsformatacao.service;

import br.udf.edu.mealsformatacao.model.Meal;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class FormatoService {

    private final ObjectMapper jsonMapper;
    private final XmlMapper xmlMapper;

    public FormatoService() {
        this.jsonMapper = new ObjectMapper();
        this.xmlMapper = new XmlMapper();
    }

    public String exportarJson(List<Meal> meals) throws Exception {
        return jsonMapper.writeValueAsString(meals);
    }

    public String exportarXml(List<Meal> meals) throws Exception {
        return xmlMapper.writeValueAsString(meals);
    }

    public ByteArrayInputStream exportarCsv(List<Meal> meals) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter printer = new CSVPrinter(
                new PrintWriter(out),
                CSVFormat.DEFAULT.withHeader(
                        "ID",
                        "Nome",
                        "Categoria",
                        "PaisOrigem",
                        "Instrucoes"
                )
        );

        for (Meal meal : meals) {
            printer.printRecord(
                    meal.getId(),
                    meal.getNome(),
                    meal.getCategoria(),
                    meal.getPaisOrigem(),
                    meal.getInstrucoes()
            );
        }
        printer.flush();
        return new ByteArrayInputStream(out.toByteArray());
    }
}