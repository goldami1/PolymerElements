package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@Tag("paper-tooltip")
@JsModule("@polymer/paper-tooltip/paper-tooltip.js")
@NpmPackage(value = "@polymer/paper-tooltip", version = "^3.0.1")
/*
 If you wish to include your own JS modules in the add-on jar, add the module
 files to './src/main/resources/META-INF/resources/frontend' and insert an
 annotation @JsModule("./my-module.js") here.
*/
public class PaperTooltip extends Component {

    public PaperTooltip() {
    }

}
