package utilities;
/*
 * Author name- Harsh Mishra(908330)
 * Date-20/04/2021
 * Description- This class is used for setting up of the excel file, reading and writing data to it.
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Excelutilities {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWbook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    static WebDriver driver;
   public static String xlFilepath="D:\\WORKSPACE\\MiniProject-Alaska-Cruises\\Testdata\\TestData.xlsx";
    
    //Method to set the file path and open the Excel file, Pass Excel Path and SheetName as Arguments to this method
    
    public static void setExcelFile(String Path,String SheetName)  {
    	try{
    		//Opening the Excel File
    		FileInputStream ExcelFile=new FileInputStream(Path);
    		//Accessing the required test data sheet
    		ExcelWbook=new org.apache.poi.xssf.usermodel.XSSFWorkbook(ExcelFile);
    		ExcelWSheet=ExcelWbook.getSheet(SheetName);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
  //Method to read the test data from the Excel cell, passing parameters as RowNum and ColNum
    
    public static String getCellData(int RowNum, int ColNum){

    try{

      Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
      String CellData = Cell.getStringCellValue();//extracting the value present at the cell in the file
      return CellData;
      }catch (Exception e){

       return"";
       }
     }
    //Method to write in the Excel cell, Where RowNum and ColNum are the parameters
    
    public static void setCellData(String Result,  int RowNum, int ColNum)  {
    try{
         Row  = ExcelWSheet.getRow(RowNum);
         Cell = Row.getCell(ColNum, MissingCellPolicy.RETURN_BLANK_AS_NULL);

          if (Cell == null)//checking whether the cell is empty or not
        	  {
              Cell = Row.createCell(ColNum);    
              Cell.setCellValue(Result);//writing the data in the cell value of the file    
               } else {    
       Cell.setCellValue(Result);
         }
      // Constant variables Test Data path and Test Data file name    
 FileOutputStream fileOut = new FileOutputStream(xlFilepath);
 ExcelWbook.write(fileOut);
 fileOut.flush();
 fileOut.close();

      }catch(Exception e){
          
          e.printStackTrace();
      }
    

}
}
