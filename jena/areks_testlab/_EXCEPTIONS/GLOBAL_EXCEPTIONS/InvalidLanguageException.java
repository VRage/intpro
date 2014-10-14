package _EXCEPTIONS.GLOBAL_EXCEPTIONS;

/**************************************************************
 * InvalidLanguageException
 *
 * Project "Semantic Web"
 *  * Professor:	xxxxxxxxxxxxxx
 *  
 * A not valid language selection throws this error
 * 
 *  Created on: 08.10.2014
 *      Author: Arkadius Pawlak
**************************************************************/

public class InvalidLanguageException extends Exception{
	   //Parameterless Constructor
    public InvalidLanguageException() {}

    //Constructor that accepts a message
    public InvalidLanguageException(String message)
    {
       super(message);
    }

}
