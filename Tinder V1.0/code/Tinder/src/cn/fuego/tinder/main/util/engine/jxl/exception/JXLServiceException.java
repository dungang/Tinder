package cn.fuego.tinder.main.util.engine.jxl.exception;

public class JXLServiceException extends RuntimeException
{
	/**
	 * 
	 */

	public JXLServiceException()
	{
		super();
	}

	public JXLServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		// super(message, cause, enableSuppression, writableStackTrace);
	}

	public JXLServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public JXLServiceException(String message)
	{
		super(message);
	}

	public JXLServiceException(Throwable cause)
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
