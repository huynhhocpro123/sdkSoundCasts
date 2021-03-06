package com.example.librarysdk.model.modelview.interactor;

import com.example.librarysdk.model.modelview.apimanager.APIManager;
import com.example.librarysdk.model.modelview.apimanager.ApiResponse;
import com.example.librarysdk.model.modelview.model.modeldata.DataVastModel;

/**
 * Created by NguyenTanHuynh on 7/30/2018.
 */

public class SoundCastInteractorImpl implements ISoundCastInteractor {

    ISoundCastInteractorListener interactorListener;

    public SoundCastInteractorImpl(ISoundCastInteractorListener interactorListener) {
        try {
            if (interactorListener != null) {
                this.interactorListener = interactorListener;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendGetURL(String URL) {
        APIManager.sendGet(URL, new ApiResponse() {
            @Override
            public void onSuccess(String result) {
                interactorListener.onSuccessSendGetURL(result);
            }

            @Override
            public void onError(String error) {
                interactorListener.onErrorSendGetURL(error);
            }
        });
    }

    @Override
    public void sendGetVastXML(String URL) {
        APIManager.sendGetVast(URL, new ApiResponse.ApiResponeModelVast() {
            @Override
            public void onSuccess(DataVastModel model) {
                interactorListener.onSuccessGetVastXML(model);
            }

            @Override
            public void onError(String s) {
                interactorListener.onErrorGetVastXML(s);
            }
        });
    }
}
