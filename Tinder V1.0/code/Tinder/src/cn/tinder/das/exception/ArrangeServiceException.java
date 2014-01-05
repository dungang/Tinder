package cn.tinder.das.exception;

public class ArrangeServiceException extends RuntimeException {
	public ArrangeServiceException(){
		super();
	}
	public ArrangeServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		//super(message, cause, enableSuppression, writableStackTrace);
	}

	public ArrangeServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ArrangeServiceException(String message)
	{
		super(message);
	}

	public ArrangeServiceException(Throwable cause)
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
