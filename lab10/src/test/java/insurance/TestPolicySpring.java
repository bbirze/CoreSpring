package insurance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


@ContextConfiguration(classes=insurance.config.InsuranceConfig.class)
public class TestPolicySpring extends AbstractJUnit4SpringContextTests {
	
	
	@Autowired
	private Policy policy01;
//
//	@Before
//	public void setUp() {
//		System.out.println("setup updating policy01");
//		policy01 = (Policy)applicationContext.getBean("policy01");
//	}

	@Test
	public void testAddClaim() {
		assertEquals("Claim count should be 3", 3, policy01.getClaimCount());
	}

	@Test
	public void testGetTotalClaims() {
		assertEquals("Total claims should be 15500", 15500.0, policy01.getTotalClaims(), 0.0);
	}

	@Test
	public void testGetAverageClaim() {

		assertEquals("Average claims should be 5167.6", 5167.0, policy01.getAverageClaim(), 0.5);
	}
}
