package rocketBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		ArrayList<RateDomainModel> alRates = _RateDAL.getAllRates();
		
		double dInterest= 0.0;
		
		for (Iterator iterator = alRates.iterator(); iterator.hasNext();) {
			RateDomainModel rte = (RateDomainModel) iterator.next();
			if(rte != null && (rte.getiMinCreditScore() == GivenCreditScore))
			{
				dInterest = rte.getdInterestRate();
			}
		}
		if(dInterest == 0.0)
		{
			throw new RateException("No Interest rate is available for the given credit score");
		}
		
		return dInterest;
	}
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
