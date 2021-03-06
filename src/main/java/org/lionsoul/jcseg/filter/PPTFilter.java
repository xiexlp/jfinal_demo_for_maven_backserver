package org.lionsoul.jcseg.filter;

import java.util.HashMap;
import java.util.Map;

/**
 * a class to deal with the text bettween the pair punctuations.  
 * 
 * @author	chenxin 
 */
public class PPTFilter {
	
	private static final Character[] PAIR_PUNCTUATION = {
		/*'“', '”', '‘', '’',*/ '《', '》', '『', '』', '【', '】'};
	
	private static Map<Character, Character> pairPunctuation = null;
	
	static {
		pairPunctuation = new HashMap<Character, Character>( 
				( int )(PAIR_PUNCTUATION.length / 1.7) + 1, 0.85f);
		for ( int j = 0; j < PAIR_PUNCTUATION.length; j += 2 )
			pairPunctuation.put(PAIR_PUNCTUATION[j], PAIR_PUNCTUATION[j+1]);
	}
	
	/**
	 * check the given char is pair punctuation or not.  
	 * 
	 * @param c  
	 */
	public static boolean isPairPunctuation( char c ) {
		return pairPunctuation.containsKey(c);
	}
	
	/**
	 * get the pair punctuation' pair.
	 * 
	 * @param c
	 * @return char
	 */
	public static char getPunctuationPair( char c ) {
		return pairPunctuation.get(c);
	}
	
}
