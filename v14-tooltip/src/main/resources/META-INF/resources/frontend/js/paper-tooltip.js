import {PolymerElement, html} from '@polymer/polymer';
import '@polymer/paper-tooltip/paper-tooltip.js';

window.papertooltips = {
		setFontSize: function(classname, fontSize)
		{
			var newClassname = '.' + classname;
			var current = document.querySelectorAll(newClassname)[0];
			var domRes = current.shadowRoot.innerHTML
			var tooltipBlockRegex = /#tooltip {[^}]*}/g;
			var fontSizeLineRegex = /font-size: [0-9]*px/g;

			var tooltipBlockRes = domRes.match(tooltipBlockRegex)[0];
			var fontSizeLineRes = tooltipBlockRes.match(fontSizeLineRegex)[0];

			domRes = domRes.replace(tooltipBlockRes, tooltipBlockRes.replace(fontSizeLineRes, "font-size: " + fontSize));
			current.shadowRoot.innerHTML = domRes;
			
			window.papertooltips._enableAndUpdateTooltip(newClassname);
		},
		
		_updatePositionAndXY: function(classname)
		{
			var currentElem = document.querySelectorAll(classname)[0];
			
			if(!currentElem)
				return;
			
			currentElem.fitToVisibleBounds = true;
			currentElem.updatePosition();
			currentElem.style.top = currentElem._target.getBoundingClientRect().top + (currentElem._target.offsetHeight - currentElem.offsetHeight) / 2 + 'px';
			switch (currentElem.position) {
				case 'top':
					currentElem.style.top = currentElem.getBoundingClientRect().top - currentElem.offsetHeight + 'px'; 
					break;
				case 'bottom':
					currentElem.style.top = currentElem.getBoundingClientRect().top + currentElem.offsetHeight + 'px';
					break;
			}
			currentElem.style.position = "fixed";
		},
		
		disableTooltip: function(classname) {
			var element = document.getElementsByClassName(classname)[0];
			element.removeEventListener('mouseenter', _foo1);
			element.removeEventListener('mouseleave', _foo2);
		},
		
		enableAndUpdateTooltip: function(classname)
		{
			var newClassname = '.' + classname;
			
			window.papertooltips._enableAndUpdateTooltip(newClassname);
		},
		
		_enableAndUpdateTooltip: function(classname)
		{
			var currentElem = document.querySelectorAll(classname)[0];
			
			currentElem.target.addEventListener('mouseenter', function _foo1()
			{
				currentElem.shadowRoot.lastElementChild.classList.remove('hidden');
				window.papertooltips._updatePositionAndXY(classname);
			});
			currentElem.target.addEventListener('mouseleave', function _foo2()
			{
				currentElem.shadowRoot.lastElementChild.classList.add('hidden');
			}); 
		}
}



