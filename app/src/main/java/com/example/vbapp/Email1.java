package com.example.vbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email1 extends AppCompatActivity {

    EditText editTextto, editTextsubject, editTextmessage;
    Button button, back;
    String to, subject, message;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email1);

        editTextto = (EditText) findViewById(R.id.editto);
        editTextsubject = (EditText) findViewById(R.id.editsubject);
        editTextmessage = (EditText) findViewById(R.id.editmessage);
        button = (Button) findViewById(R.id.btnsend);
        back = (Button) findViewById(R.id.back);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();

                intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {to});
                intent.putExtra(Intent.EXTRA_SUBJECT, subject);
                intent.putExtra(Intent.EXTRA_TEXT, message);

                intent.setType("message/rfc822");

                startActivity(Intent.createChooser(intent, "Select Email Sending Apps"));
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Email1.this, Info.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void GetData() {
        to = editTextto.getText().toString();
        subject = editTextsubject.getText().toString();
        message = editTextmessage.getText().toString();
    }
}
