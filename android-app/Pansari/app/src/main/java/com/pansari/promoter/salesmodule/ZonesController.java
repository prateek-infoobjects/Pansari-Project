package com.pansari.promoter.salesmodule;

import android.util.Log;

import com.pansari.promoter.network.APIInterface;
import com.pansari.promoter.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ZonesController {

    private final APIInterface apiInterface;
    private PageOneView viewModel;

    public ZonesController(PageOneView view) {
        viewModel = view;
        Retrofit apiClient = ApiClient.getClient();
        apiInterface = apiClient.create(APIInterface.class);
    }


    public void getZones() {

        viewModel.showProgressDialog();
        Call<ArrayList<String>> call = apiInterface.getZones();
        call.enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                Log.d("onresponse", response.toString());
                viewModel.hideProgressDialog();
                if (response.code() == 200 && response.body() != null) {
                    viewModel.zonesRecieved(response.body());
                } else {
                    viewModel.onFailure();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {
                viewModel.hideProgressDialog();
                viewModel.onFailure();
            }
        });
    }
}
