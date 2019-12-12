package com.github.goldami1.vaadin.appstorage;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div {

    public View() {
        AppStorage paperSlider = new AppStorage();
        add(paperSlider);
    }
}
