package com.ymiaohuang.phone;
/*
 * ʵ�ֵ绰���Ź���
 * 1.��Ҫ�õ�����view��
 * 		EditText����������绰����
 * 		button��ʵ�ֲ��Ź��ܵİ�ť
 * 	andoird�ṩ�Ĳ��Ź��ܵ�Activity��OutgoingCallBroadcaster
 * 2.��button��ӵļ������Ĵ�������
 * 		1.��ȡEditText�еĺ���number
 * 		2.����һ��Intent��������ͼsetAction��addcategory��setData��Uri��
 * 			���startActivity(intent);adroid�᷵��һ�����intent��ƥ���Activity
 * 3.��manifest������Ȩ�ޣ�����ʹ�øù��ܡ�
 * 		<uses-permission android:name="android.permission.CALL_PHONE"/>
 * 
 * View��
 * action������
 * Category�����
 * Uri����ַ
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
        button1.setOnClickListener(new ButtonClickListener());//�������ڲ����ʽ����д��
    }
    public final class ButtonClickListener implements View.OnClickListener{
    	public void onClick(View v){
    		
    		String number = mobileText.getText().toString();
    		Intent intent = new Intent();
    		intent.setAction("android.intent.action.CALL");
//    		intent.addCategory("android.intent.category.DEFAULT");//���Բ���д��
    		intent.setData(Uri.parse("tel:"+number));
    		startActivity(intent);//������intentƥ���Activity
    		//�����ڲ����Զ�ΪIntent������android.intent.category.DEFAULT
    	}
    }
}