package com.example.sasuke.flights;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserInfo extends AppCompatActivity {
   StoragePref storagePref;
    @BindView(R.id.dname)
    TextView  name;
    @BindView(R.id.demail)
    TextView  email;
    @BindView(R.id.dcontact)
    TextView  contact;
    @BindView(R.id.datofb)
    TextView  datofb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(UserInfo.this);
        storagePref=new StoragePref(UserInfo.this);

        String s[]=storagePref.getUserinfo();
        name.setText(""+s[0]);
        email.setText(""+s[1]);
        contact.setText(""+s[2]);
        datofb.setText(""+s[3]);

    }
}
