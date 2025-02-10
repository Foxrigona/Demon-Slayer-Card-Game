import java.util.Random;

public class NPC extends CardHolder{
	public NPC(String name, boolean isDemon) {
		super(name, isDemon);
	}
	
	@Override
	public void MakeMove(Card enemyCard) {
		ChooseCard();
		activeCard.DealDamage(enemyCard);
	}
}
