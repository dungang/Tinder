package cn.tinder.das.exception;

public class BasicException  extends RuntimeException {
		public BasicException(){
			super();
		}
		public BasicException(String message, Throwable cause,
				boolean enableSuppression, boolean writableStackTrace)
		{
			//super(message, cause, enableSuppression, writableStackTrace);
		}

		public BasicException(String message, Throwable cause)
		{
			super(message, cause);
		}

		public BasicException(String message)
		{
			super(message);
		}

		public BasicException(Throwable cause)
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

