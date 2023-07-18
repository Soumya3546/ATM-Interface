package io.github.soumyasinha.project.atm;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class OptionMenu extends Account{
	Scanner menuInput=new Scanner(System.in);
	DecimalFormat moneyFormat=new DecimalFormat("'$'###,##0.00");
	HashMap<Integer,Integer>data=new HashMap<Integer,Integer>();
	
	public void getLogin() throws IOException{
		int x=1;
		do {
			try {
				data.put(1952102, 3546);
				data.put(1952084, 2208);
				data.put(1952085, 2001);
				data.put(1952090, 2207);
				System.out.println("Welcome to the ATM Project!!!"+"\n");
				System.out.println("Enter your Customer Number: ");
				setCustomerNumber(menuInput.nextInt());
				System.out.println("Enter your PIN Number: ");
				setPinNumber(menuInput.nextInt());
			}
			catch(Exception e) {
				System.out.println("\n"+"Invalid Character(s).Only Numbers."+"\n");
				x=2;
			}
			
			int cn= getCustomerNumber();
			int pn= getPinNumber();
			if(data.containsKey(cn) && data.get(cn)==pn) {
				getAccountType();
			}
			else
				System.out.println("\n"+"Wrong Customer Number or Pin Number "+"\n");
		}while(x==1);
	}
	public void getAccountType() {
		System.out.println("\n" +"Select the Account you want to access: ");
		System.out.println("Type 1 --- Checking Account ");
		System.out.println("Type 2 --- Saving Account ");
		System.out.println("Type 3 --- Exit ");
		
		int selection= menuInput.nextInt();
		switch(selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSaving();
			break;
		case 3:
			System.out.println("\n"+"Thank You for using this ATM , BYE....\n");
			break;
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getAccountType();
		}	
	}
	public void getChecking() {
		System.out.println("\n"+"Checking Account: ");
		System.out.println("Type 1 --- View Balance ");
		System.out.println("Type 2 --- Withdraw Funds ");
		System.out.println("Type 3 --- Deposit Funds ");
		System.out.println("Type 4 --- Exit ");
		
		int selection= menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Checking Account Balance:"+moneyFormat.format(getCheckingBalance()));
			getAccountType();
			break;
		case 2:
			getCheckingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getCheckingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("\n"+"Thank You for using this ATM , BYE....\n");
			break;
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getChecking();
		}	
	}
	public void getSaving() {
		System.out.println("\n"+"Saving Account: ");
		System.out.println("Type 1 --- View Balance ");
		System.out.println("Type 2 --- Withdraw Funds ");
		System.out.println("Type 3 --- Deposit Funds ");
		System.out.println("Type 4 --- Exit ");
		System.out.println("Choice: ");
		
		int selection= menuInput.nextInt();
		switch(selection) {
		case 1:
			System.out.println("Saving Account Balance:"+moneyFormat.format(getSavingBalance()));
			getAccountType();
			break;
		case 2:
			getsavingWithdrawInput();
			getAccountType();
			break;
		case 3:
			getsavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("\n"+"Thank You for using this ATM , BYE....\n");
			break;
		default:
			System.out.println("\n"+"Invalid Choice."+"\n");
			getSaving();
		}	
	}
}

