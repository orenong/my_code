import java.util.Random;

public class Evolution {
	public static int mutation = 1;
	public static String target = "oooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo";
	private DNA[] creatures; 
	
	public Evolution (int howMantCreatures){
		
		creatures = new DNA[howMantCreatures];
		for (int i=0;i<howMantCreatures;i++){
			creatures[i] = new DNA();
		}
	}
	
	
	//gets 2 DNAs, returns the strongest
	public static DNA fight (DNA a, DNA b){
		int aScore =0,bScore =0;
		for (int i=0; i<DNA.length; i++){
			if (a.at(i) == target.charAt(i) )
				aScore ++;
			if (b.at(i) == target.charAt(i) )
				bScore ++;
		}
		if (aScore > bScore)
			return a;
		if (bScore > aScore)
			return b;
		//if equal
		if(Math.random()>0.5)
			return a;
		return b;
	}

	public String toString (){
		String str = "";
		for (int i=0;i<creatures.length;i++){
			
		str += creatures[i].toString();
		if (i%6==0 && i>0)
			str += "\n";
		else 
			str += " ; ";
		}
		return str;
		
	}
	public String print(int creature) {
		
		return creatures[creature -1].toString();
	}


	public void run(long fights) {
		Random r = new Random();
		int tmpA =0,tmpB=0;
		int howManyCreatures = creatures.length;
		while(fights >0){
			tmpA =0;
			tmpB =0;
			while(tmpA == tmpB){
				tmpA = r.nextInt(howManyCreatures);
				tmpB = r.nextInt(howManyCreatures);
			}
			creatures[tmpA] = fight(creatures[tmpA],creatures[tmpB]); //the winner survives
			creatures[tmpB] = new DNA (creatures[tmpA], mutation); //the winner have a child
			fights --;
		}
		
	}
	
	
}
