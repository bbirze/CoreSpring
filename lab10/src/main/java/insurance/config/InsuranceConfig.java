package insurance.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;

import insurance.Claim;
import insurance.Customer;
import insurance.Policy;

public class InsuranceConfig
{
	@Bean
	public Claim claim01()	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Claim c = new Claim();
		try		{
			c.setClaimID(12);
			c.setClaimDate(sdf.parse("2009/02/19"));
			c.setAmount(5000);
			
		}catch (ParseException e)		{
			e.printStackTrace();
		}
		return c;
	}
	
	@Bean
	public Claim claim02()	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Claim c = new Claim();
		try		{
			c.setClaimID(44);
			c.setClaimDate(sdf.parse("2009/04/20"));
			c.setAmount(7000);

		} catch (ParseException e)	{
			e.printStackTrace();
		}
		return c;
	}
      
//	<bean id="claim03" class="insurance.Claim">
//	  <property name="claimID" value="184"/>
//	  <property name="claimDate" value="2009/06/23"/>
//	  <property name="amount" value="3500" />
//	</bean>
	@Bean
	public Claim claim03()	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Claim c = new Claim();
		try		{
			c.setClaimID(184);
			c.setClaimDate(sdf.parse("2009/06/23"));
			c.setAmount(3500);
			
		} catch (ParseException e)	{
			e.printStackTrace();
		}
		return c;
	}
      
	@Bean
	public Customer cust01()	{		
		Customer c = new Customer();
		c.setCustomerID(457);
		c.setName("Harry Wolfe");
		return c;
	}
      
	@Bean
	public Policy policy01()	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		
		Policy p = new Policy(cust01());
		try		{
			p.setPolicyDate(sdf.parse("2008/09/12"));
			p.setPolicyNumber(64833);
			p.setAmount(100000);
			
			Set<Claim> claims = new HashSet<Claim>();
			claims.add(claim01());
			claims.add(claim02());
			claims.add(claim03());
			p.setClaims(claims);
			
		} catch (ParseException e)		{
			e.printStackTrace();
		}
		return p;
	}

}
