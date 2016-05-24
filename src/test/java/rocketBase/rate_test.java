package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class rate_test {

	@Test(expected = RateException.class) 
	public void test() throws RateException  {
		double rates;
		rates = RateBLL.getRate(10);
	}
	@Test
	public void testSuccess() {
		double rates;
		try {
			rates = RateBLL.getRate(600);
			assert(rates == 4.5);
		} catch (RateException e) {
			e.printStackTrace();
		}
		
	}
}
