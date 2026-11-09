package br.udf.edu.mealsformatacao.model;

public class Meal {

    private String id;
    private String nome;
    private String categoria;
    private String paisOrigem;
    private String instrucoes;

    public Meal() { }

    public Meal(String id, String nome, String categoria, String paisOrigem, String instrucoes) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.paisOrigem = paisOrigem;
        this.instrucoes = instrucoes;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getPaisOrigem() { return paisOrigem; }
    public void setPaisOrigem(String paisOrigem) { this.paisOrigem = paisOrigem; }

    public String getInstrucoes() { return instrucoes; }
    public void setInstrucoes(String instrucoes) { this.instrucoes = instrucoes; }
}