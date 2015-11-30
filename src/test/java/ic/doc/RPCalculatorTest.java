package ic.doc;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;

/*
 * The aim of the tests is to check the correct behavior of 
 * the Model only.
 */

@SuppressWarnings("deprecation")
@RunWith(JMock.class)
public class RPCalculatorTest {

	Mockery context = new Mockery();
	Updatable view = context.mock(Updatable.class);
	RPCalculator calculator = new RPCalculator(view);
	
    @Test
    public void calculatorAddsTwoNumbersCorrectly() {
    	
    	context.checking(new Expectations() {{
    		exactly(1).of(view).update(calculator);
    	}});
    	
    	int res = calculator.safeAdd(8, 7);
    	assertThat(res, is(15));
    }
    
    @Test
    public void calculatorSubtractsOneNumberFromTheOtherCorrectly() {
    	
    	context.checking(new Expectations() {{
    		exactly(1).of(view).update(calculator);
    	}});
    	
    	int res = calculator.safeSubtract(8, 7);
    	assertThat(res, is(1));
    }
    

    

}
