package com.example.sheardexample4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    private CheckBox check;
    private Button btnclick;

    public static final String Name="Name";
    public static final String Pass="Pass";
    public static final String Flag="false";
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Boolean falg=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.txt1);
        txt2=findViewById(R.id.txt2);
        btnclick=findViewById(R.id.btnclick);
        check=findViewById(R.id.chbox);
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();
        CheckPrefs();
    }

    private void CheckPrefs() {
       falg=prefs.getBoolean(Flag,false);

       if(falg){
           String name=prefs.getString(Name,"");
           String pass=prefs.getString(Pass,"");
           txt1.setText(name);
           txt2.setText(pass);
           check.setChecked(true);
       }
    }

    public void btnonclick(View view) {

        String name=txt1.getText().toString();
        String pass=txt2.getText().toString();
        if(check.isChecked()){
           if(!falg){
            editor.putString(Name,name);
            editor.putString(Pass,pass);
            editor.putBoolean(Flag,true);
            editor.commit();
           }
        }

    }
}