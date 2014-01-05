package cn.tinder.das.exception;



public class LoginException extends RuntimeException
{
	public LoginException()
	{
		super();
	}

	public LoginException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		//super(message, cause, enableSuppression, writableStackTrace);
	}

	public LoginException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public LoginException(String message)
	{
		super(message);
	}

	public LoginException(Throwable cause)
	{
		super(cause);
	}
    
	@Override
	public String toString()
	{
		String message = getLocalizedMessage();
	    return (message != null) ? (message) : "";
		//return "LoginException [toString()=" + super.toString() + "]";
	}

	private static final long serialVersionUID = 1L;

}