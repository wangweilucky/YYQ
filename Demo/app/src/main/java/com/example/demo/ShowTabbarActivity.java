package com.example.demo;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.demo.databinding.ActivityShowTabbarBinding;

public class ShowTabbarActivity extends AppCompatActivity implements View.OnClickListener
{
    private FrameLayout flayout;

    private RelativeLayout ruiku_layout;
    private ImageView ruiku_iv;
    private TextView ruiku_tv;

    private RelativeLayout yuyue_layout;
    private ImageView yuyue_iv;
    private TextView yuyue_tv;

    private RelativeLayout xiaoxi_layout;
    private ImageView xiaoxi_iv;
    private TextView xiaoxi_tv;

    private RelativeLayout wode_layout;
    private ImageView wode_iv;
    private TextView wode_tv;

    private int whirt = 0xFFFFFFFF;
    private int gray = 0xFF7597B3;
    private int blue =0xFF0AB2FB;

    private TestFragment1 testFragment1;
    private TestFragment2 testFragment2;
    private TestFragment3 testFragment3;
    private TestFragment4 testFragment4;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tabbar);           // 绑定页面

        initView();

        fragmentManager = getSupportFragmentManager();


        // 默认加载某一个tabbarItem（第一个按钮）
        TestFragment1 testFragment1 = new TestFragment1();

        // 启动Activity时使第一个按钮的图标为选中状态（投机取巧）
        ruiku_iv.setImageResource(R.drawable.btn_ku_s);
        getSupportFragmentManager().beginTransaction().add(R.id.content,testFragment1).commit();
    }

    /***
     * 初始化控件
     */
    public void initView()
    {
        ruiku_layout = (RelativeLayout) findViewById(R.id.ruiku_layout);
        ruiku_iv = (ImageView) findViewById(R.id.ruiku_iv);
        ruiku_tv = (TextView) findViewById(R.id.ruiku_tv);

        yuyue_layout = (RelativeLayout) findViewById(R.id.yuyue_layout);
        yuyue_iv = (ImageView) findViewById(R.id.yuyue_iv);
        yuyue_tv = (TextView) findViewById(R.id.yuyue_tv);

        xiaoxi_layout = (RelativeLayout) findViewById(R.id.xiaoxi_layout);
        xiaoxi_iv = (ImageView) findViewById(R.id.xiaoxi_iv);
        xiaoxi_tv = (TextView) findViewById(R.id.xiaoxi_tv);

        wode_layout = (RelativeLayout) findViewById(R.id.wode_layout);
        wode_iv = (ImageView) findViewById(R.id.wode_iv);
        wode_tv = (TextView) findViewById(R.id.wode_tv);

        ruiku_layout.setOnClickListener(this);
        yuyue_layout.setOnClickListener(this);
        xiaoxi_layout.setOnClickListener(this);
        wode_layout.setOnClickListener(this);

        clearChioce();          // 清空选择
    }

    /***
     * 重写点击事件 -- 根据 implements View.OnClickListener 来的
     * @param v 当前视图
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ruiku_layout:
                setChioceItem(0);
                break;
            case R.id.yuyue_layout:
                setChioceItem(1);
                break;
            case R.id.xiaoxi_layout:
                setChioceItem(2);
                break;
            case R.id.wode_layout:
                setChioceItem(3);
                break;
            default:
                break;
        }
    }

    /***
     * 定义选中后的控制器
     * @param index index
     */
    public void setChioceItem(int index)
    {
        clearChioce();      // 既然是点击选择，那么在点的时候就应该清除一下上一个索引

        // 重置选项+隐藏所有的Fragment
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        hideFragments(transaction);

        switch (index) {
            case 0:
                ruiku_iv.setImageResource(R.drawable.tabbar_ruiku_selector);
                ruiku_tv.setTextColor(blue);
                if (testFragment1 == null) {
                    testFragment1 = new TestFragment1();
                    transaction.add(R.id.content,testFragment1);
                } else {
                    transaction.show(testFragment1);
                }
                break;

            case 1:
                yuyue_iv.setImageResource(R.drawable.tabbar_yuyue_selector);
                yuyue_tv.setTextColor(blue);
                if (testFragment2 == null) {
                    testFragment2 = new TestFragment2();
                    transaction.add(R.id.content,testFragment2);
                } else {
                    transaction.show(testFragment2);
                }
                break;

            case 2:
                xiaoxi_iv.setImageResource(R.drawable.tabbar_xiaoxi_selector);
                xiaoxi_tv.setTextColor(blue);
                if (testFragment3 == null) {
                    testFragment3 = new TestFragment3();
                    transaction.add(R.id.content,testFragment3);
                } else {
                    transaction.show(testFragment3);
                }
                break;

            case 3:
                wode_iv.setImageResource(R.drawable.tabbar_wode_selector);
                wode_tv.setTextColor(blue);
                if (testFragment4 == null) {
                    testFragment4 = new TestFragment4();
                    transaction.add(R.id.content,testFragment4);
                } else {
                    transaction.show(testFragment4);
                }
                break;
        }
        transaction.commit();
    }

    public void clearChioce()
    {
        ruiku_iv.setImageResource(R.drawable.btn_ku_n);
        ruiku_layout.setBackgroundColor(whirt);
        ruiku_tv.setTextColor(gray);

        yuyue_iv.setImageResource(R.drawable.btn_book_n);
        yuyue_layout.setBackgroundColor(whirt);
        yuyue_tv.setTextColor(gray);

        xiaoxi_iv.setImageResource(R.drawable.btn_ms_n);
        xiaoxi_layout.setBackgroundColor(whirt);
        xiaoxi_tv.setTextColor(gray);

        wode_iv.setImageResource(R.drawable.btn_ps_n);
        wode_layout.setBackgroundColor(whirt);
        wode_tv.setTextColor(gray);
    }


    private void hideFragments(FragmentTransaction transaction)
    {
        if (testFragment1 != null) {
            transaction.hide(testFragment1);
        }
        if (testFragment2 != null) {
            transaction.hide(testFragment2);
        }
        if (testFragment3 != null) {
            transaction.hide(testFragment3);
        }
        if (testFragment4 != null) {
            transaction.hide(testFragment4);
        }
    }
}