public interface GameRounds {
    void addKill(int round, String playerName);
    void addDeath(int round, String playerName);
    void addAssist(int round, String playerName);
    void addPLayer(int round, String playerName);
    void addRound();
    String KDAR(int round, String playerName);
}
