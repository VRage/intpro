package _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS;

/**
 * Class throws an Exception if DatasetAccessor is not available.
 * @author Dilek R.
 *
 */
public class NoDatasetAccessorException extends Exception {
	
	public NoDatasetAccessorException() { }
	
	public NoDatasetAccessorException(String msg) {
		super(msg);
	}

}
