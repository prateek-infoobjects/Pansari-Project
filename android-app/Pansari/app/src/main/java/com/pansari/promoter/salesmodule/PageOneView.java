package com.pansari.promoter.salesmodule;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public interface PageOneView {

    Context getActivityContext();

    void zonesRecieved(ArrayList<String> body);

    void onFailure();

    void showProgressDialog();

    void hideProgressDialog();
}
