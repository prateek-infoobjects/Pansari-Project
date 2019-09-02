package com.pansari.promoter.NetworkInteractors;

import android.content.Context;
import android.util.Log;

import com.pansari.promoter.data.PrefManager;
import com.pansari.promoter.models.UserTrackingData;
import com.pansari.promoter.network.APIInterface;
import com.pansari.promoter.network.ApiClient;
import com.pansari.promoter.utils.AppUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class TrackingDataController {

    private final PrefManager prefManager;
    private Context mContext;
    APIInterface apiInterface;
    private TrackingViewModel viewModel;

    public TrackingDataController(TrackingViewModel context) {
        mContext = context.getActivityContext();
        viewModel=context;
        Retrofit apiClient = ApiClient.getClient();
        apiInterface = apiClient.create(APIInterface.class);
        prefManager = new PrefManager(mContext);
    }

    public void trackLocation(double latitude, double longitude) {
        if(!AppUtils.isValid(prefManager.getUserId())){
            return;
        }
        UserTrackingData trackingData = new UserTrackingData();
        trackingData.setLatitude(latitude);
        trackingData.setLongitude(longitude);
        trackingData.setUserid(Long.parseLong(prefManager.getUserId()));
        trackingData.setTimestamp(System.currentTimeMillis());

        Call<String> call = apiInterface.sendUserLocation(trackingData);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d("onresponse", response.toString());
                if (response.code() == 200 && response.body() != null) {
                    viewModel.dataSentSuccessfuly();
                } else {
                    viewModel.errorInSendingData();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d("onFailure", t.getLocalizedMessage());
                viewModel.errorInSendingData();
            }
        });
    }
}
