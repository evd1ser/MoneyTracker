package ru.evd1ser.moneytracker.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.evd1ser.moneytracker.R;
import ru.evd1ser.moneytracker.models.CategoriesModel;

public class CategoriesAdapret extends RecyclerView.Adapter<CategoriesAdapret.CategoriesHolder> {

    private List<CategoriesModel> categoriesList;

    public CategoriesAdapret(List<CategoriesModel> categoriesList) {
        this.categoriesList = categoriesList;
    }


    @Override
    public CategoriesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.categories_item, parent, false);
        return new CategoriesHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoriesHolder holder, int position) {
        CategoriesModel categories = categoriesList.get(position);
        holder.name.setText(categories.getName());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    class CategoriesHolder extends RecyclerView.ViewHolder {

        TextView name;

        public CategoriesHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.categories_item_expense_name);
        }
    }
}
