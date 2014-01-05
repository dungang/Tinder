package cn.tinder.das.exception;

public class DaoException extends RuntimeException {
	DaoException(){
		super();
	}
	public DaoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace)
	{
		//super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public DaoException(String message)
	{
		super(message);
	}

	public DaoException(Throwable cause)
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
