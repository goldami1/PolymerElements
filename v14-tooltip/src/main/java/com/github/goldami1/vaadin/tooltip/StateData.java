package com.github.goldami1.vaadin.tooltip;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import com.vaadin.flow.dom.Element;
import com.vaadin.flow.component.Html;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Builder(toBuilder=true, builderClassName="StateDataInternalBuilder", builderMethodName="internalBuilder")
public class StateData
{ 
	@NonNull
	private Element element;
	@Getter
	private final String uuid = createUUID();
	
	public String getTitle()
	{
		return Optional.ofNullable(element.getAttribute("title")).get();
	}
	
	public StateData disableAnimationDelay()
	{
		element.setAttribute("animation-delay", "0");
		return this;
	}
	
	public StateData disableAnimation()
	{
		element.setAttribute("animation-entry", "null");
		element.setAttribute("animation-exit", "null");
		return this;
	}
	
	public void setHTMLText(@NonNull Html text)
	{
		element.appendChild(text.getElement());
	}
	
	public void setSimpleText(@NonNull String text)
	{
		element.setText(text);
	}

	public StateData setPosition(@NonNull POSITION position)
	{
		element.setAttribute("position", position.toString());
		return this;
	}
	
	public StateData setId(@NonNull String id)
	{
		element.setAttribute("for", id);
		return this;
	}
	
	public static CustomBuilder builder()
	{
		return new CustomBuilder();
	}
	
	private StateData init()
	{
		setId(uuid);
		disableAnimationDelay();
		disableAnimation();
		
		return this;
	}
	
	private String createUUID()
	{
		String res = new StringBuilder()
				.append((char)('a' + new Random().nextInt('z'-'a')))
				.append(UUID.randomUUID().toString()).toString();
		return res;
	}
	
	public static class CustomBuilder extends StateDataInternalBuilder
	{
		public CustomBuilder()
		{
			super();
		}
		
		@Override
		public StateData build()
		{
			return super.build().init();
		}
	}
}
