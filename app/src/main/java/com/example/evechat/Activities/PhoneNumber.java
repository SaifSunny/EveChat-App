package com.example.evechat.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.evechat.databinding.ActivityPhoneNumberBinding;
import com.google.firebase.auth.FirebaseAuth;

public class PhoneNumber extends AppCompatActivity {

    ActivityPhoneNumberBinding binding;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneNumberBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        getSupportActionBar().hide();
        auth = FirebaseAuth.getInstance();
        if(auth.getCurrentUser() != null) {
            Intent intent = new Intent(PhoneNumber.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        binding.continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PhoneNumber.this, OTPActivity.class);
                intent.putExtra("phoneNumber",binding.phonebox.getText().toString());
                startActivity(intent);
            }
        });
    }
}
