package blackjack.domain.strategy;

import blackjack.domain.card.Card;
import java.util.List;

public interface CardGenerator {
    List<Card> generate();
}
