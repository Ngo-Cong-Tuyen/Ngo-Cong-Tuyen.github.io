// Lay ra path hien tai
let pathName = window.location.pathname;
console.log(pathName);

//Tim kiem the a nao co gia tri hef = pathName them class "active" cho no;

const ListA = document.querySelectorAll('a');
for (let a of ListA) {
    console.log(a.getAttribute("href"));
    if (a.getAttribute("href")== pathName){
        a.classList.add("active");
    }
}