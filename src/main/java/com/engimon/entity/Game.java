package com.engimon.entity;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.engimon.common.DataReader;
import com.engimon.common.ResourceReader;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.skill.Skill;
import com.engimon.map.Map;
import com.engimon.map.biome.Cell;

import org.jetbrains.annotations.NotNull;

public class Game {

    private static final String gameFileName = "game.dat";
    private static Game runningGame;

    public static Game getRunningGame() {
        return runningGame;
    }

    private Player player;
    private Spawner spawner;
    private StaticSerializer staticSerializer;

    public Game(Player player) {
        if (player != null) {
            this.staticSerializer = StaticSerializer.save();
            this.player = player;
            this.spawner = Spawner.getInstance();
        }
    }

    public static void firstLoad() {
        DataReader dr = new DataReader(new ResourceReader("skill.csv"));
        Skill.load(dr);
        DataReader dr2 = new DataReader(new ResourceReader("species.csv"));
        Species.load(dr2);
    }

    public Game() {
    }

    public static void create(@NotNull Engimon firstEngimon) {
        Game game = new Game();
        Map.getInstance();
        Cell[] cells = Map.getInstance().getTwoSpawnableCell();
        game.player = new Player(firstEngimon, cells[0], cells[1]);
        // TODO random spawn wild engimon
        runningGame = game;
        game.spawner = new Spawner();
        Thread spawningThread = new Thread(new Spawning());
        spawningThread.start();
    }

    public Player getPlayer() {
        return player;
    }

    public static void save(Player player) {
        Game game = new Game(player);
        try {
            FileOutputStream fout = new FileOutputStream(gameFileName);
            ObjectOutputStream oot = new ObjectOutputStream(fout);
            oot.writeObject(game.player);
            oot.writeObject(game.staticSerializer);
            oot.writeObject(game.spawner);
            oot.flush();
            oot.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void load() {
        Game game = new Game(null);
        try {
            FileInputStream fin = new FileInputStream(gameFileName);
            ObjectInputStream oit = new ObjectInputStream(fin);
            Player player = (Player) oit.readObject();
            game.player = player;
            StaticSerializer.load(((StaticSerializer) oit.readObject()));
            game.spawner = (Spawner) oit.readObject();
            oit.close();
            runningGame = game;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
