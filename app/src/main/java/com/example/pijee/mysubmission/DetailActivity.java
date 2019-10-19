package com.example.pijee.mysubmission;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pijee.mysubmission.model.Anggota;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ANGGOTA = "extra_anggota";

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvNama, tvOverview;
        ImageView ivGambar;

        tvNama = findViewById(R.id.tvNama);
        tvOverview = findViewById(R.id.tvOverview);
        ivGambar = findViewById(R.id.ivPicture);

        Anggota anggota = getIntent().getParcelableExtra(EXTRA_ANGGOTA);
        setTitle(anggota.getNama());

        tvNama.setText(anggota.getNama());
        tvOverview.setText(anggota.getBiodata());
        ivGambar.setImageResource(anggota.getPicture());

    }
}