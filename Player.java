import java.util.Scanner;

public class Player extends CardHolder{
	public Player(String name, boolean isDemon) {
		super(name, isDemon);
	}
	@Override
	public void MakeMove(Card enemyCard) {
		activeCard.DealDamage(enemyCard);
	}
	
}
