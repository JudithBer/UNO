package engine;

import java.util.ArrayList;

import gui.Card;
import gui.Colour;
import gui.Deck;
import gui.Value;

public class Game {
	private Deck deck;
	private int numberOfPlayers;
	private int numberOfCards;
	private ArrayList<ArrayList<Card>> superlist=new ArrayList<ArrayList<Card>>(); 
	private ArrayList<Card> tmp = new ArrayList<Card>();
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	private boolean rule1 = false;			// If player places a +2 card on another, it will be added and the next player without a +2 needs to take the sum of all 
	private boolean rule2 = false;			// Player can place a requestcard on another requestcard
	private boolean rule3 = false;			// If player places a +4 card on another, it will be added and the next player without a +4 needs to take the sum of all
	private boolean rule4 = false;			// A +4 card can be the last card
	private boolean rule5 = false;			// If player has 2 cards with the same Value and Colour, he can place both at the same time
	private boolean rule6 = false;			// If there are just 2 players left and one places a rotate, it's like he placed a skip
//weitere Regel: +4 nur, wenn keine Farbkarte mehr von der aktuellen Farbe auf dem Ablegestapel
	
	private int drawCards=0;
	private boolean mustDraw = false;
	

　
	public Game(){
		deck=new Deck();
		deck.create();
		deck.shuffle();
	}
	
	public void startGame(int numberOfPlayers, int numberOfCards){
		this.numberOfCards=numberOfCards;
		this.numberOfPlayers=numberOfPlayers;
		for(int i=0;i<numberOfPlayers;i++){
			tmp.clear();
			Player player = new Player(i);
			for(int j=0;j<numberOfCards;j++){
				tmp.add(deck.getFirstCard());
				deck.removeFirstCard();
			}
			superlist.add(tmp);
		}
		discardPile.add(deck.getFirstCard());
		deck.removeFirstCard();
	}
	
	public int countCards(int id){
		tmp=this.getSuperlist().get(id);
		return tmp.size();
	}
	
	public boolean checkMainRule(Card c){
		if(c.getColor().equals(discardPile.get(discardPile.size()-1).getColor())&&c.getValue().equals(discardPile.get(discardPile.size()-1).getValue())
				&& c.getValue()!= Value.REQUEST &&c.getValue()!= Value.REQUEST4){
			return true;
		}else{
		return false;
		}
	}	
	
	// If player places a +2 card on another, it will be added and the next player without a +2 needs to take the sum of all 
	public boolean checkRule1(Card c){
		if(isRule1()){		
		if(c.getValue()== Value.PLUS2 && c.getValue().equals(discardPile.get(discardPile.size()-1).getValue())){
			mustDraw=false;
			return true;
		}else{
			mustDraw=true;
		return false;
		}
		}else{
			mustDraw=true;
			return true;
		}
	}	
		
	// Player can place a requestcard on right on another requestcard
	public boolean checkRule2(Card c){
		if((isRule2()&&c.getColor()==Colour.BLACK && c.getValue().equals(discardPile.get(discardPile.size()-1).getValue()))
				||(!isRule2() && (c.getColor()!=Colour.BLACK || c.getValue()!=discardPile.get(discardPile.size()-1).getValue()))){
			return true;
		}else{
			return false;
		}
	}	
	
	// If player places a +4 card on another, it will be added and the next player without a +4 needs to take the sum of all
	public boolean checkRule3(Card c){
		if(isRule3()){		
		if(c.getValue()== Value.REQUEST4 && c.getValue().equals(discardPile.get(discardPile.size()-1).getValue())){
			mustDraw=false;
			return true;
		}else{
			mustDraw=true;
		return false;
		}
		}else{
			mustDraw=true;
			return true;
		}
	}	
	
	
	
	//A +4 card can be the last card
	public boolean checkRule4(Card c, int id){
		if(isRule4()){
			return true;				
			} else{
				if(c.getValue()==Value.REQUEST4 && this.countCards(id)==1){
					return false;
				}else{
					return true;
				}	
		}
	}	
	
	//TODO
	// If player has 2 cards with the same Value and Colour, he can place both at the same time
	public boolean checkRule5(Card c){
		return true;
	}	
	
	//TODO
	// If there are just 2 players left and one places a rotate, it's like he placed a skip
	public boolean checkRule6(Card c){
		return true;
	}	
	

　
	public boolean checkCard(Card card){

		return true;
	}
	
	
	public Deck getDeck() {
		return deck;
	}

	public ArrayList<ArrayList<Card>> getSuperlist() {
		return superlist;
	}

	public ArrayList<Card> getDiscardPile() {
		return discardPile;
	}
	
	
	public boolean isRule1() {
		return rule1;
	}

	public void setRule1(boolean rule1) {
		this.rule1 = rule1;
	}

	public boolean isRule2() {
		return rule2;
	}

	public void setRule2(boolean rule2) {
		this.rule2 = rule2;
	}

	public boolean isRule3() {
		return rule3;
	}

	public void setRule3(boolean rule3) {
		this.rule3 = rule3;
	}

	public boolean isRule4() {
		return rule4;
	}

	public void setRule4(boolean rule4) {
		this.rule4 = rule4;
	}

	public boolean isRule5() {
		return rule5;
	}

	public void setRule5(boolean rule5) {
		this.rule5 = rule5;
	}

	public boolean isRule6() {
		return rule6;
	}

	public void setRule6(boolean rule6) {
		this.rule6 = rule6;
	}
	
	public int getDrawCards() {
		return drawCards;
	}

	public void setDrawCards(int drawCards) {
		this.drawCards = drawCards;
	}

	public boolean isMustDraw() {
		return mustDraw;
	}
	
}
