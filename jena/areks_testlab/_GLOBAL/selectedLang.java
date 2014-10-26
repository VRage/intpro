package _GLOBAL;

import _EXCEPTIONS.GLOBAL_EXCEPTIONS.InvalidLanguageException;

public class selectedLang {	
	private Language selectedLang;
	
	public selectedLang(){
		selectedLang = new enEN();
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
			case 1: selectedLang = new enEN();
					break;
			case 2: selectedLang = new deDE();
					break;
			default: throw new InvalidLanguageException();
		}
	}
	
	public Language getCurrLang(){
		return this.selectedLang;
	}

}
