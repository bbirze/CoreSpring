package insurance;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import insurance.config.InsuranceConfig;

public class InsuranceApp
{
    public static void main(String[] args)
    {
    	AnnotationConfigApplicationContext ctx =
        		new AnnotationConfigApplicationContext(
        			     InsuranceConfig.class);

        Policy policy01 = (Policy)ctx.getBean("policy01");
        System.out.println("Policy number: " + policy01.getPolicyNumber());
        System.out.println("Total claims: " + policy01.getTotalClaims());
        System.out.println("Average claim: " + policy01.getAverageClaim());
        
        ctx.close();
    }
}
