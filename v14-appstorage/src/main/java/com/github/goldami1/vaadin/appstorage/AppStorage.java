package com.github.goldami1.vaadin.appstorage;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@Tag("app-storage")
@JsModule("@polymer/app-storage/app-storage.js")
@NpmPackage(value = "@polymer/app-storage", version = "^3.0.2")
/*
 If you wish to include your own JS modules in the add-on jar, add the module
 files to './src/main/resources/META-INF/resources/frontend' and insert an
 annotation @JsModule("./my-module.js") here.
*/
public class AppStorage extends Component {

    public AppStorage() {
    }

}
