package com.engimon.menu;

import javax.swing.JPanel;

import org.jetbrains.annotations.NotNull;

public abstract class EComponent extends JPanel {

    private EPage page;

    public EComponent(@NotNull EPage page) {
        super();
        this.page = page;
    }

    public EComponent() {
    }

    public EPage getPage() {
        return this.page;
    }

}
