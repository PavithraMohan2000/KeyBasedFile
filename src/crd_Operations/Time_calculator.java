package crd_Operations;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Time_calculator {
	public long lifespan_Calculator(String dataEntryDate,String CurrentDate)
	{
		 SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		 try 
		 {
		       Date EntryDate = myFormat.parse(dataEntryDate);
		       Date PresentDate = myFormat.parse(CurrentDate);
		       long difference = PresentDate.getTime() - EntryDate.getTime();
		       long daysBetween = (difference / (1000*60*60*24));
	          return daysBetween;
		 } 
		 catch (Exception e) 
		 {
			 System.out.println("AN ERROR OCCURED");
		       e.printStackTrace();
		 }
		 return 0;
	  }
	}
