package blackjack.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participants {
    private final List<Participant> participants;
    private int nowTurnIndex;

    public Participants(List<Participant> participants) {
        validateEmptyNames(participants);
        this.participants = participants;
        this.nowTurnIndex = 0;
    }

    private void validateEmptyNames(List<Participant> playerNames) {
        if (playerNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 이름이 있습니다.");
        }
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public boolean isFinished() {
        return nowTurnIndex >= participants.size();
    }

    public Participant getCurrentPlayer() {
        return participants.get(nowTurnIndex);
    }

    public void skipTurn() {
        nowTurnIndex++;
    }

    public Map<GameResult, Integer> getDealerGameResult(int dealerScore) {
        Map<GameResult, Integer> gameResult = GameResult.createInitMap();
        for (Participant participant : participants) {
            GameResult result = GameResult.compare(dealerScore, participant.getScore());
            gameResult.put(result, gameResult.getOrDefault(result,0) + 1);
        }
        return gameResult;
    }

    public Map<String, GameResult> getPlayersGameResult(int dealerScore) {
        HashMap<String, GameResult> playersGameResult = new HashMap<>();
        for (Participant participant : participants) {
            GameResult result = GameResult.compare(participant.getScore(), dealerScore);
            playersGameResult.put(participant.getName(), result);
        }
        return playersGameResult;
    }
}
