package xyz.aungpyaephyo.padc.myanmarattractions.data.persistence;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;

/**
 * Created by Phyoe Khant on 7/15/2016.
 */
public class UserContract {

    public static final String CONTENT_AUTHORITY = MyanmarAttractionsApp.class.getPackage().getName();
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // content://xyz.aungpyaephyo.padc.myanmarattractions/

    public static final String PATH_USER = "user";

    public static final class UserEntry implements BaseColumns {
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_USER).build();
        // content://xyz.aungpyaephyo.padc.myanmarattractions/attractions

        public static final String DIR_TYPE = // There are many retrun types : Attraction Data Array : One-to-may
        ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;

        public static final String ITEM_TYPE = // There is only one retrun type : Attraction Data : One-to-one
        ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_USER;

        public static final String TABLE_NAME = "user";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_EMAIL = "email";
        public static final String COLUMN_DOB = "date_of_birth";
        public static final String COLUMN_COUNTRY = "country_of_origin";

        public static Uri buildAttractionUri(long id) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions/1
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Uri buildUserUriWithName(String userName) {
            //content://xyz.aungpyaephyo.padc.myanmarattractions/attractions?title="Yangon"
            return CONTENT_URI.buildUpon()
                    .appendQueryParameter(COLUMN_NAME, userName)
                    .build();
        }

        public static String getNameFromParam(Uri uri) {
            return uri.getQueryParameter(COLUMN_NAME);
        }
    }

}