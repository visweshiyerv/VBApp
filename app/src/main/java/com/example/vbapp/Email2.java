package com.example.vbapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email2 extends AppCompatActivity {


    EditText editTextto1, editTextsubject1, editTextmessage1;
    Button button1, back1;
    String to1, subject1, message1;
    Intent intent1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email2);

        editTextto1 = (EditText) findViewById(R.id.editto1);
        editTextsubject1 = (EditText) findViewById(R.id.editsubject1);
        editTextmessage1 = (EditText) findViewById(R.id.editmessage1);
        button1 = (Button) findViewById(R.id.btnsend1);
        back1 = (Button) findViewById(R.id.back1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetData();

                intent1 = new Intent(Intent.ACTION_SEND);
                intent1.putExtra(Intent.EXTRA_EMAIL, new String[] {to1});
                intent1.putExtra(Intent.EXTRA_SUBJECT, subject1);
                intent1.putExtra(Intent.EXTRA_TEXT, message1);

                intent1.setType("message/rfc822");

                startActivity(Intent.createChooser(intent1, "Select Email Sending Apps"));
            }
        });

        back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Email2.this, Info.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void GetData() {
        to1 = editTextto1.getText().toString();
        subject1 = editTextsubject1.getText().toString();
        message1 = editTextmessage1.getText().toString();
    }
}
