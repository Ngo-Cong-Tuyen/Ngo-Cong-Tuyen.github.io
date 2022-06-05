const arr = ["Xin chao cac ban", "Hello every one", "Bonhour a touts"];

const changeContent = () => {
    let i = Math.floor(Math.random()*arr.length);
    para.innerText = arr[i];
}

const random_hex_color_code = () => {
    let n = (Math.random() * 0xfffff * 1000000).toString(16);
    return '#' + n.slice(0, 6);
};

const btn2 = document.getElementById('btn-2');
const para = document.querySelector('p');
console.log(para);
btn2.onclick = () => {
    para.style.color = random_hex_color_code();
}

const randomRGB = () => {
    let a = Math.floor(Math.random() * 256);
    let b = Math.floor(Math.random() * 256);
    let c = Math.floor(Math.random() * 256);

    let str = `rgb(${a},${b},${c})`;
    return str;
}
const btn3 = document.getElementById('btn-3');
btn3.addEventListener('click', () => {
    para.style.backgroundColor = randomRGB();
})