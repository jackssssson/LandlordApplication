package com.daredevil.landlordcommunication.views.chat;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.models.Messages;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment implements
        com.daredevil.landlordcommunication.views.chat.View{

    @BindView(R.id.chat_message)
    EditText mMessage;

    @BindView(R.id.btn_chat)
    Button mButtonChat;

    @BindView(R.id.lv_chat)
    ListView mListView;

    private Presenter presenter;
    private int tenantId;
    private int landlordId;

    @Inject
    ArrayAdapter<Messages> mAdapter;

    @Inject
    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        ButterKnife.bind(this, view);

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        tenantId = intent.getIntExtra("tenant", 0);
        landlordId = intent.getIntExtra("landlord", 0);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getMessages(tenantId, landlordId);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showAdapter(List<Messages> messages) {
        runOnUi(() -> {
            mListView.setAdapter(mAdapter);

            mAdapter.addAll(messages);
        });
    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }
}
