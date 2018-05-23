package com.test.mycalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    double firstNum = 0;
    char currentSign = '+';
    StringBuffer currentNum = new StringBuffer();
    boolean isFirstPoint = false;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = (TextView) findViewById(R.id.txtResult);
    }

    public void init(){
        currentNum.delete(0,currentNum.length());
        isFirstPoint = false;
    }

    public double stringToDouble(){
        if(currentNum.length() == 0){
            return 0;
        }
        double result = Double.parseDouble(currentNum.toString());
        return result;
    }

    public double calcu(){
        double result = 0;
        switch (currentSign){
            case '+':
                result=firstNum+stringToDouble();
                break;
            case '-':
                result=firstNum-stringToDouble();
                break;
            case '*':
                result=firstNum*stringToDouble();
                break;
            case '/':
                result=firstNum/stringToDouble();
                break;
        }

        NumberFormat format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(2);
        result=Double.parseDouble(format.format(result));
        return result;
    }

    public void display(){
        txtResult.setText(currentNum);
    }

    public void digital_click(View view){
        Button btnDigital = (Button) view;
        char text = btnDigital.getText().charAt(0);
        currentNum.append(text);
        display();
    }

    public void add(View view){
        double result = calcu();
        txtResult.setText(String.valueOf(result));
        firstNum=result;
        currentSign='+';
        init();
    }

    public void sub(View view){
        double result=calcu();
        txtResult.setText(String.valueOf(result));
        firstNum=result;
        currentSign='-';
        init();
    }

    public void mul(View view){
        double result=calcu();
        txtResult.setText(String.valueOf(result));
        firstNum=result;
        currentSign='*';
        init();
    }

    public void div(View view){
        double result=calcu();
        txtResult.setText(String.valueOf(result));
        firstNum=result;
        currentSign='/';
        init();
    }

    public void equ(View view){
        double result=calcu();
        txtResult.setText(String.valueOf(result));
        firstNum=result;
        currentSign='+';
        init();
    }

    public void point_click(View view){
        if(isFirstPoint){
            return;
        }
        if(currentNum.length()==0){
            return;
        }
        Button btnPoint=(Button)view;
        char text = btnPoint.getText().charAt(0);
        currentNum.append(text);
        isFirstPoint=true;
        display();
    }

    public void del(View view){
        if(currentNum.length()>=1){
            currentNum.delete(currentNum.length()-1,currentNum.length());
        }
        if(currentNum.length() == 0){
            init();
            display();
        }
        txtResult.setText(currentNum);
    }
}
