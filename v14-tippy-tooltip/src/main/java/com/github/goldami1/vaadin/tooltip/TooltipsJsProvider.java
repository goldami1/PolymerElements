package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@Tag("tippy-tooltip")
@JsModule("./js/tooltip/tooltips.js")
@NpmPackage(value = "tippy.js", version = "^5.1.2")
/*
 If you wish to include your own JS modules in the add-on jar, add the module
 files to './src/main/resources/META-INF/resources/frontend' and insert an
 annotation @JsModule("./my-module.js") here.
*/
public class TooltipsJsProvider extends Component
{
	private static final long serialVersionUID = 3244552910381525105L;

	public TooltipsJsProvider()
	{
		
    }

}
