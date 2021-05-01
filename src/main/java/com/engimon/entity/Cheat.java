package com.engimon.entity;

public class Cheat {

    public Cheat() {

    }
    public static void IncreaseExpBy(int exp) {
        if (Game.getRunningGame() != null) {
            Player player = Game.getRunningGame().getPlayer();
            player.getEngimons().forEach(eng ->{
                try {
                    eng.addExperience(exp);
                } catch (Exception e) {}
            });
            try {
                player.getActiveEngimon().addExperience(exp);
            } catch (Exception e) {}
        }
    }
}
