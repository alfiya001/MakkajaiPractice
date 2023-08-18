import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.StringJoiner;

public class Test {
	public static void main(String[] args) {
		System.out.println(Integer.parseUnsignedInt("4294967295"));
		
		StringJoiner strJ = new StringJoiner(":","[","]");
		strJ.add("Peter");
		strJ.add("Willson");
		System.out.println(strJ);
		
		LocalDate today  = LocalDate.now();
		LocalDate lastday = today.with(TemporalAdjusters.lastDayOfYear());
		
		Period period = today.until(lastday);
		System.out.println(period.getMonths());
	}
}
