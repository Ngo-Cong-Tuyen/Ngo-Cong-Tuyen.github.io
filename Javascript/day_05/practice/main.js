const sayHello = () =>{
    console.log('Xin cha cac ban 1');
}

const btn2 = document.getElementById('btn2');
// Anonymous function
// btn2.onclick = function(){
//     alert("xin chao cac ban 2");
// }

const sayHello2 = () =>{
    alert('Xin xhao cac ban 2');
}
btn2.onclick = sayHello2;

const btn3 = document.getElementById('btn3');
// btn3.addEventListener('click',function(){
//     alert('xin chao cac ban 3');
// }

const sayHello3 = () =>{
    alert('Xin xhao cac ban 3');
};

btn3.addEventListener('click',sayHello3);