package com.github.lucas.model;

public enum CurrencyEnum {
    BRL("Real Brasileiro", "R$"),
    USD("Dólar Americano", "$"),
    EUR("Euro", "€"),
    GBP("Libra Esterlina", "£"),
    JPY("Iene Japonês", "¥"),
    CNY("Yuan Chinês", "¥");

    private final String name;
    private final String sigla;

    CurrencyEnum(String name, String sigla){
        this.name = name;
        this.sigla = sigla;
    }

    public String getName() {
        return name;
    }

    public String getSigla(){
        return sigla;
    }
}