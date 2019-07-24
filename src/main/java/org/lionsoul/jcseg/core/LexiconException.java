package org.lionsoul.jcseg.core;


public class LexiconException extends Exception {
	
	private static final long serialVersionUID = 3794928123652720865L;

	public LexiconException( String info ) {
		super(info);
	}
	
	public LexiconException( Throwable res ) {
		super(res);
	}
	
	public LexiconException( String info, Throwable res ) {
		super(info, res);
	}

}
