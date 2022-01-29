package hw07;
/* Name: Jonathan Diaz
 * Class: CS-2013
 * Section(s): 03 & 04
 * Description: This class is meant to be an exception to see if a value is duplicated
 * Other Comments: 
 */
public class DuplicateItemException extends Exception{
	public DuplicateItemException(String msg) {
		super(msg);
	}
}
