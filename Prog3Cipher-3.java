/**
 * 
 * @Ven Shneyderman
 * CS1121 Lab Section 07
 *
 */
public class Prog3Cipher {
   // INSTANCE VARIABLES
   /**
    * 
    */
   char [ ] keyList; 
   /**
    * 
    */
   char [ ][ ] cipherTable = new char[26][26];
   

   /**
    * Encodes message
    * 
    * @param message
    * @return
    */
   String encode( String message ) {
	   int l = keyList.length;
      String result = "";
      
      for(int i=0, j=0; i < message.length(); i++){
    	  char c = message.charAt(i);
          if (c < 'A' || c > 'Z') {
        	  j++;
        	  
        	  if (j>=l)
        		  j=j-l;
        	  result += c;
        	  continue;
        	  
          }
           result += cipherTable[keyList[j]-'A'][c-'A'];
           j++;
           if (j>=l)
     		  j=j-l;
      }
      return result;
   }

   /**
    * Decodes result
    * 
    * i is index of char in message
    * j  is index of a character in key
    * @param message
    * @return
    */
   String decode( String message ) {
	   int l = keyList.length;
      String result = "";
      for(int i = 0, j = 0; i < message.length(); i++){
    	  char c = message.charAt(i);
    	  if (c < 'A' || c > 'Z') {
        	  j++;
        	  
        	  if (j>=l)
        		  j=j-l;
        	  result += c;
        	  continue;
        	  
          }
    	  int row = keyList[j]-'A';
    	  for(int k = 0; k<26;k++){
    		  if(cipherTable[row][k] == c){
    			  result += (char) ('A' + k);
    			  
    			break;
    		  }
    	  }
    	j++;  
    	 if (j>=l)
   		  j=j-l;
      }
      return result;
   }

   /**
    * Constructor creates cipher array
    * 
    * 
    * @param code
    * @param key
    */
   public Prog3Cipher( char code, String key ) {
	    code = Character.toUpperCase( code );
	    for (int row = 0; row < 26; row++) {
	       int cur = (int) code + row;
	       if ((int) cur > (int) 'Z') {
	          cur -= 26;
	       }
	       for (int column = 0; column < 26; column++) {
	          cipherTable[row][column] = (char) cur;
	          cur++;
	          if ((int) cur > (int) 'Z') {
	             cur = (int) 'A';
	          }
	       }
	    }
	    
	    keyList = key.toCharArray();
   }
   
/**
    * 
    * @param args
    */
   public static void main( String[ ] args ) {
      Prog3Cipher self = new Prog3Cipher( 'H', "BABBAGE" );
      System.out.println("Initial Table character: " + 'H');
      System.out.println("Key: " + "BABBAGE");
      // Should print "HAPPY BIRTHDAY"
      System.out.println("Message: " + self.decode( self.encode( "HAPPY BIRTHDAY" ) ) );
   // Should print "PHXXF MQYBPKNJ"
      System.out.println("Cipher: " + self.encode( "HAPPY BIRTHDAY" ) );

   }
}
