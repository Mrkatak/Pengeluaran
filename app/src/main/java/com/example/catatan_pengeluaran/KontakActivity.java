package com.example.catatan_pengeluaran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class KontakActivity extends AppCompatActivity {

    List<ContactModel> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        addData();
    }

    private void addData() {
        elements = new ArrayList<>();
        elements.add(new ContactModel("Zein", "0852278890", "Available", "#FF3700B3"));
        elements.add(new ContactModel("Supri", "0852278890", "Not Available", "#FF3700B3"));
        elements.add(new ContactModel("Bimo", "0852278890", "Not Available", "#FF3700B3"));
        elements.add(new ContactModel("Agung", "0852278890", "Available", "#FF3700B3"));
        elements.add(new ContactModel("Ucup", "0852278890", "Not Available", "#FF3700B3"));

        ContactAdapter adapter = new ContactAdapter(elements, this, new ContactAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(ContactModel item) {

                detail(item);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rvContact);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void detail(ContactModel item){
        Intent intent = new Intent(KontakActivity.this, detail.class);
        intent.putExtra("ContactMode", item);
        startActivity(intent);
    }
}