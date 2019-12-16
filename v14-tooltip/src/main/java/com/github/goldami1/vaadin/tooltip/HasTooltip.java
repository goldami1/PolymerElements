package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.HasElement;

public interface HasTooltip extends HasElement
{
	default void disableTooltip()
	{
		getTooltip().getTooltipFacade().removeTooltip();
	}
	
	default void enableTooltip()
	{
		getTooltip().getTooltipFacade().addTooltip();
	}
	
	PaperTooltip getTooltip();
}
