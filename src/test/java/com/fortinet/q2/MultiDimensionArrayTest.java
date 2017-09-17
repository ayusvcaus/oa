package com.fortinet.q2;

import java.util.Random;

import org.junit.Test;

import org.junit.Before;
import static org.junit.Assert.assertEquals;

import com.fortinet.q2.MultiDimensionArray;

public class MultiDimensionArrayTest {
	
	private Long[][][][] arr;

	private final int DIMENSION_1 = 5;
	private final int DIMENSION_2 = 4;
	private final int DIMENSION_3 = 3;
	private final int DIMENSION_4 = 2;
	
	private int[] lDims;
	
	private Long sum = 0l;
	
	@Before
	public void setup() {
		
		lDims = new int[]{DIMENSION_1, DIMENSION_2, DIMENSION_3, DIMENSION_4};
		
		arr = new Long[lDims[0]][lDims[1]][lDims[2]][lDims[3]];
		
		Random rand = new Random();
		for (int i=0; i<lDims[0]; i++) {
			for (int j=0; j<lDims[1]; j++) {
				for (int k=0; k<lDims[2]; k++) {
					for (int l=0; l<lDims[3]; l++) {
						long randNum = (long) rand.nextInt(100);
						arr[i][j][k][l] = randNum;
						sum+=randNum;
					}
				}
			}		
		}	
	}
	
	@Test
	public void testSum() {
		
		Long actual = MultiDimensionArray.sum(null, lDims);
		assertEquals(new Long(0), actual);
		
		MultiDimensionArray mArray = new MultiDimensionArray(arr);	
		actual = MultiDimensionArray.sum(mArray, null);
		assertEquals(new Long(0), actual);
		
		int[] tmp = {DIMENSION_1, DIMENSION_2, DIMENSION_3};
		actual = MultiDimensionArray.sum(mArray, tmp);
		assertEquals(new Long(0), actual);
		
		int[] tmp2 = {DIMENSION_1, DIMENSION_2, DIMENSION_3, DIMENSION_3};
		actual = MultiDimensionArray.sum(mArray, tmp2);
		assertEquals(new Long(0), actual);
		
		int[] tmp3 = {DIMENSION_1, DIMENSION_1, DIMENSION_3, DIMENSION_4};
		actual = MultiDimensionArray.sum(mArray, tmp3);
		assertEquals(new Long(0), actual);
		
		int[] tmp6 = {DIMENSION_1+1, DIMENSION_2, DIMENSION_3, DIMENSION_4};
		actual = MultiDimensionArray.sum(mArray, tmp6);
		assertEquals(new Long(0), actual); 
		
		//Success
		actual = MultiDimensionArray.sum(mArray, lDims);
		assertEquals(sum, actual);
		
		int[] tmp4 = {DIMENSION_1, DIMENSION_2, DIMENSION_3, DIMENSION_4, DIMENSION_4};
		actual = MultiDimensionArray.sum(mArray, tmp4);
		assertEquals(sum, actual);			
	}

}
