package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.dom.Element;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Builder
public class StateData
{
	@NonNull @Getter
	private Element domElement;
	@NonNull @Getter @Setter @Builder.Default
	private String text = "";
	@NonNull @Getter @Setter @Builder.Default
	private String fontSize = "10px";
	@Getter
	private Element domElementWrapper;
	
	public void setDomElementWrapper(Element domElement)
	{
		domElementWrapper = domElement;
	}
}