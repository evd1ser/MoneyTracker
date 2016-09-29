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
import ru.evd1ser.moneytracker.models.ExpenseModel;
import ru.evd1ser.moneytracker.ui.adapters.ExpensesAdapret;

public class ExpensesFragment extends Fragment {


    private RecyclerView recyclerView;
    private ExpensesAdapret expensesAdapret;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.expenses_fragment, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.list_of_expenses);
        expensesAdapret = new ExpensesAdapret(getExpenses());
        recyclerView.setLayoutManager(new LinearLayoutManager((getActivity())));
        recyclerView.setAdapter(expensesAdapret);

        return rootView;
    }

    private List<ExpenseModel> getExpenses(){
        List<ExpenseModel> expenses = new ArrayList<>();
        expenses.add(new ExpenseModel("Books", "123"));
        expenses.add(new ExpenseModel("Cafe", "200"));
        expenses.add(new ExpenseModel("Adobe", "599"));
        expenses.add(new ExpenseModel("Cinema", "300"));
        expenses.add(new ExpenseModel("Theater", "300"));
        expenses.add(new ExpenseModel("Food", "145"));
        expenses.add(new ExpenseModel("Mall", "1000"));
        expenses.add(new ExpenseModel("Books", "123"));
        expenses.add(new ExpenseModel("Cafe", "200"));
        expenses.add(new ExpenseModel("Adobe", "599"));
        expenses.add(new ExpenseModel("Cinema", "300"));
        expenses.add(new ExpenseModel("Theater", "300"));

        return expenses;
    }
}