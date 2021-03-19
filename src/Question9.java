import java.io.BufferedReader;
import java.lang.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Account{
	String customerName;
	String accountNumber;
	String accountType;
	int balance;
}
class CurrentAccount extends Account{
	int iRate = 0;
	int minBal = 400;
	int serCharge = 20;
}

class SavingsAccount extends Account{
	int iRate = 4;
}

class ActionsOnAccounts{
	CurrentAccount[] curAcc = new CurrentAccount[10];
	SavingsAccount[] savAcc = new SavingsAccount[10];
	int savTop = 0; int curTop = 0;
	
	void CreateAccount(String accType, String name) {
		Random rand = new Random();
		String accountNumber = accType + String.valueOf(Math.abs(rand.nextInt()*100));
		if(accType == "Current") {
			CurrentAccount acc = new CurrentAccount();
			acc.customerName = name;
			acc.accountNumber = accountNumber;
			acc.accountType = "Current";
			curAcc[curTop] = acc;
			curTop++;
		}
		else {
			SavingsAccount acc = new SavingsAccount();
			acc.customerName = name;
			acc.accountNumber = accountNumber;
			acc.accountType = "Savings";
			savAcc[savTop] = acc;
			savTop++;
		}
		System.out.println("Your account was successfully created with the Account Number\n" + accountNumber);
		System.out.println();
	}
	void DepositAmount(String accountNumber, int amount) {
		int top = 0;
		CurrentAccount acc1 = new CurrentAccount();
		while(top < 10) {
			acc1 = curAcc[top];
			if(acc1 != null && (accountNumber.charAt(0)) == 'C') {
				if(acc1.accountNumber.equals(accountNumber)) {
					int balance = acc1.balance;
					System.out.println("Your Outstanding Balance was " + balance + " Rs.");
					System.out.println();
					acc1.balance = acc1.balance + amount;
					System.out.println("Balance Updated with " + amount + " Rs.");
					System.out.println();
				}
			}
			top++;
		}
		SavingsAccount acc2 = new SavingsAccount();
		top = 0;
		while(top < 10) {
			acc2 = savAcc[top];
			if(acc2 != null && (accountNumber.charAt(0)) == 'S') {
				if(acc2.accountNumber.equals(accountNumber)) {
					int balance = acc2.balance;
					System.out.println("Your Outstanding Balance was " + balance + " Rs.");
					System.out.println();
					acc2.balance = acc2.balance + amount;
					System.out.println("Balance Updated with " + amount + " Rs.");
					System.out.println();
				}
			}
			top++;
		}
		
	}
	
	void WithdrawAmount(String accountNumber, int amount) {
		int top = 0;
		CurrentAccount acc1 = new CurrentAccount();
		while(top < 10) {
			acc1 = curAcc[top];
			if(acc1 != null && (accountNumber.charAt(0)) == 'C') {
				if(acc1.accountNumber.equals(accountNumber)) {
					int balance = acc1.balance;
					System.out.println("Your Outstanding Balance was " + balance + " Rs.");
					System.out.println();
					acc1.balance = acc1.balance - amount;
					System.out.println("Balance Deducted with " + amount + " Rs.");
					System.out.println();
				}
			}
			top++;
		}
		SavingsAccount acc2 = new SavingsAccount();
		top = 0;
		while(top < 10) {
			acc2 = savAcc[top];
			if(acc2 != null && (accountNumber.charAt(0)) == 'S') {
				if(acc2.accountNumber.equals(accountNumber)) {
					int balance = acc2.balance;
					System.out.println("Your Outstanding Balance was " + balance + " Rs.");
					System.out.println();
					acc2.balance = acc2.balance - amount;
					System.out.println("Balance Deducted with " + amount + " Rs.");
					System.out.println();
				}
			}
			top++;
		}
		
	}
	
	void DisplayBalance(String accountNumber) {
		int top = 0;
		CurrentAccount acc1 = new CurrentAccount();
		while(top < 10) {
			acc1 = curAcc[top];
			if(acc1 != null) {
				if(acc1.accountNumber.equals(accountNumber)) {
					System.out.println("Your Outstanding balance is: " + acc1.balance + " Rs.");
					System.out.println();
				}
			}
			top++;
		}
		SavingsAccount acc2 = new SavingsAccount();
		top = 0;
		while(top < 10) {
			acc2 = savAcc[top];
			if(acc2 != null) {
				if(acc2.accountNumber.equals(accountNumber)) {
					System.out.println("Your Outstanding balance is: " + acc2.balance + " Rs.");
					System.out.println();
				}
			}
			top++;
		}
		
	}
	void DisplayAccountDetails() {
		int top = 0;
		CurrentAccount acc1 = new CurrentAccount();
		while(top < 10) {
			acc1 = curAcc[top];
			if(acc1 != null) {
				System.out.println("Account Holder Name : " + acc1.customerName);
				System.out.println("Account Type : " + acc1.accountType);
				System.out.println("Account Number : " + acc1.accountNumber);
				System.out.println();
			}
			top++;
		}
		SavingsAccount acc2 = new SavingsAccount();
		top = 0;
		while(top < 10) {
			acc2 = savAcc[top];
			if(acc2 != null) {
				System.out.println("Account Holder Name : " + acc2.customerName);
				System.out.println("Account Type : " + acc2.accountType);
				System.out.println("Account Number : " + acc2.accountNumber);
				System.out.println();
			}
			top++;
		}
		
	}
	
	void ComputeInterest(String accountNumber) {
		if(accountNumber.charAt(0) == 'C') {
			System.out.println("Interest cannot be calculated as your account is a Current account");
			System.out.println();
		}
		else {
			int top = 0;
			SavingsAccount acc2 = new SavingsAccount();
			top = 0;
			while(top < 10) {
				acc2 = savAcc[top];
				if(acc2 != null) {
					int interest = acc2.balance*acc2.iRate*10/100;
					acc2.balance = acc2.balance + interest;
					System.out.println("Interest for 10 years is calculated as " + interest + " Rs. and added to the Outstanding Balance");
					System.out.println();
				}
				top++;
			}
		}
	}
	
	void ImposeServiceCharge() {
		int top = 0;
		while(top < 10) {
			CurrentAccount acc1 = curAcc[top];
			if(acc1 != null) {
				if(acc1.balance < acc1.minBal) {
					acc1.balance = acc1.balance - acc1.serCharge;
					System.out.println("Service charge of Rs. " + acc1.serCharge + " was imposed for the account with Account Number " + acc1.accountNumber);
					System.out.println();
				}
				else {
					System.out.println("No Service charge was imposed for the account with Account Number " + acc1.accountNumber);
					System.out.println();
				}
			}
			top++;
		}
	}
}
	
	

public class Question9{
	public static void main(String[] args) throws IOException {
		InputStreamReader is =  new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(is);
		
		ActionsOnAccounts accounts = new ActionsOnAccounts();
		
		boolean next = true;
		
		while(next) {
			System.out.println("Welcome to XYZ bank. What do you want to do?");
			System.out.println("1. Create A New Account\n2. Deposit Amount\n3. View Balance\n4. Compute and Deposit Interest\n"
					+ "5. Permit withdrawal and update balance\n6. View Account Details\n7. Impose Service Charge\n8. Exit");
			
			int input = Integer.parseInt(br.readLine());
			
			switch(input) {
				case 1:
					System.out.println("To Create a New Account, enter the following details");
					System.out.println();
					System.out.println("Enter Customer name");
					String name = br.readLine();
					System.out.println("Enter type of account\n1. Savings\n2. Current");
					int response = Integer.parseInt(br.readLine());
					switch(response) {
						case 1:
							accounts.CreateAccount("Savings", name);
							break;
						case 2:
							accounts.CreateAccount("Current", name);
							break;
					}
					break;
				case 2:
					System.out.println("To Deposit amount, enter the following details");
					System.out.println("Enter Account Number");
					String accNo = br.readLine();
					System.out.println("Enter amount to deposit");
					int amount = Integer.parseInt(br.readLine());
					accounts.DepositAmount(accNo, amount);
					break;
				case 3:
					System.out.println("To View Balance, enter the following details");
					System.out.println("Enter Account Number");
					accNo = br.readLine();
					accounts.DisplayBalance(accNo);
					break;
				case 4:
					System.out.println("Enter the Account Number you want to compute interest for");
					accNo = br.readLine();
					accounts.ComputeInterest(accNo);
					break;
				case 5:
					System.out.println("To Withdraw amount, enter the following details");
					System.out.println("Enter Account Number");
					accNo = br.readLine();
					System.out.println("Enter amount to Withdraw");
					amount = Integer.parseInt(br.readLine());
					accounts.WithdrawAmount(accNo, amount);
					break;
				case 6:
					System.out.println("All the Account Details");
					accounts.DisplayAccountDetails();
					break;
				case 7:
					accounts.ImposeServiceCharge();
					break;
				case 8:
					next = false;
					break;
							
			}
		}		
	}	
}