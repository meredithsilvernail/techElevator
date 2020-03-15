package com.techelevator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HelloControllerTest {
	
	@Test
	public void a_silly_test_that_always_passes() {
		Assert.assertEquals(2, 2);
	}
}