package com.example.emi_qwrfib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int qwrnum;
    int qwrsum = 0;
    int rest = 0;

    EditText qwrsumInput;
    TextView qwrsumResult;
    TextView fibnacResult;

    Button qwrsumButton;
    Button fibnacButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Code für Quersumme


        // EditText qwrsum_input wird der Variable qwrsumInput zugewiesen
        // TextView qwrsum_result wird der Vaiable qwrsumResult zugewiesen
        qwrsumInput = (EditText) findViewById(R.id.qwrsum_input);
        qwrsumResult = (TextView) findViewById(R.id.qwrsum_result);

        // der Button qwrsum_button wird der Variable qwrsumButton zugewiesen
        // die folgende onClick-Methode startet die calculateDigitSum()-Methode und setzt qwrsum am Ende der onClick-Methode auf 0
        qwrsumButton = (Button) findViewById(R.id.qwrsum_button);
        qwrsumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDigitSum();
                qwrsum = 0;
            }
        });


        // Code für Fibonacci

        // TextView fibnac_result wird der VAriable fibnacResult zugewiesen
        fibnacResult = (TextView) findViewById(R.id.fibnac_result);

        // der Button fibnac_button wird der Variable fibnacButton zugewiesen
        // die folgende onClick-Methode starte die calculateFibonacciRow()-Methode
        fibnacButton = (Button) findViewById(R.id.fibnac_button);
        fibnacButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFibonacciRow();
            }
        });
    }

    // calculateDigitSum()-Methode
    // der Wert von qwrsumInput wird in eine Ganzzahl umgewandelt und der Variable qwrnum zugewiesen
    // in der while-Schleife erfolgt die Berechnung der Quersumme mit Hilfe von Modulo-Rechnen
    private void calculateDigitSum() {
        qwrnum = Integer.valueOf(qwrsumInput.getText().toString());

        while (qwrnum > 0) {
            rest = qwrnum % 10;     // durch Modulo-Rechnen bleibt jeweils die letzte Zahl stehen und wird in rest gespeichert
            qwrsum += rest;         // rest wird zur Quersumme addiert
            qwrnum /= 10;           // die Ganzzahl qwrnum wird ruch 10 geteilt, wodurch die letzte Zahl wegfällt
        }

        qwrsumResult.setText(String.valueOf(qwrsum));   // qwrsum wird als Endergebnis in einen String umgewandelt und in qwrsumResult gespeichert und anschließend im TextView dargestellt
    }

    // calculateFibonacciRow()-Methode
    // die ersten beiden Zahlen 0 und 1 der Fibonacci Reihe werden num1 bzw. num2 als Ganzzahlen zugewiesen
    // Ganzzahl result wird erstellt, um das Ergebnis einer jeden Rechnung speichern zu können
    // in der for-Schleife erfolgt die Berechnung der Fibonacci-Zahlen
    private void calculateFibonacciRow() {
        int num1 = 0;
        int num2 = 1;
        int result = 0;

        fibnacResult.setText(String.valueOf(num1 + "\n" + num2));   // vor der for-Schleife werden die Werte von num1 und num2 in Strings umgewandelt schnließend im TextView dargestellt

        for(int i=2; i<30; i++) {                                   // Variable i, Ganzzahl, wird beginnend von 2 bis 30 hochgezählt, nach jedem Durchlauf um 1 hochgerechnet
            result=num1+num2;                                       // num1 wird mit num2 addiert und result zugewiesen
            fibnacResult.append(String.valueOf("\n" + result));     // das Ergebnis result wird zusammen mit einem Zeilenumbruch dem TextView hinzugefügt
            num1=num2;                                              // num2 wird num1 zugewiesen
            num2=result;                                            // result wird num2 zugewiesen
        }


    }
}
