package entities;

public class TaxPayer {
	
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending )
	{
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax()
	{
		if((salaryIncome/12) < 3000)
		{
			return 0.0;
		}
		else if((salaryIncome/12) >= 3000 && (salaryIncome/12) < 5000)
		{
			return salaryIncome * 0.10;
		}
		else if((salaryIncome/12) >= 5000)
		{
			return salaryIncome * 0.20;
		}
		
		return 0.0;
	}

	public double servicesTax()
	{
		if (servicesIncome > 0)
		{
			return servicesIncome * 0.15;
		}
		return 0.0;
	}
	
	public double capitalTax()
	{
		if (capitalIncome > 0)
		{
			return capitalIncome * 0.20;
		}
		return 0.0;
	}
	
	public double grossTax()
	{
		return salaryTax() + servicesTax() + capitalTax();
	}
	
	public double taxRebate()
	{
		double rebateLimit = grossTax() * 0.30;
		
		if ((healthSpending + educationSpending) > rebateLimit)
		{
			return rebateLimit;
		}
		
		return healthSpending + educationSpending;
	}
	
	public double netTax()
	{
		return grossTax() - taxRebate();
	}
	
	public String toString()
	{
		return "Imposto bruto total: "
			+ String.format("%.2f", grossTax())
			+ "\nAbatimento: "
			+ String.format("%.2f", taxRebate())
			+ "\nImposto devido: "
			+ String.format("%.2f", netTax());
	}
}
