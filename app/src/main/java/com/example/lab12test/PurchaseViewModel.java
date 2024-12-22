package com.example.lab12test;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;



import java.util.List;

public class PurchaseViewModel extends ViewModel {
    private final PurchaseDao purchaseDao;

    public PurchaseViewModel() {
        purchaseDao = App.getInstance().getDatabase().purchaseDao();
    }

    public LiveData<Purchase> getPurchaseById(long purchaseId) {
        return purchaseDao.getById(purchaseId);
    }


}