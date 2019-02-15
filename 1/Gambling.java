
/**
 * A little gambling program for two players.
 */
public class Gambling {
	
	public static void main(String[] ARGV) {
		int Number;
		String name1 , name2;
		
		 	    
		Terminal.print("Guten Tag\n");
		Terminal.print("enter your first player name :");
		name1=Terminal.readString();
		
		Terminal.print("enter your second player name :");
		name2=Terminal.readString();
		
	
	
	while(true) {
		int res = (int)(Math.random()*99+1);
		 
			
		Terminal.print("Hello " + name1 +" enter your tipp:");
		int i1=Terminal.readInt();
		
		
		Terminal.print("Hello " + name2 + " enter your tipp:");
		int i2=Terminal.readInt();
		
		int d1 = Math.abs(i1 - res);
		int d2 = Math.abs(i2 - res);
		
		if(d1 == d2) {
			Terminal.println("gibt es keine Sieger , bitte versuchen sie noch mal.." );
		}
		else {
	      if(d1 < d2 ) {
	      	Terminal.println("du bist der Sieger : " + name1 );
	      }
	      else if(d1 >d2 ) {
	    	Terminal.println("du bist der Sieger : " + name2 );
	      }
	      break;
		}
	}
	}
}
