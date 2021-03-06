package com.joke.textdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list = new ArrayList<>();
    private TextView myTextView;
    private Spinner mySpinner;
    private ArrayAdapter<String> adapter;
    private Button bt;
    private EditText et;
    private String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
        bt = (Button) findViewById(R.id.button);
        et = (EditText) findViewById(R.id.editText);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et.getText().toString();
                list.add(str);
                et.setText("");
            }
        });
       /* list.add("12");
        list.add("23");
        list.add("34");
        list.add("45");
        list.add("56");*/
        myTextView = (TextView) findViewById(R.id.TextView_city);
        mySpinner = (Spinner) findViewById(R.id.Spinner_city);
        //第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        //第三步：为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //第四步：将适配器添加到下拉列表上
        mySpinner.setAdapter(adapter);
        //第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                /* 将所选mySpinner 的值带入myTextView 中*/
                myTextView.setText("您选择的是：" + adapter.getItem(arg2));
                /* 将mySpinner 显示*/
                arg0.setVisibility(View.VISIBLE);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
                myTextView.setText("NONE");
                arg0.setVisibility(View.VISIBLE);
            }
        });
        /*下拉菜单弹出的内容选项触屏事件处理*/
        mySpinner.setOnTouchListener(new Spinner.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                /**
                 *
                 */
                return false;
            }
        });
        /*下拉菜单弹出的内容选项焦点改变事件处理*/
        mySpinner.setOnFocusChangeListener(new Spinner.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                // TODO Auto-generated method stub

            }
        });
    }
}