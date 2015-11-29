
public class PostNet {
	   public void zipToPostNet ( String zipcode ) {
		   
		   int[] num = new int[zipcode.length()];  //converting zipcode string to int array num
			char [ ] text = zipcode.toCharArray();
			
			for (int i = 0; i < text.length; i++){
				num[i] = zipcode.charAt(i) - '0';
			}

			// calculating checksum
			int sum = 0;
			for (int i: num){
				sum += i;}
			
			int checksum = 10 - (sum % 10);

			//adding checksum to zipcode for future convenience
			zipcode = zipcode + checksum;
			
			num = new int[zipcode.length()]; //converting to int again
			text = zipcode.toCharArray();

			for (int i = 0; i < text.length; i++){
				num[i] = zipcode.charAt(i) - '0';
			}

			
			int [] digits =	{0,1,2,3,4,5,6,7,8,9};
			
			String startend = "   ****"; // starting/ending bar
			System.out.println(startend);
			String [] codes = 	{	

	" ****\n   ****\n   **\n   **\n   **\n",	

	" **\n" +
	"   **\n" +
	"   **\n" +
	"   ****\n" +
	"   ****\n",

	" **\n" +
	"   **\n" +
	"   ****\n" +
	"   **\n" +
	"   ****\n",

	" **\n" +
	"   **\n" +
	"   ****\n" +
	"   ****\n" +
	"   **\n",

	" **\n" +
	"   ****\n" +
	"   **\n" +
	"   **\n" +
	"   ****\n",

	" **\n" +
	"   ****\n" +
	"   **\n" +
	"   ****\n" +
	"   **\n",

	" **\n" +
	"   ****\n" +
	"   ****\n" +
	"   **\n" +
	"   **\n",

	" ****\n" +
	"   **\n" +
	"   **\n" +
	"   **\n" +
	"   ****\n",

	" ****\n" +
	"   **\n" +
	"   **\n" +
	"   ****\n" +
	"   **\n",

	" ****\n" +
	"   **\n" +
	"   ****\n" +
	"   **\n" +
	"   **\n",

			};
			//		System.out.println(codes[a])
			for (int index = 0; index < num.length - 1; index++) { //finding digits in digit array
				for (int a = 0; a <10; a++){
					if ( num[index] == digits[a]){
						System.out.printf( "%2s", digits[a]); //zipcode printing
						System.out.print(codes[a]);
						
					}
					}
				}
							for (int a = 0; a <10; a++){
			if (num[num.length - 1] == digits[a]){ //checksum printing
				System.out.printf( "✓" + checksum);
				System.out.print(codes[a]);
			}
				}
			System.out.println(startend);
	   }
	   public static void main(String[] args) {
		      PostNet self = new PostNet( );
		      self.zipToPostNet( args[0] );
	}
}