import java.awt.*;

public class CardDrawer extends Canvas{
	/*
	 * This class is responsible for drawing the graphics of a card
	 */
	private String cardName;
	private String attackName;
	private int damage;
	private int health;
	private boolean isDemon;
	
	final static int xSize = 300;
	final static int ySize = 450;
	final static Color slayerColor = Color.BLUE;
	final static Color demonColor = Color.RED;
	
	public CardDrawer(String cardName, String attackName, int damage, int health, boolean isDemon) {
		this.cardName = cardName;
		this.attackName = attackName;
		this.damage = damage;
		this.health = health;
		this.isDemon = isDemon;
		this.setSize(CardDrawer.xSize, CardDrawer.ySize);
	}
	
	@Override
	public void paint(Graphics g) {
		if(isDemon) g.setColor(CardDrawer.demonColor);
		if(!isDemon) g.setColor(CardDrawer.slayerColor);
		
		g.fillRect(0, 0, xSize, ySize);
		
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
		g.drawString("Name: " + cardName, 0, 40);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString("Attack Name:", 0, 150);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		g.drawString(attackName, 0, 200);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g.drawString("Damage: " + damage, 0, 350);
		
		g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		if(health > 0) {
			g.drawString("Health: " + health, 0, 450);
		}
		else {
			g.drawString("Health: " + health + "(Dead)", 0, 450);
		}
	}
}
