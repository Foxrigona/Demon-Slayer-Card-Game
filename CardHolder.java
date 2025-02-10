import java.util.ArrayList;
import java.util.Random;

public class CardHolder {
	String name;
	int damageDealt;
	ArrayList<Card> hand = new ArrayList<Card>();
	Card activeCard;
	private boolean isDemon;
	
	public CardHolder(String name, boolean isDemon) {
		this.name = name;
		this.isDemon = isDemon;
	}
	
	public void AddToHand(Card c) {
		hand.add(c);
	}
	
	public void RemoveFromHand(Card c) {
		hand.remove(c);
	}
	
	public int GetCardCount() {
		return hand.size();
	}
	
	public Card getCurrentCard() {
		return activeCard;
	}
	
	public ArrayList<Card> getAllCards() {
		return hand;
	}
	
	public void ChooseCard(int index) {
		this.activeCard = hand.get(index);		
	}
	public void ChooseCard() {
		this.activeCard = hand.get(new Random().nextInt(hand.size()));
	}
	public void MakeMove(Card enemyCard) {
		activeCard.DealDamage(enemyCard);
	}
	public String GetName() {
		return name;
	}
	public boolean IsDemon() {
		return isDemon;
	}
}
