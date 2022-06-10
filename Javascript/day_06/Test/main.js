const para = document.querySelector('p');
para.innerHTML = para.innerText.split(" ")
    .map(ele => ele.length >= 8 ? `<span style= "background-color: yellow">${ele}</span>` : ele)
    .join(" ");

const linkFace = document.createElement('a');
linkFace.href = 'https://facebook.com';
linkFace.innerText = 'facebook.com';
para.insertAdjacentElement('afterend',linkFace);

// 3.Đếm số từ có trong đoạn văn. Tạo 1 thẻ div để hiển thị số từ
const divEl = document.createElement('div');
const amountWord = para.innerText.split(" ").length;
divEl.innerHTML =`numberWord : ${amountWord}`;
document.body.appendChild(divEl);
// Thay thế ký hiệu ? => 🤔, ! => 😲
para.innerHTML= para.innerHTML.replaceAll('?','🤔');
para.innerHTML = para.innerHTML.replaceAll('!','😲');