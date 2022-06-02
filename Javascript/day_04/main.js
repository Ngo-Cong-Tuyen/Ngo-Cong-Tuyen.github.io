const heading = document.getElementById('heading');
console.log(heading);
const para3 = document.querySelector('.para:nth-child(4)');
console.log(para3);
const ul2 = document.querySelector('body > ul');
console.log(ul2);

const ul1 = document.querySelector('ul');
console.log(ul1);

const paras = document.querySelectorAll('p');
console.log(paras);

heading.style.color = "red";

heading.textContent = "Hello world";
console.log(heading.textContent);

const box = document.querySelector('.box');
console.log(box.parentElement);
console.log(box.previousElementSibling);
console.log(box.nextElementSibling);
console.log(box.children);

document.body.prepend(para3);
document.body.appendChild(para3);
document.body.insertBefore(para3, box);

const link = document.createElement("a");
link.innerText = "Link google";
link.href = "https://google.com";
console.log(link);

document.body.insertBefore(link, ul2);

const li = document.createElement('li');
li.innerText = "Tao the li moi";
let li1 = document.querySelectorAll('body > ul li');
console.log(li1);
ul2.insertBefore(li, li1[2]);

const boxCopyTrue = box.cloneNode(true);
document.body.appendChild(boxCopyTrue);