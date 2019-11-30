package com.example.emi_qwrfib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
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


        //alles, was die Quersumme betrifft


        //es werden Variablen definiert, welche EditText und TextView zugewiesen werden
        qwrsumInput = (EditText) findViewById(R.id.qwrsum_input);
        qwrsumResult = (TextView) findViewById(R.id.qwrsum_result);

        //der "=" Button wird qwrsumButton zugewiesen und eine onClick-Methode hinzugfeügt, welche die Funktion calculateDigitSum() auslöst
        qwrsumButton = (Button) findViewById(R.id.qwrsum_button);
        qwrsumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateDigitSum();
                qwrsum = 0;
            }
        });


        //alles, was die Fibonacci betrifft

        //Variable, die sich auf die TextView fibnac_result bezieht
        fibnacResult = (TextView) findViewById(R.id.fibnac_result);

        //variable, bezieht sich auf den Button fibnac_button, onClick_Event löst Funktion calculateFibonacciRow() aus
        fibnacButton = (Button) findViewById(R.id.fibnac_button);
        fibnacButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateFibonacciRow();
            }
        });
        fibnacResult.setMovementMethod(new ScrollingMovementMethod());
    }

    //Methode, Berechnung der Quersumme der in qwrsumInput gegebenen Zahl (String wird erst in Ineger und nach Berechnung wieder in einen String umgewandelt)
    private void calculateDigitSum() {
        qwrnum = Integer.valueOf(qwrsumInput.getText().toString());

        while (qwrnum > 0) {
            rest = qwrnum % 10;
            qwrsum += rest;
            qwrnum /= 10;
        }

        qwrsumResult.setText(String.valueOf(qwrsum));
    }
    //Methode, Berechnung der ersten 30 Zahlen der Fibonacci-Reihe
    //die beiden ersten Zahlen 0 und 1 werden in Variablen definiert und anschließend im TextView fibnac_result ausgegeben
    //danach for-Schleife, welche die int i bis 30 hochzählt
    //in der for-Schleife werden die Zahlen der Fibonacci-Reihe schrittweise hochgerechnet und das Ergebnis einer jeden Rechnung zum TextView fibnac_result hinzugefügt
    private void calculateFibonacciRow() {
        int num1 = 0;
        int num2 = 1;
        int result = 0;

        fibnacResult.setText(String.valueOf(num1 + "\n" + num2));

        for(int i=2; i<30; i++) {
            result=num1+num2;
            fibnacResult.append(String.valueOf("\n" + result));
            num1=num2;
            num2=result;
        }


    }
}
