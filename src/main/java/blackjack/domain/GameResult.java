package blackjack.domain;

import java.util.EnumMap;
import java.util.Map;

public enum GameResult {
    WIN("승"),
    DRAW("무"),
    LOSE("패");

    private final String result;

    GameResult(String result) {
        this.result = result;
    }

    public static Map<GameResult, Integer> createInitMap() {
        EnumMap<GameResult, Integer> gameResult = new EnumMap<>(GameResult.class);
        return gameResult;

    }

    public static GameResult compare(int score, int targetScore) {
        if (score > targetScore) {
            return WIN;
        }
        if (score < targetScore) {
            return LOSE;
        }
        return DRAW;
    }

    @Override
    public String toString() {
        return result;
    }
}
