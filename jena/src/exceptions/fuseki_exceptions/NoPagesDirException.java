package exceptions.fuseki_exceptions;
/**
 * Class throws an exception if page directory path is wrong.
 * @author Dilek R.
 *
 */
public class NoPagesDirException extends Exception{
	
	public NoPagesDirException() {}
	
	public NoPagesDirException(String msg) {
		super(msg);
	}

}
