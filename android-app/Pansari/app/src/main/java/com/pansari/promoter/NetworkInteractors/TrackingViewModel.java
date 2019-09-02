package com.pansari.promoter.NetworkInteractors;

import android.content.Context;

public interface TrackingViewModel {

    Context getActivityContext();

    void dataSentSuccessfuly();

    void errorInSendingData();
}
