package com.engimon;

import com.engimon.entity.engimon.Elementum;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.engimon.Species;
import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.exception.EngimonDeadException;
import com.engimon.exception.EngimonStateException;
import com.engimon.exception.SkillNotFound;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestEngimon {

    String[] pesan1 = {"sheesshh", "pikapika"};
    String[] pesan2 = {"buzz", "buzbuzbuzz"};
    String[] pesan3 = {"wiii", "saya berguling!"};
    private final Species species1 = new Species(Element.ELECTRIC, 101, 0, "Pikaco", pesan1);
    private final Species species2 = new Species(Element.ELECTRIC, 102, 0, "Electabuz", pesan2);
    private final Species species3 = new Species(Element.GROUND, 103, 7, "Armadilo", pesan3);
    private final Skill skill0 =  new Skill (Element.ELECTRIC, 0, "Unique", 50.0D);
    private final Skill skill1 =  new Skill (Element.ELECTRIC, 1, "SambarListrik", 50.0D);
    private final Skill skill2 =  new Skill (Element.ELECTRIC, 2, "KilatListrik", 50.0D);
    private final Skill skill3 =  new Skill (Element.ELECTRIC, 3, "Halilintar", 150.0D);
    private final Skill skill4 =  new Skill (Element.ELECTRIC, 4, "SentrumListrik",80.0D);
    private final Skill skill5 =  new Skill (Element.FIRE, 5, "Ember", 50.0D);
    private final Skill skill6 =  new Skill (Element.GROUND, 6, "LemparBatu", 50.0D);

    @Test
    @DisplayName("Test getSkill")
    void testgetSkill(){
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            assertEquals(engimon1.getSkill(1), Skill.getSkillList().getSkill(1));
            assertEquals(engimon1.getSkill(2), Skill.getSkillList().getSkill(2));
        }
        catch (SkillNotFound e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - Penuh")
    void testaddSkill1() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            engimon1.addSkill(skill3);
            engimon1.addSkill(skill4);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - yang sudah ada")
    void testaddSkill2() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill1);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - elemen beda")
    void testaddSkill3() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill5);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test replaceSkill - idx not found")
    void testreplaceSkill1() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.replaceSkill(2, skill2);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test replaceSkill - skill already learned")
    void testreplaceSkill2() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.addSkill(skill2);
            engimon1.replaceSkill(2, skill1);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addSkill - elemen beda")
    void testreplaceSkill3() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addSkill(skill1);
            engimon1.replaceSkill(1, skill5);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test hasParent")
    void testhasParent() {
        try{
            Engimon engimon1 = new Engimon(species1);
            Engimon engimon2 = new Engimon(species2);
            Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
            assertEquals(true, engimon3.hasParent());
            assertEquals(false, engimon1.hasParent());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getName")
    void testgetName() {
        try{
            Engimon engimon1 = new Engimon(species1);
            assertEquals("Pikaco", engimon1.getName());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test setName")
    void testsetName() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.setName("Pikacov2");
            assertEquals("Pikacov2", engimon1.getName());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getSpecies")
    void testgetSpecies() {
        try{
            Engimon engimon1 = new Engimon(species1);
            assertEquals(species1, engimon1.getSpecies());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getParentFirst")
    void testgetParentFirst() {
        try{
            Engimon engimon1 = new Engimon(species1);
            Engimon engimon2 = new Engimon(species2);
            Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
            assertEquals(species1, engimon1.getParentFirst());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getParentSecond")
    void testgetParentSecond() {
        try{
            Engimon engimon1 = new Engimon(species1);
            Engimon engimon2 = new Engimon(species2);
            Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
            assertEquals(species2, engimon1.getParentSecond());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getExperience")
    void testgetExperience() {
        try{
            Engimon engimon1 = new Engimon(species1);
            assertEquals(0, engimon1.getExperience());
            engimon1.addExperience(50);
            assertEquals(50, engimon1.getExperience());
            engimon1.addExperience(150);
            assertEquals(100, engimon1.getExperience());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test addExperience - pass max_cumulative_exp")
    void testaddExperience() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addExperience(20100);
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    // Fungsi interact di test di Species

    @Test
    @DisplayName("Test getCumulativeExperience")
    void testgetCumulativeExperience() {
        try{
            Engimon engimon1 = new Engimon(species1);
            assertEquals(0, engimon1.getCumulativeExperience());
            engimon1.addExperience(250);
            assertEquals(250, engimon1.getCumulativeExperience());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getLevel")
    void testgetLevel() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.addExperience(350);
            assertEquals(3, engimon1.getLevel());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getLife")
    void testgetLife() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.getLife();
            assertEquals(3, engimon1.getLife());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test reduceLife : error reduce")
    void testreduceLife1() {
        try{
            Engimon engimon1 = new Engimon(species1);
            assertEquals(3, engimon1.getLife());
            engimon1.reduceLife();
            assertEquals(2, engimon1.getLife());
            engimon1.reduceLife();
            assertEquals(1, engimon1.getLife());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test reduceLife : hp 0")
    void testreduceLife2() {
        try{
            Engimon engimon1 = new Engimon(species1);
            engimon1.reduceLife();
            engimon1.reduceLife();
            engimon1.reduceLife();
        }
        catch (EngimonDeadException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test compareTo ")
    void testcompareTo() {
        // todo
    }

    @Test
    @DisplayName("Test toString ")
    void testtoString() {
        try{
            Engimon engimon1 = new Engimon(species1);
            assertEquals("Pikaco/ELECTRIC/1", engimon1.getLevel());
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test equals ")
    void testequals() {
        try{
            Engimon engimon1 = new Engimon(species1);
            Engimon engimon2 = new Engimon(species2);
            Engimon engimon3 = new Engimon(species1, engimon1, engimon2);
            Engimon engimon4 = new Engimon(species1, engimon1, engimon2);
            Engimon engimon5 = new Engimon(species2, engimon1, engimon3);
            Engimon engimon6 = new Engimon(species2, engimon1, engimon2);
            // Cek parent
            assertEquals(true,engimon3.equals(engimon4));
            assertEquals(false,engimon4.equals(engimon5));
            // Cek exp
            engimon3.addExperience(100);
            assertEquals(false,engimon3.equals(engimon4));
            engimon4.addExperience(100);
            // Cek life
            engimon3.reduceLife();
            assertEquals(false,engimon3.equals(engimon4));
            engimon4.reduceLife();
            // Cek skill
            engimon3.addSkill(skill2);
            assertEquals(false,engimon3.equals(engimon4));
            // Cek species
            assertEquals(false,engimon3.equals(engimon6));
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }

    @Test
    @DisplayName("Test getPower ")
    void testgetPower() {
        try{
            Engimon engimon1 = new Engimon(species1);
            Engimon engimon3 = new Engimon(species3);
            engimon1.getPower(engimon3);
            // Bingung hitung powernya :<
        }
        catch (EngimonStateException e){
            e.getMessage();
        }
    }
    
}