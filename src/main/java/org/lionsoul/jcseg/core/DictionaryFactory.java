package org.lionsoul.jcseg.core;

import java.io.IOException;
import java.lang.reflect.Constructor;

/**
 * Dictionary Factory to create Dictionary instance .  
 * 		a path of the class that has extends the ADictionary
 * 	class must be given first.  
 * 
 * @author	chenxin 
 */
public class DictionaryFactory {
	
	private DictionaryFactory() {}
	
	/**
	 * create a new ADictionary instance .  
	 * 
	 * @param 	__dicClass
	 * @return	ADictionary
	 */
	public static ADictionary createDictionary(
			String __dicClass, Class<?>[] paramType, Object[] args) {
		try {
			Class<?> _class = Class.forName(__dicClass);
			Constructor<?> cons = _class.getConstructor(paramType);
			return ( ( ADictionary ) cons.newInstance(args) );
		} catch ( Exception e ) {
			System.err.println("can't create the ADictionary instance " +
					"with classpath ["+__dicClass+"]");
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * create a default ADictionary instance of class
	 * 		com.webssky.Dictionary .
	 * 
	 * @see		Dictionary
	 * @return	ADictionary
	 */
	public static ADictionary createDefaultDictionary( JcsegTaskConfig config, boolean sync ) {
		ADictionary dic = createDictionary("org.lionsoul.jcseg.Dictionary",
					new Class[]{JcsegTaskConfig.class, Boolean.class},
					new Object[]{config, sync});
		try {
			//load lexicon from more than one path.
			String[] lexpath = config.getLexiconPath();


			if ( lexpath == null )

				throw new IOException("Invalid lexicon path, " +
						"make sure the JcsegTaskConfig is initialized.");
			
			//load word item from all the directories.
			for ( String lpath : lexpath ) {
				System.out.println("字典路径:"+lpath);
				System.out.println("字典实例:"+dic);
					dic.loadFromLexiconDirectory(lpath);
			}
			if ( dic.getConfig().isAutoload() ) dic.startAutoload();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dic;
	}
	
	public static ADictionary createDefaultDictionary( JcsegTaskConfig config ) {
		return createDefaultDictionary(config, config.isAutoload());
	}
}