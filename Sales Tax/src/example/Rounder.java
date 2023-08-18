package example;

import java.text.DecimalFormat;

public class Rounder implements TaxCalculation {

	private TaxCalculation calculation;
    DecimalFormat decfor = new DecimalFormat("0.00");

	public Rounder(TaxCalculation calculation) {
		this.calculation = calculation;
	}

	@Override
	public Item getItem() {
	    return calculation.getItem();
	}

	@Override
	public float calc() {
		float val = 2 + (float)(calculation.calc() * 100);
	    float remainder = val % 5;
	    return ((float)(val - remainder)) / 100f;
	   }

}
