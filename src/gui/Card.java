package gui;

public class Card {

	final Colour color;
	final Value value;
	
	public Card(Colour c, Value v){
		this.color=c;
		this.value=v;
	}
	

	public Colour getColor() {
		return color;
	}

	public Value getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "Card [color=" + this.getColor() + ", value=" + this.getValue() + "]";
	}
	
	
	
}
