package com.github.goldami1.vaadin.tooltip;

import com.github.goldami1.vaadin.tooltip.component.TooltipComponent;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends VerticalLayout
{
	private static final long serialVersionUID = -4372176211379612378L;
	private static String labelPrefix = "Item No. ";
	private TooltipComponent tooltip;
	private boolean isEnabled = true;
	
	public View()
	{
		this.setSizeFull();
		for(int i=0; i<10; i++)
		{
			TooltipComponent tc = new TooltipComponent();
			tc.add(new Label(labelPrefix+i));
	        if(i==5)
	        	tooltip = tc;
	        
	        tc.getTooltip().getTooltipFacade()
	        				.disableAnimation()
	        				.disableAnimationDelay()
	        				.setPosition(POSITION.RIGHT)
	        				.setSimpleText("Hello hello hello", "15px");
//	        				.setHTMLText(new Html("<span style=\"background-color:red\">"+"<span style=\"background-color:red\">"+labelPrefix+i+" tooltip"+"</span>"+"</span>"));
	        
	        this.add(tc);
		}
		
		tooltip.addClickListener(e ->
		{
        	if(isEnabled)
        		tooltip.disableTooltip();
        	else
        		tooltip.enableTooltip();
        	isEnabled = !isEnabled;
		});
		
    }
}
