package ru.evd1ser.moneytracker.models;

public class ExpenseModel {

    private String name;
    private String prise;

    public ExpenseModel(String name, String prise) {
        this.name = name;
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public String getPrise() {
        return prise;
    }
}
