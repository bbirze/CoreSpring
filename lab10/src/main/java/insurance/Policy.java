package insurance;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

public class Policy
{
    private int policyNumber;
    private double amount;
    private Date policyDate;
    private Collection<Claim> claims = new HashSet<Claim>();
    private Customer theCustomer;

    public Policy(Customer theCustomer)
    {
        this.theCustomer = theCustomer;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public Collection<Claim> getClaims()
    {
        return claims;
    }

    public void setClaims(Collection<Claim> claims)
    {
        this.claims = claims;
    }

    public Date getPolicyDate()
    {
        return policyDate;
    }

    public void setPolicyDate(Date policyDate)
    {
        this.policyDate = policyDate;
    }

    public Customer getTheCustomer()
    {
        return theCustomer;
    }

    public void setTheCustomer(Customer theCustomer)
    {
        this.theCustomer = theCustomer;
    }

    public Claim getClaim(int claimNumber)
    {
        Claim theClaim = null;

        for (Claim c : claims)
        {
            if (c.getClaimID() == claimNumber)
            {
                theClaim = c;
                break;
            }
        }

        return theClaim;
    }

    public void addClaim(Claim c)
    {
        claims.add(c);
    }

    public int getClaimCount()
    {
        return claims.size();
    }

    public double getTotalClaims()
    {
        double total = 0;
        for (Claim c : claims)
        {
            total += c.getAmount();
        }
        return total;
    }

    public double getAverageClaim()
    {
        if (claims.size() > 0)
        {
            double total = getTotalClaims();
            return total / claims.size();
        }
        else
            return -1;
    }

    public int getPolicyNumber()
    {
        return policyNumber;
    }

    public void setPolicyNumber(int policyNumber)
    {
        this.policyNumber = policyNumber;
    }
}