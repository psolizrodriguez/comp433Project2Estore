/**
 * Author: Beans Factory Date: 13-Jun-2012 Description: Common java script
 * functions to be used within the application
 */
$(function() {
	$.i18n.properties({
		name : [ 'jserrormessages', 'jscommonparameters' ],
		path : 'resources/',
		callback : function() {
		}
	});
});
// Name Validation
function isValidName(Element) {
	var rg = new RegExp(/^[A-Za-z\s'.]+$/gi);
	name = Element.value;
	if (String(rg.test(name)) == "false") {
		window.event.returnValue = false;
	}
}

function validateFromToDate(fromDateId, fromDateLabel, toDateId, toDateLabel) {
	var sdf = new JsSimpleDateFormat(param.common.date_format.codes);
	var objFromDate = $('#' + fromDateId).val();
	var objToDate = $('#' + toDateId).val();
	if (objFromDate != '') {
		if (objToDate != '') {
			var date1 = sdf.parse(objFromDate);
			var date2 = sdf.parse(objToDate);
			if (date1 > date2) {
				alert(msg.invalid.fromDate_toDate.codes(fromDateLabel,
						toDateLabel));
				return false;
			} else {
				return true;
			}
		} else {
			alert(msg.invalid.empty.codes(fromDateLabel));
			return false;
		}
	} else {
		alert(msg.invalid.empty.codes(toDateLabel));
		return false;
	}
}

function roundNumber(element, decallowed) {
	var aux = element.value;
	var valor = aux.indexOf(".");
	if (valor != null && valor != -1) {
		var decText = aux.substring(valor + 1, aux.length);
		if (decText.length > decallowed) {
			var lim = valor + 1 + decallowed;
			var decFlag = aux.substring(lim, lim + 1);
			decText = aux.substring(valor + 1, lim);
			if (decFlag > 5) {
				decText++;
			}
			element.value = "" + aux.substring(0, valor) + "." + decText;
		}

		aux = element.value;
		var auxLast = aux.substring(aux.length - 1, aux.length);
		var auxNewLim = aux.length;
		while (auxLast == 0) {
			auxNewLim--;
			auxLast = aux.substring(auxNewLim - 1, auxNewLim);
		}
		if (auxLast == ".") {
			auxNewLim--;
		}
		element.value = "" + aux.substring(0, auxNewLim);

	}
}
function ValidateNumber(element, intallowed, decallowed) {
	var dato = element.value;
	var valor = dato.indexOf(".");
	if (window.event.keyCode != 8 && window.event.keyCode != 37
			&& window.event.keyCode != 39 && window.event.keyCode != 9) {
		if ((window.event.keyCode > 47 && window.event.keyCode < 58)
				|| window.event.keyCode == 46) {
			if (window.event.keyCode == 46) {
				if (valor >= 0 || decallowed == 0) {
					window.event.returnValue = false;
				}
			} else {
				if (valor != -1) {
					dectext = dato.substring(valor + 1, dato.length);
					if (dectext.length >= decallowed) {
						window.event.returnValue = false;
					}
				} else {
					if (dato.length >= intallowed) {
						window.event.returnValue = false;
					}
				}
			}
		} else {
			window.event.returnValue = false;
		}
	}
}
function enviarFormulario(value) {
	$('#' + value).submit();
}
function changeActionFormulario(value, newName) {
	$('#' + value).get(0).setAttribute('action', newName);
	$('#' + value).submit();
}
function isInteger(value) {
	var numericExpression = /^[0-9]{11}$/;
	alert("value " + value);
	alert("result " + value.match(numericExpression));
	return value.match(numericExpression);
}
function openLocation(url) {
	window.location = url;
}
function confirmdelete() {
	var agree = confirm(msg.confirm.deleteConfirmation.codes);
	if (agree)
		return true;
	else
		return false;
}
function confirmNotNull(value) {
	return value != null && value.length > 0;
}
function alertAndFocus(element, message) {
	alert(message);
	element.focus();
}
function MaxLength(textField, length) {
	if (textField.value.length < length) {
		window.event.returnValue = true;
	} else {
		window.event.returnValue = false;
	}
}
function getCheckedRadio(radioName) {
	var radioButtons = document.getElementsByName(radioName);
	for ( var x = 0; x < radioButtons.length; x++) {
		if (radioButtons[x].checked) {
			alert("You checked " + radioButtons[x].id);
			return radioButtons[x].id;
		}
	}
	return -1;
}
function verifyNotNullValues(controlIds, controlLabels) {
	for (index in controlIds) {
		var tempVal = $('#' + controlIds[index]).val();
		if (tempVal == null || tempVal.length == 0) {
			alert(msg.invalid.empty.codes(controlLabels[index]));
			$('#' + controlIds[index]).focus();
			return false;
		}
	}
	return true;
}
