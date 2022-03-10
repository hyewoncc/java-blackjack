package blackjack.domain;

import blackjack.domain.card.Card;
import blackjack.domain.card.HoldingCard;
import java.util.List;

public class Dealer extends Participant {
    private static final int DEALER_MIN_TOTAL = 17;

    public Dealer(List<Card> cards) {
        super("딜러",new HoldingCard(cards));
    }

    public Card showFirstCard() {
        return super.getHoldingCard().getFirstCard();
    }

    public boolean isFinished() {
        return super.getHoldingCard().calculateScore() >= DEALER_MIN_TOTAL;
    }
}
