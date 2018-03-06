package com.giulliano.mercado.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.giulliano.mercado.model.Item;
import com.giulliano.mercado.repository.ItemRepository;

import java.util.List;

/**
 * Created by Giulliano on 06/03/2018.
 */

public class MainViewModel extends AndroidViewModel {

    private ItemRepository mRepository;

    private LiveData<List<Item>> mAllItens;

    public MainViewModel (Application application) {
        super(application);
        mRepository = new ItemRepository(application);
        mAllItens = mRepository.getAllItens();
    }

    LiveData<List<Item>> getAllWords() { return mAllItens; }

    public void insert(Item word) { mRepository.insert(word); }
}