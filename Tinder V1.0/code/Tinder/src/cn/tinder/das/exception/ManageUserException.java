package cn.tinder.das.exception;

public class ManageUserException extends RuntimeException {
	public ManageUserException(){
		super();
	}
	public ManageUserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		//super(message, cause, enableSuppression, writableStackTrace);
	}

	public ManageUserException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ManageUserException(String message)
	{
		super(message);
	}

	public ManageUserException(Throwable cause)
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
