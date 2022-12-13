package com.example.demo;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.demo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button tabbar_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        setTitle("做着玩的");

        initView();                               /// 初始化控件
        selectorMethod();                         /// 点击事件
    }

    /*** * 初始化控件 */
    public void initView()
    {
        tabbar_btn = (Button) findViewById(R.id.tabbar_btn);
    }

    /*** * 按钮点击事件 */
    public void selectorMethod()
    {
        // 展示自定义Tabbar
        tabbar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("展示自定义Tabbar");
                // 跳转页面
                Intent intent = new Intent(MainActivity.this, ShowTabbarActivity.class);
                startActivity(intent);
            }
        });
    }

}