package com.SparkHub.Spark_Hub_Automation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
	
	public String getStartDate() {
        // Desired date format
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

        // Get today's date
        Calendar cal = Calendar.getInstance();

        // ---- START DATE: 15 days after current date ----
        cal.add(Calendar.DAY_OF_MONTH, 15);
        String startDate = sdf.format(cal.getTime());
		return startDate;
  
    }


public String getEndDate() {
	
    // Desired date format
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");

    Calendar cal = Calendar.getInstance();
    // ---- End DATE: 1 month after start date ----
    
    cal.add(Calendar.DAY_OF_MONTH, 45);
    String endDate = sdf.format(cal.getTime());
	return endDate;
    
}
}
