package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div {

    public View() {
        PaperTooltip paperSlider = new PaperTooltip();
        add(paperSlider);
    }
}
