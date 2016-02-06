package kConnectGame;

/**
 * Created by pankaj on 2/6/16.
 */
public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Player)) return false;
        Player p = (Player) o;
        return this.name.equals(p.name);
    }

    @Override
    public String toString() {
        return name;
    }
}
