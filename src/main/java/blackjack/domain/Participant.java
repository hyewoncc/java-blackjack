package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.HoldingCard;
import java.util.List;

public abstract class Participant {
    private String name;
    private HoldingCard holdingCard;

    public Participant(String name, HoldingCard holdingCard) {
        this.name = name;
        this.holdingCard = holdingCard;
    }

    void receiveCard(Card card){
        holdingCard.add(card);
    };

    List<Card> showCards(){
        return holdingCard.getHoldingCard();
    };

    public String getName() {
        return name;
    }

    public HoldingCard getHoldingCard() {
        return holdingCard;
    }

    public boolean isBust() {
        return holdingCard.isBust();
    }

    public int getScore() {
        int score = holdingCard.calculateScore();
        if (score > 21) {
            return 0;
        }
        return score;
    }

    public abstract boolean isFinished();
}
