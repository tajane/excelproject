package resources;

import java.util.Scanner;

public class Sampletest 
{
	
	public static void arryTest() 
	{
		int[] a = {1,5,7,3,8,9,4,2,6,8};
		int[] b =a;
		
		int c= 0;
		int countofsum = 0 ;
		for (int i = 0; i < a.length; i++) 
		{			
			for (int j = 1; j < b.length; j++) 
			{
				c = a[i] + b[j];
				int additionoffirsttwoindex = a[0] + b[1];
				
				if (c==additionoffirsttwoindex) 
				{
					countofsum++;
				}
			}	
			
		}
		System.out.println("addition of two pair is " + countofsum);
		
		
	}

	
	public static void test23()
	{
		int a = 1;
		int b=2;
		int r =0;
		for (int i = 0; i < 5; i++) 
		{
			for(int j = 0; j <= i; j++) 
			{
				
				System.out.print(r+" ");
				r++;
				
			}
			System.out.println();
			
		}
	}
	


	public static void name3() 
	{
	
		Scanner sc = new Scanner(System.in);        

        System.out.println("How many rows you want in this pattern?");         

        int rows = sc.nextInt();   
        
        int z = rows;

        System.out.println("Here is your pattern….!!!");         

        for (int i = 1; i <= rows; i++) 

        {
            for (int j = 1; j <= i; j++)
            	           	
            {
            
                System.out.print(z+" ");              
            } 
           
            z-=1;
            
            System.out.println();
            
        }         

        //Close the resources         

        sc.close();

    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		test23();
	}

}
