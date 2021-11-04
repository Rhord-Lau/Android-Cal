package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    //Activity本身作为事件监听器

    //数字按钮
    private Button number0; //0
    private Button number1; //1
    private Button number2; //2
    private Button number3; //3
    private Button number4; //4
    private Button number5; //5
    private Button number6; //6
    private Button number7; //7
    private Button number8; //8
    private Button number9; //9

    //运算符
    private Button sum_btn;  //加
    private Button sub_btn;  //减
    private Button mul_btn;  //乘
    private Button div_btn;  //除
    private Button equ_btn;  //等于
    private Button rad_btn;  //开根号

    //其他功能
    private Button p_btn;    //小数点
    private Button cle_btn;  //清除
    private Button chg_btn;  //切换正负

    //记录
    private String op;  //记录选择不同运算方法
    double numL;        //运算符左边的数
    double numR;        //运算符右边的数
    double result;      //运算结果
    double exNum;       //用于开根号和正负数切换的数值


    //结果
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    //初始化控件
    private void initView() {

        //数字控件
        number0 = (Button) findViewById(R.id.zero);
        number1 = (Button) findViewById(R.id.one);
        number2 = (Button) findViewById(R.id.two);
        number3 = (Button) findViewById(R.id.three);
        number4 = (Button) findViewById(R.id.four);
        number5 = (Button) findViewById(R.id.five);
        number6 = (Button) findViewById(R.id.six);
        number7 = (Button) findViewById(R.id.seven);
        number8 = (Button) findViewById(R.id.eight);
        number9 = (Button) findViewById(R.id.nine);

        //运算符控件
        sum_btn = (Button) findViewById(R.id.Sum);
        sub_btn = (Button) findViewById(R.id.Sub);
        mul_btn = (Button) findViewById(R.id.Mul);
        div_btn = (Button) findViewById(R.id.Div);
        equ_btn = (Button) findViewById(R.id.Equal);
        rad_btn = (Button) findViewById(R.id.Rad);

        //其他功能（小数点、切换正负、清零控件）
        p_btn = (Button) findViewById(R.id.Point);
        chg_btn = (Button) findViewById(R.id.change);
        cle_btn = (Button) findViewById(R.id.clear);

        //结果（显示结果的控件）
        editText = (EditText) findViewById(R.id.Result);

    }

    //初始化事件
    private void initEvent() {
        //数字按钮监听器
        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);

        //运算符按钮监听器
        sum_btn.setOnClickListener(this);
        sub_btn.setOnClickListener(this);
        mul_btn.setOnClickListener(this);
        div_btn.setOnClickListener(this);
        equ_btn.setOnClickListener(this);
        rad_btn.setOnClickListener(this);

        //小数点、切换正负、清零按钮监听器
        p_btn.setOnClickListener(this);
        chg_btn.setOnClickListener(this);
        cle_btn.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {

        String str = editText.getText().toString();  //获取文本框中的文本内容

        //根据不同案例做出不同响应
        switch (v.getId()) {

            //清零：清空显示控件中的文本内容
            case R.id.clear:
                str = " ";
                editText.setText(str);
                break;

            //零：向文本内容中添加“0”，并在显示控件中显示数字0，
            case R.id.zero:
                str += "0";
                editText.setText(str);
                break;

            //一：向文本内容中添加“1”，并在显示控件中显示数字1
            case R.id.one:
                str += "1";
                editText.setText(str);
                break;

            //二：向文本内容中添加“2”，并在显示控件中显示数字2
            case R.id.two:
                str += "2";
                editText.setText(str);
                break;

            //三：向文本内容中添加“3”，并在显示控件中显示数字3
            case R.id.three:
                str += "3";
                editText.setText(str);
                break;

            //四：向文本内容中添加“4”，并在显示控件中显示数字4
            case R.id.four:
                str += "4";
                editText.setText(str);
                break;

            //五：向文本内容中添加“5”，并在显示控件中显示数字5
            case R.id.five:
                str += "5";
                editText.setText(str);
                break;

            //六：向文本内容中添加“6”，并在显示控件中显示数字6
            case R.id.six:
                str += "6";
                editText.setText(str);
                break;

            //七：向文本内容中添加“7”，并在显示控件中显示数字7
            case R.id.seven:
                str += "7";
                editText.setText(str);
                break;

            //八：向文本内容中添加“8”，并在显示控件中显示数字8
            case R.id.eight:
                str += "8";
                editText.setText(str);
                break;

            //九：向文本内容中添加“9”，并在显示控件中显示数字9
            case R.id.nine:
                str += "9";
                editText.setText(str);
                break;

            //加法：先将显示控件中的数字内容存储，再将显示控件中的内容清空，记录op为“+”，以便后面做计算时判断为何种算法
            case R.id.Sum:

                numL = Double.valueOf(str);//将获取的字符串转化为double类型以便计算
                str += "+";
                op = "+";
                editText.setText(null);

                break;

            //减法：先将显示控件中的数字内容存储，再将显示控件中的内容清空，记录op为“-”，以便后面做计算时判断为何种算法
            case R.id.Sub:

                numL = Double.valueOf(str);//将获取的字符串转化为double类型以便计算
                str += "-";
                op = "-";
                editText.setText(null);

                break;

            //乘法：先将显示控件中的数字内容存储，再将显示控件中的内容清空，记录op为“*”，以便后面做计算时判断为何种算法
            case R.id.Mul:

                numL = Double.valueOf(str);//将获取的字符串转化为double类型以便计算
                str += "*";
                op = "*";
                editText.setText(null);
                break;

            //除法：先将显示控件中的数字内容存储，再将显示控件中的内容清空，记录op为“/”，以便后面做计算时判断为何种算法
            case R.id.Div:

                numL = Double.valueOf(str);//将获取的字符串转化为double类型以便计算
                str += "/";
                op = "/";
                editText.setText(null);

                break;

            //小数点：在显示控件中显示“.”
            case R.id.Point:
                str += ".";
                op = ".";
                editText.setText(str);
                break;

            //开平方运算：记录当前数字，如果为负数，报错提示“负数不能被开平方！”；若不为负数，则进行开平方运算
            case R.id.Rad:

                exNum = Double.valueOf(str);
                if(exNum < 0) {
                    editText.setText("负数不能被开平方！");
                }else{
                    editText.setText("√" + String.valueOf(exNum) + "=" + String.valueOf(Math.sqrt(exNum)));
                }

                break;

            //切换正负：单独记录当前数字，若数字大于0，即为正数，添加负号改为负数，并显示在显示控件中；若数字小于0，即已经为负数，不添加负号，直接显示在显示控件中
            case R.id.change:
                exNum = Double.valueOf(str);
                if(str.length() > 0) {
                    if (exNum > 0) {
                        editText.setText(-exNum + "");
                    } else {
                        editText.setText(exNum + "");
                    }
                }


                break;

            //计算:先获取文本框中内容，记录数字为一个算式中第二个运算的数字，清空显示控件内容
            case R.id.Equal:
                String string = editText.getText().toString();
                numR = Double.valueOf(string);
                editText.setText(null);


                switch (op){      //用switch函数来判断进行何种操作，实施运算并得出结果
                    //加法运算：将算式中的第一个数字和第二个数字相加，将结果按设置好的格式输出到显示控件中
                    case "+":
                        result = numL + numR;
                        editText.setText(String.valueOf(numL) + "+" + String.valueOf(numR) + "=" + String.valueOf(result));//获取结果并将其转为字符串输出
                        break;

                    //减法运算：将算式中的第一个数字和第二个数字相减，将结果按设置好的格式输出到显示控件中
                    case "-":
                        result = numL - numR;
                        editText.setText(String.valueOf(numL) + "-" + String.valueOf(numR) + "=" + String.valueOf(result));
                        break;

                    //乘法运算：将算式中的第一个数字和第二个数字相乘，将结果按设置好的格式输出到显示控件中
                    case "*":
                        result = numL * numR;
                        editText.setText(String.valueOf(numL) + "*" + String.valueOf(numR) + "=" + String.valueOf(result));
                        break;

                    //除法运算：如果除数为零，进行报错提示；若除数不为零，则将算式中的第一个数字和第二个数字相除，将结果按设置好的格式输出到显示控件中
                    case "/":
                        if(numR == 0){
                        editText.setText("除数不能为0！");
                    }
                    else{
                        result = numL / numR;
                        editText.setText(String.valueOf(numL) + "/" + String.valueOf(numR) + "=" + String.valueOf(result));
                    }
                        break;

                }

                break;

        }

    }

}
