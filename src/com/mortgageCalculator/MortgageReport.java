package com.mortgageCalculator;

import java.text.NumberFormat;

public class MortgageReport {

    private final NumberFormat currency;
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currency = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_".repeat("PAYMENT SCHEDULE".length()));
        for (double balance: calculator.getRemainingBalances()) {
            String paymentSchedule = currency.format(balance);
            System.out.println(paymentSchedule);
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormatted = currency.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("_".repeat("MORTGAGE".length()));
        System.out.println("Monthly Payments: " + mortgageFormatted);
    }
}
