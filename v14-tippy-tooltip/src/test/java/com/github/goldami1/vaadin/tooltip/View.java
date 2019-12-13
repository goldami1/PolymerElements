package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div
{
	private static final long serialVersionUID = -4372176211379612378L;

	public View() {
        TippyTooltip paperSlider = new TippyTooltip();
        add(paperSlider);
    }
}
