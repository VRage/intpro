package _GLOBAL;

import _EXCEPTIONS.GLOBAL_EXCEPTIONS.InvalidLanguageException;

public class currLANG {	
	private Language currLang;
	
	public currLANG(){
		currLang = new enEN();
		try {
			setLANG(1);
		} catch (InvalidLanguageException e) {
			// there are no errors, it's just an illusion!
		}
	}
	
	
	public void setLANG(int lang) throws InvalidLanguageException{
		/** possible languagepacks insert here 
		 * 1 > english
		 * 2 > german
		 * **/
		switch (lang){
			case 1: currLang = new enEN();
					break;
			case 2: currLang = new deDE();
					break;
			default: throw new InvalidLanguageException();
		}
	}
	
	public Language getCurrLang(){
		return this.currLang;
	}

}
