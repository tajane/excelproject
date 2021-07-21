package ApiFramework.excelProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PracticeDataDrive 
{

	public static ArrayList<String> getData(String sheetname,String testcasename) throws IOException 
	{
	
		ArrayList<String> arrayList = new ArrayList<String>();
		
		FileInputStream fileInputStream = new FileInputStream("D:\\nitin data\\learn api testing\\Rest Assured API TESTING\\testdata.xlsx");

		  XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		  
		  int numberofsheet = workbook.getNumberOfSheets();
		  
		  for (int i = 0; i < numberofsheet; i++) 
		  {
			 if(workbook.getSheetName(i).equalsIgnoreCase(sheetname))
			 {
				 XSSFSheet sheet = workbook.getSheetAt(i);
				 
				 Iterator<Row> row = sheet.iterator();
				 
				 Row firstrow = row.next();
				 
				 Iterator<Cell> firstrowcells = firstrow.iterator();
				 
				 int a = 0;
				 
				 int column = 0;
			
				 while (firstrowcells.hasNext()) 
				 {
					Cell column2 = firstrowcells.next();
					
					System.out.println("header contains is : " + column2.getStringCellValue()); 
					
					if (column2.getStringCellValue().equalsIgnoreCase("testcase"))
					{
						column=a;
					}
					
					a++;
				 }
				 
				while (row.hasNext()) 
				{
					Row row2 = row.next();
					
					if (row2.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)) 
					{
						Iterator<Cell> cellvalue = row2.iterator();
						
						while (cellvalue.hasNext()) 
						{
							Cell cell3 = cellvalue.next();
							
							switch (cell3.getCellType()) 
							{
							case NUMERIC:
								arrayList.add(NumberToTextConverter.toText(cell3.getNumericCellValue()));
								break;
							case STRING:
								arrayList.add(cell3.getStringCellValue());
								break;							
							}
							
							// below is alternate code for wrapping datatype of cell value
							
							/*if (cell3.getCellTypeEnum()==CellType.STRING) 
							{
								arrayList.add(cell3.getStringCellValue());
							} else 
							{
								arrayList.add(NumberToTextConverter.toText(cell3.getNumericCellValue()));
							}*/							
						}
					}					
				}	 				 
			 }			  
	      } 		  
	return arrayList;
	}
	
	public static void main(String[] args) throws IOException 
	{
	
	  ArrayList<String> alldata = getData("testdata","purchase");
	  System.out.println(alldata.get(0));
	  System.out.println(alldata.get(1));
	  System.out.println(alldata.get(2));
	  System.out.println(alldata.get(3));
	}

}
