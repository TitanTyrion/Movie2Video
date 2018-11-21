/*
 * SortedStringList.java
 * @author Frank Hildesheim, Leipzig 2013, 2014, 2015, 2016, 2017, 2018 (c), <FrankHildesheim@mail.ru>
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
public class SortedStringList extends HashMap<String, String> {
	//
	private static final long serialVersionUID = 1L;
	
	
	//===========================================================================================================================================
	// Konstruktor
	//===========================================================================================================================================
	public SortedStringList() {
		super();
	}
	
	
	//===========================================================================================================================================
	// Methode 'values'
	//===========================================================================================================================================
        @Override
	public Collection<String> values() {
		// New SortedMap
		SortedMap<String, String> sortedValues = new TreeMap<>(this);
		// Return Values
		return (sortedValues.values());
	}
}
//
// End SortedStringList.java
//