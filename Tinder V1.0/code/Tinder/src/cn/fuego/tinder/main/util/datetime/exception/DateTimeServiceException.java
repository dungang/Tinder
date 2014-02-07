package cn.fuego.tinder.main.util.datetime.exception;


public class DateTimeServiceException extends RuntimeException
{
	/**
	 * 
	 */

	public DateTimeServiceException()
	{
		super();
	}

	public DateTimeServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		// super(message, cause, enableSuppression, writableStackTrace);
	}

	public DateTimeServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DateTimeServiceException(String message)
	{
		super(message);
	}

	public DateTimeServiceException(Throwable cause)
	{
		super(cause);
	}

	@Override
	public String toString()
	{
		String message = getLocalizedMessage();
		return (message != null) ? (message) : "";

	}
}
