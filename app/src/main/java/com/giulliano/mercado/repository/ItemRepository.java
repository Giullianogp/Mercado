package com.giulliano.mercado.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import com.giulliano.mercado.data.ItemDao;
import com.giulliano.mercado.data.MercadoDatabase;
import com.giulliano.mercado.model.Item;
import java.util.List;

/**
 * Created by giull on 02/03/2018.
 */

public class ItemRepository {

  private ItemDao itemDao;
  private LiveData<List<Item>> allItens;

  ItemRepository(Application application) {
    MercadoDatabase db = MercadoDatabase.getDatabase(application);
    itemDao = db.itemDao();
    allItens = itemDao.getItens();
  }

  LiveData<List<Item>> getAllWords() {
    return allItens;
  }


  public void insert (Item item) {
    new insertAsyncTask(itemDao).execute(item);
  }

  private static class insertAsyncTask extends AsyncTask<Item, Void, Void> {

    private ItemDao mAsyncTaskDao;

    insertAsyncTask(ItemDao dao) {
      mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Item... params) {
      mAsyncTaskDao.insert(params[0]);
      return null;
    }
  }
}
