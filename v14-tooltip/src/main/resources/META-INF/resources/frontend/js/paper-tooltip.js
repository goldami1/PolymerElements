import {PolymerElement, html} from '@polymer/polymer';
import '@polymer/paper-tooltip/paper-tooltip.js';

window.tooltips = {
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
			document.querySelectorAll(newClassname)[0].shadowRoot.innerHTML = domRes;
			
			window.tooltips.enableTooltip(newClassname);
		},
		
		disableTooltip: function(classname) {
			var element = document.getElementsByClassName(classname)[0];
			element.removeEventListener('mouseenter', _foo1);
			element.removeEventListener('mouseleave', _foo2);
		},
		
		enableTooltip: function(classname)
		{
			var currentElem = document.querySelectorAll(classname)[0];
			
			currentElem.target.addEventListener('mouseenter', function _foo1()
			{
				currentElem.shadowRoot.lastElementChild.classList.remove('hidden');
				currentElem.updatePosition();
			});
			currentElem.target.addEventListener('mouseleave', function _foo2()
			{
				currentElem.shadowRoot.lastElementChild.classList.add('hidden');
				currentElem.updatePosition();
			}); 
		}
}



