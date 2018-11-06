package com.daredevil.landlordcommunication.views.images;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.daredevil.landlordcommunication.R;

import java.util.ArrayList;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ImagesFragment extends Fragment {

    @BindView(R.id.lv_images)
    ListView mListView;

    @Inject
    public ImagesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_images, container, false);

        ButterKnife.bind(this, view);

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        ArrayList<String> mMessages = intent.getStringArrayListExtra("images");

        CustomListView listView = new CustomListView(getActivity(), mMessages);
        mListView.setAdapter(listView);

        return view;
    }

}