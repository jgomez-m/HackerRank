package julian.solution;

import java.util.*;

public class PirateGame {

    private List<Pirate> players = new ArrayList<>();

    public static void main(String[] args) {
        new PirateGame().pirateGame(3,3);
    }

    private void pirateGame(int numPirates, int gold) {
        assignVotes(numPirates);
        //count votes
        String winner = getWinnerVote();
        Pirate mostSenior = getMostSenior(players);
        if (winner.equals("yes")) {
            finishGame(numPirates);
        }
        else if (winner.equals("no")) {
            pirateGame(numPirates-1, gold);
        }
        else { // tie case
            if (mostSenior.getVote().equals("yes")) {
                finishGame(numPirates);
            }
            else {
                pirateGame(numPirates-1, gold);
            }
        }
    }

    private void finishGame(int numPirates) {
        System.out.println("FINISHED - The distribution is accepted: numPirates=" + numPirates);
    }

    private Pirate getMostSenior(List<Pirate> players) {
        return Collections.max(players, Comparator.comparingInt(Pirate::getSeniorExperience));
    }

    private String getWinnerVote() {
        Map<String, Integer> votes = new HashMap<>();
        for (Pirate p: players){
            String vote = p.getVote();
            votes.merge(vote, 1, Integer::sum);
        }
        if (votes.get("yes") > votes.get("no")) {
            return "yes";
        }
        else if (votes.get("yes") < votes.get("no")) {
            return "no";
        }
        return "tie";
    }

    // Algorithm to create Pirates and the votes
    private void assignVotes(int numPirates) {
        String response = "";
        for (int i=0; i<numPirates; i++) {
            Pirate p = new Pirate();
            if (i%2 == 0) { // even
                int exp = getExp();
                p.setSeniorExperience(exp);
                p.setVote("yes");
            }
            else { // odd
                int exp = getExp();
                p.setSeniorExperience(exp);
                p.setVote("no");
            }
            players.add(p);
        }
    }

    private static int getExp() {
        Random r = new Random();
        int low = 1;
        int high = 10;
        return r.nextInt(high-low) + low;
    }

    class Pirate {
        String vote;
        int seniorExperience;

        public int getGold() {
            return gold;
        }

        public void setGold(int gold) {
            this.gold = gold;
        }

        public int getSeniorExperience() {
            return seniorExperience;
        }

        public void setSeniorExperience(int seniorExperience) {
            this.seniorExperience = seniorExperience;
        }

        public String getVote() {
            return vote;
        }

        public void setVote(String vote) {
            this.vote = vote;
        }

        int gold;
    }

    // 1 votes - yes
    // 5 vote - no
}
