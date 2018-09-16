package demos;

import java.util.List;

public class DateReaders {

	public static void main(String[] args) {
		readXLS();

	}
	public static void readCSV()
	{
		String filename = "/Users/enkhbattulga/Documents/software/UserAccounts.csv";
		List<String[]> records = utilities.CSV.get(filename);
		
		//Iterating through list
		for(String[] record: records)
		{
			for(String field: record)
			{
				System.out.println(field);
			}
		}
	}
	public static void readXLS()
	{
		String filename = "/Users/enkhbattulga/Documents/software/UserLogin.xls";
		String [][] data = utilities.Excel.get(filename);
		for(String[] record : data)
		{
			System.out.println("\nNewRecord");
			System.out.println(record[0]);
			System.out.println(record[1]);
			System.out.println(record[2]);
		}
	}
}
