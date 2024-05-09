<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="/validate" method="post">
        <label>Enter OTP:</label><br>
        <input id="enterOTP" type="number" name="enteredOTP" required>
        <input type="number" name ="generatedOTP" value="${message}" required style="display: none"/> 
        <button id="login" type="submit" onclick="enterInvalid()">Login</button>
       	<label id="invalidOTP" style="display: ${isValid ? 'block' : 'none'}">Invalid OTP</label>
       	<label id="blockedLabel" style="display: none;">Your account is blocked</label>
    </form>
    
</body>
<script>
function setItemWithExpiry(value) {
    const now = new Date();
    const expiryTime = now.getTime() + 3000000;
    const item = {
        value: value,
        expiryTime: expiryTime
    };
    localStorage.setItem("key", JSON.stringify(item));
}

function isValid(){
	const itemStr = localStorage.getItem("key");
	if (itemStr !== null) {
		const item = JSON.parse(itemStr);
	    const now = new Date();
	    if (now.getTime() > item.expiryTime && item.value >= 3) {
	        localStorage.removeItem("key");
	        return null;
	    }
    }
}

function enterInvalid(){
	const itemStr = localStorage.getItem("key");
	if (itemStr !== null) {
		const item = JSON.parse(itemStr);
		if (item.value < 3) {
			setItemWithExpiry(item.value + 1);
	    }
	}else{
		setItemWithExpiry(1);
	}
}

document.addEventListener('DOMContentLoaded', function() {
	isValid();
	
    const value = localStorage.getItem('key');
    if (value !== null) {
    	const item = JSON.parse(value);
    	if(item.value >= 3){
	        document.getElementById('blockedLabel').style.display = 'block';
	        document.getElementById('invalidOTP').style.display = 'none';
	        document.getElementById('enterOTP').disabled = true;
	        document.getElementById('login').disabled = true;
    	}
    }
    
    setTimeout(function() {
        window.location.href = '/';
    }, 120000); 
});
</script>
</html>