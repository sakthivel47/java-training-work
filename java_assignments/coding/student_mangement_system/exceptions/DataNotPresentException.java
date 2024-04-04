package studentmanagementsystem.exceptions;

public class DataNotPresentException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataNotPresentException() {

	}
	
	public DataNotPresentException(String message) {
		super(message);
	}

	public DataNotPresentException(Throwable cause) {
		super(cause);
	}
	
	public DataNotPresentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotPresentException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
