public class Player {
    int kills;
    int deaths;
    int assists;
    String nam;

    public Player(String name, int K, int D, int A){
        this.nam = name;
        this.kills = K;
        this.deaths = D;
        this.assists = A;
    }

    public String getKDA() {
        return kills + " " + deaths + " " + assists;
    }

    public String getName(){
        return this.nam;
    }
    public void addKill(){
        this.kills++;
    }
    public void addDeath(){
        this.deaths++;
    }
    public void addAssist(){
        this.assists++;
    }
}
