package _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS;
/**
 * Class throws an exception if DatasetGraph is not available.
 * @author Dilek R.
 *
 */
public class NoDatasetGraphException extends Exception{
	
	public NoDatasetGraphException() {}
	
	public NoDatasetGraphException(String msg) {
		super(msg);
	}

}
