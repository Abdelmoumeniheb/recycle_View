package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewEtudaint;
    RecyclerView.LayoutManager layoutManager;
    EtudaintAdapter etudaintAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewEtudaint = findViewById(R.id.rcvetudaints);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewEtudaint.setLayoutManager(layoutManager);

        List<Etudaint> listeEtudaint = EtudaintContent.getEtudaints();
        Collections.sort(listeEtudaint);
        etudaintAdapter = new EtudaintAdapter(this,listeEtudaint);
        recyclerViewEtudaint.setAdapter(etudaintAdapter);
    }
}