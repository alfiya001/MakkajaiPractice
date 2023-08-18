package example;

public class BaseTaxCalculator implements TaxCalculation {

	protected Item item;

	public BaseTaxCalculator(Item item) {
	    this.item = item;
	}

	@Override
	public Item getItem() {
	    return item;
	}

	@Override
	public float calc() {
	    return 0;
	}
}
