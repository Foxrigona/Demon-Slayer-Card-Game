
public class Card {
	/*
	 * This class stores all the information that will be stored on a card. 
	 * It also provides methods to access and modify variables that are stored in this class appropriately
	 */
	private String name;
	private String attackName;
	private int damage;
	private int health;
	public Card(String name, String attackName, int damage, int health) {
		this.name = name;
		this.attackName = attackName;
		this.damage = damage;
		this.health = health;
	}
	
	public String toString() {
		return String.format("Name: %s, Attack: %s, Damage: %d, Health: %d", name,attackName,damage,health);
	}
	
	//Decreases the health by a certain amount
	public void TakeDamage(int damage) {
		this.health -= damage;
	}
	
	//Returns the cards health
	public int GetHealth() {
		return this.health;
	}
	//Deals damage to another card
	public int DealDamage(Card enemyCard) {
		enemyCard.TakeDamage(this.damage);
		return this.damage;
	}
	//returns if the health is equal to or less than zero
	public boolean shouldDie() {
		return health <=0;
	}
	//returns the cards name
	public String GetName() {
		return name;
	}
	//returns the cards attack name
	public String GetAttackName() {
		return attackName;
	}
	//return the damage the card can deal
	public int GetDamage() {
		return damage;
	}
}
