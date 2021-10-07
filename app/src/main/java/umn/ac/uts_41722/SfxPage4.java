package umn.ac.uts_41722;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SfxPage4 extends AppCompatActivity {
    Button playsfx;
    TextView namaSfx, descSfx;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sfx_page);
        descSfx=findViewById(R.id.sfxdesc);
        descSfx.setText("DarkSouls death SFX");
        namaSfx=(TextView)findViewById(R.id.sfxtext);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String nama = prefs.getString("nama", "");
        namaSfx.setText(nama);

        getSupportActionBar().setTitle(nama);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        playsfx = findViewById(R.id.sfxbtn);
        mp = MediaPlayer.create(this, R.raw.udied);
        playsfx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });


    }


    public boolean onOptionsItemSelected(MenuItem item){
        Intent back = new Intent(getApplicationContext(),SoundBoardActivity.class);
        startActivity(back);
        return true;
    }
}
