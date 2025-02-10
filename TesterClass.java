public class TesterClass {
	public static void main(String[] args) {
		GameHandler.AddPlayer(new Player("Player", false));
		GameHandler.AddPlayer(new NPC("NPC", true));
		GameHandler.DealHand(5);
		
		System.out.println(GameHandler.DisplayIntroduction());

		System.out.println(GameHandler.DisplayAvailableCards(GameHandler.GetPlayer(0)));
		GameHandler.ExecuteTurn();
		GameHandler.ShowPlayerCard(GameHandler.GetPlayer(0));
		GameHandler.ShowPlayerCard(GameHandler.GetPlayer(1));
		GameHandler.KillCards();
		System.out.println("\nTHE CARDS HAVE BEEN DRAWN(THE NPC CARD MAY SPAWN BEHIND THE PLAYER CARD SO YOU MAY NEED TO MOVE THE PLAYER CARD)");
		System.out.printf("\nYou: %d cards left\n", GameHandler.GetPlayer(0).GetCardCount());
		System.out.printf("NPC: %d cards left\n", GameHandler.GetPlayer(1).GetCardCount());
	}
}
