package ru.evd1ser.moneytracker.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.evd1ser.moneytracker.R;
import ru.evd1ser.moneytracker.models.CategoriesModel;
import ru.evd1ser.moneytracker.ui.adapters.CategoriesAdapret;
import ru.evd1ser.moneytracker.ui.adapters.ExpensesAdapret;

public class CategoriesFragment extends Fragment {

        private RecyclerView recyclerView;
        private CategoriesAdapret categoriesAdapret;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.categories_fragment, container, false);

            recyclerView = (RecyclerView) rootView.findViewById(R.id.list_of_categories);

            categoriesAdapret = new CategoriesAdapret(getCategories());

            recyclerView.setLayoutManager(new LinearLayoutManager((getActivity())));
            recyclerView.setAdapter(categoriesAdapret);

            return rootView;
        }

        private List<CategoriesModel> getCategories(){
            List<CategoriesModel> categories = new ArrayList<>();
            categories.add(new CategoriesModel("Edu"));
            categories.add(new CategoriesModel("Food"));
            categories.add(new CategoriesModel("PC"));
            categories.add(new CategoriesModel("Other"));

            return categories;
        }
    }