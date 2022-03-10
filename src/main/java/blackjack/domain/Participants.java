package blackjack.domain;

import java.util.List;

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

    public int getNowTurnIndex() {
        return nowTurnIndex;
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
}
