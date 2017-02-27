package insurance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestPolicy {
	private Policy policy01;
	
	@Before
	public void setUp()  {
		System.out.println("setup updating policy01");
		Customer cust01 = new Customer();
		policy01 = new Policy(cust01);
		
		Claim claim01 = new Claim();
		claim01.setClaimID(12);
		claim01.setAmount(5000);
		policy01.addClaim(claim01);
		
		Claim claim02 = new Claim();
		claim02.setClaimID(44);
		claim02.setAmount(7000);
		policy01.addClaim(claim02);		
	}
	
	@Test
	public void testAddClaim() {
		assertEquals("Claim count should be 2", 2, policy01.getClaimCount());
	}

	@Test
	public void testGetTotalClaims() {
		assertEquals("Total claims should be 12000", 12000.0, policy01.getTotalClaims(), 0.0);
	}

	@Test
	public void testGetAverageClaim() {
		
		assertEquals("Average claims should be 6000", 6000.0, policy01.getAverageClaim(), 0.0);
	}

}
