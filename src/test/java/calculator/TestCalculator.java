package calculator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.calculator.ExpressionCalculator;
import com.calculator.exceptions.CalculatorException;

public class TestCalculator {

	private ExpressionCalculator testObject;

	@Before
	public void setUp() throws Exception {
		this.testObject = new ExpressionCalculator();
	}

	@After
	public void tearDown() throws Exception {
		testObject = null;
	}

	@Test(expected = CalculatorException.class)
	public void testInvalidExpression() throws CalculatorException {
		try {
			testObject.eval("3+");
			Assert.fail("This assert should not be called");
		} catch (Exception e) {

		}

		try {
			testObject.eval("+3");
			Assert.fail("This assert should not be called");
		} catch (Exception e) {

		}

		try {
			testObject.eval("+*");
			Assert.fail("This assert should not be called");
		} catch (Exception e) {
			throw e;
		}
	}

	@Test
	public void testAddition() throws CalculatorException {
		Assert.assertEquals("add", 7, testObject.eval("3 + 4"));
	}

	@Test(expected = CalculatorException.class)
	public void testNegativeAddition() throws CalculatorException {
		testObject.eval("- 3 - 4");
	}

	@Test
	public void testSubstract() throws CalculatorException {
		Assert.assertEquals("substract", 3, testObject.eval("5 - 2"));
	}

	@Test
	public void testNegativeSubstract() throws CalculatorException {
		Assert.assertEquals("substract and result is negative", -3, testObject.eval("2-5"));
	}

	@Test
	public void testMultiply() throws CalculatorException {
		Assert.assertEquals("multiply", 120, testObject.eval("10*12"));
	}

	@Test
	public void testExpression() throws CalculatorException {
		Assert.assertEquals("Verify expression", 2, testObject.eval("a=2"));
	}

	@Test
	public void testAssignments() throws CalculatorException {
		testObject.eval("a=4");
		testObject.eval("b=2");
		testObject.eval("c=a/b");
		Assert.assertEquals("Verify expression", 2, testObject.eval("c"));
	}

}
