package com.github.goldami1.vaadin.appstorage;

import com.github.goldami1.vaadin.appstorage.jsprovider.AppStorageLocalStorageDocumentJsProvider;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends VerticalLayout
{
	private static final long serialVersionUID = -2264970829737523176L;
	private TextField textField;
	private HorizontalLayout buttonsLayout;
	private Button saveButton, restoreButton, cleanButton; 

	public View()
    {
		initView();
		
		AppStorageLocalStorageDocumentJsProvider appStorage = new AppStorageLocalStorageDocumentJsProvider();
    }

	private void initView()
	{
		this.setSizeFull();
		
		textField = new TextField("Please enter:");
		
		saveButton = new Button("Save");
		restoreButton = new Button("Restore");
		cleanButton = new Button("Clean");
		buttonsLayout = new HorizontalLayout(cleanButton, saveButton, restoreButton);
		
		add(textField, buttonsLayout);
	}
}
