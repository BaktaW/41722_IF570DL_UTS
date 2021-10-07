package umn.ac.uts_41722;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Loginpage extends AppCompatActivity {
    public EditText Uname;
    private Button btnNext;
    String judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Uname = (EditText) findViewById(R.id.txtUsername);
        btnNext= (Button) findViewById(R.id.btnNext);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(Uname.getText().toString())) {
                        Uname.setError("Harap Di-isi");
                }
                else {
                    Intent GoToSoundboard = new Intent(Loginpage.this, SoundBoardActivity.class);
                    judul = Uname.getText().toString();
                    //menyimpan input user
                    SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(Loginpage.this);
                    SharedPreferences.Editor editor= prefs.edit();
                    editor.putString("judul", judul);
                    editor.commit();

                    startActivity(GoToSoundboard);
                }
            }
        });

    }
}

