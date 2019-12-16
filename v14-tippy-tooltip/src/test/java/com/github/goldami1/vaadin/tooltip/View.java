package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Inline;
import com.vaadin.flow.component.page.Inline.Position;
import com.vaadin.flow.component.page.TargetElement;
import com.vaadin.flow.router.Route;

@Route("")
@Inline(target=TargetElement.BODY, position=Position.APPEND, value="frontend://init.html")
public class View extends VerticalLayout
{
	private static final long serialVersionUID = -4372176211379612378L;
	private Tooltips tooltipProvider = null;
	
	public View()
	{
		try {
			tooltipProvider = new Tooltips(UI.getCurrent());
		} catch (TooltipsAlreadyInitialized e) {
			e.printStackTrace();
		}
		this.setSizeFull();
		Label current = null;
		
		for(int i=0;i<10;i++)
		{
			current = new Label();
			current.setText("Hello");
			
			if(tooltipProvider == null)
			{
				System.out.println("Return");
				return;
			}
			
			Tooltips.getCurrent().setTooltip(current, "hello world");
	        this.add(current);
		}
    }
}
