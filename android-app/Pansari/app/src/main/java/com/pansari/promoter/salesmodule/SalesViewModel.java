package com.pansari.promoter.salesmodule;

import android.content.Context;

import java.util.List;

public interface SalesViewModel {

    Context getActivityContext();

    void storeListSuccess(List<StoresList> body);

    void onFailure();

    void itemsListReceived(List<SalesItems> body);

    void showProgressDialog();

    void hideProgressDialog();

    void salesDataPostedSuccessfuly(String message);

    void failedToPostData(String message);

}
