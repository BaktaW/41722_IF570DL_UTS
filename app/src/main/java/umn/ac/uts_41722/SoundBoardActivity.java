package umn.ac.uts_41722;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundBoardActivity extends AppCompatActivity {


    ImageButton delete;
    ArrayList<SoundObject> soundList = new ArrayList<>();
    RecyclerView SoundView;
    SoundboardRecyclerAdapter SoundAdapter = new SoundboardRecyclerAdapter(soundList);
    RecyclerView.LayoutManager SoundLayoutManager;

    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soundboard);

        //menjadikan input user sebagai judul actionbar
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String judul = prefs.getString("judul", "");
        getSupportActionBar().setTitle(judul);
        Toast.makeText(this, "Selamat Datang, " +judul, Toast.LENGTH_SHORT).show();
        List<String> nameList = Arrays.asList(getResources().getStringArray(R.array.soundNames));

        SoundObject[] soundItems = new SoundObject[]{
                new SoundObject(nameList.get(0), R.raw.ayaya), new SoundObject(nameList.get(1), R.raw.monsterkill),
                new SoundObject(nameList.get(2), R.raw.phub),new SoundObject(nameList.get(3), R.raw.sixconsoles),
                new SoundObject(nameList.get(4), R.raw.udied)};

        soundList.addAll(Arrays.asList(soundItems));
        SoundView = (RecyclerView) findViewById(R.id.soundboardRecyclerView);
        SoundLayoutManager = new GridLayoutManager(this, 1);
        SoundView.setLayoutManager(SoundLayoutManager);
        SoundView.setAdapter(SoundAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        SoundView.addItemDecoration(dividerItemDecoration);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        // Check which menu action user choose
        switch (id) {
            case R.id.menuProfile:
                Intent goToProfile = new Intent(SoundBoardActivity.this, Profilepage.class);
                startActivity(goToProfile);
                break;
            case R.id.menuKeluar:
                Intent goToMainMenu = new Intent(SoundBoardActivity.this, MainActivity.class);
                finish();
                startActivity(goToMainMenu);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
