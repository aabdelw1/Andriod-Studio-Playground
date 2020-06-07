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

            if (checkMessage(messageValue)) message.setError("Invalid Message");
            if (checkRange(keyValue)) keyNumber.setError("Invalid Key Number");
            if (checkRange(incrementVal)) incrementNumber.setError("Invalid Increment Number");


            if(!keyValue.trim().equals("") && !incrementVal.trim().equals("")) {
                result = cipher(messageValue, keyValue, incrementVal);
                encryptedMessage.setText(result);
            }

        }
    }

    public static boolean checkMessage(String messageValue){
        if(messageValue.trim().equals("") || !(messageValue.trim().matches(".*[a-zA-Z]+.*")))
            return true;
        return false;
    }

    public static boolean checkRange(String keyValue){
        if(keyValue.trim().equals(""))
            return true;
        if(Integer.parseInt(keyValue.trim()) < 1 || Integer.parseInt(keyValue.trim()) > 25 )
            return true;
        return false;
    }

    private static String cipher(String message, String key, String increment) {

        String newString = "";
        int track = 0;

        for (int i = 0; i < message.length(); i++) {
            char letter = message.charAt(i);
            int shift = (Integer.parseInt(key) + (Integer.parseInt(increment) * track)) % 26;

            if (letter >= 'a' && letter <= 'z') {
                letter = (char) (letter + shift);
                if (letter > 'z') {
                    letter = (char) (letter + 'a' - 'z' - 1);
                }
                newString = newString + letter;
                track++;
            } else if (letter >= 'A' && letter <= 'Z') {
                letter = (char) (letter + shift);

                if (letter > 'Z') {
                    letter = (char) (letter + 'A' - 'Z' - 1);
                }
                newString = newString + letter;
                track++;
            } else {
                newString = newString + letter;
            }
        }

        StringBuilder lowtoUpp = new StringBuilder(newString);
        for (int i = 0; i < newString.length(); i++) {
            if (Character.isLowerCase(newString.charAt(i))) {
                lowtoUpp.setCharAt(i, Character.toUpperCase(newString.charAt(i)));
            } else if (Character.isUpperCase(newString.charAt(i))) {
                lowtoUpp.setCharAt(i, Character.toLowerCase(newString.charAt(i)));
            }
        }

        return lowtoUpp.toString();
    }
}