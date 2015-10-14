package routines;

import java.util.Date;
import java.lang.reflect.*;

/*
 * user specification: the function's comment should contain keys as follows: 1. write about the function's comment.but
 * it must be before the "{talendTypes}" key.
 * 
 * 2. {talendTypes} 's value must be talend Type, it is required . its value should be one of: String, char | Character,
 * long | Long, int | Integer, boolean | Boolean, byte | Byte, Date, double | Double, float | Float, Object, short |
 * Short
 * 
 * 3. {Category} define a category for the Function. it is required. its value is user-defined .
 * 
 * 4. {param} 's format is: {param} <type>[(<default value or closed list values>)] <name>[ : <comment>]
 * 
 * <type> 's value should be one of: string, int, list, double, object, boolean, long, char, date. <name>'s value is the
 * Function's parameter name. the {param} is optional. so if you the Function without the parameters. the {param} don't
 * added. you can have many parameters for the Function.
 * 
 * 5. {example} gives a example for the Function. it is optional.
 */
public class rowcompare {

	// inner class
	static class ReflectionUtils {
		
		public static Object getField(Object obj, String fieldName) {
	        Object returnValue = null;

	        try {
	        	if ( obj != null && fieldName != null )
	        	{
		        	Class<? extends Object> c = obj.getClass();
		        	Field f = c.getField(fieldName);
		        	
		        	returnValue = f.get(obj);
	        	}
	        }
	        catch (Exception e) {
	            // Do nothing, method returns null
	        	System.out.println("    getField: exception=" + e.getClass().toString() + ", message=" + e.getMessage() ); 
	        }

	        return returnValue;
	    }
	} 
	   
    /**
     * NamesMatch: check if "Name" attributes from the two rows match.
     * 
     * {Category} User Defined
     *
     * {param} row(null) input: Row from the actual excel file.
     * {param} row(null) input: Row from the expected excel file.
     * 
     */
	
    /*public static boolean NamesMatch(Object r1, Object r2){
    	Date d = null;
    	return true;
    }*/
	
   
    public static boolean NamesAndDatesMatch(Object r1, Object r2){
    	
    	boolean result = false;
    	
    	String s1 = null;
    	String s2 = null;
    	Date d1 = null;
    	Date d2 = null;

		try{
	    	s1 = (String)ReflectionUtils.getField(r1, "name");
	    	s2 = (String)ReflectionUtils.getField(r2, "name");
	    	d1 = (Date)ReflectionUtils.getField(r1, "date");
	    	d2 = (Date)ReflectionUtils.getField(r2, "date");
	    	
	    	if ( s1 != null && s2 != null && d1 != null && d2 != null)
    		{
    			result =  s1.equals(s2) && d1.equals(d2);
    		}
    	}
    	catch( Exception e)
    	{ 
    		// result = false;
        	System.out.println("NamesAndDatesMatch: exception=" + e.getClass().toString() + ", message=" + e.getMessage() ); 
    	}
    	
    	return result;
    }
}
