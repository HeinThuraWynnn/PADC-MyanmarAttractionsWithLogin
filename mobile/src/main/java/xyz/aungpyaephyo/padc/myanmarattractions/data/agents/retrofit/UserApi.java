package xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.AttractionListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.LoginResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

/**
 * Created by Phyoe Khant on 7/15/2016.
 */
public interface UserApi {

    @FormUrlEncoded
    @POST(MyanmarAttractionsConstants.API_GET_USER_LOGIN)
    Call<LoginResponse> loadLogin(
            @Field(MyanmarAttractionsConstants.PARAM_ACCESS_TOKEN) String param);
}