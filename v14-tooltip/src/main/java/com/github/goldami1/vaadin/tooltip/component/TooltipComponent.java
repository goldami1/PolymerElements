package com.github.goldami1.vaadin.tooltip.component;

import com.github.goldami1.vaadin.tooltip.HasTooltip;
import com.github.goldami1.vaadin.tooltip.PaperTooltip;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.shared.Registration;

public class TooltipComponent extends Composite<Div> implements HasTooltip
{
	private static final long serialVersionUID = -4085420023557918217L;
	private PaperTooltip tooltip;
	private Div layout;
	private Component element;

	public TooltipComponent()
	{
		this.layout = getContent();
		tooltip = new PaperTooltip();
		this.addDetachListener(e -> disableTooltip());
	}
	
	public Registration addClickListener(ComponentEventListener<ClickEvent<Div>> listener)
	{
		return layout.addClickListener(listener);
	}
	
	public void add(Component element)
	{
		if(this.element == null)
		{
			layout.add(element);
			element.setId(tooltip.getTooltipFacade().getUuid());
			element.getElement().appendChild(tooltip.getElement());
			tooltip.getTooltipFacade().setWrapperElement(element.getElement());
		}
	}
	
	@Override
	public PaperTooltip getTooltip()
	{
		return tooltip;
	}

}
