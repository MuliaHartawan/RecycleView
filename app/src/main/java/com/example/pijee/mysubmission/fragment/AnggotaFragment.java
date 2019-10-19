package com.example.pijee.mysubmission.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pijee.mysubmission.R;
import com.example.pijee.mysubmission.adapter.AnggotaAdapter;
import com.example.pijee.mysubmission.model.Anggota;

import java.util.ArrayList;

public class AnggotaFragment extends Fragment {
    private String[] nama, biodata;
    private TypedArray picture;
    private AnggotaAdapter anggotaAdapter;
    private RecyclerView rvAnggota;
    private ArrayList<Anggota> listAnggota = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_anggota,container,false);

        anggotaAdapter = new AnggotaAdapter(getContext());
        rvAnggota = view.findViewById(R.id.rvAnggota);
        rvAnggota.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAnggota.setAdapter(anggotaAdapter);

        addItem();

        return view;
    }

    private void addItem() {
        nama = getResources().getStringArray(R.array.anggota_nama);
        biodata = getResources().getStringArray(R.array.anggota_biodata);
        picture = getResources().obtainTypedArray(R.array.anggota_picture);
        listAnggota = new ArrayList<>();

        for (int i = 0; i < nama.length; i++){
            Anggota anggota = new Anggota();
            anggota.setNama(nama[i]);
            anggota.setBiodata(biodata[i]);
            anggota.setPicture(picture.getResourceId(i, -1 ));
            listAnggota.add(anggota);

        }
        anggotaAdapter.setListClub(listAnggota);
    }

}