package com.example.deepanshumeemroth.fit2blit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.password;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView loginTextView =(TextView) findViewById(R.id.login_text_view);
        ImageView imageFB = (ImageView)findViewById(R.id.fb_image);
        imageFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    getApplicationContext().getPackageManager().getPackageInfo("com.facebook.katana",0);
                    Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/pulkitkks"));
                    startActivity(i);
                }catch (Exception e){
                    Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("https://facebook.com/pulkitkks"));
                    startActivity(i);
                }
            }
        });
        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameTextView = (EditText)findViewById(R.id.username_edit_text);
                EditText passwordTextView = (EditText)findViewById(R.id.password_edit_text);
                String username = usernameTextView.getText().toString();
                String password = passwordTextView.getText().toString();
                if(username.length()!=0 && password.length()!=0) {
                    Intent i = new Intent(v.getContext(), Main5Activity.class);
                    Toast.makeText(getApplicationContext(),"You are successfully logged in",Toast.LENGTH_SHORT).show();
                    startActivity(i);
                }else if(username.length() == 0){
                    Toast.makeText(getApplicationContext(),"Username can't be empty",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Password can't be empty",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
