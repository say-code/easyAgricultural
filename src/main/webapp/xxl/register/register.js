//定义一个函数获取节点对象
function $(id){
	return document.getElementById(id);
}
/*--定义一个判断密码强弱程度的函数--*/
function getLevel(pwd){  //string
	var level = 0;
	var isNummberFlag = true;  //标识是含有数字   true：没有  false 有
	var isWordFlag = true; //标识是含有字母   true：没有  false 有
	var isOtherFlag = true;//标识是含有其他字符   true：没有  false 有
	for(var i = 0;i<pwd.length;i++){
		var regs = /\d/;
		var reg = /[a-zA-Z]/;
		if(regs.test(pwd[i])){
			if(isNummberFlag){
				level++;
				isNummberFlag = false;
			}
		}else if(reg.test(pwd[i])){
			if(isWordFlag){
				level++;
				isWordFlag = false;
			}
		}else{
			if(isOtherFlag){
				level++;
				isOtherFlag = false;
			}
		}
	}
	return level;
}
//页面加载完成执行
window.onload = function(){
	//获取需要的节点对象
	var userName = $("userName");
	var psd = $("psd");
	var psd1 = $("psd1");
	var email = $("email");
	var phone = $("phone");
	var btn = $("btn");
	var ck = $("ck");
	/*---------------用户名检测------------*/
	userName.onfocus = userName.onblur = userName.onkeyup = function(e){
		_event = window.event||e;
		user(_event);
	}
	/*定义一个函数*/
	function user(_e){
		//判断是什么事件
		var t;
		if(_e){
			t = _e.type;
		}
		//得到文本框里面的值
		var v = userName.value;
		//得到其父节点
		var userTop = userName.parentNode;
		//得到父节点的下一个兄弟节点
		var tip = userTop.nextElementSibling;
		//得到tip里面的最后一个子节点
		var span = tip.lastElementChild;
		//获取焦点
		if(t == "focus"){
			//内容为空
			if(v.length==0){
				tip.className = "tip default";//改变节点信息
				span.innerHTML = "支持汉字、字母、数字、“-”、“_”,4-20个字符";
				return false;
			}
		}
		//失去焦点
		if(t == "blur"){
			//内容为空
			if(v.length==0){
				userTop.className = "userTop";
				tip.className = "tip hidden";//改变节点信息
				return false;
			}
		}
		//键盘弹起
		if(v.length==0){	//内容为空（输入后删去为空）
			userTop.className = "userTop error";
			tip.className = "tip error";
			span.innerHTML = "请输入用户名";
			return false;
		}else{	//内容不为空
			//输入为字符字母数字下划线正则表达式
			var reg = /^([\u4e00-\u9fa5]|[a-zA-Z0-9_-])+$/;
			//如果为真（匹配成功）
			if(reg.test(v)){
				//输入的字符串长度范条件
				if(v.length<4||v.length>20){
					userTop.className = "userTop error";
					tip.className = "tip error";
					span.innerHTML = "长度4-20个字符";
					return false;
				}else{
					userTop.className = "userTop right";
					tip.className = "tip hidden";
					return true;
				}
			}else{		//匹配不成功
				userTop.className = "userTop error";
					tip.className = "tip error";
					span.innerHTML = "格式输入错误";
					return false;
			}
		}
	}
	
	/*-----------输入密码判断-------------*/
	psd.onfocus = psd.onblur = psd.onkeyup = function(e){
		_event = window.event||e;
		psdd(_event);
	}
	/*定义一个函数*/
	function psdd(_e){
		//判断是什么事件
		var t;
		if(_e){
			t = _e.type;
		}
		//得到文本框里面的值
		var v = psd.value;
		//得到其父节点
		var userTop = psd.parentNode;
		//得到父节点的下一个兄弟节点
		var tip = userTop.nextElementSibling;
		//得到tip里面的最后一个子节点
		var span = tip.lastElementChild;
		//获取焦点
		if(t == "focus"){
			//内容为空
			if(v.length==0){
				tip.className = "tip default";//改变节点信息
				span.innerHTML = "建议使用字母、数字和符号两种以上的组合，6-20个字符";
				return false;
			}
		}
		//失去焦点
		if(t == "blur"){
			//内容为空
			if(v.length==0){
				userTop.className = "userTop";
				tip.className = "tip hidden";//改变节点信息
				return false;
			}
		}
		//键盘弹起
		if(v.length==0){	//内容为空（输入后删去为空）
			userTop.className = "userTop error";
			tip.className = "tip error";
			span.innerHTML = "请输入密码";
			return false;
		}else{	//内容不为空
			//输入的字符串长度范条件
			if(v.length<6||v.length>20){
				userTop.className = "userTop error";
				tip.className = "tip error";
				span.innerHTML = "长度6-20个字符";
				return false;
			}else{	//判断成功检测安全程度
				var level = getLevel(v);
					switch(level){
						case 1:    //弱
							tip.className = "tip ruo";
							span.innerHTML = "有被盗风险,建议使用字母、数字和符号两种及以上组合";
						break;
						case 2:
							tip.className = "tip zhong";
							span.innerHTML = "安全强度适中，可以使用三种以上的组合来提高安全强度";
						break;
						case 3:
							tip.className = "tip qiang";
							span.innerHTML = "你的密码很安全";
						break
					}
					userTop.className = "userTop right";
					return true;
			}
			
		}
	}
	/*-----------输入密码是否一致判断-------------*/
	psd1.onfocus = psd1.onblur = psd1.onkeyup = function(e){
		_event = window.event||e;
		pssd(_event);
	}
	/*定义一个函数*/
	function pssd(_e){
		//判断是什么事件
		var t;
		if(_e){
			t = _e.type;
		}
		//得到文本框里面的值
		var v = psd1.value;
		//得到其父节点
		var userTop = psd1.parentNode;
		//得到父节点的下一个兄弟节点
		var tip = userTop.nextElementSibling;
		//得到tip里面的最后一个子节点
		var span = tip.lastElementChild;
		//获取焦点
		if(t == "focus"){
			//内容为空
			if(v.length==0){
				tip.className = "tip default";//改变节点信息
				span.innerHTML = "请再次输入密码";
				return false;
			}
		}
		//失去焦点
		if(t == "blur"){
			//内容为空
			if(v.length==0){
				userTop.className = "userTop";
				tip.className = "tip hidden";//改变节点信息
				return false;
			}
		}
		//键盘弹起
		if(v.length==0){	//内容为空（输入后删去为空）
			userTop.className = "userTop error";
			tip.className = "tip error";
			span.innerHTML = "请再次输入密码";
			return false;
		}else{	//内容不为空
			//输入的字符串长度范条件
			if(v!==psd.value){
				userTop.className = "userTop error";
				tip.className = "tip error";
				span.innerHTML = "两次密码输入不一致";
				return false;
			}else{
				userTop.className = "userTop right";
				tip.className = "tip hidden";
				return true;
			}
		}
	}
	/*-----------邮箱验证-------------*/
	email.onfocus = email.onblur = email.onkeyup = function(e){
		_event = window.event||e;
		email1(_event);
	}
	/*定义一个函数*/
	function email1(_e){
		//判断是什么事件
		var t;
		if(_e){
			t = _e.type;
		}
		//得到文本框里面的值
		var v = email.value;
		//得到其父节点
		var userTop = email.parentNode;
		//得到父节点的下一个兄弟节点
		var tip = userTop.nextElementSibling;
		//得到tip里面的最后一个子节点
		var span = tip.lastElementChild;
		//获取焦点
		if(t == "focus"){
			//内容为空
			if(v.length==0){
				tip.className = "tip default";//改变节点信息
				span.innerHTML = "请输入邮箱账号";
				return false;
			}
		}
		//失去焦点
		if(t == "blur"){
			//内容为空
			if(v.length==0){
				userTop.className = "userTop";
				tip.className = "tip hidden";//改变节点信息
				return false;
			}
		}
		//键盘弹起
		if(v.length==0){	//内容为空（输入后删去为空）
			userTop.className = "userTop error";
			tip.className = "tip error";
			span.innerHTML = "请输入邮箱";
			return false;
		}else{	//内容不为空
			var reg = /^\w+@\w+(\.\w+)+$/;
			//验证失败
			if(!reg.test(v)){
				userTop.className = "userTop error";
				tip.className = "tip error";
				span.innerHTML = "格式输入错误";
				return false;
			}else{	//验证成功
				userTop.className = "userTop right";
				tip.className = "tip hidden";
				return true;
			}
		}
	}
	/*-----------手机验证-------------*/
	phone.onfocus = phone.onblur = phone.onkeyup = function(e){
		_event = window.event||e;
		phones(_event);
	}
	/*定义一个函数*/
	function phones(_e){
		//判断是什么事件
		var t;
		if(_e){
			t = _e.type;
		}
		//得到文本框里面的值
		var v = phone.value;
		//得到其父节点
		var userTop = phone.parentNode;
		//得到父节点的下一个兄弟节点
		var tip = userTop.nextElementSibling;
		//得到tip里面的最后一个子节点
		var span = tip.lastElementChild;
		//获取焦点
		if(t == "focus"){
			//内容为空
			if(v.length==0){
				tip.className = "tip default";//改变节点信息
				span.innerHTML = "请输入手机号";
				return false;
			}
		}
		//失去焦点
		if(t == "blur"){
			//内容为空
			if(v.length==0){
				userTop.className = "userTop";
				tip.className = "tip hidden";//改变节点信息
				return false;
			}
		}
		//键盘弹起
		if(v.length==0){	//内容为空（输入后删去为空）
			userTop.className = "userTop error";
			tip.className = "tip error";
			span.innerHTML = "请输入手机号";
			return false;
		}else{	//内容不为空
			var reg = /^[1-3]\d{10}$/;
			//验证失败
			if(!reg.test(v)){
				userTop.className = "userTop error";
				tip.className = "tip error";
				span.innerHTML = "格式输入错误";
				return false;
			}else{	//验证成功
				userTop.className = "userTop right";
				tip.className = "tip hidden";
				return true;
			}
		}
	}
	/*---------------按钮控制----------------*/
	btn.onclick = function(){
		//得到其父节点
		var userTop = ck.parentNode;
		//得到父节点的下一个兄弟节点
		var tip = userTop.nextElementSibling;
		//得到tip里面的最后一个子节点
		var span = tip.lastElementChild;
		//同意注册
		if(ck.checked){
			
			tip.className = "tip hidden";
			//判断前面的信息是否全部输入正确
			if(user()&&psdd()&&pssd()&&email1()&&phones()){
				alert("可以注册");
			}
		}else{
				userTop.className = "userTop error";
				tip.className = "tip error";
				span.innerHTML = "请同意注册协议";
			}
	}
}