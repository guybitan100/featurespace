package com.featurespace.app;
import com.featurespace.model.PostcodeStatus;
import com.featurespace.model.PostcodeStatusValidate;
import com.featurespace.model.Result;

import java.util.Scanner;

public class FTT
{

	public FTT()
	{
		readInput();
	}

	public static void main(String args[])
	{
		FTT application = new FTT();

	}

	private void readInput()
	{
		Scanner sc = new Scanner(System.in);
		String selected = "";
		while (!selected.equals("q"))
		{
			showMenu();
			String postCode = sc.nextLine().trim();
			manageQueries(postCode);
		}
		System.exit(1);
	}

	private void showMenu()
	{
		System.out.println("");
		System.out.print("Please Enter you POSTCODE: ");
	}

	public void manageQueries(String postCodeString)
	{
		Postcode postcode = new Postcode(postCodeString);
		PostcodeStatusValidate psv = postcode.validate();
		if (psv.getResult())
		{
			PostcodeStatus postcodeStatus = postcode.getDetails();
			Result result = postcodeStatus.getResult();
			System.out.println("");
			System.out.println("Region: " + result.getRegion());
			System.out.println("Country: " + result.getCountry());
			Result[] results = postcode.getNearest().getResult();
			for (Result res : results)
			{
				System.out.println("");
				System.out.println("Nearest");
				System.out.println("Postcode: " + res.getPostcode());
				System.out.println("Region: " + res.getRegion());
				System.out.println("Country: " + res.getCountry());
			}

		}
		else
		{
			System.out.println("");
			System.out.println("Invalid Postcode please enter again!!!");
		}
	}
}
