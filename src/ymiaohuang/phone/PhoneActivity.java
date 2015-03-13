package com.ymiaohuang.phone;
/*
 * 实现电话拨号功能
 * 1.需要用到两个view：
 * 		EditText：用来输入电话号码
 * 		button：实现拨号功能的按钮
 * 	andoird提供的拨号功能的Activity：OutgoingCallBroadcaster
 * 2.给button添加的监听器的处理方法中
 * 		1.获取EditText中的号码number
 * 		2.定义一个Intent，给这意图setAction，addcategory，setData（Uri）
 * 			最后startActivity(intent);adroid会返回一个与该intent相匹配的Activity
 * 3.在manifest中声明权限，才能使用该功能。
 * 		<uses-permission android:name="android.permission.CALL_PHONE"/>
 * 
 * View：
 * action：动作
 * Category：类别
 * Uri：地址
 * */
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PhoneActivity extends Activity {
    private EditText mobileText;
    private Button button1;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button1 = (Button)this.findViewById(R.id.button1);
        mobileText = (EditText)findViewById(R.id.mobile);
        button1.setOnClickListener(new ButtonClickListener());//可以用内部类格式简化书写。
    }
    public final class ButtonClickListener implements View.OnClickListener{
    	public void onClick(View v){
    		
    		String number = mobileText.getText().toString();
    		Intent intent = new Intent();
    		intent.setAction("android.intent.action.CALL");
//    		intent.addCategory("android.intent.category.DEFAULT");//可以不用写。
    		intent.setData(Uri.parse("tel:"+number));
    		startActivity(intent);//激活与intent匹配的Activity
    		//方法内部会自动为Intent添加类别：android.intent.category.DEFAULT
    	}
    }
}