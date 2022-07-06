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
const avatarInput = document.getElementById("avatar");
const btnModalImage = document.getElementById("btn-modal-image");
const imageContainerEl = document.querySelector(".image-container");

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

// Post avatar

avatarInput.addEventListener("change", async (event) => {
  try {
    let formData = new FormData();
    formData.append("file", event.target.files[0]);
    console.log(id);
    let res = await axios.post(
      `http://localhost:8080/api/v1/users/${id}/upload-avatar`,
      formData
    );
    avatarImg.src = "http://localhost:8080" + res.data;
  } catch (error) {
    console.log(error);
  }
});

let listAvatars;
btnModalImage.addEventListener("click", async () => {
  try {
    let res = await axios.get(`http://localhost:8080/api/v1/users/${id}/files`);
    console.log(res);
    listAvatars = res.data;
    renderImg(listAvatars);
  } catch (error) {
    console.log(error);
  }
});

let chooseImg;
function renderImg(arr) {
  imageContainerEl.innerHTML='';
  for (let path of arr) {
    let img = document.createElement('img')
    img.src=`http://localhost:8080/${path}`;
    img.addEventListener('click',function(){
      img.classList.add('shadow-lg');
      chooseImg=img;
    })
    imageContainerEl.appendChild(img);
  }
}




