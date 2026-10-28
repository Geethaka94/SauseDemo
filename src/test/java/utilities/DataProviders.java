package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = "./testData/LoginData.xlsx";
		ExcelUtility xlutil = new ExcelUtility(path);

		int tot_rows = xlutil.getRowCount("Sheet1");
		int tot_colms = xlutil.getCellCount("Sheet1", 1);

		String logindata[][] = new String[tot_rows][tot_colms];

		for (int i = 1; i <= tot_rows; i++) {
			for (int j = 0; j < tot_colms; j++) {
				logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		return logindata;
	}

}
