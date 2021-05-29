package com.example.coffeeorderapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bumptech.glide.Glide;
import com.example.coffeeorderapp.Model.CofeModel;
import com.example.coffeeorderapp.R;

import java.util.List;


public class CoffeeAdapter  extends RecyclerView.Adapter<CoffeeAdapter.CoffeListHolder> {


    List<CofeModel> cofeModelList;

    GetOneCoffee interfacegetCoffee;

    public CoffeeAdapter(GetOneCoffee interfacegetCoffee) {
        this.interfacegetCoffee = interfacegetCoffee;
    }

    @Override
    public CoffeListHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coffeeliststyle, parent, false);
        return new CoffeListHolder(view);

    }

    @Override
    public void onBindViewHolder( CoffeeAdapter.CoffeListHolder holder, int position) {

        holder.cofeename.setText(cofeModelList.get(position).getCoffeename());
        holder.description.setText(cofeModelList.get(position).getDescription());

        Glide.with(holder.itemView.getContext()).load(cofeModelList.get(position).getImageURL()).into(holder.iamgeView);

    }

    @Override
    public int getItemCount() {
        return cofeModelList.size();
    }


//    sets the coffee list from viewmodel
    public void setCofeModelList(List<CofeModel> cofeModelList){
        this.cofeModelList = cofeModelList;
    }

    class CoffeListHolder extends ViewHolder implements View.OnClickListener{

        TextView cofeename, description;
        ImageView iamgeView;


        public CoffeListHolder( View itemView) {
            super(itemView);

            cofeename = itemView.findViewById(R.id.coffeeName);
            description = itemView.findViewById(R.id.coffeedetail);
            iamgeView = itemView.findViewById(R.id.coffeeImage);

            cofeename.setOnClickListener(this);
            description.setOnClickListener(this);
            iamgeView.setOnClickListener(this);


        }

        @Override
        public void onClick(View v) {

            interfacegetCoffee.clickedCoffee(getAdapterPosition(), cofeModelList);


        }
    }

    public interface GetOneCoffee{
        void clickedCoffee(int position, List<CofeModel> cofeModels);
    }
}
