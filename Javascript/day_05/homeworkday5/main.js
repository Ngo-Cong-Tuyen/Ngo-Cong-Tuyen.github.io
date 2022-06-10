let colors = [
    '#3498db',
    '#9b59b6',
    '#e74c3c',
    '#2c3e50',
    '#d35400',
]
const boxesEL = document.querySelector('.boxes');
const moreBoxesEl = document.getElementById('btn');
const spanEl = document.querySelector('.points');

for (let cl of colors) boxesEL.appendChild(newBox(cl));
const fCount = () => spanEl.innerText = boxesEL.childElementCount;
fCount();
function newBox(color) {
    let box = document.createElement('div');
    box.classList.add('box');
    box.style.backgroundColor = color;
    box.addEventListener('click', () => {
        box.parentNode.removeChild(box);
        fCount();
    });
    return box;
}

moreBoxesEl.addEventListener('click', () => {
    for (let cl of colors) boxesEL.appendChild(newBox(cl));
    fCount();
})
// check
