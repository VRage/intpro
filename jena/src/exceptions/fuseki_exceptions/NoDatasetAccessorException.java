package exceptions.fuseki_exceptions;

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
