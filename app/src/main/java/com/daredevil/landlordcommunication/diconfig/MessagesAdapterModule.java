package com.daredevil.landlordcommunication.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.daredevil.landlordcommunication.models.Messages;

import dagger.Module;
import dagger.Provides;

@Module
public class MessagesAdapterModule {
    @Provides
    public ArrayAdapter<Messages> adapter(Context context){
        return new ArrayAdapter<>(context,
                android.R.layout.simple_list_item_1);
    }
}
