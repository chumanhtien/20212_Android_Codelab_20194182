package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button bt_0, bt_1, bt_2, bt_3, bt_4, bt_5, bt_6, bt_7, bt_8, bt_9,
            bt_add, bt_sub, bt_multi, bt_divide,
            bt_equal, bt_dot,
            bt_clear, bt_ce; //Clear: xóa hết, ce: xóa toán hạng
    ImageButton bt_dl1;
    TextView text_main_screen, text_extra_screen;
    String toanhang, pheptoan;
    boolean checkEqual, checkDot, is2ndOperator, isHaveAnotherOperation, isFirstInput;
    int result, num1, num2;

    public static int semaphore;
//    double result, num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Khởi tạo các nút
        generateVariables();

        bt_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_extra_screen.setText("");
                text_main_screen.setText("0");
                pheptoan = "";
                toanhang = "";
                checkDot = false;
                checkEqual = false;
                is2ndOperator = false;
                isHaveAnotherOperation = false;
                num1 = 0;
                num2 = 0;
            }
        });

        bt_ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toanhang = text_main_screen.getText().toString();
                text_main_screen.setText("0");
            }
        });

        bt_dl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toanhang = text_main_screen.getText().toString();
                if (toanhang.length() == 1)
                    toanhang = "0";
                else
                    toanhang = toanhang.substring(0, toanhang.length() - 1);
                text_main_screen.setText((toanhang));
            }
        });

        bt_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("0");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "0");
                    } else {
                        text_main_screen.setText("0");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();

                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("1");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "1");
                    } else {
                        text_main_screen.setText("1");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("2");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "2");
                    } else {
                        text_main_screen.setText("2");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("3");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "3");
                    } else {
                        text_main_screen.setText("3");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("4");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "4");
                    } else {
                        text_main_screen.setText("4");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("5");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "5");
                    } else {
                        text_main_screen.setText("5");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("6");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "6");
                    } else {
                        text_main_screen.setText("6");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;
            }
        });

        bt_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("7");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "7");
                    } else {
                        text_main_screen.setText("7");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;

            }
        });

        bt_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("8");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "8");
                    } else {
                        text_main_screen.setText("8");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;

            }
        });

        bt_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkEqual) {
                    checkEqual = false;
                    text_extra_screen.setText("");
                    text_main_screen.setText("0");
                }
                if (!checkEqual) {
                    toanhang = text_main_screen.getText().toString();
                    if (toanhang.equals(String.valueOf("0"))) {
                        text_main_screen.setText("9");
                    } else if (!is2ndOperator) {
                        text_main_screen.setText(toanhang + "9");
                    } else {
                        text_main_screen.setText("9");
                        is2ndOperator = false;
                    }
                }
                isHaveAnotherOperation = false;

            }
        });

        bt_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (text_main_screen.getText() == "0") {
                    num1 = num1 + 0;
                    text_extra_screen.setText(String.valueOf(num1)+ " + ");
                }
                else {
//                    toanhang = text_main_screen.getText().toString();
                    pheptoan = "+";

                    if (!isHaveAnotherOperation)
                        num1 = num1 + Integer.parseInt(text_main_screen.getText() + "");
                    else
                        num1 = Integer.parseInt(text_main_screen.getText() + "");
                    text_extra_screen.setText(String.valueOf(num1) + " " + pheptoan + " ");
                    toanhang = String.valueOf(num1);
                    text_main_screen.setText(toanhang);



                    toanhang = "0";
                    checkEqual = false;
                    checkDot = false;
                    is2ndOperator = true;
                    isHaveAnotherOperation = true;
                }
            }
        });

        bt_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_main_screen.getText() == "0") {
                    num1 = num1 - 0;
                    text_extra_screen.setText(String.valueOf(num1)+ " - ");
                }
                else {
                    pheptoan = "-";
                    if (!isHaveAnotherOperation && num1 != 0)
                        num1 = num1 - Integer.parseInt(text_main_screen.getText() + "");
                    else
                        num1 = Integer.parseInt(text_main_screen.getText() + "");
//                    toanhang = text_main_screen.getText().toString();
                    toanhang = String.valueOf(num1);
                    text_main_screen.setText(toanhang);
                    text_extra_screen.setText(String.valueOf(num1) + " " + pheptoan + " ");

                    toanhang = "0";
                    checkEqual = false;
                    checkDot = false;
                    is2ndOperator = true;
                }
                isHaveAnotherOperation = true;

            }
        });

        bt_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_main_screen.getText() == "0") {
                    num1 = num1 + 0;
                    text_extra_screen.setText(String.valueOf(num1)+ " x ");
                }
                else {
//                    toanhang = text_main_screen.getText().toString();
                    pheptoan = "x";
                    if (!isHaveAnotherOperation && num1 != 0)
                        num1 = Integer.parseInt(text_main_screen.getText() + "") * num1;
                    else
                        num1 = Integer.parseInt(text_main_screen.getText() + "");
                    text_extra_screen.setText(String.valueOf(num1) + " " + pheptoan + " ");
                    toanhang = String.valueOf(num1);
                    text_main_screen.setText(toanhang);



                    toanhang = "0";
                    checkEqual = false;
                    checkDot = false;
                    is2ndOperator = true;
                    isHaveAnotherOperation = true;
                }
                isHaveAnotherOperation = true;

            }
        });

        bt_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (text_main_screen.getText() == "0") {
                    num1 = num1 + 0;
                    text_extra_screen.setText(String.valueOf(num1)+ " / ");
                }
                else {
//                    toanhang = text_main_screen.getText().toString();
                    pheptoan = "/";
                    if (!isHaveAnotherOperation && num1 != 0)
                        num1 = Integer.parseInt(text_main_screen.getText() + "") / num1;
                    else
                        num1 = Integer.parseInt(text_main_screen.getText() + "");
                    text_extra_screen.setText(String.valueOf(num1) + " " + pheptoan + " ");
                    toanhang = String.valueOf(num1);
                    text_main_screen.setText(toanhang);



                    toanhang = "0";
                    checkEqual = false;
                    checkDot = false;
                    is2ndOperator = true;
                }

                isHaveAnotherOperation = true;
            }
        });


        bt_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkEqual) {
                    checkDot = false;
                    toanhang = text_main_screen.getText().toString();

//                    if (is2ndOperator)
                        num2 = Integer.parseInt(toanhang);
//                    else num2 = 0;

                    text_extra_screen.setText(text_extra_screen.getText().toString() + toanhang + " = ");

                    if (pheptoan == "+") {
                        result = num1 + num2;
                    } else if (pheptoan == "-") {
                        result = num1 - num2;
                    } else if (pheptoan == "x") {
                        result = num1 * num2;
                    } else if (pheptoan == "/") {
                        if (num2 == 0) {
                            text_extra_screen.setText(text_extra_screen.getText().toString() + "Can't divide by zero");
//                            text_main_screen.setText(text_extra_screen.getText().toString()+ " = Can't divide by zero");
                        }
                        else
                            result = num1 / num2;
                    } else if (pheptoan == "") {
                        result = Integer.parseInt(text_main_screen.getText().toString());
                    }


                    if (num2 != 0)
                        text_main_screen.setText(String.valueOf(result));

                    num1 = 0;
                    checkEqual = true;
                    toanhang="0";
                    pheptoan="";
                    is2ndOperator = false;
                    isHaveAnotherOperation = false;
                }
            }
        });

    }

    protected void generateVariables() {
        bt_0 = findViewById(R.id.button_number_0);
        bt_1 = findViewById(R.id.button_number_1);
        bt_2 = findViewById(R.id.button_number_2);
        bt_3 = findViewById(R.id.button_number_3);
        bt_4 = findViewById(R.id.button_number_4);
        bt_5 = findViewById(R.id.button_number_5);
        bt_6 = findViewById(R.id.button_number_6);
        bt_7 = findViewById(R.id.button_number_7);
        bt_8 = findViewById(R.id.button_number_8);
        bt_9 = findViewById(R.id.button_number_9);

        bt_add = findViewById(R.id.button_add);
        bt_sub = findViewById(R.id.button_subtract);
        bt_multi = findViewById(R.id.button_multiple);
        bt_divide = findViewById(R.id.button_divide);

        bt_equal = findViewById(R.id.button_equal);
        bt_dot = findViewById(R.id.button_dot);
        bt_clear = findViewById(R.id.button_c);
        bt_ce = findViewById(R.id.button_ce);
        bt_dl1 = findViewById(R.id.button_dl1);

        text_extra_screen = findViewById(R.id.text_expression);
        text_main_screen= findViewById(R.id.text_result);

        is2ndOperator = false;
        num1 = 0;
    }
}