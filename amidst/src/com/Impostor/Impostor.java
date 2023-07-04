package com.Impostor;
import com.Player.Player;

public interface Impostor {
    public abstract void freeze(Player p);
    public abstract void sabotage(Player p);
}
