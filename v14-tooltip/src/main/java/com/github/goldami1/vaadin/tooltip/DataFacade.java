package com.github.goldami1.vaadin.tooltip;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import com.vaadin.flow.dom.Element;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.UI;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder(toBuilder=true, builderClassName="DataFacadeInternalBuilder", builderMethodName="internalBuilder")
public class DataFacade
{ 
	private UI ui;
	private enum JS_METHODS{
		enableAndUpdateTooltip("window.papertooltips.enableAndUpdateTooltip($0)"),
		setFontSize("window.papertooltips.setFontSize($0,$1)"),
		disableTooltip("window.papertooltips.disableTooltip($0)");
		
		String jsMethod;
		
		JS_METHODS(String jsMethod)
		{
			this.jsMethod = jsMethod;
		}
		
		@Override
		public String toString()
		{
			return jsMethod;
		}
	}
	@NonNull @Getter
	private StateData tooltipState;
	@Getter
	private final String uuid = createUUID();
	
	public String getTitle()
	{
		return Optional.ofNullable(getDomElement().getAttribute("title")).get();
	}
	
	public DataFacade disableAnimationDelay()
	{
		getDomElement().setAttribute("animation-delay", "0");
		return this;
	}
	
	public DataFacade disableAnimation()
	{
		getDomElement().setAttribute("animation-entry", "null");
		getDomElement().setAttribute("animation-exit", "null");
		return this;
	}
	
	public void setHTMLText(@NonNull Html text)
	{
		getDomElement().appendChild(text.getElement());
	}
	
	public void setSimpleText(@NonNull String text, @NonNull String fontSize)
	{
		setSimpleText(text);
		ui.access(() -> ui.getPage().executeJs(JS_METHODS.setFontSize.toString(), uuid, fontSize));
		tooltipState.setFontSize(fontSize);
	}
	
	public DataFacade setFixedPosition()
	{
		ui.access(() -> ui.getPage().executeJs(JS_METHODS.enableAndUpdateTooltip.toString(), uuid));
		return this;
	}
	
	public void setSimpleText(@NonNull String text)
	{
		getDomElement().setText(text);
		tooltipState.setText(text);
	}

	public DataFacade setPosition(@NonNull POSITION position)
	{
		getDomElement().setAttribute("position", position.toString());
		return this;
	}
	
	public void setWrapperElement(Element wrapperElement)
	{
		tooltipState.setDomElementWrapper(wrapperElement);
	}
	
	public void removeTooltip()
	{
//		disableTooltip();
		getDomElementWrapper().removeChild(getDomElement());
	}
	
	public void addTooltip()
	{
		getDomElementWrapper().appendChild(getDomElement());
		setSimpleText(tooltipState.getText(), tooltipState.getFontSize());
	}
	
	@SuppressWarnings("unused")
	@Deprecated
	private void disableTooltip()
	{
		ui.access(() -> ui.getPage().executeJs(JS_METHODS.disableTooltip.toString(), uuid));
	}
	
	public DataFacade setId(@NonNull String id)
	{
		getDomElement().setAttribute("for", id);
		return this;
	}
	
	public boolean isEnabled()
	{
		return Optional.ofNullable(getDomElement().getParent()).isPresent();
	}
	
	public static CustomBuilder builder()
	{
		return new CustomBuilder();
	}
	
	private DataFacade init()
	{
		setId(uuid);
		ui = UI.getCurrent();
		getDomElement().getClassList().add(uuid);
		
		return this;
	}
	
	private String createUUID()
	{
		String res = new StringBuilder()
				.append((char)('a' + new Random().nextInt('z'-'a')))
				.append(UUID.randomUUID().toString()).toString();
		return res;
	}
	
	private Element getDomElement()
	{
		return tooltipState.getDomElement();
	}
	
	private Element getDomElementWrapper()
	{
		return tooltipState.getDomElementWrapper();
	}
	
	public static class CustomBuilder extends DataFacadeInternalBuilder
	{
		public CustomBuilder()
		{
			super();
		}
		
		@Override
		public DataFacade build()
		{
			return super.build().init();
		}
	}
}
