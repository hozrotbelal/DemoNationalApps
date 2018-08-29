package belal.brur.com.ApiUtilities;



/**
 * Created by Md. Hozrot Belal
 *
 * github : https://github.com/hozrotbelal
 */
public class UtilsApi {

    public static final String BASE_URL_API = "http://nationalappsbangladesh.com/";


    public static BaseApiService getOthersAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
