package com.github.lucas.controller;

import com.github.lucas.dto.CurrencyConversionResponse;
import com.github.lucas.model.CurrencyConversion;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import javafx.animation.RotateTransition;
import java.math.BigDecimal;
import com.github.lucas.model.CurrencyEnum;

public class CurrencyConversionController {

    @FXML
    private ComboBox<CurrencyEnum> fromCurrencyCombo;

    @FXML
    private ComboBox<CurrencyEnum> toCurrencyCombo;

    @FXML
    private TextField fromValueField;

    @FXML
    private TextField toValueField;

    @FXML
    private Label fromIconLabel;

    @FXML
    private Label toIconLabel;

    @FXML
    private Button swapButton;

    private final CurrencyConversion currencyConversion = new CurrencyConversion();

    @FXML
    public void initialize() {
        // Inicializar ComboBox com moedas
        for (CurrencyEnum currency : CurrencyEnum.values()){
            fromCurrencyCombo.getItems().add(currency);
            toCurrencyCombo.getItems().add(currency);
        }

        // Seleções padrão e conversão inicial
        fromCurrencyCombo.setValue(CurrencyEnum.USD);
        toCurrencyCombo.setValue(CurrencyEnum.BRL);
        convertCurrency();
        updateCurrencyIcons();

        // Listener para conversão automática ao mudar moeda ou valor
        fromCurrencyCombo.setOnAction(event -> {convertCurrency(); updateCurrencyIcons();});
        toCurrencyCombo.setOnAction(event -> {convertCurrency(); updateCurrencyIcons();});
        swapButton.setOnAction(event -> swapCurrencies());
        fromValueField.textProperty().addListener((obs, oldValue, newValue) -> convertCurrency());

    }
    private void swapCurrencies() {
        CurrencyEnum currentFrom = fromCurrencyCombo.getValue();
        CurrencyEnum currentTo = toCurrencyCombo.getValue();

        fromCurrencyCombo.getSelectionModel().select(currentTo);
        toCurrencyCombo.getSelectionModel().select(currentFrom);
        animateSwapButton();
        convertCurrency();
    }

    private void convertCurrency() {
        try {
            CurrencyEnum fromCurrency = fromCurrencyCombo.getValue();
            CurrencyEnum toCurrency = toCurrencyCombo.getValue();
            BigDecimal amount = new BigDecimal(fromValueField.getText().trim());
            CurrencyConversionResponse result = currencyConversion.convertCurrency(fromCurrency, toCurrency, amount);

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

    private void updateCurrencyIcons() {
        CurrencyEnum fromCurrency = fromCurrencyCombo.getValue();
        CurrencyEnum toCurrency = toCurrencyCombo.getValue();

        fromIconLabel.setText(fromCurrency != null ? fromCurrency.getSigla() : "");
        toIconLabel.setText(toCurrency != null ? toCurrency.getSigla() : "");
    }

    private void animateSwapButton(){
        RotateTransition rt = new RotateTransition(Duration.seconds(0.4), swapButton);
        rt.setByAngle(180);
        rt.play();
    }
}
