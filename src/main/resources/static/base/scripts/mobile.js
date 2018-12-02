var check_mobile = function() {
	
	var page_flg = false;
	
	var mobile_uri = "/mobile/";
	
	this.set_page_flg = function(pf){
		page_flg = pf;
	}
	
	this.set_mobile_uri = function(mu){
		mobile_uri = mu;
	}
	
	//处理函数
	this.browser_redirect = function(){
		
		if (!page_flg)
			return false;
		
		var sUserAgent = navigator.userAgent.toLowerCase();
		var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
		var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
		var bIsMidp = sUserAgent.match(/midp/i) == "midp";
		var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
		var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
		var bIsAndroid = sUserAgent.match(/android/i) == "android";
		var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
		var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";

		console.log(sUserAgent);

		if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
			console.log("phone");
			location.href = mobile_uri;
		} else {
			console.log("pc");
		}
	}
	
	this.is_wechat = function(){
		var ua = navigator.userAgent.toLowerCase();  
		if(ua.match(/MicroMessenger/i)=="micromessenger") {  
				return true;  
			} else {  
				return false;  
			}  
	}
	
};

var cm = new check_mobile();
cm.set_page_flg(false);
cm.set_mobile_uri("/mobile/");
cm.browser_redirect();









