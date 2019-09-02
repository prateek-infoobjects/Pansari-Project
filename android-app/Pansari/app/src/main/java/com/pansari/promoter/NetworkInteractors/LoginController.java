package com.pansari.promoter.NetworkInteractors;

import android.content.Context;
import android.util.Log;

import com.pansari.promoter.LoginActivity;
import com.pansari.promoter.R;
import com.pansari.promoter.models.LoginRequestModel;
import com.pansari.promoter.models.UserDataResponse;
import com.pansari.promoter.network.APIInterface;
import com.pansari.promoter.network.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginController {

    private Context mContext;
    APIInterface apiInterface;

    public LoginController(Context context) {
        mContext = context;
        Retrofit apiClient = ApiClient.getClient();
        apiInterface = apiClient.create(APIInterface.class);
    }

    public void login(String username, String password) {
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setUsername(username);
        loginRequestModel.setPassword(password);


        Call<UserDataResponse> call = apiInterface.userLogin(loginRequestModel);
        call.enqueue(new Callback<UserDataResponse>() {
            @Override
            public void onResponse(Call<UserDataResponse> call, Response<UserDataResponse> response) {
                Log.d("onresponse", response.toString());
                if (response.code() == 200 && response.body()!=null) {
                    ((LoginActivity) mContext).loginResponseSucess(response.body().getUserid(),response.body().getName());
                } else {
                    ((LoginActivity) mContext).loginResponseFailed(response.code(),
                            response.message());
                }
            }

            @Override
            public void onFailure(Call<UserDataResponse> call, Throwable t) {
                Log.d("onFailure", t.getLocalizedMessage());
                ((LoginActivity) mContext).loginResponseFailed(500,
                        mContext.getString(R.string.went_wrong));
            }
        });
    }
}
