package com.daredevil.landlordcommunication.diconfig;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.daredevil.landlordcommunication.models.Estates;

import java.util.Objects;

import dagger.Module;
import dagger.Provides;

@Module
public class EstateAdapterModule {
    @Provides
    public ArrayAdapter<Estates> adapter(Context context){
        return new  ArrayAdapter<>(Objects.requireNonNull(context),
                android.R.layout.simple_list_item_1);
    }
}
