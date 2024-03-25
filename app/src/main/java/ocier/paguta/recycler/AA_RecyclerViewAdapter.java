package ocier.paguta.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class AA_RecyclerViewAdapter extends RecyclerView.Adapter<AA_RecyclerViewAdapter.MyViewHolder> {
private final RecyclerViewInterface recyclerViewInterface;


    Context context;
    ArrayList<AminoAcidModel> aminoAcidModels;

    public AA_RecyclerViewAdapter(Context context, ArrayList<AminoAcidModel>aminoAcidModels, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.aminoAcidModels = aminoAcidModels;
        this.recyclerViewInterface = recyclerViewInterface;


    }

    @NonNull
    @Override
    public AA_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new AA_RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AA_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(aminoAcidModels.get(position).getTitle());
        holder.tv3Letter.setText( "$" + aminoAcidModels.get(position).getPrice());
        holder.tv1Letter.setText( "Rating: " + aminoAcidModels.get(position).getRating());

        String imageUrl = aminoAcidModels.get(position).getThumbnail();

        Glide.with(context)
                .load(imageUrl) // Load image from URL specified in AminoAcidModel
                .placeholder(R.drawable.icons_here) // Optional placeholder image while loading
                .error(R.drawable.location) // Optional error image if loading fails
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return aminoAcidModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView tvName, tv3Letter, tv1Letter;


        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView3);
            tvName = itemView.findViewById(R.id.textView);
            tv3Letter = itemView.findViewById(R.id.textView2);
            tv1Letter = itemView.findViewById(R.id.textView3);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }

                    }
                }
            });

        }
    }

}










