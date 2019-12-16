package com.github.goldami1.vaadin.tooltip;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

import lombok.Getter;
import lombok.NonNull;

@Tag("paper-tooltip")
@JsModule("./js/paper-tooltip.js")
@NpmPackage(value = "@polymer/paper-tooltip", version = "^3.0.1")
public class PaperTooltip extends Component
{
	private static final long serialVersionUID = 6431493404762755091L;
	@NonNull @Getter
	private DataFacade tooltipFacade;
	
	public PaperTooltip()
	{
		tooltipFacade = DataFacade.builder()
									.tooltipState(StateData.builder()
															.domElement(getElement())
															.build())
									.build();
    }
}
