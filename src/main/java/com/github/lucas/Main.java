package com.github.lucas;

import com.github.lucas.dto.CurrencyConversionResponse;
import com.github.lucas.model.CurrencyConversion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.math.BigDecimal;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start (Stage primaryStage) throws Exception {
        URL url = getClass().getResource("/view/teste.fxml");
        System.out.println("FXML URL: " + url);
        Parent root = FXMLLoader.load(getClass().getResource("/view/teste.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Conversor de Moedas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String [] args) {
        launch(args);
//        CurrencyConversion currencyConversion = new CurrencyConversion();
//        CurrencyConversionResponse teste = currencyConversion.convertCurrency("BRL","BRL", BigDecimal.valueOf(1));
//        System.out.println(teste.toString());

    }
}
