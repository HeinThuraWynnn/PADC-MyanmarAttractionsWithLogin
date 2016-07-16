package xyz.aungpyaephyo.padc.myanmarattractions.data.models;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.AttractionDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.HttpUrlConnectionDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.OkHttpDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.UserDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit.RetrofitDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;
import xyz.aungpyaephyo.padc.myanmarattractions.events.DataEvent;

/**
 * Created by Phyoe Khant on 7/15/2016.
 */
public class UserModel {

    public static final String BROADCAST_DATA_LOADED = "BROADCAST_DATA_LOADED";

    private static final int INIT_DATA_AGENT_OFFLINE = 1;
    private static final int INIT_DATA_AGENT_HTTP_URL_CONNECTION = 2;
    private static final int INIT_DATA_AGENT_OK_HTTP = 3;
    private static final int INIT_DATA_AGENT_RETROFIT = 4;

    private static UserModel objInstance;

    private List<UserVO> mUser;

    private UserDataAgent dataAgent;

    private UserModel() {
        mUser = new ArrayList<>();
        initDataAgent(INIT_DATA_AGENT_RETROFIT);
        dataAgent.loadUser();
    }

    public static UserModel getInstance() {
        if (objInstance == null) {
            objInstance = new UserModel();
        }
        return objInstance;
    }

    private void initDataAgent(int initType) {
        switch (initType) {
            case INIT_DATA_AGENT_OFFLINE:
                //dataAgent = OfflineDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_HTTP_URL_CONNECTION:
                //dataAgent = HttpUrlConnectionDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_OK_HTTP:
                //dataAgent = OkHttpDataAgent.getInstance();
                break;
            case INIT_DATA_AGENT_RETROFIT:
                dataAgent = RetrofitDataAgent.getInstance();
                break;
        }
    }

    public List<UserVO> getUser() {
        return mUser;
    }

    public UserVO getUserByName(String userName) {
        for (UserVO user : mUser) {
            if (user.getName().equals(userName))
                return user;
        }

        return null;
    }

    public void notifyUserLoaded(List<UserVO> user) {
        //Notify that the data is ready - using LocalBroadcast
        mUser = user;

        //keep the data in persistent layer.
        UserVO.saveUser(mUser);

        //compile 'de.greenrobot:eventbus:2.4.0'
        broadcastUserLoadedWithEventBus();

        //INIT_DATA_AGENT_HTTP_URL_CONNECTION
        //INIT_DATA_AGENT_OK_HTTP
        //INIT_DATA_AGENT_RETROFIT
        //broadcastAttractionLoadedWithLocalBroadcastManager();
    }

    public void notifyErrorInLoadingUser(String message) {

    }

    private void broadcastUserLoadedWithEventBus() {
        EventBus.getDefault().post(new DataEvent.UserDataLoadedEvent("extra-in-broadcast", mUser));
    }
}