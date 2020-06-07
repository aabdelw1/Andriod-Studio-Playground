package edu.gatech.seclass.sdpencryptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText message;
    private EditText keyNumber;
    private EditText incrementNumber;
    private EditText encryptedMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (EditText) findViewById(R.id.messageID);
        keyNumber = (EditText) findViewById(R.id.keyNumberID);
        incrementNumber = (EditText) findViewById(R.id.incrementNumberID);
        encryptedMessage = (EditText) findViewById(R.id.encryptedMessageID);

    }

    public void handleClick(View view) {
        if(view.getId() == R.id.encryptButtonID){
            String result;
            String messageValue = message.getText().toString();
            String keyValue = keyNumber.getText().toString();
            String incrementVal = incrementNumber.getText().toString();


        }
    }
}
