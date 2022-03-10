package blackjack.domain.strategy;

import blackjack.domain.card.Card;
import blackjack.domain.card.CardNumber;
import blackjack.domain.card.Symbol;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RandomCardGenerator implements CardGenerator{
    @Override
    public List<Card> generate() {
        List<Card> cards = createCards();
        Collections.shuffle(cards);
        return cards;
    }

    private List<Card> createCards() {
        return Arrays.stream(Symbol.values())
                .flatMap(symbol -> createSymbolCards(symbol).stream())
                .collect(Collectors.toList());
    }

    private List<Card> createSymbolCards(Symbol symbol) {
        return Arrays.stream(CardNumber.values())
                .map(cardNumber -> new Card(cardNumber, symbol))
                .collect(Collectors.toList());
    }
}
