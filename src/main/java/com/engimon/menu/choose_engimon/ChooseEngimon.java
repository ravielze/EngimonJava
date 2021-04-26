package com.engimon.menu.choose_engimon;

import java.util.List;

import javax.swing.Box;

import com.engimon.entity.Game;
import com.engimon.entity.Player;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.skill.SkillItem;
import com.engimon.inventory.Storable;
import com.engimon.menu.EPage;
import com.engimon.menu.component.EColumn;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ChooseEngimon extends EPage {

    private Player player;
    private List<Engimon> engiInventory;
    private List<SkillItem> skillInventory;
    private ChooseMode mode;
    private EColumn column = new EColumn();
    public ChooseEngimon(ChooseMode mode) {
        super();
        this.mode = mode;
        update();
    }

    @Override
    public void update() {
        if (Game.getRunningGame() == null) {
            return;
        }
        player = Game.getRunningGame().getPlayer();
        engiInventory = player.getEngimons();
        skillInventory = player.getItems();
        column.removeAll();
        removeAll();
        // column = new EColumn();
        
        if (mode == ChooseMode.ALL) {
            show(engiInventory);
            show(skillInventory);
        } else if (mode == ChooseMode.ENGIMON) {
            show(engiInventory);
        } else if (mode == ChooseMode.SKILLITEM) {
            show(skillInventory);
        }
    }

    private void show(List<? extends Storable> list) {
        add(Box.createRigidArea(new Dimension(0,100)));
        list.forEach(item -> {
            EngimonCard card = new EngimonCard(item);
            card.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (item instanceof Engimon) {
                        chooseEngimon((Engimon) item, card);
                    } else if (item instanceof SkillItem) {
                        chooseSkillItem((SkillItem) item, card);
                    }
                }
            });
            column.add(card);
        });
        add(column);
        revalidate();
    }

    public enum ChooseMode{

        NONE(999999), ALL(0), ENGIMON(1), SKILLITEM(2);
    
        private final int index;
    
        private ChooseMode(int index) {
            this.index = index;
        }
    
        public int getIndex() {
            return index;
        }
    
    }
    
    public void setMode(ChooseMode mode) {
        this.mode = mode;
    }
    @Override
    public String getName() {
        return "choose_engimon";
    }

    public abstract void chooseEngimon(Engimon e, EngimonCard ec);
    public abstract void chooseSkillItem(SkillItem e, EngimonCard ec);
    
}
