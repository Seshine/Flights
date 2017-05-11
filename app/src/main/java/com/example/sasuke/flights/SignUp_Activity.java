package com.example.sasuke.flights;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUp_Activity extends AppCompatActivity {
StoragePref storagePref;
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.dateofbirth)
    EditText dateofbirth;
    @BindView(R.id.contact)
    EditText contact;
    @BindView(R.id.email)
    EditText email;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.conpassword)
    EditText conpassword;


    public boolean a1, a2, a3, a4, a5,a6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(SignUp_Activity.this);
        storagePref=new StoragePref(SignUp_Activity.this);
        if(!storagePref.isFrist()){
            startActivity(new Intent(SignUp_Activity.this,Login_activity.class));
            finish();
        }




    }






   public void signupUser(View v) {

        a1 = true;
        a2 = true;
        a3 = true;
        a4 = true;
        a5 = true;
        a6 = true;


       if (TextUtils.isEmpty(name.getText().toString())) {

            name.setError("Emtyname");
            a1 = false;

        }

        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String m = email.getText().toString();
        if (m.matches(emailPattern) != true) {
            email.setError("invalid");
            a2 = false;
        }


        if (password.getText().toString().length() > 6) {
            String pa = password.getText().toString();
            String pas = conpassword.getText().toString();
            if (pas.equals(pa) != true) {
                password.setError("Mismatch password");
                a3 = false;
            }

        } else {


            password.setError(" can't lessthan 6 char");
            password.setError("can't  lessthan 6 char");
            a4 = false;

        }


        if (contact.getText().toString().length() < 10) {
            contact.setError("can't lessthan 10 numbers");
            a5 = false;
        }
        if (TextUtils.isEmpty(dateofbirth.getText().toString())) {
                       a6=false;
        }

        if (a1 && a2 && a3 && a4 && a5 && a6 == true) {
            storagePref.storeInfo(name.getText().toString(),dateofbirth.getText().toString(),contact.getText().toString(),email.getText().toString(),password.getText().toString());
            startActivity(new Intent(SignUp_Activity.this,Login_activity.class));
        }
    }
}
