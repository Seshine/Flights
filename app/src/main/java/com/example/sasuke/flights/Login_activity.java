package com.example.sasuke.flights;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login_activity extends AppCompatActivity {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    Button logins;
      StoragePref pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        pref=new StoragePref(Login_activity.this);
        ButterKnife.bind(this);


    }

    public void logins(View view) {
        loginuser();
    }


    private void loginuser() {


        if (TextUtils.isEmpty(username.getText().toString())) {

            Toast.makeText(this, "please enter email", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(password.getText().toString())) {


            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();

            return;
        }

         if(pref.checkLogin(username.getText().toString(),password.getText().toString()))
        startActivity(new Intent(getApplicationContext(),HomeScreen.class));
        else{
             Toast.makeText(getApplicationContext(),"username or password worng",Toast.LENGTH_SHORT).show();
         }
    }

    @OnClick(R.id.reset)
    public  void reset(View view){

        AlertDialog.Builder builder=new  AlertDialog.Builder(Login_activity.this);
        View v=getLayoutInflater().inflate(R.layout.verify_reset_login,null);
        builder.setTitle("Enter detials");
        builder.setView(v);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();


    }


}
