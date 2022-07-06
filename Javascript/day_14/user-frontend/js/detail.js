const nameInput = document.getElementById("name");
const emailInput = document.getElementById("email");
const phoneInput = document.getElementById("phone");
const addressOption = document.getElementById("address");
const avatarImg = document.getElementById("avatar-preview");
const passwordInput = document.getElementById("old-password");
const newPasswordInput = document.getElementById("new-password");
const changePassBtn = document.getElementById("btn-change-password");
const updateBtn = document.getElementById("btn-save");
const forgotPassBtn = document.getElementById("btn-forgot-password");
const backBtn = document.querySelector(".btn-back");
// Truy cập
const avatarEl = document.getElementById("avatar");
const avatarPreviewEl = document.getElementById("avatar-preview");

const btnModalImage = document.getElementById("btn-modal-image");
const imageContainerEl = document.querySelector(".image-container");

const btnChoseImage = document.getElementById("btn-chose-image");
const btnDeleteImage = document.getElementById("btn-delete-image");

const modelImageEl = document.getElementById("modal-image");

let param = new URLSearchParams(window.location.search);
const id = param.get("id");
let user;

async function getUsers() {
  try {
    let res = await axios.get(`http://localhost:8080/api/v1/users/${id}`);
    user = res.data;
    console.log(res);
    await renderUser(user);
    getProvinces();
  } catch (error) {
    console.log(error);
  }
}
getUsers(id);

function renderUser(user) {
  nameInput.value = user.name;
  emailInput.value = user.email;
  phoneInput.value = user.phone;
  avatarImg.src = user.avatar;
}

const getProvinces = async () => {
  try {
    //goi tinh thanh pho
    let res = await axios.get("https://provinces.open-api.vn/api/p/");
    console.log(res);
    // hien thi
    renderProvinces(res.data);
  } catch (error) {
    console.log(error);
  }
};

const renderProvinces = (arr) => {
  let html = "<option hidden>'--Chọn thành phố--'</option>";
  for (let pr of arr) {
    html += `<option value ="${pr.name}">${pr.name}</option>`;
  }
  addressOption.innerHTML = html;
  addressOption.value = user.address;
};

// thay doi password;
console.log(changePassBtn);
changePassBtn.addEventListener("click", async () => {
  try {
    let res = await axios.put(
      `http://localhost:8080/api/v1/users/check/${id}`,
      {
        password: passwordInput.value,
        newPassword: newPasswordInput.value,
      }
    );
    if (res.data) {
      alert("Thay doi mat khau thanh cong");
    } else alert("Mat khau khong dung");
  } catch (error) {
    console.log(error);
  }
});

//  Cap nhat
updateBtn.addEventListener("click", async () => {
  try {
    let res = await axios.put(`http://localhost:8080/api/v1/users/${id}`, {
      name: nameInput.value,
      email: emailInput.value,
      phone: phoneInput.value,
      address: addressOption.value,
      avatar: avatarImg.src,
    });

    console.log(res);
  } catch (error) {
    console.log(error);
  }
});

forgotPassBtn.addEventListener("click", async () => {
  try {
    let res = await axios.post(
      `http://localhost:8080/api/v1/users/${id}/forgot-password`
    );
    alert("Mat khau moi la" + res.data);
  } catch (error) {
    console.log(error);
  }
});

backBtn.addEventListener("click", () => {
  window.location.href = "./index.html";
});

let userId = id;

// Khai báo biến
let listImage = [];

avatarEl.addEventListener("change", async function (event) {
  try {
    // Lấy ra file cần upload dựa vào event
    let file = event.target.files[0];

    // Tạo formData và append file vào
    let formData = new FormData();
    formData.append("file", file);

    // Gọi API
    let res = await axios.post(
      `http://localhost:8080/api/v1/users/${userId}/upload-avatar`,
      formData
    );

    // Thêm vào mảng ban đầu, mới nhất thì cho lên đầu
    listImage.unshift(res.data);

    // Hiển thị lại trên giao diện
    renderImg(listImage);
  } catch (error) {
    console.log(error);
  }
});

// Hiển thị danh sách hình ảnh
btnModalImage.addEventListener("click", async () => {
  try {
    // Gọi API
    let res = await axios.get(
      `http://localhost:8080/api/v1/users/${userId}/files`
    );

    // Lưu lại ảnh của user
    listImage = res.data;

    // Hiển thị ra ngoài giao diện
    renderImg(listImage);
  } catch (error) {
    console.log(error);
  }
});

// Hiển thị danh sách hình ảnh ra ngoài giao diện
function renderImg(arr) {
  imageContainerEl.innerHTML = "";

  let html = "";
  arr.forEach((i) => {
    html += `
            <div class="image-item" onclick="choseImage(this)">
                <img src="http://localhost:8080/${i}" alt="">
            </div>
        `;
  });
  imageContainerEl.innerHTML = html;
}

// CHọn ảnh
const choseImage = (ele) => {
  // Tìm kiếm image đang được active
  let imageSelected = document.querySelector(".selected");

  // Nếu tồn tại thì xóa class "border-primary", "selected" trong image đó đi
  if (imageSelected) {
    imageSelected.classList.remove("border-primary", "selected");
  }

  // Thêm class "border-primary", "selected" vào image đang được click
  ele.classList.add("border-primary", "selected");

  // Bỏ "disabled" ở 2 nút "Chọn ảnh" và "Xóa ảnh" để có thể thực hiện chức năng
  btnChoseImage.disabled = false;
  btnDeleteImage.disabled = false;
};

// Lắng nghe sự hiện đóng modal để disabled 2 nút "Chọn ảnh" và "Xóa ảnh"
modelImageEl.addEventListener("hidden.bs.modal", function () {
  btnChoseImage.disabled = true;
  btnDeleteImage.disabled = true;
});

btnChoseImage.addEventListener("click", async function (event) {
  try {
    let imageSelected = document.querySelector(".selected img");
    avatarPreviewEl.src = imageSelected.src;
    let res = await axios.put(`http://localhost:8080/api/v1/users/${userId}/update-avatar`,{
      avatar: avatarPreviewEl.src
    });
    console.log(res);
  } catch (error) {
    console.log(error);
  }
});

btnDeleteImage.addEventListener("click", async () => {
  try {
    let imageSelected = document.querySelector(".selected img");
    let res = await axios.delete(`${imageSelected.src}`);
    imageContainerEl.removeChild(imageSelected.parentNode);
  } catch (error) {
    console.log(error);
  }
});
