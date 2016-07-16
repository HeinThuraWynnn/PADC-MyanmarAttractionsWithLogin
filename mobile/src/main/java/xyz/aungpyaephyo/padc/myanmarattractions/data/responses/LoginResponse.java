package xyz.aungpyaephyo.padc.myanmarattractions.data.responses;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.AttractionVO;
import xyz.aungpyaephyo.padc.myanmarattractions.data.vos.UserVO;

/**
 * Created by Phyoe Khant on 7/15/2016.
 */
public class LoginResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("login_user")
    private ArrayList<UserVO> user;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public ArrayList<UserVO> getUser() {
        return user;
    }
}