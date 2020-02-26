package com.caramba.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.caramba.simplecalculator.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView textViewInput;
    private TextView textViewAnswer;
    private TextView textViewHistory;

    private Button button_1;
    private Button button_2;
    private Button button_3;
    private Button button_4;
    private Button button_5;
    private Button button_6;
    private Button button_7;
    private Button button_8;
    private Button button_9;
    private Button button_0;
    private Button button_00;
    private Button button_divide;
    private Button button_multiply;
    private Button button_minus;
    private Button button_plus;
    private Button button_equals;
    private Button button_Clear;
    private Button button_del;
    private Button button_interest;
    private Button button_point;


    /**
     * Результат который заносится в масив для обработки
     */
    ArrayList<Float> result = new ArrayList<Float>();

    /**
     * Первое введенное число
     */
    float number1;

    /**
     * Второе введенное число
     */
    float number2;

    int currentOperation = 0;
    int nextOperation;

    /**
     * Прибавление
     */
    final static int ADD = 1;

    /**
     * Вычитание
     */
    final static int SUBTRACT = 2;

    /**
     * Умножение
     */
    final static int MULTIPLY = 3;

    /**
     * Деление
     */
    final static int DIVISION = 4;

    /**
     * Равно
     */
    final static int EQUALS = 5;


    final static int CLEAR = 1;
    final static int DONT_CLEAR = 0;
    int clearCalcDisplay = 0;

    private static final String TAG = "myLogs";//тег для лога


    private String history;//записываетса история
    private String input = "";//записываетса вод
    private String answer;//записываетса ответ


    // ключи для сохранеия состояния переменых
    private static final String KEY_HISTORY = "HISTORY";
    private static final String KEY_INPUT = "INPUT";
    private static final String KEY_ANSWER = "ANSWER";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        //находим елементы по индификатору
        textViewInput = (TextView) findViewById(R.id.textViewInput);
        textViewAnswer = (TextView) findViewById(R.id.textViewAnswer);
        textViewHistory = (TextView) findViewById(R.id.textViewHistory);
        button_0 = (Button) findViewById(R.id.button_0);
        button_1 = (Button) findViewById(R.id.button_1);
        button_2 = (Button) findViewById(R.id.button_2);
        button_3 = (Button) findViewById(R.id.button_3);
        button_4 = (Button) findViewById(R.id.button_4);
        button_5 = (Button) findViewById(R.id.button_5);
        button_6 = (Button) findViewById(R.id.button_6);
        button_7 = (Button) findViewById(R.id.button_7);
        button_8 = (Button) findViewById(R.id.button_8);
        button_9 = (Button) findViewById(R.id.button_9);
        button_00 = (Button) findViewById(R.id.button_00);
        button_divide = (Button) findViewById(R.id.button_divide);
        button_multiply = (Button) findViewById(R.id.button_multiply);
        button_minus = (Button) findViewById(R.id.button_minus);
        button_plus = (Button) findViewById(R.id.button_plus);
        button_equals = (Button) findViewById(R.id.button_equals);
        button_Clear = (Button) findViewById(R.id.button_Clear);
        button_del = (Button) findViewById(R.id.button_del);
        button_interest = (Button) findViewById(R.id.button_interest);
        button_point = (Button) findViewById(R.id.button_point);


        if (savedInstanceState != null) {
            answer = savedInstanceState.getString(KEY_ANSWER, String.valueOf(0));
            textViewAnswer.setText(answer);

            input = savedInstanceState.getString(KEY_INPUT, String.valueOf(0));
            textViewInput.setText(input);

            history = savedInstanceState.getString(KEY_HISTORY, String.valueOf(0));
            textViewHistory.setText(history);
        }


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_ANSWER, answer);
        outState.putString(KEY_INPUT, input);
        outState.putString(KEY_HISTORY, history);
    }

    //обробатываем нажатия кнопок

    public void onClick(View view) {

        //TODO history
        Log.d(TAG, "Оброботаем нажатие кнопки"); //выводит лог в Logcat
//        CharSequence text = textViewInput.getText();

        switch (view.getId()) {


            case R.id.button_0:

                clearIfEqualsZero();
                textViewInput.append("0");
                input += 0;
                history += 0;
                result.add(Float.valueOf("0"));

                break;

            case R.id.button_00:

                clearIfEqualsZero();

                textViewInput.append("00");
                input += 00;
                history += 00;
                result.add(Float.valueOf("00"));


                break;

            case R.id.button_1:
                clearIfEqualsZero();
                textViewInput.append("1");// добовляет 1 к  textViewInput
                input += 1;
                history += 1;
                result.add(Float.valueOf("1"));


                break;

            case R.id.button_2:

                clearIfEqualsZero();

                textViewInput.append("2");
                input += 2;
                history += 2;
                result.add(Float.valueOf("2"));
                break;

            case R.id.button_3:

                clearIfEqualsZero();

                textViewInput.append("3");

                input += 3;
                history += 3;

                result.add(Float.valueOf("3"));


                break;

            case R.id.button_4:

                clearIfEqualsZero();


                textViewInput.append("4");

                input += 4;
                history += 4;

                result.add(Float.valueOf("4"));

                break;

            case R.id.button_5:

                clearIfEqualsZero();

                textViewInput.append("5");

                input += 5;
                history += 5;

                result.add(Float.valueOf("5"));

                break;

            case R.id.button_6:

                clearIfEqualsZero();

                textViewInput.append("6");
                input += 6;
                history += 6;

                result.add(Float.valueOf("6"));

                break;

            case R.id.button_7:

                clearIfEqualsZero();

                textViewInput.append("7");
                input += 7;
                history += 7;

                result.add(Float.valueOf("7"));

                break;

            case R.id.button_8:

                clearIfEqualsZero();

                textViewInput.append("8");
                input += 8;
                history += 8;

                result.add(Float.valueOf("8"));

                break;

            case R.id.button_9:

                clearIfEqualsZero();

                textViewInput.append("9");
                input += 9;
                history += 9;

                result.add(Float.valueOf("9"));

                break;
            case R.id.button_point:


                textViewInput.append(".");
                if (input != "") {
                    input += ".";
                    history += ".";
//TODO
                }
                break;

            case R.id.button_del:
                input = textViewInput.getText().toString();
                if (input.length() != 0) {
                    textViewInput.setText(input.substring(0, input.length() - 1));
                    input = textViewInput.getText().toString();
                    history = input;
                }
                //TODO
                break;

            case R.id.button_Clear:
                clearAll();

                break;

            case R.id.button_plus:
                if (input.length() != 0) {
                    calcLogic(ADD);
                }
                textViewInput.append("+");
                history += "+";

                Log.d(TAG, "Нажата кнопка +");
                break;

            case R.id.button_minus:
                if (textViewInput.length() != 0) {
                    calcLogic(SUBTRACT);

                }
                textViewInput.append("-");
                history += "-";

                Log.d(TAG, "Нажата кнопка -");
                break;

            case R.id.button_divide:
                if (textViewInput.length() != 0) {
                    calcLogic(DIVISION);
                }
                textViewInput.append("/");
                history = "+";


                Log.d(TAG, "Нажата кнопка /");
                break;
            case R.id.button_multiply:
                if (textViewInput.length() != 0) {
                    calcLogic(MULTIPLY);

                }

                textViewInput.append("*");

                history = "*";

                Log.d(TAG, "Нажата кнопка *");
                break;

            case R.id.button_equals:
                Log.d(TAG, "Нажата кнопка =");
                try {

                    if (textViewInput.getText().length() != 0) {

                        calcLogic(EQUALS);
                    }
                } catch (Exception e) {
                    textViewAnswer.setText("Oшибка!");
                    Log.e(TAG, "ошибка: " + e);
                }


                break;


            default:
                break;

        }

    }


    private void clearDisplay() {
        if (clearCalcDisplay == CLEAR) {
            textViewInput.setText("");

        }
    }


    private void clearIfEqualsZero() {
        if (textViewInput.getText().toString().equals("0")) {
            textViewInput.setText("");
            Log.d(TAG, "clearIfEqualsZero");
        }
    }


    /*Функция расчета введенных значений*/
    private void calcLogic(int operator) {


        try {

            if (input != "") {
                result.add(Float.valueOf(input));
            }

            if (operator != EQUALS) {
                nextOperation = operator;
            } else if (operator == EQUALS) {
                nextOperation = 0;
            }

            switch (currentOperation) {

                /*Прибавление*/
                case ADD:
                    number1 = result.get(0);
                    number2 = result.get(1);

                    result.clear();
                    result.add(number1 + number2);

                    answer = String.format("%.0f", result.get(0));

                    input = "";
                    input = answer;
                    textViewAnswer.setText(answer);
                    answer = "";
                    break;

                /*Вычитание*/
                case SUBTRACT:
                    number1 = result.get(0);
                    number2 = result.get(1);

                    result.clear();

                    result.add(number1 - number2);

                    answer = String.format("%.0f", result.get(0));
                    textViewAnswer.setText(answer);
                    break;

                /*Умножение*/
                case MULTIPLY:
                    number1 = result.get(0);
                    number2 = result.get(1);

                    result.clear();

                    result.add(number1 * number2);

                    answer = String.format("%.0f", result.get(0));
                    textViewAnswer.setText(answer);
                    break;
                /*Деление*/
                case DIVISION:
                    number1 = result.get(0);
                    number2 = result.get(1);

                    result.clear();

                    result.add(number1 / number2);

                    answer = String.format("%.0f", result.get(0));
                    textViewAnswer.setText(answer);
                    break;
            }


//            clearCalcDisplay = CLEAR;
            currentOperation = nextOperation;
            if (operator == EQUALS) {
                number1 = 0;
                number2 = 0;

                Float answerFloat = result.get(0);

                answer = String.format("%.0f", answerFloat);
                textViewAnswer.setText("");
                history += " = " + " " + answer + "\n";
                textViewHistory.append(history);
                textViewInput.setText(answer);
                result.clear();

                result.add(answerFloat);

                input = "";
                answer = "";
                //  answer = "";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void clearAll() {
        result.clear();
        textViewInput.setText("0");
        textViewHistory.setText("");
        textViewAnswer.setText("");
        input = "";
        history = "";
        answer = "";
    }
//TODO manes eqvals


}
