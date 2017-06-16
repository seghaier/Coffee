package com.example.formation.coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    public static String Extra_Message= "com.exemple.formation.MESSAGE";
    EditText pseudo;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pseudo = (EditText) findViewById(R.id.pseudo);



        Button sendButton = (Button) findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                message = pseudo.getText().toString();
                if (pseudo.length()>3){
                    Intent sendIntent = new Intent(MainActivity.this,OrderActivity.class);
                    sendIntent.putExtra(Extra_Message, message);

                    startActivity(sendIntent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Minimum 3 caractères  ! ", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

}
