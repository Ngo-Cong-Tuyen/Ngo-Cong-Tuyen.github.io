// document.addEventListener('click', function() {
//     console.log('click');
//    })

//    document.addEventListener('mousedown', function() {
//     console.log('mousedown');
//    })

//    document.addEventListener('mousemove', function() {
//     console.log('mousemove');
//    })

//    document.addEventListener('mouseup', function() {
//     console.log('mouseup');
//    })
document.addEventListener('click', function(event) {
    const boxEl = document.querySelector('.box')
    if (boxEl) {
        boxEl.parentElement.removeChild(boxEl);
    }

    const box = document.createElement('div');
    box.classList.add('box');

    box.style.left= `${event.offsetX -50}px`;
    box.style.top= `${event.offsetY -50}px`;

    document.body.append(box);
   })

