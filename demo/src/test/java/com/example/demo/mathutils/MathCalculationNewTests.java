package com.example.demo.mathutils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Mathutils.MathCalcuation;

@SpringBootTest

public class MathCalculationNewTests {
	
	@Test
	public void testCalculation() {
		
		MathCalcuation mathCalculation = new MathCalcuation();	
//		int actualresult = mathCalculation.mulCalculation(4, 4);
//		assertEquals(16,actualresult);
		
		assertEquals(0,mathCalculation.calculation(0,0));
		assertEquals(0,mathCalculation.calculation(-1,1));
	}

}
