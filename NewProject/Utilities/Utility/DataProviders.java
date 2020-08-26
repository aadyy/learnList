package Utility;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();

	@DataProvider(name = "NewProjectExel")
	public Object[][] getdata() {
		// Totals rows count
		int rows = obj.getRowCount("NewProjectExel");
		// Total Columns
		int column = obj.getColumnCount("NewProjectExel");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}
		
	}
	
	
