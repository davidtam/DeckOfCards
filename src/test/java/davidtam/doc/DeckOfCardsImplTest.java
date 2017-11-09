package davidtam.doc;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class DeckOfCardsImplTest {

    public static final Comparator<Card> CARD_COMPARATOR = Comparator.comparing(Card::getRank).thenComparing(Card::getSuit);

    @Test(expected = IllegalStateException.class)
    public void drawDownTheCardsThenDrawShouldThrow(){

        DeckOfCards deckOfCards = new DeckOfCardsImpl();
        IntStream.range(0, 52).forEach(x -> deckOfCards.draw());
        deckOfCards.draw();

    }

    @Test(expected = IllegalStateException.class)
    public void drawDownTheCardsThenGetBottomShouldThrow(){

        DeckOfCards deckOfCards = new DeckOfCardsImpl();
        IntStream.range(0, 52).forEach(x -> deckOfCards.draw());
        deckOfCards.getBottom();

    }

    @Test(expected = IllegalStateException.class)
    public void drawDownTheCardsThenGetTopShouldThrow(){

        DeckOfCards deckOfCards = new DeckOfCardsImpl();
        IntStream.range(0, 52).forEach(x -> deckOfCards.draw());
        deckOfCards.getTop();

    }

    @Test
    public void validateCardsDrawnAreUnique(){

        DeckOfCards deckOfCards = new DeckOfCardsImpl();
        Set<Card> cards = new TreeSet<>(CARD_COMPARATOR);
        IntStream.range(0, 52).forEach(x -> cards.add(deckOfCards.draw()));
        assertEquals(52, cards.size());

    }

    @Test
    public void validateCardsDrawnAreUniqueAfterShuffle(){

        DeckOfCards deckOfCards = new DeckOfCardsImpl();
        Set<Card> cards = new TreeSet<>(CARD_COMPARATOR);
        IntStream.range(0, 52).forEach(x -> cards.add(deckOfCards.draw()));
        assertEquals(52, cards.size());

        deckOfCards.shuffle();
        cards.clear();
        IntStream.range(0, 52).forEach(x -> cards.add(deckOfCards.draw()));
        assertEquals(52, cards.size());

    }

    @Test
    public void validateTopAndBottomAreTheSameWhenOnlyOneCardLeftInTheDeck(){

        DeckOfCards deckOfCards = new DeckOfCardsImpl();
        Set<Card> cards = new TreeSet<>(CARD_COMPARATOR);
        IntStream.range(0, 51).forEach(x -> cards.add(deckOfCards.draw()));
        assertEquals(0, CARD_COMPARATOR.compare(deckOfCards.getTop(), deckOfCards.getBottom()));

    }

}
