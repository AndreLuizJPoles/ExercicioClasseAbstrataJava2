package application;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<TaxPayer> taxPayers = new ArrayList<>();
        System.out.print("Enter the number of tax payers: ");
        int numberOfTaxPayers = sc.nextInt();
        for(int i=0;i<numberOfTaxPayers;i++){
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char typeTaxPayer = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Annual income: ");
            double annualIncome = sc.nextDouble();
            if(typeTaxPayer == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                taxPayers.add(new Individual(name,annualIncome,healthExpenditures));
            }
            else{
                System.out.print("Number of employees: ");
                int numberOfEmployees = sc.nextInt();
                taxPayers.add(new Company(name,annualIncome,numberOfEmployees));
            }
        }
        System.out.println();
        System.out.println("TAXES PAID:");
        double sum = 0;
        for(TaxPayer taxPayer : taxPayers){
            System.out.println(taxPayer);
            sum += taxPayer.tax();
        }
        System.out.println();
        System.out.print("TOTAL TAXES: $ " + String.format("%.2f", sum));
    }
}