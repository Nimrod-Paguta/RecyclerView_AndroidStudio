package ocier.paguta.recycler;

import ocier.paguta.recycler.ProductModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("https://dummyjson.com/products/1")
    Call<ProductModel> fetchData(); // Modify YourResponseModel as per your API response
}
