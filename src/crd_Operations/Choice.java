package crd_Operations;
import java.io.File;
import java.io.IOException;
import java.util.*;
	public class Choice {
		//CODE TO CHECK THE EXISTANCE OF THE FILE
		static int file_existance(String filename)
		{
			File file=new File(filename);
			if(file.exists())
			{
				return 1;
			}
			return 0;
		}
		//CODE TO CREATE A NEW FILE
		static void createfile(String filename)
		{
			try
			{
				
				if(file_existance(filename)==0)
				{
					File file=new File(filename);
					file.createNewFile();
					System.out.println("A NEW FILE WITH NAME - "+filename+" IS CREATED");
				}
				else
				{
					System.out.println("FILE WITH THIS NAME ALREADY EXIST, PLEASE TRY NEW NAME");
				}
			}
			catch(IOException e)
			{
				System.out.println("An error occured");
				e.printStackTrace();
			}
		}
		
		//CODE TO CREATE FILE AND ADD DATA TO IT
		static void create() throws IOException
		{
			Scanner data=new Scanner(System.in);
			System.out.println("ENTER THE NAME OF THE FILE");
			String filename=data.next();
			createfile(filename);
			System.out.println("ENTER THE KEY AND VALUE SEPERATED BY SPACE TO ADD TO THE FILE");
			String key="";
			String value="";
			while((key=data.next())!=null)
			{
			value=data.next();
			System.out.println("IF YOU WISH TO ADD THE LIFE TIME ENTER 1 AND THEN ENTER THE CURRENT DATE IN THE FORMAT DD/MM/YYY AND THE LIFE TIME IN DAYS ELSE ENTER 0");
			int flag=data.nextInt();
			if(flag==0)
			{
				Operations object=new Operations(key,value);
				object.add_data(filename);
			}
			else
			{
				String current_date=data.next();
				int lifetime=data.nextInt();
				Operations object=new Operations(key,value,current_date,lifetime);
				object.add_data(filename,flag);
			}
				
			}	
		}
		//TO READ THE VALUE FROM THE FILE
		static void read()
		{
			try (Scanner data = new Scanner(System.in)) {
				System.out.println("ENTER THE NAME OF THE FILE IN WHICH YOU WISH TO READ DATA");
				String filename=data.next();
				if(file_existance(filename)==1)
				{
					System.out.println("THE FILE IS FOUND\n ENTER THE KEY TO FIND THE VALUE FROM THE FILE");
					String key=data.next();
					Operations object=new Operations(key);
					object.read_value(filename);
				}
				else
				{
					System.out.println("CREATE A FILE TO ADD DATA");
				}
			}
		}
		//TO DELETE THE VALUE
		static void delete()
		{
			try (Scanner data = new Scanner(System.in)) {
				System.out.println("ENTER THE FILE IN WHICH YOU WISH TO DELETE THE DATA");
				String filename=data.next();
				if(file_existance(filename)==1)
				{
					System.out.println("THE FILE IS FOUND\n ENTER THE KEY TO DELETE THE VALUE FROM THE FILE");
					String key=data.next();
					Operations object=new Operations(key);
					object.delete_value(filename);
				}
				else
				{
					System.out.println("CREATE A FILE TO ADD DATA");
				}
			}
		}
	}
	
