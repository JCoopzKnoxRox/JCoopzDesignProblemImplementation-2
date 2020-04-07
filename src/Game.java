import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Game implements GameRounds {
    public ArrayList<ArrayList<Player>> gameRounds;
    public Game(){
        gameRounds = new ArrayList<>();
    }
    public void addKill(int r, String player){
        boolean killAdd = false;
        if(r < 0 || r > (gameRounds.size())){
            throw new IndexOutOfBoundsException();
        }
        else {
            for (Player pl : gameRounds.get(r)) {
                if (pl.getName() == player) {
                    pl.addKill();
                    killAdd = true;
                }
            }
            if (killAdd == false) {
                throw new NoSuchElementException();
            }
        }
    }
    public void addDeath(int r, String player){
        boolean deathAdd = false;
        if(r < 0 || r > (gameRounds.size())){
            throw new IndexOutOfBoundsException();
        }
        else {
            for (Player pl : gameRounds.get(r)) {
                if (pl.getName() == player) {
                    pl.addDeath();
                    deathAdd = true;
                }
            }
            if (deathAdd == false) {
                throw new NoSuchElementException();
            }
        }
    }
    public void addAssist(int r, String player){
        boolean assistAdd = false;
        if(r < 0 || r > (gameRounds.size())){
            throw new IndexOutOfBoundsException();
        }
        else {
            for (Player pl : gameRounds.get(r)) {
                if (pl.getName() == player) {
                    pl.addAssist();
                    assistAdd = true;
                }
            }
            if (assistAdd == false) {
                throw new NoSuchElementException();
            }
        }
    }
    public void addPLayer(int round, String player){
        Player play = new Player(player, 0, 0, 0);
        if(round < 0 || round > (gameRounds.size())){
            throw new IndexOutOfBoundsException();
        }
        for (Player p: gameRounds.get(round)) {
            if (play.getName() == p.getName()){
                throw new IllegalArgumentException();
            }
        }
        gameRounds.get(round).add(play);
    }

    public void addRound() {
        ArrayList<Player> roundUP = new ArrayList<>();
        gameRounds.add(roundUP);
    }

    public String KDAR(int round, String player){
        String KDA = "";
        boolean KDAE = false;
        if(round < 0 || round > gameRounds.size()){
            throw new IndexOutOfBoundsException();
        }
        for (Player p: gameRounds.get(round)) {
            if (player == p.getName()){
                KDA = p.getKDA();
                KDAE = true;
            }
        }
        if (KDAE == false){
            throw new NoSuchElementException();
        }
        return KDA;
    }
}
