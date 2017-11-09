package davidtam.doc;

import java.util.Collections;
import java.util.List;

import static java.util.EnumSet.allOf;
import static java.util.stream.Collectors.toList;

public class DeckOfCardsImpl implements DeckOfCards {

    private List<Card> cards;

    public DeckOfCardsImpl(){
        shuffle();
    }

    public Card getTop() {
        checkDeckHasMoreCards();
        return cards.get(0);
    }

    public Card getBottom() {
        checkDeckHasMoreCards();
        return cards.get(cards.size() - 1);
    }

    public void shuffle() {
        cards = allOf(Rank.class).stream()
                    .flatMap(r -> allOf(Suit.class).stream().map(s -> new Card(r, s)))
                    .collect(toList());
        Collections.shuffle(cards);
    }

    public Card draw() {
        checkDeckHasMoreCards();
        return cards.remove(0);
    }

    private void checkDeckHasMoreCards(){
        if (cards.size() == 0) {
            throw new IllegalStateException("Deck is empty");
        }
    }


}
