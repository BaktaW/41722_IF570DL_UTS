package umn.ac.uts_41722;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnProfile, btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProfile= (Button) findViewById(R.id.btnProfile);
        btnLibrary= (Button) findViewById(R.id.btnLibrary);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoToProfile = new Intent(MainActivity.this, Profilepage.class);
                startActivity(GoToProfile);
            }
        });
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GoToUsernamePrompt = new Intent(MainActivity.this, Loginpage.class);
                startActivity(GoToUsernamePrompt);
            }
        });
    }
}