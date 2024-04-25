package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class Main {
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Quantos contribuintes você vai digitar? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		List<TaxPayer> tpList = new ArrayList<>();
		
		for (int i = 0; i < n; i++)
		{
			System.out.printf("Digite os dados do %do contribuinte:%n", i + 1);
			
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();
			sc.nextLine();
			
			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			sc.nextLine();
			
			TaxPayer taxpayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending);
			
			tpList.add(taxpayer);
		}
		
		
		
		for(int i = 0; i < tpList.size(); i++)
		{
			TaxPayer taxpayer = tpList.get(i);
			System.out.println();
			System.out.printf("Resumo do %do contribuinte:%n", i+1);
			System.out.println(taxpayer);
		}
		
		sc.close();
	}
}
