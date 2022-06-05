document.addEventListener("keydown", function(event) {
    if (event.keyCode ==13) {
        drawCircle();
    } else if (event.keyCode ==32) {
        drawSquare();
    } else {
        changeBackgroundColor();
    }
})

function drawCircle() {
    let boxEl = document.querySelector('.circle')
    if (boxEl) {
        boxEl.parentElement.removeChild(boxEl);
    }

    let box = document.createElement('div');
    box.classList.add('circle');
    let x = Math.floor()
    box.style.left= `${randomPostion(100,800)}px`;
    box.style.top= `${randomPostion(100,800)}px`;

    document.body.append(box);
}

function drawSquare() {
    let boxEl = document.querySelector('.square')
    if (boxEl) {
        boxEl.parentElement.removeChild(boxEl);
    }

    let box = document.createElement('div');
    box.classList.add('square');

    box.style.left= `${randomPostion(100,800)}px`;
    box.style.top= `${randomPostion(100,800)}px`;

    document.body.append(box);
}

function changeBackgroundColor() {
    document.body.style.backgroundColor = "#" + Math.floor(Math.random()*16777215).toString(16);
}

function randomPostion(min ,max) {
    return Math.random() * (max - min) + min;
}