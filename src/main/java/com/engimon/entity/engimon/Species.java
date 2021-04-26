package com.engimon.entity.engimon;

import java.awt.Image;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.engimon.common.DataReader;
import com.engimon.common.ResourceReader;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;

import org.jetbrains.annotations.NotNull;

public class Species extends Elementum {

    private static final long serialVersionUID = -6290674014341181063L;
    private String name;
    private List<String> message;
    private int speciesId;
    private static Map<Integer, Species> speciesList = new TreeMap<Integer, Species>();
    private String iconFilepath, spriteFilepath;

    @NotNull
    public static Map<Integer, Species> getSpeciesList() {
        return speciesList;
    }

    public static void setSpeciesList(@NotNull Map<Integer, Species> x) {
        speciesList.clear();
        speciesList.putAll(x);
    }

    @Nullable
    public static Species getSpecies(int idx) {
        return speciesList.getOrDefault(idx, null);
    }

    public static void load(DataReader dr) {
        List<String[]> data = dr.getResult();
        data.remove(0);
        for (String[] each : data) {
            if (each.length != 8)
                continue;
            int speciesId = Integer.valueOf(each[0]);
            String name = each[1];
            Element firstElement = Element.valueOf(each[2]);
            Element secondElement = Element.valueOf(each[3]);
            String[] message = each[4].split(",");
            int uniqueSkillId = Integer.valueOf(each[5]);
            String spriteFilepath = each[6];
            String iconFilepath = each[7];
            try {
                if (secondElement != Element.NONE) {
                    new Species(firstElement, secondElement, speciesId, uniqueSkillId, name, message, iconFilepath,
                            spriteFilepath);
                } else {
                    new Species(firstElement, speciesId, uniqueSkillId, name, message, iconFilepath, spriteFilepath);
                }
            } catch (SkillNotFound snf) {
                snf.printStackTrace();
            }
        }
    }

    @NotNull
    public static Species getRandomSpecies(Elementum el) {
        List<Species> filtered = speciesList.values().stream().filter(x -> x.equals(el)).collect(Collectors.toList());
        SecureRandom sr = new SecureRandom();
        Collections.shuffle(filtered);
        int randomIndex = sr.nextInt(filtered.size());
        return filtered.get(randomIndex);
    }

    @NotNull
    public static Species getRandomSpecies() {
        List<Species> filtered = new ArrayList<>(speciesList.values());
        SecureRandom sr = new SecureRandom();
        Collections.shuffle(filtered);
        int randomIndex = sr.nextInt(filtered.size());
        return filtered.get(randomIndex);
    }

    private Skill uniqueSkill;

    public Species(@NotNull Element firstElement, int speciesId, int uniqueSkillId, @NotNull String name,
            @NotNull String[] message) throws SkillNotFound {
        super(firstElement);
        this.speciesId = speciesId;
        this.name = name;
        this.iconFilepath = "";
        this.spriteFilepath = "";
        this.uniqueSkill = Skill.getSkill(uniqueSkillId);
        if (this.uniqueSkill == null) {
            throw new SkillNotFound(uniqueSkillId);
        }
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
        speciesList.put(speciesId, this);
    }

    public Species(@NotNull Element firstElement, int speciesId, int uniqueSkillId, @NotNull String name,
            @NotNull String[] message, @NotNull String iconFilepath, @NotNull String spriteFilepath)
            throws SkillNotFound {
        super(firstElement);
        this.speciesId = speciesId;
        this.name = name;
        this.iconFilepath = iconFilepath;
        this.spriteFilepath = spriteFilepath;
        this.uniqueSkill = Skill.getSkill(uniqueSkillId);
        if (this.uniqueSkill == null) {
            throw new SkillNotFound(uniqueSkillId);
        }
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
        speciesList.put(speciesId, this);
    }

    public Species(@NotNull Element firstElement, @NotNull Element secondElement, int speciesId, int uniqueSkillId,
            @NotNull String name, @NotNull String[] message) throws SkillNotFound {
        super(firstElement, secondElement);
        this.speciesId = speciesId;
        this.name = name;
        this.iconFilepath = "";
        this.spriteFilepath = "";
        this.uniqueSkill = Skill.getSkill(uniqueSkillId);
        if (this.uniqueSkill == null) {
            throw new SkillNotFound(uniqueSkillId);
        }
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
        speciesList.put(speciesId, this);
    }

    public Species(@NotNull Element firstElement, @NotNull Element secondElement, int speciesId, int uniqueSkillId,
            @NotNull String name, @NotNull String[] message, @NotNull String iconFilepath,
            @NotNull String spriteFilepath) throws SkillNotFound {
        super(firstElement, secondElement);
        this.speciesId = speciesId;
        this.name = name;
        this.iconFilepath = iconFilepath;
        this.spriteFilepath = spriteFilepath;
        this.uniqueSkill = Skill.getSkill(uniqueSkillId);
        if (this.uniqueSkill == null) {
            throw new SkillNotFound(uniqueSkillId);
        }
        this.message = new ArrayList<String>();
        if (message.length > 0) {
            for (String each : message) {
                if (each == null)
                    continue;
                if (each.length() == 0)
                    continue;
                this.message.add(each);
            }
        }
        speciesList.put(speciesId, this);
    }

    @NotNull
    public Skill getUniqueSkill() {
        return this.uniqueSkill;
    }

    @NotNull
    public String getName() {
        return this.name;
    }

    @NotNull
    public String interact() {
        SecureRandom rnd = new SecureRandom();
        return message.get(rnd.nextInt(message.size()));
    }

    public int getSpeciesId() {
        return this.speciesId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (!(o instanceof Species)) {
            return false;
        }
        Species species = (Species) o;
        return speciesId == species.speciesId;
    }

    @Override
    public @NotNull String toString() {
        return String.format("%s/%s", getName(), getElementString());
    }

    @NotNull
    public String getElementString() {
        return super.toString();
    }

    public Image getIcon() {
        if (this.iconFilepath.isEmpty())
            return null;
        return ResourceReader.getImage("Images/Engimon/" + this.iconFilepath, 100, 100);
    }

    public Image getSprite() {
        if (this.spriteFilepath.isEmpty())
            return null;
        return ResourceReader.getImage("Images/Engimon/" + this.spriteFilepath, 20, 20);
    }

}
