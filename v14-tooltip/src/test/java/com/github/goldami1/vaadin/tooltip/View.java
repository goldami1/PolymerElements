package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.Html;
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
			Label a = new Label();
			a.setText(labelPrefix+i);
	        PaperTooltip paperTooltip = new PaperTooltip();
	        paperTooltip.getTooltipState()
	        			.disableAnimation()
	        			.disableAnimationDelay()
	        			.setPosition(POSITION.RIGHT)
	        			.setHTMLText(new Html("<span style=\"background-color:red\">"+"<span style=\"background-color:red\">"+labelPrefix+i+" tooltip"+"</span>"+"</span>"));
	        a.setId(paperTooltip.getTooltipState().getUuid().toString());
	        a.add(paperTooltip);
	        this.add(a);
		}
    }
}
