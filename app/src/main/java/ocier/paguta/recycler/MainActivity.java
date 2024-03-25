package ocier.paguta.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.toolbox.JsonObjectRequest;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    private ProductModel responseData;
    private JsonObjectRequest request;
    JSONArray jsonArray;

    ArrayList<AminoAcidModel> aminoAcidModels = new ArrayList<>();
    private AA_RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);

        setUpAminoAcidModels();

        adapter = new AA_RecyclerViewAdapter(this,
                aminoAcidModels, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setUpAminoAcidModels(){
        String url = "https://dummyjson.com/products";
        request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            jsonArray = response.getJSONArray("products");

                            for(int i = 0; i < jsonArray.length(); i++){
                                JSONObject product = jsonArray.getJSONObject(i);

                                int id = product.getInt("id");
                                String title = product.getString("title");
                                String description = product.getString("description");
                                int price = product.getInt("price");
                                double discount = product.getDouble("discountPercentage"); // Assuming discount is a double
                                double rating = product.getDouble("rating"); // Assuming rating is a double
                                int stock = product.getInt("stock");
                                String brand = product.getString("brand");
                                String category = product.getString("category");
                                String thumbnail = product.getString("thumbnail");

                                // Retrieve the "images" array
                                JSONArray imagesArray = product.getJSONArray("images");

                                // Create a list to hold image URLs
                                List<String> imagesList = new ArrayList<>();

                                // Extract individual image URLs from the array
                                for (int j = 0; j < imagesArray.length(); j++) {
                                    String imageUrl = imagesArray.getString(j);
                                    imagesList.add(imageUrl);
                                }

                                // Assuming you have proper data to fill in the AminoAcidModel constructor
                                aminoAcidModels.add(new AminoAcidModel(
                                        "Product ID: #" + String.valueOf(id),
                                        title,
                                        description,
                                        String.valueOf(price),
                                        String.valueOf(discount),
                                        String.valueOf(rating),
                                        String.valueOf(stock),
                                        brand,
                                        category,
                                        thumbnail,
                                        imagesList
                                        // Add other parameters as needed
                                ));
                            }

                            // After populating the list, you need to notify the adapter about the changes
                            adapter.notifyDataSetChanged();

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        // Add the request to the RequestQueue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    @Override
    public void onItemClick(int position) {
//        AminoAcidModel clickedAminoAcid = responseData.getAminoAcidModels().get(0);
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        List<String> imagesList = aminoAcidModels.get(position).getImages();

        String[] imagesArray = new String[imagesList.size()];
        imagesArray = imagesList.toArray(imagesArray);

        intent.putExtra("images", imagesArray);
        intent.putExtra("title", aminoAcidModels.get(position).getTitle());
        intent.putExtra("id", aminoAcidModels.get(position).getId());
        intent.putExtra("description", aminoAcidModels.get(position).getDescription());
        intent.putExtra("price", aminoAcidModels.get(position).getPrice());
        intent.putExtra("discountPercentage", aminoAcidModels.get(position).getDiscountPercentage());
        intent.putExtra("rating", aminoAcidModels.get(position).getRating());
        intent.putExtra("stock", aminoAcidModels.get(position).getStock());
        intent.putExtra("brand", aminoAcidModels.get(position).getBrand());
        intent.putExtra("category", aminoAcidModels.get(position).getCategory());

        startActivity(intent);





    }
}