import java.util.Random;

public class Deck {
	protected String[][] names = new String[3][];
	
	protected String[][] attackNames = new String[3][];
	
	protected int[] damages = new int[3];
	
	protected int[] health = new int[3];
	
	public Deck() {
		damages[0] = 40;
		damages[1] = 25;
		damages[2] = 10;
		
		health[0] = 50;
		health[1] = 25;
		health[2] = 10;
	}
	
	public Card GenerateCard() {
		Random r = new Random();
		int chosenRank = r.nextInt(3);
		int selectedName = r.nextInt(names[chosenRank].length);
		int selectedAttackName = r.nextInt(attackNames[chosenRank].length);;
		Card newCard = new Card(names[chosenRank][selectedName], attackNames[chosenRank][selectedAttackName], r.nextInt(damages[chosenRank]-damages[chosenRank]/10, damages[chosenRank]+damages[chosenRank]/10), health[chosenRank]);
		return newCard;
	}
}
