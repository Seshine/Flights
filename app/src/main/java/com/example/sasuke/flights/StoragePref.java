package com.example.sasuke.flights;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sasuke on 5/10/2017.
 */

public class StoragePref {
 Context context;
SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    public StoragePref(Context context) {
        this.context=context;
        sharedPreferences=context.getSharedPreferences("Local_Storage",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();

    }
    public void storeInfo(String name,String dfb,String number,String email,String password){
        editor.putString("name",name);
        editor.putString("dfb",dfb);
        editor.putString("number",number);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.commit();

    }
    public String[] getUserinfo(){
        sharedPreferences.getString("name","nothing");
        sharedPreferences.getString("dfb","nothing");
        sharedPreferences.getString("number","nothing");
        sharedPreferences.getString("email","nothing");
        return new String[]{sharedPreferences.getString("name",null),  sharedPreferences.getString("dfb",null),sharedPreferences.getString("number",null),
                sharedPreferences.getString("email",null)};

    }
    public  void setFrist(boolean checker){
        editor.putBoolean("key",checker);
        editor.commit();
    }
    public  boolean isFrist(){
        return  sharedPreferences.getBoolean("key",true);
    }

    public boolean checkLogin(String u,String pass){

        if(sharedPreferences.getString("number",null).equals(u)&&sharedPreferences.getString("password",null).equals(pass)){
          return  true;}
        else if(
                        sharedPreferences.getString("email", null).equals(u) && sharedPreferences.getString("password", null).equals(pass))
        { return  true;
        }
        else
            return false;
    }
}
