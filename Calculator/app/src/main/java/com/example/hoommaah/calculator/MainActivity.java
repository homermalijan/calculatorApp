package com.example.hoommaah.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean decimalClicked = false;
    int parenthesisClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void zeroClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(!input.equals("0")){
            t.append("0");
        }

    }

    public void oneClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("1");
        }else {
            t.append("1");
        }

    }

    public void twoClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("2");
        }else {
            t.append("2");
        }

    }

    public void threeClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("3");
        }else {
            t.append("3");
        }

    }

    public void fourClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("4");
        }else {
            t.append("4");
        }

    }

    public void fiveClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("5");
        }else {
            t.append("5");
        }

    }

    public void sixClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("6");
        }else {
            t.append("6");
        }

    }

    public void sevenClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("7");
        }else {
            t.append("7");
        }

    }

    public void eightClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("8");
        }else {
            t.append("8");
        }

    }

    public void nineClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        if(input.equals("0")){
            t.setText("9");
        }else {
            t.append("9");
        }

    }

    public void clearClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        t.setText("0");
        decimalClicked = false;


    }

    public void decimalClick(View view){

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        //if(decimalClicked == false){
            t.append(".");
        //    decimalClicked = true;
        //}

    }

    public void parenthesisClick(View view) {

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        char checker = input.charAt(input.length() - 1);
        if (checker == '1' || checker == '2' || checker == '3' || checker == '4' || checker == '5' || checker == '6' || checker == '7' || checker == '8' || checker == '9') {
            if(parenthesisClicked > 0){
                t.append(")");
                parenthesisClicked--;
            }else {
                t.append("X(");
                parenthesisClicked++;
            }
        } else {
            if (checker == 'X' || checker == '/' || checker == '-' || checker == '+' || checker == '(') {
                t.append("(");
                parenthesisClicked++;
            } else {
                t.append("X(");
                parenthesisClicked++;
            }
        }
    }

    public void divideClick(View view) {

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        char checker = input.charAt(input.length() - 1);

        if (checker == 'X' || checker == '/' || checker == '-' || checker == '+' || checker == '(') {
        } else {
            t.append("/");
        }

    }

    public void multiplyClick(View view) {

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        char checker = input.charAt(input.length() - 1);

        if (checker == 'X' || checker == '/' || checker == '-' || checker == '+' || checker == '(') {
        } else {
            t.append("X");
        }

    }

    public void subtractClick(View view) {

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        char checker = input.charAt(input.length() - 1);

        if (checker == 'X' || checker == '/' || checker == '-' || checker == '+' || checker == '(') {
        } else {
            t.append("-");
        }

    }

    public void addClick(View view) {

        TextView t = (TextView) findViewById(R.id.inputView);

        String input = t.getText().toString();

        char checker = input.charAt(input.length() - 1);

        if (checker == 'X' || checker == '/' || checker == '-' || checker == '+' || checker == '(') {
        } else {
            t.append("+");
        }

    }

    //public void

    public void solveEquation(View view){
        TextView t = (TextView) findViewById(R.id.inputView);
        String input = t.getText().toString().trim();

        String[] holder1 = input.split("[X/+-]");
        String[] holder2 = input.split("\\d+(\\.\\d+)?");

        ArrayList<String> operands = new ArrayList<String>();
        ArrayList<String> operators = new ArrayList<String>();

        int i;

        //copy
        for(i = 0; i < holder1.length; i++)
            operands.add(holder1[i]);

        for(i = 0; i < holder2.length; i++)
            operators.add(holder2[i]);

        operators.remove(0);


        //solve mul or div
        for(i = 0; i < operators.size(); i++){

            if(operators.get(i).equals("X")){
                double product = Double.parseDouble(operands.get(i)) * Double.parseDouble(operands.get(i+1));
                operands.set(i+1, Double.toString(product));
            }

            if(operators.get(i).equals("/")){
                double quotient = Double.parseDouble(operands.get(i)) / Double.parseDouble(operands.get(i+1));
                operands.set(i+1, Double.toString(quotient));
            }

            operands.remove(i);
            operators.remove(i);
            i = 0;
        }


        for(i = 0; i < operators.size(); i++){

            if(operators.get(i).equals("+")){
                double sum = Double.parseDouble(operands.get(i)) + Double.parseDouble(operands.get(i+1));

                operands.remove(i);
                operators.remove(i);

                operands.set(i, Double.toString(sum));

                i = 0;
                if(operators.size() == 0)
                    break;
            }

            if(operators.get(i).equals("-")){
                double difference = Double.parseDouble(operands.get(i)) - Double.parseDouble(operands.get(i+1));

                operands.remove(i);
                operators.remove(i);

                operands.set(i, Double.toString(difference));

                i = 0;
                if(operators.size() == 0)
                    break;
            }
        }

        t.setText(operands.get(0));
    }
}
