package xyz.aungpyaephyo.padc.myanmarattractions.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.data.persistence.AttractionsContract;
import xyz.aungpyaephyo.padc.myanmarattractions.data.persistence.UserContract;

/**
 * Created by Phyoe Khant on 7/15/2016.
 */
public class UserVO {

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("date_of_birth")
    private String date_of_birth;

    @SerializedName("country_of_origin")
    private String country_of_origin;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public String getCountry_of_origin() {
        return country_of_origin;
    }

    /**
    public static void saveAttractions(List<AttractionVO> attractionList) {
        Context context = MyanmarAttractionsApp.getContext();
        ContentValues[] attractionCVs = new ContentValues[attractionList.size()];
        for (int index = 0; index < attractionList.size(); index++) {
            AttractionVO attraction = attractionList.get(index);
            attractionCVs[index] = attraction.parseToContentValues();

            //Bulk insert into attraction_images.
            AttractionVO.saveAttractionImages(attraction.getTitle(), attraction.getImages());
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(AttractionsContract.AttractionEntry.CONTENT_URI, attractionCVs);

        Log.d(MyanmarAttractionsApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }
    /**/

    public static void saveUser(List<UserVO> user) {
        Context context = MyanmarAttractionsApp.getContext();
        ContentValues[] userCVs = new ContentValues[user.size()];
        for (int index = 0; index < user.size(); index++) {
            UserVO u = user.get(index);
            userCVs[index] = u.parseToContentValues();
        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(UserContract.UserEntry.CONTENT_URI, userCVs);

        Log.d(MyanmarAttractionsApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(UserContract.UserEntry.COLUMN_NAME, name);
        cv.put(UserContract.UserEntry.COLUMN_EMAIL, email);
        cv.put(UserContract.UserEntry.COLUMN_DOB, date_of_birth);
        cv.put(UserContract.UserEntry.COLUMN_COUNTRY, country_of_origin);
        return cv;
    }

    public static UserVO parseFromCursor(Cursor data) {
        UserVO user = new UserVO();
        user.name = data.getString(data.getColumnIndex(UserContract.UserEntry.COLUMN_NAME));
        user.email = data.getString(data.getColumnIndex(UserContract.UserEntry.COLUMN_EMAIL));
        user.date_of_birth = data.getString(data.getColumnIndex(UserContract.UserEntry.COLUMN_DOB));
        user.country_of_origin = data.getString(data.getColumnIndex(UserContract.UserEntry.COLUMN_COUNTRY));
        return user;
    }

}