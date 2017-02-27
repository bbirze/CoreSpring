package insurance;

import java.util.Date;

public class Claim
{
    private int claimID;
    private Date claimDate;
    private double amount;

    public int getClaimID()
    {
        return claimID;
    }

    public void setClaimID(int claimID)
    {
        this.claimID = claimID;
    }

    public Date getClaimDate()
    {
        return claimDate;
    }

    public void setClaimDate(Date claimDate)
    {
        this.claimDate = claimDate;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public boolean equals(Object o)
    {
        Claim other = (Claim) o;
        if (other.claimID == this.claimID)
            return true;
        else
            return false;
    }

    public int hashCode()
    {
        return this.claimID;
    }
}
