const heading = document.getElementById('heading');
console.log(heading .classList);

heading.classList.add('text-big','text-center');

heading.classList.remove('text-big');

console.log(heading.classList.contains('text-red'));
console.log(heading.classList.contains('text-big'));

// setInterval(() =>{
//     heading.classList.toggle('text-red');
// },1000);

const timeEl = document.querySelector(".time");
console.log(timeEl);
const textEl = document.querySelector('.text');
console.log(textEl);

let time =10;
let interval = setInterval(() =>{
    time--;
    timeEl.innerText = `${time}s`;
    if (time == 0) {
        clearInterval(interval);
        timeEl.classList.add('hide');
        textEl.classList.remove('hide');
    }
},1000);

