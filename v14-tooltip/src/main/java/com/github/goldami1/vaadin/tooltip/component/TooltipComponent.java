package com.github.goldami1.vaadin.tooltip.component;

import com.github.goldami1.vaadin.tooltip.HasTooltip;
import com.github.goldami1.vaadin.tooltip.POSITION;
import com.github.goldami1.vaadin.tooltip.PaperTooltip;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.Html;
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
		this.layout.setWidthFull();
		tooltip = new PaperTooltip();
		this.addDetachListener(e -> disableTooltip());
	}
	
	public Registration addClickListener(ComponentEventListener<ClickEvent<Div>> listener)
	{
		return layout.addClickListener(listener);
	}
	
	public static TooltipComponent setDescription(Component component, String description, int fontSizeInPixels)
	{
		if(fontSizeInPixels<=0)
			throw new IllegalArgumentException("Illegal font size");
		
		TooltipComponent res = setDescription(component, description, false);
		
		res.getTooltip().getTooltipFacade().setSimpleText(description, fontSizeInPixels+"px");
		
		return res;
	}
	
	public static TooltipComponent setDescription(Component component, String description, boolean isHTML)
	{
		TooltipComponent tooltipComponent = new TooltipComponent();
		tooltipComponent.add(component);
        tooltipComponent.getTooltip().getTooltipFacade()
        				.disableAnimation()
        				.disableAnimationDelay()
        				.setPosition(POSITION.RIGHT);
        
        if(isHTML)
        	tooltipComponent.getTooltip().getTooltipFacade()
        					.setHTMLText(new Html(description));
        else
        	tooltipComponent.getTooltip().getTooltipFacade()
        					.setSimpleText(description);
        
		return tooltipComponent;
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
