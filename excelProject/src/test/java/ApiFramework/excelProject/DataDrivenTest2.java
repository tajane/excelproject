package ApiFramework.excelProject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDrivenTest2 
{

	public static ArrayList<String> getData(String testcasesname) throws IOException 
	{

		//identify testcase column by scanning the entired first row 
		//once testcases column identify then scan entired test cases column to identify purchase testcase  row
		// after you get purchase row then pull  all data from that row feed into test	
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		FileInputStream fileInput = new FileInputStream("D:\\nitin data\\learn api testing\\Rest Assured API TESTING\\testdata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInput);
		int sheetcount = workbook.getNumberOfSheets();
		for (int i = 0; i < sheetcount; i++) 
		{
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) 
			{	
				XSSFSheet sheet = workbook.getSheetAt(i);
				//identify testcase column by scanning the entired first row
				
				Iterator<Row> row = sheet.iterator(); // sheet is collection of rows
				// this above line iterate each row from sheet means we scan each row
				Row firstrow = row.next();   // this step accessing first row from sheet if we add one more step then we can access to second row
				
				// from above line we are on first row 
				// next line we have get(iterate) all value from same row and iterate column wise
				Iterator<Cell> cell = firstrow.cellIterator(); // row is collection of cells
				
				//we require this two variable to identify on which column testcase title present
				// under while loop, when if condition match with testcase title then we got column number
				int r=0;
				int column = 0;
				while (cell.hasNext()) // hasnext checking if next cell present or not, if present then return true otherwise false
				{
					Cell value = cell.next();
					// this line moving to next cell r use to define column  value not for increment the cell index
					
					//below line printing each cell value 
					System.out.println(value.getStringCellValue());
					System.out.println("value of r is " + r);
					
					if (value.getStringCellValue().equalsIgnoreCase("testcase")) 
					{
						System.out.println("desired column get");
						column=r;
						
					}
					
					r++;  // this r value increment till the cell value present (hasnext is true)
					// you can break this increment if condition when if condition true 
				}
				System.out.println("column number is = " + column);
				
				
				
				while (row.hasNext()) 
				{
					Row newr = row.next();
					
					if (newr.getCell(column).getStringCellValue().equalsIgnoreCase(testcasesname)) 
					{
						 Iterator<Cell> newcell = newr.iterator();
						 while (newcell.hasNext()) 
						 {
							 // hadling datatype wrapper to hadle integer and string data from excel file 
							 String cellvalues = null;
							 Cell cell2 = newcell.next();
							 if (cell2.getCellTypeEnum()==CellType.STRING) 
							 {
								cellvalues =  cell2.getStringCellValue();
							 }else 
							 {
								 String convetedvalue = NumberToTextConverter.toText(cell2.getNumericCellValue());
								 cellvalues =  convetedvalue;
							 }
									 
							
							
							arrayList.add(cellvalues);
						}
					}
					
				}
				return	arrayList;
			}
		}
		return arrayList;
	}

	
	public static void main(String[] args) throws IOException 
	{
		ArrayList getdata = getData("purchase");
		System.out.println(getdata.get(0));
		System.out.println(getdata.get(1));
		System.out.println(getdata.get(2));
		System.out.println(getdata.get(3));
		

	}
}
