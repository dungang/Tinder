package cn.tinder.das.exception;

public class checkOutException extends RuntimeException {
	public checkOutException(){
		super();
	}
	public checkOutException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		//super(message, cause, enableSuppression, writableStackTrace);
	}

	public checkOutException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public checkOutException(String message)
	{
		super(message);
	}

	public checkOutException(Throwable cause)
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

