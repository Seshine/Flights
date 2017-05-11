package com.example.sasuke.flights;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;


import com.example.sasuke.flights.databinding.ActivityHomeScreenBinding;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {
Toolbar toolBar;
    user sa;
    DatabaseReference dataref;
    ArrayList<String> arrayList=new ArrayList<>();

    ActivityHomeScreenBinding binding;
    StoragePref storagePref;
    private ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storagePref=new StoragePref(HomeScreen.this);
        setContentView(R.layout.activity_home_screen);
       binding= DataBindingUtil.setContentView(this,R.layout.activity_home_screen);
       dataref = FirebaseDatabase.getInstance().getReference();
           sa=new user();

        dialog=new ProgressDialog(this);
        storagePref.setFrist(false);

      /*  dataref.child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String sad=dataSnapshot.getValue(String.class);
                Toast.makeText(getApplicationContext(),"="+sad,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/
        dataref.addValueEventListener(new ValueEventListener() {




            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dialog.setMessage("Loading data...");
                dialog.show();
                sa=dataSnapshot.getValue(user.class);



                dialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });







    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.meuns,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        Toast.makeText(getApplicationContext(),"userinfo",Toast.LENGTH_SHORT).show();
        switch(id){
            case R.id.resetpass:
                break;
            case R.id.usInfo:
                Toast.makeText(getApplicationContext(),"userinfo",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeScreen.this,UserInfo.class));
                break;
            case R.id.locations:
                startActivity(new Intent(HomeScreen.this,MainActivity.class));
                break;
        }


        return true;
    }
    }




