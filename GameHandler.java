import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;

public class GameHandler {
	private static ArrayList<CardHolder> players = new ArrayList<CardHolder>();

	public static void ShowPlayerCard(CardHolder player) {
		JFrame f = new JFrame(player.GetName());
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Canvas c = new CardDrawer(player.getCurrentCard().GetName(), player.getCurrentCard().GetAttackName(), player.getCurrentCard().GetDamage(), player.getCurrentCard().GetHealth(), player.IsDemon());
		f.add(c);
		f.pack();
		
		f.setVisible(true);
	}	
	
	public static void SetPlayerCard() {
		System.out.print("Pick a card (Using its number): ");
		Scanner sc = new Scanner(System.in);
		boolean hasChosen = false;
		while(!hasChosen) {
			try {
				String regex = "[0-9]*";
				String input = sc.next();
				if(!input.matches(regex)) throw new IndexOutOfBoundsException();
				GetPlayer(0).ChooseCard(Integer.parseInt(input)-1);
				hasChosen = true;
			} catch(IndexOutOfBoundsException e) {
				System.out.print("Please choose a valid card number: ");
			}
		}
	}
	
	public static void AddPlayer(CardHolder p) {
		players.add(p);
	}
	
	public static void DealHand(int handSize) {
		Deck deck;
		for(int i = 0; i < players.size(); i++) {
			if(players.get(i).IsDemon()){deck = new DemonDeck();} 
			else deck = new SlayerDeck();
			for(int x = 0; x < handSize; x++) {
				players.get(i).AddToHand(deck.GenerateCard());
			}
		}
	}
	
	public static String DisplayAvailableCards(CardHolder player) {
		String cards = "Your available cards are: ";
		for(int i = 0; i < player.GetCardCount(); i++) {
			cards += String.format("\n\t[%d]",i+1) + player.getAllCards().get(i);
		}
		return cards;
	}
	
	public static CardHolder GetPlayer(int i) {
		return players.get(i);
	}
	
	public static void ExecuteTurn() {
		SetPlayerCard();		
		
		players.get(1).MakeMove(players.get(0).getCurrentCard());
		players.get(0).MakeMove(players.get(1).getCurrentCard());
	}
	
	public static String DisplayIntroduction() {
		String welcomeMessage = "Hello! In this game you will play as a demon slayer, and your enemy will play as a demon. \n"
				+ "You have been provided with 5 cards that deal different amounts of damages and have different health. \n"
				+ "Every turn you must choose a card, and your enemy will do the same. \n"
				+ "Your cards will then damage each other and if a card's health goes below zero it will be removed from the deck.\n"
				+ "Your objective is to remove all your enemy cards from their deck while keeping as many as you can. \n"
				+ "After choosing which card you want to play, a visual will pop up to show you your card and the enemies card after the clash.\n"
				+ "Please feel free to begin.\n";
		
		return welcomeMessage;
	}
	
	public static void KillCards() {
		for(int i = 0; i < players.size(); i++) {
			if(GetPlayer(i).getCurrentCard().shouldDie()) {
				GetPlayer(i).RemoveFromHand(GetPlayer(i).getCurrentCard());
			}
			
		}
	}
}
