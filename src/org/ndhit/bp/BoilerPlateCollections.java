package org.ndhit.bp;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.ZonedDateTime;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.stream.Collectors;

import org.ndhit.bp.PlayingCard.Face;
import org.ndhit.bp.PlayingCard.Suit;

class BoilerPlateCollections {
//		create a set of transactions to be added to the queue
	private static Transaction[] trans = new Transaction[9]; 
	
	public static void init()
	{
		trans[0] = new Transaction.Builder().tranId("8").amount(new BigDecimal(1099.25)).account("897653227").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[1] = new Transaction.Builder().tranId("7").amount(new BigDecimal(1097.25)).account("897653229").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[2] = new Transaction.Builder().tranId("6").amount(new BigDecimal(1096.25)).account("897653227").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[3] = new Transaction.Builder().tranId("5").amount(new BigDecimal(1095.25)).account("897653226").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[4] = new Transaction.Builder().tranId("4").amount(new BigDecimal(1094.25)).account("897653226").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[5] = new Transaction.Builder().tranId("3").amount(new BigDecimal(1093.25)).account("897653228").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[6] = new Transaction.Builder().tranId("2").amount(new BigDecimal(1092.25)).account("897653229").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		trans[7] = new Transaction.Builder().tranId("1").amount(new BigDecimal(10.25)).account("897653229").tranType(Transaction.TransactionTypes.WITHDRAWAL).tranDate(ZonedDateTime.now()).build();
		trans[8] = new Transaction.Builder().tranId("0").amount(new BigDecimal(11.25)).account("897653228").tranType(Transaction.TransactionTypes.FEE).tranDate(ZonedDateTime.now()).build();
		
	}
	
	public static void bpCollectionsRun() {
		
		init();
		
//		Create a Set interface from HashSet using playing cards
//		Theoretically the best performing Set implementation
		createHashSet();
		
//		Create a Set interface from TreeSet using playing cards
		createTreeSet();
		
//		Create a Set interface from LinkedHashSet using playing cards
		createLinkedHashSet();
		
//		Create a List interface from ArrayList of playing cards
		createArrayList();
		
//		Create a List interface from LinkedList of playing cards
		createLinkedList();
		
//		Create Dequeue interface, treat it like a stack, using playing cards
		createDeque();
		
//		Create a Vector of playing cards
		createVector();
		
//		Shuffle deck of cards; using Collections.shuffle()
		shuffleCards();
		
//		create playing card deck
		createCards();
		
//		Create list of Transactions; using Collections.sort(); and Collections.binarySearch()
		createSortAndSearchList();
		
//		Create a Queue interface of Transactions from a LinkedList
		createQueue();
		
		
//		Create Map interface from HashMap - use to sum transactions against account number
		createMap();
		
//		Create SortedMap interface from TreeMap
		createSortedMap();
		
		
		
	}
	


	private static void createHashSet() {
		
		Set<PlayingCard> spades = new HashSet<>(PlayingCard
				.getCardDeck().stream().filter((c) -> c.getSuit() == Suit.Spades)
				.collect(Collectors.toList()));
		
		System.out.print("\nSpades from a HashSet: "); 
		for(PlayingCard c : spades)
		System.out.print(c.getSuit() + ":" + c.getFace() +", "); 
		 
	}
	
	private static void createTreeSet() {
		Set<PlayingCard> clubs = new TreeSet<>(PlayingCard
				.getCardDeck().stream().filter((c) -> c.getSuit() == Suit.Clubs)
				.collect(Collectors.toList()));
		
		System.out.print("\nClubs from a TreeSet: "); 
		for(PlayingCard c : clubs)
			System.out.print(c.getSuit() + ":" + c.getFace() + ", "); 
	}
	
	private static void createLinkedHashSet() {
		Set<PlayingCard> hearts = new LinkedHashSet<>(PlayingCard
				.getCardDeck().stream().filter((c) -> c.getSuit() == Suit.Hearts)
				.collect(Collectors.toList()));
		
		System.out.print("\nHearts from a LinkedHashSet: "); 
		for(PlayingCard c : hearts)
			System.out.print(c.getSuit() + ":" + c.getFace() + ", "); 
		
	}
	
	
	private static void createArrayList() {
		List<PlayingCard> kings = new ArrayList<>(PlayingCard
				.getCardDeck().stream().filter((c) -> c.getFace() == Face.King)
				.collect(Collectors.toList()));
		
		System.out.print("\nKings from an ArrayList: "); 
		for(PlayingCard c : kings)
			System.out.print(c.getSuit() + ":" + c.getFace() + ", "); 
	}
	
	private static void createLinkedList() {
		List<PlayingCard> kings = new LinkedList<>(PlayingCard
				.getCardDeck().stream().filter((c) -> c.getFace() == Face.Queen)
				.collect(Collectors.toList()));
		
		System.out.print("\nQueens from a LinkedList: "); 
		for(PlayingCard c : kings)
			System.out.print(c.getSuit() + ":" + c.getFace() + ", "); 
		
	}
	
	private static void createSortAndSearchList() {

		Comparator<Transaction> tranCompare = (t1,t2) -> t1.getTranId().compareTo(t2.getTranId());
		Transaction tran5 = new Transaction.Builder().tranId("3").amount(new BigDecimal(0.00d)).account("897653228").tranType(Transaction.TransactionTypes.DEPOSIT).tranDate(ZonedDateTime.now()).build();
		List<Transaction> tranList = new ArrayList<>(Arrays.asList(trans));
		Collections.sort(tranList, tranCompare);
		int t5 = Collections.binarySearch(tranList, tran5, tranCompare );
		System.out.println("\nBinary search found Transaction with ID of 5: " + (t5 >= 0) + " at index: " + t5);
	}

	private static void createVector() {

		Set<PlayingCard> deck = PlayingCard.getCardDeck();
		
//		Using stream processing create a Vector containing only Clubs
		Vector<PlayingCard> cardSuit = new Vector<>(
						deck.stream().filter(c -> c.getSuit() == Suit.Clubs )
						.collect(Collectors.toList()));
		System.out.print("\nClubs from Vector: ");
		for(PlayingCard c : cardSuit) {
			System.out.print(c.getFace() + " of " + c.getSuit() + ", ");
		}
		
	}
	
	private static void createDeque() {
		List<PlayingCard> hand = new ArrayList<>();
		Deque<PlayingCard> deck = new ArrayDeque<>(PlayingCard.getShuffledCardDeck());
		
//		Pop the top 5 cards from deck
		for(int i = 0; i < 5; i++)
			hand.add(deck.pop());
		
		System.out.print("\nShow my hand from top of deck: ");
		for(PlayingCard c : hand)
			System.out.print(c.getSuit() + ":" + c.getFace() + ", ");
		
	}
	
	private static void shuffleCards() {
		Set<PlayingCard> deck = PlayingCard.getCardDeck();
		List<PlayingCard> newdeck = new ArrayList<>(deck);
		Collections.shuffle(newdeck);
		System.out.println("Top of shuffled card deck is: " + newdeck.get(0).getFace() + " of " + newdeck.get(0).getSuit());
	}
	
	private static void createCards() {
		
//		will get the deck sorted in natural order
		System.out.println("\nOrdered card deck:");
		Set<PlayingCard> deck = PlayingCard.getCardDeck();
		for(PlayingCard c : deck) {
			System.out.println(c.getFace() + " of " + c.getSuit() );
		}
		
//		will get the deck shuffled
		System.out.println("\nShuffled card deck:");
		Set<PlayingCard> sd = PlayingCard.getShuffledCardDeck();
		for(PlayingCard c : sd) {
			System.out.println(c.getFace() + " of " + c.getSuit() );
		}
	}
	
	private static void createQueue() {

		Queue<Transaction> inProcessTransactions = new LinkedList<>();
		
		for(Transaction t: trans)
			inProcessTransactions.add(t);
		
//		Output using single threaded stream will results in same ordering
		System.out.println("\n\nOutput using Stream");
		inProcessTransactions.stream()
			.forEach(System.out::println);
		
		System.out.println();
		
//		Output using parallel stream will result in mixed ordering
		System.out.println("\nOutput using parallelStream");
		inProcessTransactions.parallelStream()
		.forEach(System.out::println);
		
//		Remove all transactions from queue (FIFO)
		System.out.println("\nOutput after removing from Queue");
		while(!inProcessTransactions.isEmpty()) {
			System.out.println(inProcessTransactions.remove());
		}
		
		System.out.println("\nTransactions remaining in queue: " + inProcessTransactions.size());
	}
		
	private static void createMap() {
		Map<String, BigDecimal> accounts = new HashMap<>();
		BigDecimal bigZero = new BigDecimal(0.00d, MathContext.DECIMAL64);
		
//		Sum transactions against account in a map; assumes zero balance start
		for(Transaction t: trans) {
			BigDecimal tranAmount = t.getAmount();
			BigDecimal acctBalance = bigZero;
			if(accounts.containsKey(t.getAccount())) 
				acctBalance = accounts.get(t.getAccount());
			
			if(t.getTranType() == Transaction.TransactionTypes.DEPOSIT)
				acctBalance = acctBalance.add(tranAmount);
			else if(t.getTranType() == Transaction.TransactionTypes.WITHDRAWAL || 
					t.getTranType() == Transaction.TransactionTypes.FEE)
				acctBalance = acctBalance.subtract(tranAmount);
			accounts.put(t.getAccount(), acctBalance);
		}
		
//		Lets see the accounts with balance
		System.out.println("\nIterate over the accounts with calculated balances.");
		for(String key: accounts.keySet())
			System.out.println("\"{Account\": " + key + " \"Balance\": " + accounts.get(key) +"}");
		
	}
	
	private static void createSortedMap() {
		SortedMap<String, Transaction> transByTranId = new TreeMap<>();
		for(Transaction t : trans) {
			transByTranId.put(t.getTranId(), t);
		}
		
		System.out.println("\nIterate over the transactions in order by tranId.");
		for(String key: transByTranId.keySet()) {
			Transaction t = transByTranId.get(key);
			System.out.println(t);
		}
	}

		
}
