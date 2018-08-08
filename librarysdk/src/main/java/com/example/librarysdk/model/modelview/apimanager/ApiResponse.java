package com.example.librarysdk.model.modelview.apimanager;


import com.example.librarysdk.model.modelview.model.modeldata.DataVastModel;

/**
 * Created by NguyenTanHuynh on 7/18/2018.
 */

public interface ApiResponse<T> {
    void onSuccess(String result);

    void onError(String error);

    interface ApiResponeModelVast {
        void onSuccess(DataVastModel model);
        void onError(String s);
    }
}
