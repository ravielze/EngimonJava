package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import java.util.TreeMap;

import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.SkillNotFound;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSpecies {

    private final Skill skill = new Skill(Element.FIRE, Element.ELECTRIC, 1, "ThunderBoom", 50.0D);

    @Test
    @DisplayName("Test Species - getSpeciesList()")
    void testgetSpeciesList(){
        String[] pesan = { "aku bisa bikin api", "aku takut petir" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals(spesies.getName(), Species.getSpeciesList().get(1).getName());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test setSpeciesList()")
    void testsetSpeciesList(){
        String[] pesan = { "aku bisa bikin api", "aku takut petir" };
        try{
            Map<Integer, Species> speciesList = new TreeMap<Integer, Species>();
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            Species.setSpeciesList(speciesList);
            assertEquals(speciesList, Species.getSpeciesList());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test Species - getUniqueSkill()")
    void testgetUniqueSkill(){
        String[] pesan = { "aku bisa bikin api", "aku takut petir" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals(skill.getSkillId(), spesies.getUniqueSkill().getSkillId());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test Species - getName()")
    void testgetName(){
        String[] pesan = { "aku bisa bikin api", "aku takut petir" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals("ApiPetir", spesies.getName());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test Species - getinteract()")
    void testinteract(){
        String[] pesan = { "aku bisa bikin api" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals("aku bisa bikin api", spesies.interact());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test Species - getSpeciesId()")
    void testgetSpeciesId(){
        String[] pesan = { "aku bisa bikin api" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals(1, spesies.getSpeciesId());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test Species - equals(Object o)")
    void testequals(){
        String[] pesan = { "aku bisa bikin api" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals(true, spesies.equals(spesies));
            assertEquals(false, spesies.equals(null));
            assertEquals(false, spesies.equals("objek berbeda"));
            assertEquals(false, spesies.equals(new Species(Element.FIRE, 2, 2, "Apii", pesan)));
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test Species - getElementString()")
    void testgetElementString(){
        String[] pesan = { "aku bisa bikin api" };
        try{
            Species spesies = new Species(Element.FIRE, Element.ELECTRIC, 1, 1, "ApiPetir", pesan);
            assertEquals("FIRE-ELECTRIC", spesies.getElementString());
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }
}
