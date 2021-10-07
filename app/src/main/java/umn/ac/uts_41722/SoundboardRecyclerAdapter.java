package umn.ac.uts_41722;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SoundboardRecyclerAdapter extends RecyclerView.Adapter<SoundboardRecyclerAdapter.SoundboardViewHolder> {

    private ArrayList<SoundObject> soundObjects;
    private Context context;
    ImageButton delete;
    String nama;


    public SoundboardRecyclerAdapter(ArrayList<SoundObject> soundObjects) {
        this.soundObjects = soundObjects;

    }



    @NonNull
    @Override
    public SoundboardViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.sound_item, null);
        context = parent.getContext();
        return new SoundboardViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull SoundboardViewHolder holder, int position) {

        final SoundObject object = soundObjects.get(position);

        holder.itemTextView.setText(object.getItemName());


    }

    @Override
    public int getItemCount() { return soundObjects.size(); }

    public class SoundboardViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        TextView itemTextView;

        public SoundboardViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = (TextView) itemView.findViewById(R.id.textViewitem);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            nama = itemTextView.getText().toString();
            SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(context);
            SharedPreferences.Editor editor= prefs.edit();
            editor.putString("nama", nama);
            editor.commit();

            Intent GoToSFX;
            switch (getAdapterPosition()){

                case 0:
                    GoToSFX = new Intent(context,SfxPage.class);
                    break;

                case 1:
                    GoToSFX = new Intent(context,SfxPage1.class);
                    break;

                case 2:
                    GoToSFX = new Intent(context,SfxPage2.class);
                    break;

                case 3:
                    GoToSFX = new Intent(context,SfxPage3.class);
                    break;

                case 4:
                    GoToSFX = new Intent(context,SfxPage4.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + getAdapterPosition());
            }

           context.startActivity(GoToSFX);
        }


    }
}
