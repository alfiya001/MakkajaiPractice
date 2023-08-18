package example;

public class SalesTaxCalculation implements TaxCalculation {

	TaxCalculation calculation;
	public SalesTaxCalculation(TaxCalculation calculation) {
	    this.calculation = calculation;
	}

	@Override
	public Item getItem() {
	    return calculation.getItem();
	}

	@Override
	public float calc() {
		return (calculation.calc() + getItem().basePrice * 0.1f);
	}
}
