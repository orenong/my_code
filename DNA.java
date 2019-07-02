import java.util.Random;

public class DNA {
	public static final int length = Evolution.target.length();
	private  char[] dna = new char[length];
	
	//random DNA
	public DNA (){
		Random r = new Random();
		for (int i=0; i<length; i++){
			
			dna[i] = (char)(r.nextInt(26) + 'a');
			
		}
		
	}
	//child DNA
	public DNA (DNA par, int rate){
		Random r = new Random();
		for (int i=0; i<length; i++){
			
			if (r.nextInt(100)<=rate){
				
				dna[i] = (char)(r.nextInt(26) + 'a');
				
			}else{
				
				dna[i] = par.dna[i];
			}
		}
	}
	
	public char at (int index){
		
		return dna[index];
		
	}
	
	
	public String toString (){
		String str ="";
		for (int i =0 ; i<length; i++){
			str +=dna[i];
		}
		return str;
	}
	
}
