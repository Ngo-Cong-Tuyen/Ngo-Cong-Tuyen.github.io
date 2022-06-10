const ulEl = document.querySelector('ul');
const listLi = ()=> { return document.querySelectorAll('li')};
// Thêm 3 thẻ <li> có nội dung Item 8, Item 9, Item 10 vào cuối danh sách
for (let i=8; i<=10; i++) {
    let newLi = document.createElement('li');
    newLi.innerHTML = `Item ${i}`;
    ulEl.appendChild(newLi);
}
// Sửa nội dung cho thẻ <li> 1 thành màu đỏ (color)
console.log(listLi());
// Sửa background cho thẻ <li> 3 thành màu xanh (background-color)
// Remove thẻ <li> 4
// Thêm thẻ <li> mới thay thế cho thẻ <li> 4 bị xóa ở bước trước, thẻ <li> mới có nội dung bất kỳ
// Thêm 1 nút “add” + 1 ô input để nhập text. Mỗi khi bấm nút thêm 1 thẻ <li> có nội dung là nội dung trong ô input vào cuối danh sách
const addLiEL = document.createElement('button');
addLiEL.innerHTML="add";
document.body.insertAdjacentElement('afterbegin',addLiEL);

const inputEl = document.createElement('input');
document.body.insertAdjacentElement('afterbegin',inputEl);
addLiEL.addEventListener('click', () =>{
    let value = inputEl.value;
    if (value =="") {
        alert('Xin vui long nhap lai');
    }
    ulEl.insertAdjacentHTML('beforeend', `<li>${value}</li>`);
    inputEl.value = '';
})
const btnRemove = document.querySelector('.remove');

// Thêm 1 nút “remove”. Chức năng để xóa thẻ <li> cuối cùng của danh sách
// Thêm 1 nút “Hide” trên đầu của danh sách <ul>.
// Khi bấm vào “Hide” thì <ul> sẽ ẩn. Đồng thời label của nút “Hide” => “Show”
// Và ngược lại Khi bấm vào “Show” thì <ul> sẽ hiện. Đồng thời label của nút “Show” => “Hide”