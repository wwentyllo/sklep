package com.cebul.jez.junit;
import static org.junit.Assert.*;

import org.junit.Test;

public class FirstTest
{
	@Test
	public void testOrder()
	{
		assertEquals(9, DoTestowania.largest(new int[] {8,9,7}));
		assertEquals(9, DoTestowania.largest(new int[] {9,8,7}));
		assertEquals(9, DoTestowania.largest(new int[] {8,7,9}));
	}
}
