package example;

public class ImportTaxCalculation implements TaxCalculation {

	private TaxCalculation calculation;

	public ImportTaxCalculation(TaxCalculation calculation) {
		this.calculation = calculation;
	}

	@Override
	public Item getItem() {
	    return calculation.getItem();
	}

	@Override
	public float calc() {
//		System.out.println("imported"+(calculation.calc()));
	    return (calculation.calc() + getItem().basePrice * 0.05f);
	}

}
