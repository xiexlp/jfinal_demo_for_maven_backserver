package org.lionsoul.jcseg.util;

/**
 * string buffer class. 
 * 
 * @author	chenxin
 */
public class IStringBuffer {
	
	/**
	 * buffer char array. 
	 */
	private char buff[];
	private int count;
	
	/**
	 * create a buffer with a default length 16.  
	 */
	public IStringBuffer() {
		buff = new char[16];
		count = 0;
	}
	
	/**
	 * create a buffer with a specified length. 
	 * 
	 * @param	length
	 */
	public IStringBuffer( int length ) {
		if ( length <= 0 )
			throw new IllegalArgumentException("length <= 0");
		buff = new char[length];
		count = 0;
	}
	
	/**
	 * create a buffer with a specified string. 
	 * 
	 * @param	str
	 */
	public IStringBuffer( String str ) {
		if ( str == null )
			throw new NullPointerException();
		
		buff = new char[str.length() + 16];
		append(str);
		count = 0;
	}
	
	/**
	 * resize the buffer. 
	 * 	this will have to copy the old chars from the old buffer to the new buffer.  
	 */
	private void resizeTo( int length ) {
		if ( length <= 0 )
			throw new IllegalArgumentException("length <= 0");
		if ( length != buff.length ) {
			int len = ( length > buff.length ) ? buff.length : length;
			//System.out.println("resize:"+length);
			char[] obuff = buff;
			buff = new char[length];
			/*for ( int j = 0; j < len; j++ ) {
				buff[j] = obuff[j];
			}*/
			System.arraycopy(obuff, 0, buff, 0, len);
		}
	}
	
	/**
	 * append a string to the buffer. 
	 * 
	 * @param	str	string to append to
	 */
	public IStringBuffer append( String str ) {
		if ( str == null )
			throw new NullPointerException();
		//check the necessary to resize the buffer.
		if ( count + str.length() > buff.length )
			resizeTo( (count + str.length()) * 2 + 1 );
		for ( int j = 0; j < str.length(); j++ ) {
			buff[count++] = str.charAt(j);
		}
		
		return this;
	}
	
	/**
	 * append parts of the chars to the buffer. 
	 * 
	 * @param	chars
	 * @param	start	the start index.
	 * @param	length	length of chars to append to.
	 */
	public IStringBuffer append( char[] chars, int start, int length ) {
		if ( chars == null )
			throw new NullPointerException();
		if ( start < 0 )
			throw new IndexOutOfBoundsException();
		if ( length <= 0 )
			throw new IndexOutOfBoundsException();
		if ( start + length >= chars.length ) 
			throw new IndexOutOfBoundsException();
		
		//check the necessary to resize the buffer.
		if ( count + length > buff.length ) 
			resizeTo( (count + length) * 2 + 1 );
		for ( int j = 0; j < length; j++ ) {
			buff[count++] = chars[start+j];
		}
		
		return this;
	}
	
	/**
	 * append some chars to the buffer. 
	 * 
	 * @param	chars
	 */
	public IStringBuffer append( char[] chars ) {
		return append(chars, 0, chars.length);
	}
	
	/**
	 * append a char to the buffer. 
	 * 
	 * @param	c	the char to append to
	 */
	public IStringBuffer append( char c ) {
		if ( count == buff.length ) resizeTo( buff.length * 2 + 1 );
		buff[count++] = c;
		
		return this;
	}
	
	/**
	 * return the lenght of the buffer. 
	 * 
	 * @return	int	the length of the buffer.
	 */
	public int length() {
		return count;
	}
	
	/**
	 * get the char at a specified position in the buffer.  
	 */
	public char charAt( int idx ) {
		if ( idx < 0 )
			throw new IndexOutOfBoundsException("idx < 0");
		if ( idx >= count )
			throw new IndexOutOfBoundsException("idx >= buffer.length");
		return buff[idx];
	}
	
	/**
	 * delete the char at the specified position.  
	 */
	public IStringBuffer deleteCharAt( int idx ) {
		if ( idx < 0 )
			throw new IndexOutOfBoundsException("idx < 0");
		if ( idx >= count )
			throw new IndexOutOfBoundsException("idx >= buffer.length");
		
		//here we got a bug for j < count
		//change over it to count - 1
		//thanks for the feedback of xuyijun@gmail.com
		//@date 2013-08-22
		for ( int j = idx; j < count - 1; j++ ) {
			buff[j] = buff[j+1];
		}
		count--;
		
		return this;
	}
	
	/**
	 * return the chars of the buffer. 
	 * 
	 * @return	char[]
	 */
	public char[] buffer() {
		return buff;
	}
	
	/**
	 * clear the buffer by
	 * 		reset the count to 0.  
	 */
	public IStringBuffer clear() {
		count = 0;
		
		return this;
	}
	
	/**
	 * return the string of the current buffer. 
	 * 
	 * @return	String
	 * @see Object#toString() 
	 */
	public String toString() {
		return new String(buff, 0, count);
	}
}
