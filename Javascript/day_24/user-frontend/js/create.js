toastr.options = {
    "closeButton": false,
    "debug": false,
    "newestOnTop": false,
    "progressBar": false,
    "positionClass": "toast-top-center",
    "preventDuplicates": false,
    "onclick": null,
    "showDuration": "300",
    "hideDuration": "1000",
    "timeOut": "5000",
    "extendedTimeOut": "1000",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "fadeIn",
    "hideMethod": "fadeOut"
  }

const nameInput = document.getElementById("fullname");
const emailInput = document.getElementById("email");
const phoneInput = document.getElementById("phone");
const addressOption = document.getElementById("address");
const passwordInput = document.getElementById("password");
const createBtn = document.getElementById("btn-save");
const backBtn = document.querySelector('.btn-back');

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
  let html = "";
  for (let pr of arr) {
    
    html += `<option value ="${pr.name}">${pr.name}</option>`;
  }
  addressOption.innerHTML = html;
};

getProvinces();

createBtn.addEventListener("click", async () => {
  try {
    let res = await axios.post(`http://localhost:8080/api/v1/users`, {
        name: nameInput.value,
        email : emailInput.value,
        phone: phoneInput.value,
        address: addressOption.value,
        password: passwordInput.value
    });
  } catch (error) {
    toastr["success"](error.response.data.message)
  }
});

backBtn.addEventListener('click',()=>{
    window.location.href= './index.html';
})

