import java.util.Scanner;
public class User {

	
	public static void main(String [] args){
		
		Scanner ask = new Scanner(System.in);
		System.out.println("The target is " + Evolution.target + " how many creatures to make?");
		Evolution evolution = new Evolution (ask.nextInt());
		//game loop
		while (true){
			
			System.out.println("\n" + "1 = print creatures, 2 = run evolution");
			int ans = ask.nextInt();
			//print creatures
			if (ans==1){
				System.out.println("1 = print 1 creature, 2 = print all creatures");
				if (ask.nextInt()==2){
					System.out.println(evolution);
				}else
				{	System.out.println("What creature do you want to print?");
				System.out.println(evolution.print(ask.nextInt()));
				}
			}
			
			//run evolution
			if (ans ==2){
				System.out.println("after how many deaths you want the evolution to pause?");
				long tmp = ask.nextLong();
				System.out.print ("running, wait...");
				evolution.run(tmp);
				System.out.print ("done!");
				
			}
			
			
		}
	}
	
}
