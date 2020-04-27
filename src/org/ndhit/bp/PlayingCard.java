package org.ndhit.bp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Neil D. Harvey
 * 
 * The enumerations for Suit and Face contain the Unicode representations of these playing cards.
 *
 */

public class PlayingCard implements Comparable<PlayingCard> {
	
	
	public enum Suit {
		Spades(0x1F0A0), Hearts(0x1F0B0), Diamonds(0x1F0C0), Clubs(0x1F0D0);
		
		private final int code;
	
		Suit(int code) {
			this.code = code;
		}
		
		public int getCode() {
			return code;
		}
	};
	
	public enum Face {
		Ace(0x1), Two(0x2), Three(0x3), Four(0x4), Five(0x5), Six(0x6), Seven(0x7), Eight(0x8), 
		Nine(0x9), Ten(0xA), Jack(0xB), Queen(0xD), King(0xE);

		private final int code;
		
		Face(int code){
			this.code = code;
		}
	
		public int getCode() {
			return code;
		}
	}

	private final Suit s;
	private final Face f;
	private final int code;
	
	private final static List<PlayingCard> cardDeck = new ArrayList<>(52);
	
	private PlayingCard(Suit s, Face f) {
		this.s = s;
		this.f = f;
		code = s.getCode() + f.getCode();
	}
	
	public Suit getSuit() {
		return s;
	}
	public Face getFace() {
		return f;
	}
	public int getCode() {
		return code;
	}
	
	public static PlayingCard getPlayingCard(Suit s, Face f) {
		return new PlayingCard(s,f);
	
	}
	
	@Override
	public int compareTo(PlayingCard c) {
		return Integer.compare(getCode(), c.getCode());
	}
	
	/**
	 * 
	 * @return SortedSet in natural order
	 */
	public static SortedSet<PlayingCard> getCardDeck() {
		SortedSet<PlayingCard> ss = new TreeSet<>(cardDeck);
		return ss;
	}
	
	/**
	 * @param comparator determines the order of the returned card deck
	 * @return A sorted set of playing cards.
	 */
	public static SortedSet<PlayingCard> getCardDeck(Comparator<PlayingCard> comparator) {
		SortedSet<PlayingCard> ss = new TreeSet<>(comparator);
		ss.addAll(cardDeck); 
		return ss;
	}
	
	public static Set<PlayingCard> getShuffledCardDeck() {
		List<PlayingCard> shuffledDeck = new ArrayList<>(cardDeck);
		Collections.shuffle(shuffledDeck);
		return new HashSet<PlayingCard>(shuffledDeck);
	}
	
	static {
//		Create a complete deck of playing cards
		for(Suit s1: Suit.values()) {
			for(Face f1 : Face.values()) {
				cardDeck.add(new PlayingCard(s1, f1));
			}
		}
		
	}

	
	
	

}
