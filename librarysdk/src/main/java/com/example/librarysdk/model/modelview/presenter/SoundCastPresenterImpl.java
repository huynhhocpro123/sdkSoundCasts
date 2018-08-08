package com.example.librarysdk.model.modelview.presenter;


import com.example.librarysdk.model.modelview.interactor.ISoundCastInteractor;
import com.example.librarysdk.model.modelview.interactor.ISoundCastInteractorListener;
import com.example.librarysdk.model.modelview.interactor.SoundCastInteractorImpl;
import com.example.librarysdk.model.modelview.model.modeldata.DataVastModel;
import com.example.librarysdk.model.modelview.view.ISourdCastViewListener;

/**
 * Created by NguyenTanHuynh on 7/30/2018.
 */

public class SoundCastPresenterImpl implements ISoundCastPresenter, ISoundCastInteractorListener {

    ISourdCastViewListener viewListener;
    ISoundCastInteractor interactor;

    public SoundCastPresenterImpl(ISourdCastViewListener viewListener) {
        try {
            if (viewListener != null) {
                this.viewListener = viewListener;
                interactor = new SoundCastInteractorImpl(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void sendGetURL(String URL) {
        viewListener.showProgress();
        interactor.sendGetURL(URL);
    }

    @Override
    public void sendGetVastXML(String url) {
        viewListener.showProgress();
        interactor.sendGetVastXML(url);
    }

    @Override
    public void onDestroy() {
        interactor = null;
        viewListener = null;
    }

    @Override
    public void onSuccessSendGetURL(String object) {
        viewListener.hideProgress();
        viewListener.onSuccessSendGetURL(object);
    }

    @Override
    public void onErrorSendGetURL(String object) {
        viewListener.hideProgress();
        viewListener.onErrorSendGetURL(object);
    }

    @Override
    public void onSuccessGetVastXML(DataVastModel object) {
        viewListener.hideProgress();
        viewListener.onSuccessGetVastXML(object);
    }

    @Override
    public void onErrorGetVastXML(String object) {
        viewListener.hideProgress();
        viewListener.onErrorGetVastXML(object);
    }
}
