package belal.brur.com.ApiUtilities;

import belal.brur.com.model.GetContentFileListResp;
import belal.brur.com.model.ParamAppUser;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Md. Hozrot Belal
 *
 * github : https://github.com/hozrotbelal
 */

public interface BaseApiService {

    @POST("mobsvc/ContentFile.php")
    Call<GetContentFileListResp> pContentFileListRequest(@Body ParamAppUser paramAppUser);

}
