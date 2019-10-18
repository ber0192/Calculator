package sk.test.calculator;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	 @Test
	 public void test1() {
	     Calculator calc = new Calculator();
	     assertSame(18, calc.readInput("src/test/resources/calculator_test1.txt"));
	 }
	 
	 @Test
	 public void test2() {
	      Calculator calc = new Calculator(); 
	      assertSame(45, calc.readInput("src/test/resources/calculator_test2.txt"));
	 }
	 
	 @Test
	 public void test3() {
	      Calculator calc = new Calculator();
	      assertSame(1, calc.readInput("src/test/resources/calculator_test3.txt"));
	 }
	 
}
