package com.pansari.promoter.network;

import com.pansari.promoter.models.LoginRequestModel;
import com.pansari.promoter.models.SalesPostRequestObj;
import com.pansari.promoter.models.UserDataResponse;
import com.pansari.promoter.models.UserTrackingData;
import com.pansari.promoter.salesmodule.SalesItems;
import com.pansari.promoter.salesmodule.SalesPostDataResponse;
import com.pansari.promoter.salesmodule.StoresList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {

    @POST("/login")
    Call<UserDataResponse> userLogin(@Body LoginRequestModel user);

    @POST("/realtime/location")
    Call<String> sendUserLocation(@Body UserTrackingData data);

    @Headers("Content-Type: application/json")
    @GET("/stores/listbyzone")
    Call<List<StoresList>> getStoresListFromZone(@Query("zone") String zone);

    @Headers("Content-Type: application/json")
    @GET("/items/list")
    Call<List<SalesItems>> getItemsList();

    @Headers("Content-Type: application/json")
    @GET("/stores/getzones")
    Call<ArrayList<String>> getZones();

    @Headers("Content-Type: application/json")
    @POST("/sale")
    Call<SalesPostDataResponse> postSalesData(@Body SalesPostRequestObj requestObj);

}
