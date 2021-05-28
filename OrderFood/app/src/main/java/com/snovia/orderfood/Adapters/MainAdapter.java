package com.snovia.orderfood.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.snovia.orderfood.DetailActivity;
import com.snovia.orderfood.Models.MainItemsModel;
import com.snovia.orderfood.Models.MainModel;
import com.snovia.orderfood.R;

import java.util.ArrayList;
import java.util.Collection;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewHolder> implements Filterable {
    ArrayList<MainModel> mainModels;
    ArrayList<MainModel> allFood;
    Context context;

    public MainAdapter(ArrayList<MainModel> mainModels, Context context) {
        this.mainModels = mainModels;
        this.allFood = new ArrayList<>(mainModels);
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view1= LayoutInflater.from(context).inflate(R.layout.sample_main_food,parent,false);
        return new viewHolder(view1);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        final MainModel model1=mainModels.get(position);
        holder.mainImageView.setImageResource(model1.getImage());
        holder.mainName.setText(model1.getName());
        holder.mainPrice.setText(model1.getPrice());
        holder.mainDescription.setText(model1.getDescription());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(context, DetailActivity.class);
                intent1.putExtra("foodImage",model1.getImage());
                intent1.putExtra("foodName",model1.getName());
                intent1.putExtra("foodDesc",model1.getDescription());
                intent1.putExtra("foodPrice",model1.getPrice());
                context.startActivity(intent1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mainModels.size();
    }

    @Override
    public Filter getFilter() {
        return getFilter;
    }
    Filter getFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String searchTxt = constraint.toString().toLowerCase();
            ArrayList<MainModel> tempoList = new ArrayList<>();
            if (searchTxt.length() == 0 || searchTxt.isEmpty()) {
                tempoList.addAll(mainModels);
            } else {
                for (MainModel item : mainModels) {
                    if (item.getName().toLowerCase().contains(searchTxt)) {
                        tempoList.add(item);
                    }
                }
            }
            FilterResults filteredResults = new FilterResults();
            filteredResults.values = tempoList;
            return filteredResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mainModels.clear();
            mainModels.addAll((Collection<? extends MainModel>) results.values);
            notifyDataSetChanged();
        }
    };
    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView mainImageView;
        TextView mainName,mainPrice,mainDescription;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            mainImageView=itemView.findViewById(R.id.foodImageView);
            mainName=itemView.findViewById(R.id.foodName);
            mainPrice=itemView.findViewById(R.id.foodPrice);
            mainDescription=itemView.findViewById(R.id.foodDescription);
        }
    }
}
