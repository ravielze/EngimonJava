package com.engimon.menu.switch_engimon;

import com.engimon.entity.Game;
import com.engimon.entity.engimon.Engimon;
import com.engimon.entity.skill.SkillItem;
import com.engimon.menu.EMenu;
import com.engimon.menu.choose_engimon.ChooseEngimon;
import com.engimon.menu.choose_engimon.EngimonCard;
import com.engimon.menu.component.ETitle;

public class SwitchEngimon extends ChooseEngimon {

    public SwitchEngimon() {
        super(ChooseMode.ENGIMON);
    }
    @Override
    public void update() {
        super.update();
        
        add(new ETitle("Switch Engimon"), 0);
    }
    @Override
    public void chooseEngimon(Engimon e, EngimonCard ec) {
        Game.getRunningGame().getPlayer().switchEngimon(e);

        EMenu.getInstance().changePage(EMenu.MAIN_PAGE);
    }

    @Override
    public void chooseSkillItem(SkillItem e, EngimonCard ec) {
        
    }
    
}
