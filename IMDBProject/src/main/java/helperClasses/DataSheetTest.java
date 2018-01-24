package helperClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.extensions.XSSFCellFill;
import org.testng.annotations.DataProvider;

public class DataSheetTest {

	public static XSSFWorkbook ExcelWBook;
	public static XSSFSheet ExcelWSheet;
	public static XSSFCell Cell;
	private String sTestCaseName;
	private int iTestCaseRow;

	public static void setExcelFile(String Path,String SheetName) throws Exception {

		try {


			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e){

			throw (e);

		}

	}

	public static String getData(int RowNum,int ColNum) throws Exception{
		Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		@SuppressWarnings("deprecation")
		int dataType = Cell.getCellType();

		if  (dataType == 3) {

			return "";

		}else{

			String CellData = Cell.getStringCellValue();

			return CellData;
		}
	}
	public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

		Object[][] tabArray = null;


		FileInputStream ExcelFile = new FileInputStream(FilePath);
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(SheetName);
		int startRow = 1; 
		int startCol = 0;
		int totalRows = ExcelWSheet.getLastRowNum();
		int totalCols = 4;

		tabArray=new Object[totalRows][totalCols];


		for (int i=startRow;i<=totalRows;i++) {           	   
			for (int j=startCol;j<=totalCols-1;j++){

				tabArray[i-1][j]=getData(i,j);
			}
		}
		return tabArray;


	}
	/*public static int getRowUsed() throws Exception {

		try{

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		}catch (Exception e){

			System.out.println(e.getMessage());

			throw (e);
		}
	}*/
/*	public static int getRowContains(String sTestCaseName, int colNum) throws Exception{

		int i;

		try {

			int rowCount = DataSheetTest.getRowUsed();

			for ( i=0 ; i<rowCount; i++){

				if  (DataSheetTest.getData(i,colNum).equalsIgnoreCase(sTestCaseName)){

					break;

				}

			}

			return i;

		}catch (Exception e){

			throw(e);

		}

	}*/

	/*public static String getTestCaseName(String sTestCase)throws Exception{

		String value = sTestCase;

		try{

			int posi = value.indexOf("@");

			value = value.substring(0, posi);

			posi = value.lastIndexOf(".");	

			value = value.substring(posi + 1);

			return value;

		}catch (Exception e){

			throw (e);
		}
}*/
@DataProvider(name="userData")
public Object[][] Authentication() throws Exception{


	 	DataSheetTest.setExcelFile("C:\\Users\\shapandit\\git\\IMDBProject\\IMDBdataSheet.xlsx","Sheet1");

//	 	sTestCaseName = this.toString();
//	  	sTestCaseName = DataSheetTest.getTestCaseName(this.toString());
//	 	iTestCaseRow = DataSheetTest.getRowContains(sTestCaseName,0);

	    Object[][] testObjArray = DataSheetTest.getTableArray(".//IMDBdataSheet.xlsx","Sheet1");

	    	return (testObjArray);

		}

}
