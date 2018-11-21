/*
 * SortedIntegerList.java
 * @author Frank Hildesheim, Leipzig 2018 (c), <FrankHildesheim@mail.ru>
 * Last change: 2018 Oct 29
 * ==================================================================================================================================================
 */

import java.util.Collection;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;


//===================================================================================================================================================
// Klasse 'SortedStringList'
//===================================================================================================================================================
public class SortedIntegerList extends HashMap<Integer, String> {
	//
	private static final long serialVersionUID = 1L;
	
	
	//===============================================================================================================================================
	// Konstruktor
	//===============================================================================================================================================
	public SortedIntegerList() {
		super();
	}
	
	
	//===============================================================================================================================================
	// Methode 'values'
	//===============================================================================================================================================
        @Override
	public Collection<String> values() {
		// New SortedMap
		SortedMap<Integer, String> sortedValues = new TreeMap<>(this);
		// Return Values
		return (sortedValues.values());
	}
}
//
// End SortedIntegerList.java
//