package davidtam.doc;

public interface DeckOfCards {

    Card getTop();
    Card getBottom();
    void shuffle();
    Card draw();

}