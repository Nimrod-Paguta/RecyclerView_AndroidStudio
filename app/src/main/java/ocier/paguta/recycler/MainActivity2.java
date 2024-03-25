package ocier.paguta.recycler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String title = getIntent().getStringExtra("title");
        String id = getIntent().getStringExtra("id");
        String description = getIntent().getStringExtra("description");
        String price = getIntent().getStringExtra("price");
        String discountPercentage = getIntent().getStringExtra("discountPercentage");
        String rating = getIntent().getStringExtra("rating");
        String stock = getIntent().getStringExtra("stock");
        String brand = getIntent().getStringExtra("brand");
        String category = getIntent().getStringExtra("category");
        String[] imagesArray = getIntent().getStringArrayExtra("images");
        List<String> imagesList = Arrays.asList(imagesArray);

        TextView titleTextView = findViewById(R.id.title);
        TextView idTextview = findViewById(R.id.id);
        TextView descriptionTextview = findViewById(R.id.description);
        TextView priceTextview = findViewById(R.id.price);
        TextView discountPercentageTextview = findViewById(R.id.discountPercentage);
        TextView ratingTextview = findViewById(R.id.rating);
        TextView stockTextview = findViewById(R.id.stock);
        TextView brandTextview = findViewById(R.id.brand);
        TextView categoryTextview = findViewById(R.id.category);

        titleTextView.setText(title);
        idTextview.setText(id);
        descriptionTextview.setText(description);
        priceTextview.setText("$" + price);
        discountPercentageTextview.setText(discountPercentage+"% OFF");
        ratingTextview.setText("Rating: "+rating);
        stockTextview.setText(stock + " pieces left");
        brandTextview.setText(brand);
        categoryTextview.setText(category);

        ImageView[] imageViews = {
                findViewById(R.id.image1),
                findViewById(R.id.image2),
                findViewById(R.id.image3)
        };

        // Load images using Glide in a loop
        for (int i = 0; i < Math.min(imagesList.size(), imageViews.length); i++) {
            Glide.with(this)
                    .load(imagesList.get(i))
                    .placeholder(R.drawable.icons_here)
                    .error(R.drawable.location)
                    .into(imageViews[i]);
        }


    }
}
