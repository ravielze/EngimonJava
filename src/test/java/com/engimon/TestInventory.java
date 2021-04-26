package com.engimon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.engimon.entity.enums.Element;
import com.engimon.entity.skill.Skill;
import com.engimon.entity.skill.SkillItem;
import com.engimon.exception.InventoryFull;
import com.engimon.inventory.Inventory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestInventory {

    private Skill skillE = new Skill(Element.ELECTRIC, 101, "Lightning Stiletto", 84);
    private SkillItem skillItem1 = new SkillItem(skillE);
    private Skill skillQ = new Skill(Element.ELECTRIC, 102, "Lightning Blade", 90);
    private SkillItem skillItem2 = new SkillItem(skillQ);

    @Test
    @DisplayName("Test constructor Inventory")
    void testconstructorInventory(){
        Inventory<Integer> I1 = new Inventory<Integer>(10);
        assertEquals(false, I1 == null);
        assertEquals(0, I1.size());
    } 

    @Test
    @DisplayName("Test add")
    void testadd1(){
        try{
            Inventory<SkillItem> I1 = new Inventory<SkillItem>(5);
            I1.add(skillItem1);
            assertEquals(1, I1.size());
            assertEquals(skillItem1, I1.get(0));
        }
        catch (InventoryFull e){
            assert(false);
        }
        Inventory<Integer> I2 = new Inventory<Integer>(0);
        try{
            I2.add(1);
            assert(false);
        }
        catch (InventoryFull e){}
        finally{
            assertEquals(true, I2.size() == 0);
        }
    }


    @Test
    @DisplayName("Test addAll - no index")
    void testaddAll1(){
        try{
            Inventory<SkillItem> I1 = new Inventory<SkillItem>(5);
            I1.add(skillItem1);
            Inventory<SkillItem> I2 = new Inventory<SkillItem>(2);
            I2.add(skillItem2);
            I2.addAll(I1);
            assertEquals(2, I2.size());
            assertEquals(skillItem2, I2.get(0));
            assertEquals(skillItem1, I2.get(1));
        }
        catch (InventoryFull e){
            e.getMessage();
        }
    }


    @Test
    @DisplayName("Test addAll - with index")
    void testaddAll2(){
        try{
            Inventory<Integer> I1 = new Inventory<Integer>(5);
            I1.add(1);
            I1.add(2);
            Inventory<Integer> I2 = new Inventory<Integer>(2);
            I2.add(3);
            I2.addAll(1, I1);
            assertEquals(3, I2.size());
            assertEquals(true, I2.get(2) == 2);
            assertEquals(true, I2.get(0) == 3);
        }
        catch (InventoryFull e){
            e.getMessage();
        }
    }


    @Test
    @DisplayName("Test add - with index")
    void testadd2(){
        try{
            Inventory<Integer> I1 = new Inventory<Integer>(5);
            I1.add(0, 30);
            assertEquals(1, I1.size());
            assertEquals(true, I1.get(0) == 30);
        } 
        catch (InventoryFull e){
            assert(false);
        }
    }


    @Test
    @DisplayName("Test toString")
    void testtoString(){
        try{
            Inventory<SkillItem> I1 = new Inventory<SkillItem>(5);
            I1.add(skillItem1);
            assertEquals("Inventory 1/5", I1.toString());
        }
        catch (InventoryFull e){
            assert(false);
        }
    }

}
