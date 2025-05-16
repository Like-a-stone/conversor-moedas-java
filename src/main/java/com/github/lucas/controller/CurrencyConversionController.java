package com.github.lucas.controller;

import com.github.lucas.dto.CurrencyConversionResponse;
import com.github.lucas.model.CurrencyConversion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConversionController {

    @FXML
    private ComboBox<String> fromCurrencyCombo;

    @FXML
    private ComboBox<String> toCurrencyCombo;

    @FXML
    private TextField fromValueField;

    @FXML
    private TextField toValueField;

//    TODO
//    @FXML
//    private Button swapButton;

    private final CurrencyConversion currencyConversion = new CurrencyConversion();

    @FXML
    public void initialize() {
        // Inicializar ComboBox com moedas
        fromCurrencyCombo.getItems().addAll("BRL", "USD", "EUR", "GBP", "JPY");
        toCurrencyCombo.getItems().addAll("BRL", "USD", "EUR", "GBP", "JPY");

        // Seleções padrão
        fromCurrencyCombo.setValue("BRL");
        toCurrencyCombo.setValue("USD");

        // Listener para conversão automática ao mudar moeda ou valor
        fromCurrencyCombo.setOnAction(event -> convertCurrency());
        toCurrencyCombo.setOnAction(event -> convertCurrency());
        fromValueField.textProperty().addListener((obs, oldValue, newValue) -> convertCurrency());

    }

    private void convertCurrency() {
        try {
            String fromCurrency = fromCurrencyCombo.getValue();
            String toCurrency = toCurrencyCombo.getValue();
            BigDecimal amount = new BigDecimal(fromValueField.getText().trim());
            CurrencyConversionResponse result =currencyConversion.convertCurrency(fromCurrency, toCurrency, amount);

            System.out.println("Converted Amount: " + result.toString());
            toValueField.setText(String.format("%.2f", result.conversion_result()));
        } catch (NumberFormatException e) {
            toValueField.setText("0.00");
        }
    }
}
