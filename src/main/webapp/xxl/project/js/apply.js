var obj = {
    valueI:'申请中'
};
 function signUp(obj){
     var sup =document.getElementById("sup");       
     sup.innerText =obj.valueI;
     sup.style.backgroundColor='rgba(255, 0, 0, 0.938)';
 }