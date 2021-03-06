package com.example.redes.myapplication;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.content.Intent;
import android.widget.*;
import android.view.*;
import android.provider.ContactsContract;
import android.database.Cursor;
import android.net.Uri;
//import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private final static  String TAG = MainActivity.class.getSimpleName();
    private Uri uriContact;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"---OnCreate---");
        System.out.print("---OnCreate---");



        Button loginBtn = (Button) findViewById(R.id.buttonLogin);
        Button contactsBtn = (Button) findViewById(R.id.buttonContacts);

        //final TextView username = (TextView) findViewById(R.id.editTextUsername);

        final EditText loginUsername = (EditText) findViewById(R.id.editTextUsername);
        final EditText loginPassword = (EditText) findViewById(R.id.editTextPassword);
        final EditText loginCode = (EditText) findViewById(R.id.editTextCode);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                i.putExtra("usernameData", loginUsername.getText().toString());
                i.putExtra("passwordData", loginPassword.getText().toString());
                i.putExtra("codeData", loginCode.getText().toString());
                //i.putExtra("codeData", Integer.toString(new Random().nextInt(10000)));

                startActivity(i);
            }
        });

        contactsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                retrieveContactName();


            }


        });

    }



    private void retrieveContactName() {


        String[] projection = new String[] {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
        //String selection = ContactsContract.Contacts.IN_VISIBLE_GROUP + " = '" + ("1") + "'";
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, projection, null, null, "display_name ASC");

        Log.d(TAG, "------" + phones.getColumnCount());

        while (phones.moveToNext()){

            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            //Log.d(TAG, "Contact #" + phones.getPosition() + " : " + name );
            Log.d(TAG, "Contact #" + phones.getPosition() + " : " + name + " (" + phoneNumber + ")");
            //Toast.makeText(getApplicationContext(),name, Toast.LENGTH_LONG).show();
        }

        phones.close();



    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"---OnStart---");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"---OnPause---");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"---OnResume---");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"---OnStop---");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"---OnRestart---");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"---OnDestroy---");
    }



}
