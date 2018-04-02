package cotemig.hiago.exercicio4;

import cotemig.hiago.exercicio4.RetrofitClient;
import retrofit2.Retrofit;

/**
 * Created by hiago on 21/06/2017.
 */

public class ApiUtils {

    private ApiUtils() {}

    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";

    public static APIService getAPIService() {
        return RetrofititClientClient.getClient(BASE_URL).create(APIService.class);
    }
}
