package com.github.lucas.controller;

import com.github.lucas.dto.CurrencyConversionResponse;
import com.github.lucas.model.CurrencyConversion;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.math.BigDecimal;

public class CurrencyConversionController {

    @FXML
    private ComboBox<String> fromCurrencyCombo;

    @FXML
    private ComboBox<String> toCurrencyCombo;

    @FXML
    private TextField fromValueField;

    @FXML
    private TextField toValueField;

    @FXML
    private Button swapButton;

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
        swapButton.setOnAction(event -> swapCurrencies());
        fromValueField.textProperty().addListener((obs, oldValue, newValue) -> convertCurrency());

    }
    private void swapCurrencies() {
        String currentFrom = fromCurrencyCombo.getValue();
        String currentTo = toCurrencyCombo.getValue();

        fromCurrencyCombo.getSelectionModel().select(currentTo);
        toCurrencyCombo.getSelectionModel().select(currentFrom);

        convertCurrency();
    }

    private void convertCurrency() {
        try {
            String fromCurrency = fromCurrencyCombo.getValue();
            String toCurrency = toCurrencyCombo.getValue();
            BigDecimal amount = new BigDecimal(fromValueField.getText().trim());
            CurrencyConversionResponse result =currencyConversion.convertCurrency(fromCurrency, toCurrency, amount);

            toValueField.setText(String.format("%.2f", result.conversion_result()));
            highlightConversion(toValueField);
        } catch (NumberFormatException e) {
            toValueField.setText("0.00");
        }
    }

    private void highlightConversion (TextField field){
        field.getStyleClass().add("converted-highlight");

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> field.getStyleClass().remove("converted-highlight"));
        pause.play();
    }
}
