package com.example.whereaboutsv5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onGetNameClick(View view) {
        Intent getNameScreenIntent = new Intent(this,
                SecondScreen.class);
        final int result = 1;

        getNameScreenIntent.putExtra("callingActivity","MainActivity");
        startActivityForResult(getNameScreenIntent, result);
//        startActivity(getNameScreenIntent);//Use this if you're not expecting a response from next screen

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView usersNameMessage = (TextView)
                findViewById(R.id.users_name_message);

        String nameSentBack = data.getStringExtra("UsersName");

        usersNameMessage.append(" " + nameSentBack);
    }
}
