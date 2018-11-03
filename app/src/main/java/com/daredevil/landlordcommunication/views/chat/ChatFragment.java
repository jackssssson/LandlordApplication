package com.daredevil.landlordcommunication.views.chat;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
        com.daredevil.landlordcommunication.views.chat.View {

    @BindView(R.id.chat_message)
    EditText mMessage;

    @BindView(R.id.btn_chat)
    Button mButtonChat;

    @BindView(R.id.lv_chat)
    ListView mListView;

    private Presenter presenter;
    private int senderId;
    private int recipientId;

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
        senderId = intent.getIntExtra("sender", 0);
        recipientId = intent.getIntExtra("recipient", 0);

        buttonSendChat();

        clickEnter();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getMessages(senderId, recipientId);
        presenter.refreshMessages();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.stopThread();
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

    @Override
    public void showNewElement(List<Messages> messages) {
        runOnUi(() -> mAdapter.addAll(messages));
    }

    @Override
    public void showSendMessage(Messages message) {
        runOnUi(() -> mAdapter.add(message));

    }

    private void runOnUi(Runnable action) {
        Objects.requireNonNull(getActivity()).runOnUiThread(action);
    }

    private void buttonSendChat() {
        mButtonChat.setOnClickListener(v -> {
            String message = mMessage.getText().toString();

            if (message.equals("")) {
                return;
            }

            presenter.sendMessage(message, senderId, recipientId);
            mMessage.getText().clear();
        });
    }

    private void clickEnter() {
        mMessage.setOnKeyListener((v, keyCode, event) -> {

            String message = mMessage.getText().toString();

            if (message.equals("")) {
                return false;
            }

            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // Perform action on key press

                presenter.sendMessage(message, senderId, recipientId);
                mMessage.getText().clear();

                return true;
            }
            return false;
        });


    }
}