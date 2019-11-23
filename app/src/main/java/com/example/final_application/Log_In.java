package com.example.final_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Log_In extends AppCompatActivity  implements View.OnClickListener {
    @BindView(R.id.passwordLoginButton)  Button mLogInButton;
    @BindView(R.id.emailEditText) EditText mUserName;
    @BindView(R.id.registerTextView) TextView mSignUpPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);
        ButterKnife.bind(this);


        mLogInButton.setOnClickListener(this);
        mSignUpPage.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        if(v == mLogInButton) {
            String userName = mUserName.getText().toString();
            Toast.makeText(Log_In.this, "welcome "+userName , Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else if (v == mSignUpPage){
            Intent intent = new Intent(this,Sign_Up.class);
            startActivity(intent);
        }else{
            Toast.makeText(Log_In.this, "kindly click a button", Toast.LENGTH_LONG);
        }

    }


}
