package com.engimon.entity;

import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;

public class Cheat {

    public Cheat() {

    }
    private static Engimon firstEngimon;
    private static Engimon secondEngimon;
    private static Engimon thirdEngimon;
    public static Engimon getEngimon() {
        if (firstEngimon != null) {
            return firstEngimon;
        }
        try {
            new Skill(Element.ELECTRIC, 0, "Tidak Berguna", 0.0D);

            Species species1 = new Species(Element.ELECTRIC, 100, 0, "Pikaco",
                    new String[] { "sheeshhhh", "pikapika" });
            Engimon engimon1 = new Engimon(species1);
            firstEngimon = engimon1;
            return firstEngimon;
        } catch (SkillNotFound ignored) {
            return null;
        }
    }

    public static Engimon getSecondEngimon() { // Fungsi ngetes doang
        if (secondEngimon != null) {
            return secondEngimon;
        }
        try {
            new Skill(Element.ELECTRIC, 1, "SambarListrik", 50.0D);

            Species species1 = new Species(Element.ELECTRIC, 101, 1, "Electabuz", new String[] { "buzz", "buzbuzbuzz" });
            Engimon engimon1 = new Engimon(species1);
            secondEngimon = engimon1;
            return secondEngimon;
        } catch (SkillNotFound ignored) {
            return null;
        }
    }

    public static Engimon getThirdEngimon() { // Fungsi ngetes doang
        if (thirdEngimon != null) {
            return thirdEngimon;
        }
        try {
            new Skill(Element.ELECTRIC, 2, "KilatListrik", 50.0D);

            Species species1 = new Species(Element.ELECTRIC, 102, 2, "Armadilo", new String[] { "wiii", "saya berguling!" });
            Engimon engimon1 = new Engimon(species1);
            try {
                engimon1.addSkill(Skill.getSkill(0));
                engimon1.addSkill(Skill.getSkill(1));
            } catch (Exception e) {}
            thirdEngimon = engimon1;
            return thirdEngimon;
        } catch (SkillNotFound ignored) {
            return null;
        }
    }
}
