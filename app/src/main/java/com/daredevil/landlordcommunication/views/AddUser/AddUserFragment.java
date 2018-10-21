package com.daredevil.landlordcommunication.views.AddUser;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.daredevil.landlordcommunication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddUserFragment extends Fragment {

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_user, container, false);

        Button mCreate = view.findViewById(R.id.create_id);
        Button mLogIn = view.findViewById(R.id.log_in_id);

        mCreate.setOnClickListener(item -> startActivity(new Intent(getActivity(), CreateUserActivity.class)));

        mLogIn.setOnClickListener(item -> startActivity(new Intent(getActivity(), CreateUserActivity.class)));

        return view;
    }
}
