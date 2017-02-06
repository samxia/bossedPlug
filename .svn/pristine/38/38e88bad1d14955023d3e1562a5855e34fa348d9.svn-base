/**
function dateFormatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
function isDate(dateValue) {
	var regex = new RegExp(
			"^(?:(?:([0-9]{4}(-|\/)(?:(?:0?[1,3-9]|1[0-2])(-|\/)(?:29|30)|((?:0?[13578]|1[02])(-|\/)31)))|([0-9]{4}(-|\/)(?:0?[1-9]|1[0-2])(-|\/)(?:0?[1-9]|1\\d|2[0-8]))|(((?:(\\d\\d(?:0[48]|[2468][048]|[13579][26]))|(?:0[48]00|[2468][048]00|[13579][26]00))(-|\/)0?2(-|\/)29))))$");
	if (!regex.test(dateValue)) {
		return false;
	} else {
		return true;
	}
}*/
var Util = {
	createNew : function() {
		var util = {};
		util.isDate = function(dateValue) {
			var regex = new RegExp(
					"^(?:(?:([0-9]{4}(-|\/)(?:(?:0?[1,3-9]|1[0-2])(-|\/)(?:29|30)|((?:0?[13578]|1[02])(-|\/)31)))|([0-9]{4}(-|\/)(?:0?[1-9]|1[0-2])(-|\/)(?:0?[1-9]|1\\d|2[0-8]))|(((?:(\\d\\d(?:0[48]|[2468][048]|[13579][26]))|(?:0[48]00|[2468][048]00|[13579][26]00))(-|\/)0?2(-|\/)29))))$");
			if (!regex.test(dateValue)) {
				return false;
			} else {
				return true;
			}
		};
		util.dateFormatter=function(date){
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			var d = date.getDate();
			return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
		};
		return util;
	}
};
function utilGetQueryString(name) {
	   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");
	   var r = location.search.substr(1).match(reg);
	   if (r!=null) return (r[2]); return null;
	}

