package crd_Operations;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;
	import java.io.*;
	public class Operations {
		String key;
		String value="";
		String current_date="";
		int lifetime=0;
		public Operations(String key) {
			super();
			this.key = key;
		}
		public Operations(String key, String value) {
			super();
			this.key = key;
			this.value = value;
		}
		public Operations(String key, String value,String current_date,int lifetime) {
			super();
			this.key = key;
			this.value = value;
			this.current_date=current_date;
			this.lifetime=lifetime;
		}
		public void add_data(String filename) throws IOException
		{
			File file = new File(filename);
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			int result=read_value(filename);
			if(result==0)
			{
			br.write(key);
			br.write(":");
			br.write(value);
			br.newLine();
			br.close();
			fr.close();
			}
			else
				System.out.println("THE KEY VALUE EXISTS");
		}
		public void add_data(String filename,int flag) throws IOException
		{
			File file = new File(filename);
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);
			int result=read_value(filename);
			if(result==0)
			{
			br.write(key);
			br.write(":");
			br.write(value);
			br.write(":");
			br.write(current_date);
			br.write(":");
			br.write(String.valueOf(lifetime));
			br.newLine();
			br.close();
			fr.close();
			}
			else
				System.out.println("THE KEY VALUE EXISTS");
		}
		public int read_value(String filename)
		{
			int flag=0;
			try  
			{  
			
			File file=new File(filename);    
			FileReader fr=new FileReader(file);   
			BufferedReader br=new BufferedReader(fr); 
			String line;  
			
			while((line=br.readLine())!=null)  
			{  
			String[] data=line.split(":");
			if(data[0].equals(key))
			{
				flag=1;
				if(data.length>2)
				{
					System.out.println("ENTER THE CURRENT DATE INT THE FORMAT DD/MM/YYYY");
					Scanner input=new Scanner(System.in);
					String currentDate=input.next();
					Time_calculator object2=new Time_calculator();
					long result=object2.lifespan_Calculator(data[2],currentDate);
					long life=Integer.parseInt(data[3]);
					int final_result=(int)(result-life);
					
					if(final_result>(float)(0))
					{
						System.out.println("THE LIFE SPAN OF THE DATA HAS END ");
						delete_value(filename);
						break;
					}
				}
				System.out.println(data[1]);
				break;
			}
			else
			{
				System.out.println("THE KEY IS NOT FOUND");
			}
			}  
			fr.close();    //closes the stream and release the resources  
			 
			}  
			catch(IOException e)  
			{  
				System.out.println("AN ERROR OCCURED");
			e.printStackTrace();  
			}  
			return flag;
		}
		public void delete_value(String filename)
		{
			try { 
	            File file = new File(filename); 
	            RandomAccessFile raf = new RandomAccessFile(file, "rw"); 
	            boolean found = false; 
	            while (raf.getFilePointer() < raf.length()) 
	            { 
	  
	                String line = raf.readLine(); 
	                String[] temp=line.split(":");
	                if (temp[0].equals(key))//== newName) 
	                	{ 
	                    found = true; 
	                    break; 
	                	} 
	            } 
	            if (found == true) 
	            { 
	  
	                File tmpFile = new File("temp.txt"); 
	                RandomAccessFile tmpraf = new RandomAccessFile(tmpFile, "rw"); 
	                raf.seek(0); 
	                while (raf.getFilePointer() < raf.length()) 
	                { 
	                    String line= raf.readLine(); 
	                    String[] temp=line.split(":");
	                    if (temp[0].equals(key)) 
	                    { 
	                        continue; 
	                    } 
	                    tmpraf.writeBytes(line); 
	                    tmpraf.writeBytes(System.lineSeparator()); 
	                } 
	                raf.seek(0); 
	                tmpraf.seek(0); 
	                while (tmpraf.getFilePointer() < tmpraf.length()) { 
	                    raf.writeBytes(tmpraf.readLine()); 
	                    raf.writeBytes(System.lineSeparator()); 
	                } 
	                raf.setLength(tmpraf.length());
	                tmpraf.close(); 
	                raf.close(); 
	                tmpFile.delete(); 
	  
	                System.out.println("DATA DELETED"); 
	            } 
	            else 
	            { 
	                raf.close(); 
	                System.out.println(" INPUT KEY "+key+" DOES NOT EXIST "); 
	            } 
	        } 
	  
	        catch (IOException ioe) { 
	            System.out.println(ioe); 
	        } 
		}
	}
