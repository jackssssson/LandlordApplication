package com.daredevil.landlordcommunication.views.tenant.unoccupiedestates;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Estates;
import com.daredevil.landlordcommunication.views.tenant.estate.TenantEstateActivity;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TenantUnOccupiedFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.tenant.unoccupiedestates.View, AdapterView.OnItemClickListener {

    @BindView(R.id.lv_unoccupied_estate)
    ListView mListView;

    ArrayAdapter<Estates> mAdapter;

    private Presenter presenter;
    private int userId;

    @Inject
    public TenantUnOccupiedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tenant_un_occupied, container, false);

        ButterKnife.bind(this, view);

        instantiateAdapter();

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        userId = intent.getIntExtra("id", 0);

        mListView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.loadAdapter();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showAdapter(List<Estates> estates) {
        runOnUi(() -> {
            mAdapter.clear();
            mListView.setAdapter(mAdapter);
            mAdapter.addAll(estates);
        });
    }

    private void runOnUi(Runnable action) {
        if(getActivity()==null)
            return;
        getActivity().runOnUiThread(action);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), TenantEstateActivity.class);
        intent.putExtra("estate", mAdapter.getItem(position));
        intent.putExtra("id", userId);
        startActivity(intent);
    }

    private void instantiateAdapter(){
        mAdapter = new ArrayAdapter<Estates>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1){
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = view.findViewById(android.R.id.text1);

                textView.setTextColor(Color.CYAN);

                return view;
            }
        };
    }
}
