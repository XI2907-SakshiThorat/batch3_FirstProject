package com.example.demo.mathutils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;//verify the conditions and return results as true or false

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.Mathutils.MathCalcuation;

@SpringBootTest
public class MathCalcuationTest {
	
	@Test
	public void testCalculation() {
		
		MathCalcuation mathCalculation = new MathCalcuation();
//		//1
//		int actualresult = mathCalculation.calculation(2, 3);
//		assertEquals(5,actualresult);
//		//2
//		actualresult = mathCalculation.calculation(3, 3);
//		assertEquals(6,actualresult);
		
		List<Integer> l1 = Stream.of(1,2,3,4,5).collect(Collectors.toList());
		List<Integer> l2 = Stream.of(1,-2,3,4,6).collect(Collectors.toList());
		
		for(int i=0; i<l1.size(); i++) {
			int actualresult = mathCalculation.calculation(l1.get(i),l2.get(i));
			assertEquals(l1.get(i)+l2.get(i),actualresult);
			
		}
	}

}
