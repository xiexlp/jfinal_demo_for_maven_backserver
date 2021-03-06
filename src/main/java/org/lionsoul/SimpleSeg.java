package org.lionsoul;

import java.io.IOException;
import java.io.Reader;

import org.lionsoul.jcseg.ASegment;
import org.lionsoul.jcseg.Chunk;
import org.lionsoul.jcseg.core.ADictionary;
import org.lionsoul.jcseg.core.IChunk;
import org.lionsoul.jcseg.core.IWord;
import org.lionsoul.jcseg.core.JcsegTaskConfig;


/**
 * simplex segment for JCSeg,
 * 		has extend from ASegment. 
 * 
 * @author	chenxin
 */
public class SimpleSeg extends ASegment {
	
	public SimpleSeg( JcsegTaskConfig config, ADictionary dic ) throws IOException {
		super(config, dic);
	}
	
	public SimpleSeg( Reader input, 
			JcsegTaskConfig config, ADictionary dic ) throws IOException {
		super(input, config, dic);
	}

	/**
	 * @see ASegment#getBestCJKChunk(char[], int) 
	 */
	@Override
	public IChunk getBestCJKChunk(char[] chars, int index) {
		IWord[] words = getNextMatch(chars, index);
		return new Chunk(new IWord[]{words[words.length - 1]});
	}

}
