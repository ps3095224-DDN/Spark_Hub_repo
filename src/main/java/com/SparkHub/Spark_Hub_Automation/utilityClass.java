package com.SparkHub.Spark_Hub_Automation;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class utilityClass {
	
	public String getStartDate() {
        // Desired date format
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        // Get today's date
        Calendar cal = Calendar.getInstance();

        // ---- START DATE: 15 days after current date ----
        cal.add(Calendar.DAY_OF_MONTH, 15);
        String startDate = sdf.format(cal.getTime());
		return startDate;
  
    }


public String getEndDate() {
	
    // Desired date format
    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

    // Get today's date
    Calendar cal = Calendar.getInstance();

    // ---- START DATE: 15 days after current date ----
    cal.add(Calendar.DAY_OF_MONTH, 15);
    String startDate = sdf.format(cal.getTime());
    
    cal.add(Calendar.MONTH, 1);
    String endDate = sdf.format(cal.getTime());
	return endDate;
    
}
}
