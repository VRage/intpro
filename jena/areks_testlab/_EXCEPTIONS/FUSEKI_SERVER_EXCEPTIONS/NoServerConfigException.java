package _EXCEPTIONS.FUSEKI_SERVER_EXCEPTIONS;
/**
 * Class throws an exception if server configuration file is not available or not correctly configured.
 * @author Dilek R.
 *
 */
public class NoServerConfigException extends Exception{
	
	public NoServerConfigException() {}
	
	public NoServerConfigException(String msg) {
		super(msg);
	}
	
	
}
