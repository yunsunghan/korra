/* gnb */
(function() {
	var _d = document,
		index = 0,
		hook, objanchor, depth = [];


	var _getID = function(element) {
		return _d.getElementById(element);
	};

	var addEvent = function(element, type, callback) {
		if (element.addEventListener) {
			element.addEventListener(type, callback, false);
		} else if (element.attachEvent) {
			element.attachEvent('on' + type, callback);
		}
	};

	var initialize = function() {
		hook = _getID('ddtabs1');
		if (!hook) return;
		objanchor = hook.getElementsByTagName('a');

		for (var i=0; i<objanchor.length; i++) {
			if (objanchor[i].parentNode.parentNode == hook) {
				depth.push(objanchor[i]);
				objanchor[i].onmouseover = depthEvent(index);
				index++;
			} else {
			}
		}
	};
	var depthEvent = function(num) {
		return function(e) {
			/*
			for (var i=0; i<depth.length; i++) {
				if (i == num) {
					depth[i].parentNode.getElementsByTagName('ul')[0].style.display = 'block';
				} else {
					depth[i].parentNode.getElementsByTagName('ul')[0].style.display = 'none';
				}
			}
			*/
		}
	};
	addEvent(window, 'load', initialize);
})();

function sortControl(tableName, headRowCount){
	this.container = document.getElementById(tableName);
	this.headRowCount = headRowCount || 0;
	this.count = this.container.rows.length;

	this.moveUp = sortControl.moveUp;
	this.moveDown = sortControl.moveDown;
}

sortControl.moveUp = function(rowName, sortName, index) {

	var sourceRow = this.container.rows(rowName + index);
	var rowIndex = sourceRow.rowIndex;
	
	if(rowIndex - this.headRowCount <= 0) return;

	var targetRow = this.container.rows(rowIndex - 1);
	var targetIndex = targetRow.id.replace(rowName, "");
	
	var sourceSort = document.getElementById(sortName + index);
	var targetSort = document.getElementById(sortName + targetIndex);
	
	sortControl.swapValue(sourceSort, targetSort);
	sourceRow.swapNode(targetRow);
	document.documentElement.scrollTop = document.documentElement.scrollTop - sourceRow.clientHeight;
}

sortControl.moveDown = function(rowName, sortName, index) {

	var sourceRow = document.getElementById(rowName + index);
	var rowIndex = sourceRow.rowIndex;

	if(rowIndex >= (this.count - 1)) return;
	
	var targetRow = this.container.rows(rowIndex + 1);
	var targetIndex = targetRow.id.replace(rowName, "");
	
	var sourceSort = document.getElementById(sortName + index);
	var targetSort = document.getElementById(sortName + targetIndex);
	
	sortControl.swapValue(sourceSort, targetSort);
	sourceRow.swapNode(targetRow);
	document.documentElement.scrollTop = document.documentElement.scrollTop + sourceRow.clientHeight;
}

sortControl.swapValue = function(sourceControl, targetControl){
	var tempValue = sourceControl.value;
	sourceControl.value = targetControl.value;
	targetControl.value = tempValue;
}

/* popup */
function popup(url,wName,w,h){
	window.open(url,wName,'width='+w+',height='+h+',resizable=0,scrollbars=0');
}
function popupscroll(url,wName,w,h){
	window.open(url,wName,'width='+w+',height='+h+',resizable=1,scrollbars=1');
}