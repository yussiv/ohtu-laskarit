package ohtu;

public class TennisGame {

    private class Player {

        String name;
        int score;

        public Player(String name) {
            this.name = name;
            this.score = 0;
        }
    }

    private Player player1;
    private Player player2;

    public TennisGame(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.name)) {
            player1.score += 1;
        } else {
            player2.score += 1;
        }
    }

    public String getScore() {
        if (isTie()) {
            return tieText();
        }

        if (someoneIsWinning()) {
            if (scoreDifference() == 1) {
                return advantageText();
            } else {
                return wonText();
            }
        }
        
        return scoreAsText(player1.score) + "-" + scoreAsText(player2.score);
    }

    private boolean someoneIsWinning() {
        return player1.score >= 4 || player2.score >= 4;
    }

    private int scoreDifference() {
        return Math.abs(player1.score - player2.score);
    }

    private boolean isTie() {
        return player1.score == player2.score;
    }

    private String scoreAsText(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }

    private String wonText() {
        return "Win for " + leaderName();
    }

    private String advantageText() {
        return "Advantage " + leaderName();
    }

    private String leaderName() {
        return player1.score < player2.score ? player2.name : player1.name;
    }

    private String tieText() {
        if (player1.score == 4) {
            return "Deuce";
        } else {
            return scoreAsText(player1.score) + "-All";
        }
    }
}
