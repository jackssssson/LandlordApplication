package com.daredevil.landlordcommunication.views.images;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.daredevil.landlordcommunication.R;

import java.util.ArrayList;

public class CustomListView extends ArrayAdapter<String> {

    private ArrayList<String> messages;
    private Activity context;

    CustomListView(Activity context, ArrayList<String> messages) {
        super(context, R.layout.images_layout, messages);

        this.context = context;
        this.messages = messages;
    }

    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r = convertView;

        ViewHolder viewHolder;

        if (r == null) {
            LayoutInflater layoutInflater = context.getLayoutInflater();
            r = layoutInflater.inflate(R.layout.images_layout, null, true);
            viewHolder = new ViewHolder(r);
            r.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) r.getTag();
        }


        for (String image : messages) {
            byte[] bytes = Base64.decode(image, Base64.DEFAULT);

            Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,
                    0, bytes.length);

            viewHolder.imageView.setImageBitmap(bitmap);
            viewHolder.imageView.setImageResource(position);
        }


        return super.getView(position, convertView, parent);
    }

    class ViewHolder {
        ImageView imageView;

        ViewHolder(View v) {
            imageView = v.findViewById(R.id.image_image_view);
        }
    }
}
