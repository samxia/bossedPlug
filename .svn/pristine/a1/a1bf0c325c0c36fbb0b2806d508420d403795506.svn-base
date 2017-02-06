package oval;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.constraint.Min;
import net.sf.oval.constraint.Range;
import net.sf.oval.constraint.ValidateWithMethod;

public class TestOval {

	/**
	 * @param args
	 * @throws BussinessException 
	 */
	public static void main(String[] args) throws BussinessException {
		Validator validator = new Validator();

		TestOval to = new TestOval();
		to.setDay(1959);
		to.setMonth(15);
		List<ConstraintViolation> violations = validator.validate(to);
		if (violations.size() > 0) {
			System.out.println("Object " + to + " is invalid.");

		//	throw new BussinessException(violations);
		}
		System.out.println(to.getDay());

	}

	@Min(1960)
	private int year = 1977;

	@Range(min = 1, max = 12)
	private int month = 2;

	@ValidateWithMethod(methodName = "isValidDay", parameterType = int.class)
	private int day = 31;

	private boolean isValidDay(int day) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setLenient(false);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month - 1);
		cal.set(Calendar.DATE, day);
		try {
			cal.getTimeInMillis(); // throws IllegalArgumentException
		} catch (IllegalArgumentException e) {
			return false;
		}
		return true;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public class BussinessException extends Exception {
		
		public BussinessException(List<ConstraintViolation> list)
		{
			Iterator it=list.iterator();
			while(it.hasNext())
			{
				ConstraintViolation cv=(ConstraintViolation) it.next();
				System.out.println(cv.getMessage());
			}
		}
	}
}
