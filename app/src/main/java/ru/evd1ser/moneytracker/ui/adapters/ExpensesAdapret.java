package ru.evd1ser.moneytracker.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ru.evd1ser.moneytracker.R;

import ru.evd1ser.moneytracker.models.ExpenseModel;

public class ExpensesAdapret extends RecyclerView.Adapter<ExpensesAdapret.ExpenseHolder> {

    private List<ExpenseModel> expensesList;

    public ExpensesAdapret(List<ExpenseModel> expensesList) {
        this.expensesList = expensesList;
    }

    @Override
    public ExpenseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.expense_item, parent, false);
        return new ExpenseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpenseHolder holder, int position) {
        ExpenseModel expense = expensesList.get(position);
        holder.name.setText(expense.getName());
        holder.prise.setText(expense.getPrise());
    }

    @Override
    public int getItemCount() {
        return expensesList.size();
    }

    class ExpenseHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView prise;

        public ExpenseHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.expense_item_expense_name);
            prise = (TextView) itemView.findViewById(R.id.expense_item_expense_prise);
        }
    }
}
