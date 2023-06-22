package com.example.catatan_pengeluaran;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class detail extends AppCompatActivity {

    TextView tvNamaDetail, tvHpDetail, tvStatusDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvNamaDetail = findViewById(R.id.tvNamaDetail);
        tvHpDetail = findViewById(R.id.tvHpDetail);
        tvStatusDetail = findViewById(R.id.tvStatusDetail);

        ContactModel element = (ContactModel) getIntent().getSerializableExtra("ContactMode");
        tvNamaDetail.setText(element.getNama());
        tvHpDetail.setTextColor(Color.parseColor(element.getColor()));
        tvHpDetail.setText(element.getHp());
        tvStatusDetail.setText(element.getStatus());
    }
}