package com.daredevil.landlordcommunication.camera;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;

import com.daredevil.landlordcommunication.R;
import com.daredevil.landlordcommunication.async.AsyncRunner;
import com.daredevil.landlordcommunication.models.dto.MessageDTO;
import com.daredevil.landlordcommunication.servieces.UserService;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;
import pl.aprilapps.easyphotopicker.EasyImage;


public class CameraActivity extends DaggerAppCompatActivity implements EasyImage.Callbacks {

    @BindView(R.id.image_view_camera)
    ImageView mPhoto;

    @Inject
    UserService mUserService;

    @Inject
    AsyncRunner mAsyncRunner;

    private int senderId;
    private int recipientId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        senderId = intent.getIntExtra("senderId", 0);
        recipientId = intent.getIntExtra("recipientId", 0);

        EasyImage.openCamera(this, EasyImage.REQ_SOURCE_CHOOSER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        EasyImage.handleActivityResult(requestCode, resultCode, data, this, this);
    }

    @Override
    public void onImagePickerError(Exception e, EasyImage.ImageSource source, int type) {

    }

    @Override
    public void onImagePicked(File imageFile, EasyImage.ImageSource source, int type) {
        String path = imageFile.getPath();
        Bitmap bitmap = BitmapFactory.decodeFile(path);
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth()/4, bitmap.getHeight()/4, true);
        mPhoto.setImageBitmap(bitmap1);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap1.compress(Bitmap.CompressFormat.JPEG, 25, stream);

        byte[] byteArray = stream.toByteArray();
        String imageString =  Base64.encodeToString(byteArray, Base64.DEFAULT);


        MessageDTO messageDTO = new MessageDTO(imageString, recipientId, senderId);

        new Thread(() -> {
            try {
                mUserService.sendImageMessage(messageDTO);
                finish();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void onCanceled(EasyImage.ImageSource source, int type) {

    }
}
