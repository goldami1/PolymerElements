package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.HasElement;

public interface HasTooltip extends HasElement
{
	default void disableTooltip()
	{
		if(isEnabled())
			getTooltip().getTooltipFacade().removeTooltip();
	}
	
	default void enableTooltip()
	{
		getTooltip().getTooltipFacade().addTooltip();
	}
	
	default boolean isEnabled()
	{
		return getTooltip().getTooltipFacade().isEnabled();
	}
	
	PaperTooltip getTooltip();
}
