package com.sun.tranquilo.datatype.datetime;

public class TimeZone
{
	/** difference from GMT in terms of minutes */
	public int minutes;
	
	public static TimeZone GMT			= new TimeZone(0);
	
	private TimeZone( int minutes )
	{
		// value must be within -14:00 and 14:00
		if( minutes<-14*60 || minutes>14*60 )
			throw new IllegalArgumentException();
		
		this.minutes = minutes;
	}
	
	public static TimeZone create( int minutes )
	{
		if(minutes==0)		return GMT;
		else				return new TimeZone(minutes);
	}
	
	public int hashCode()	{ return minutes; }
	public boolean equals( Object o ) 
	{
		return ((TimeZone)o).minutes==this.minutes;
	}
}