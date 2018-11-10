package com.daredevil.landlordcommunication.views.chat;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.camera.CameraActivity;
import com.daredevil.landlordcommunication.models.Messages;
import com.daredevil.landlordcommunication.views.chat.picture.PictureChatActivity;

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

    @BindView(R.id.btn_send_image)
    Button mButtonPhoto;

    @BindView(R.id.lv_chat)
    ListView mListView;

    @BindView(R.id.id_picture)
    ImageView mPicture;

    @BindView(R.id.ll_chat)
    LinearLayout mLinearLayout;

    @BindView(R.id.pb_chat)
    ProgressBar mProgressBar;



    private Presenter presenter;
    private int senderId;
    private int recipientId;
    private Messages messageForPicture;

    private ArrayAdapter<Messages> mAdapter;

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

        instantiateAdapter();

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        senderId = intent.getIntExtra("sender", 0);
        recipientId = intent.getIntExtra("recipient", 0);

        buttonSendChat();

        clickEnter();

        mPicture.setOnClickListener(p->{
            Intent intent5=new Intent(getActivity(), PictureChatActivity.class);
            intent5.putExtra("bm", messageForPicture);
            startActivity(intent5);
        });

        mButtonPhoto.setOnClickListener(v -> {
            Intent intent1 = new Intent(getActivity(), CameraActivity.class);
            intent1.putExtra("senderId", senderId);
            intent1.putExtra("recipientId", recipientId);

            startActivity(intent1);


        });

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
            mAdapter.clear();
            mListView.setAdapter(mAdapter);

            for (int i = messages.size() - 1; i >= 0; i--) {
                if (messages.get(i).getImageMessage() != null) {
                    testMethod(messages.get(i));
                    break;
                }
            }

            for (Messages m : messages) {
                if (m.getImageMessage() != null) {
                    continue;
                }

                mAdapter.add(m);
            }
            hideLoading();
            mListView.smoothScrollToPosition(messages.size());
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

            message.replaceAll(System.getProperty("line.separator"), "\\n");
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

                presenter.sendMessage(message.replaceAll(System.getProperty("line.separator"), "\\n"), senderId, recipientId);
                mMessage.getText().clear();

                return true;
            }
            return false;
        });
    }

    private void testMethod(Messages m) {
        this.messageForPicture=m;
        byte[] bytes = Base64.decode(m.getImageMessage(), Base64.DEFAULT);

        Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,
                0, bytes.length);

        mPicture.setImageBitmap(bitmap);
    }

    private void instantiateAdapter() {
        mAdapter = new ArrayAdapter<Messages>(Objects.requireNonNull(getContext()),
                android.R.layout.simple_list_item_1) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                Messages messages = getItem(position);

                assert messages != null;
                if (messages.getSender().getUserid() == senderId){
                    TextView textView = view.findViewById(android.R.id.text1);

                    textView.setTextColor(Color.CYAN);
                } else {
                    TextView textView = view.findViewById(android.R.id.text1);

                    textView.setTextColor(Color.GREEN);
                }

                return view;
            }
        };
    }

    @Override
    public void showLoading(){
        runOnUi(()->{
            mProgressBar.setVisibility(View.VISIBLE);
            mLinearLayout.setVisibility(View.GONE);
        });
    }

    @Override
    public void hideLoading(){
        runOnUi(()->{
            mProgressBar.setVisibility(View.GONE);
            mLinearLayout.setVisibility(View.VISIBLE);
        });
    }
}