

import java.util.ArrayList;
import java.lang.Math;

/**
 *
 * 
 */
public class Member {
    private String memberName = null;
    private int memberID = 0;
    private String debitCardNumber = null;
    private String membershipType = null;
    private boolean isPremium = false;
    private boolean hasMissedPayment = false;

    private double totalBalancePaid = 0.0;

    // constructor

    public Member( String name, int ID, String debitCard, String type,boolean isMembershipPremium,boolean paymentOverdue,double balance) {
        memberName = name;
        memberID = ID;
        debitCardNumber = debitCard;
        membershipType = type;
        isPremium = isMembershipPremium;
        hasMissedPayment = paymentOverdue;

        totalBalancePaid = balance;
    }

    // getters

    public String getName() {
        return memberName;
    }

    public int getID() {
        return memberID;
    }

    public String getPaymentInfo() {
        return debitCardNumber;
    }

    public String getMembership() {
        return membershipType;
    }

    public double getTotalBalance() {
        return totalBalancePaid;
    }

    public boolean overduePayments() {
        return hasMissedPayment;
    }

    // setters

    public void setName(String newName) {
        memberName = newName;
    }

    public void setID(int newID) {
        memberID = newID;
    }

    public void setCardInfo(String newCard) {
        debitCardNumber = newCard;
    }

    public void setMembershipType(String membership) {
        membershipType = membership;
        if (membership.equals("Premium")) {
            isPremium = true;
            totalBalancePaid += 9.99;
        }
    }

    public void addTotalToBalance(double total) {
        totalBalancePaid = totalBalancePaid + total;
    }

    // display

    public String memberDisplay() {
        // fix decimal not rounding to the nearest 100th
        return "Account Type: " + membershipType + " | Name: " + memberName +
                " | ID: " + memberID + "\nCard Number: " + debitCardNumber + " | History Total " +
                "Spent: " + (
            double
        )(Math.round(totalBalancePaid * 100.0) / 100.0) + "\n";
    }
}
