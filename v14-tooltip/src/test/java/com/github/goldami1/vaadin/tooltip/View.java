package com.github.goldami1.vaadin.tooltip;

import com.github.goldami1.vaadin.tooltip.component.TooltipComponent;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends VerticalLayout
{
	private static final long serialVersionUID = -4372176211379612378L;
	private static String labelPrefix = "Item No. ";
	
	public View()
	{
		this.setSizeFull();
		
		for(int i=0; i<10; i++)
		{
			TooltipComponent tc = TooltipComponent.setDescription(new Label(labelPrefix+i), "Hello World - tooltip", 30);
			
			tc.addClickListener(e ->
			{
				if(tc.getTooltip().getTooltipFacade().isEnabled())
	        		tc.disableTooltip();
	        	else
	        		tc.enableTooltip();
			});
			
	        this.add(tc);
		}
    }
}
