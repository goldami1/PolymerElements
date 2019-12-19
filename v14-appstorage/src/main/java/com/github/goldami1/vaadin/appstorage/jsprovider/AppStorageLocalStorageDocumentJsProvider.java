package com.github.goldami1.vaadin.appstorage.jsprovider;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@Tag("app-storage-localstorage-document")
@JsModule("./js/app-storage-localstorage-document.js")
@NpmPackage(value = "@polymer/app-storage", version = "^3.0.2")
/*
 If you wish to include your own JS modules in the add-on jar, add the module
 files to './src/main/resources/META-INF/resources/frontend' and insert an
 annotation @JsModule("./my-module.js") here.
*/
public class AppStorageLocalStorageDocumentJsProvider extends Component
{
	private static final long serialVersionUID = 6584173606720211056L;

	public AppStorageLocalStorageDocumentJsProvider()
	{
		
    }
}
