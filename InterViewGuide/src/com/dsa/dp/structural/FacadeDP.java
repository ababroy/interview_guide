package com.dsa.design_pattern;

public class FacadeDP
{
    // Client/User
    public static void main ( String[] args )
    {
        BankAccountFacade baf = new BankAccountFacade( 12345678, 1234 );
        baf.withdrawCash( 50.00 );
        baf.withdrawCash( 900.00 );
        baf.depositCash( 200.00 );
    }
}

class BankAccountFacade
{
    private int accountNo;

    private int securityCode;

    AccountNumberCheck accountNumberCheck;

    SecurityCodeCheck securityCodeCheck;

    FundsCheck fundsCheck;

    Bank bank;

    BankAccountFacade ( int newAccountNo, int newSecurityCode )
    {
        accountNo = newAccountNo;
        securityCode = newSecurityCode;

        bank = new Bank();
        accountNumberCheck = new AccountNumberCheck();
        securityCodeCheck = new SecurityCodeCheck();
        fundsCheck = new FundsCheck();
    }

    public int getAccountNo ()
    {
        return accountNo;
    }

    public int getSecurityCode ()
    {
        return securityCode;
    }

    public void depositCash ( double cashToDeposit )
    {
        if ( accountNumberCheck.accountActive( getAccountNo() ) && securityCodeCheck.isCodeCorrect( getSecurityCode() ) )
        {
            fundsCheck.makeDeposite( cashToDeposit );
            System.out.println( "TransactionComplete" );
        }
        else
        {
            System.out.println( "Transaction failed" );
        }
    }

    public void withdrawCash ( double cashToGet )
    {
        if ( accountNumberCheck.accountActive( getAccountNo() ) && securityCodeCheck.isCodeCorrect( getSecurityCode() ) && fundsCheck.haveEnoughMoney( cashToGet ) )
        {
            System.out.println( "TransactionComplete" );
        }
        else
        {
            System.out.println( "Transaction failed" );
        }
    }

}

class Bank
{
    Bank ()
    {
        System.out.println( "Welcome to our Bank" );
        System.out.println( "We are happy to give you your money if we can find it" );
    }
}

class AccountNumberCheck
{
    private int accountNo = 12345678;

    public int getAccountNumber ()
    {
        return accountNo;
    }

    public boolean accountActive ( int accountNumberToCheck )
    {
        if ( accountNumberToCheck == getAccountNumber() )
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}

class SecurityCodeCheck
{
    private int securityCode = 1234;

    public int getSecurityCode ()
    {
        return securityCode;
    }

    public boolean isCodeCorrect ( int securityCodeToCheck )
    {
        if ( securityCodeToCheck == getSecurityCode() )
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

class FundsCheck
{
    private double cashInAccount = 1000.00;

    public double getCashInAccount ()
    {
        return cashInAccount;
    }

    public void decreaseCashInAccount ( double cashWithdrawn )
    {
        cashInAccount = cashInAccount - cashWithdrawn;
    }

    public void increaseCashInAccount ( double cashDeposited )
    {
        cashInAccount = cashInAccount + cashDeposited;
    }

    public boolean haveEnoughMoney ( double cashWithdrawal )
    {
        if ( cashWithdrawal > getCashInAccount() )
        {
            System.err.println( "ERROR: You don't have enough money " );
            System.out.println( "Current balance: " + getCashInAccount() );
            return false;
        }
        else
        {
            decreaseCashInAccount( cashWithdrawal );
            System.out.println( "Withdrawal Complete: curren balance: " + getCashInAccount() );
            return true;
        }

    }

    public void makeDeposite ( double cashToDeposit )
    {
        increaseCashInAccount( cashToDeposit );
        System.out.println( "Deposit Complete: Current balance:" + getCashInAccount() );
    }

}
