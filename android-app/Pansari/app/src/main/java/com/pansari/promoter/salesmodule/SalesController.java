package com.pansari.promoter.salesmodule;

import android.util.Log;

import com.pansari.promoter.NetworkInteractors.CallbackWithRetry;
import com.pansari.promoter.models.SalesPostRequestObj;
import com.pansari.promoter.network.APIInterface;
import com.pansari.promoter.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SalesController {

    private final APIInterface apiInterface;
    private SalesViewModel viewModel;
    private static final int RETRY_COUNT = 3;

    public SalesController(SalesViewModel viewModel) {
        this.viewModel = viewModel;
        Retrofit apiClient = ApiClient.getClient();
        apiInterface = apiClient.create(APIInterface.class);
    }

    public void getStoresList(String zone) {

        viewModel.showProgressDialog();
        Call<List<StoresList>> call = apiInterface.getStoresListFromZone(zone);
        call.enqueue(new Callback<List<StoresList>>() {
            @Override
            public void onResponse(Call<List<StoresList>> call, Response<List<StoresList>> response) {
                Log.d("onresponse", response.toString());
//                viewModel.hideProgressDialog();
                if (response.code() == 200 && response.body() != null) {
                    viewModel.storeListSuccess(response.body());
                } else {
                    viewModel.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<StoresList>> call, Throwable t) {
//                viewModel.hideProgressDialog();
                viewModel.onFailure();
            }
        });
    }

    public void getSalesItmsList() {

        viewModel.showProgressDialog();
        Call<List<SalesItems>> call = apiInterface.getItemsList();
        call.enqueue(new Callback<List<SalesItems>>() {
            @Override
            public void onResponse(Call<List<SalesItems>> call, Response<List<SalesItems>> response) {
                Log.d("onresponse", response.toString());
                viewModel.hideProgressDialog();
                if (response.code() == 200 && response.body() != null) {
                    viewModel.itemsListReceived(response.body());
                } else {
                    viewModel.onFailure();
                }
            }

            @Override
            public void onFailure(Call<List<SalesItems>> call, Throwable t) {
                viewModel.hideProgressDialog();
                viewModel.onFailure();
            }
        });
    }

    public void postSalesData(SalesPostRequestObj requestObj) {

        viewModel.showProgressDialog();
        Call<SalesPostDataResponse> call = apiInterface.postSalesData(requestObj);
        call.enqueue(new CallbackWithRetry<SalesPostDataResponse>() {
            @Override
            public void afterThreeTries(String message) {
                viewModel.hideProgressDialog();
                viewModel.failedToPostData(message);
            }

            @Override
            public void onResponse(Call<SalesPostDataResponse> call, Response<SalesPostDataResponse> response) {
                Log.d("onresponse", response.toString());
                viewModel.hideProgressDialog();
                if (response.code() == 200 && response.body() != null) {
                    viewModel.salesDataPostedSuccessfuly("Sales record added successfully");
                } else {
                    viewModel.onFailure();
                }
            }

        });
//        call.enqueue(new Callback<SalesPostDataResponse>() {
//
//            @Override
//            public void onResponse(Call<SalesPostDataResponse> call, Response<SalesPostDataResponse> response) {
//                Log.d("onresponse", response.toString());
//                viewModel.hideProgressDialog();
//                if (response.code() == 200 && response.body() != null) {
//                    viewModel.salesDataPostedSuccessfuly("Sales record added successfully");
//                } else {
//                    viewModel.onFailure();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<SalesPostDataResponse> call, Throwable t) {
//                viewModel.hideProgressDialog();
//                viewModel.failedToPostData(t.getMessage());
//            }
//        });
    }

}
