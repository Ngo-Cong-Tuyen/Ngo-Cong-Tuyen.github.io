const inputUsername = document.getElementById('input-username');
const inputPassword = document.getElementById('input-password');
const btnLogin = document.getElementById('btn-login');
const nameEl = document.getElementById('name');
const avatarEl = document.getElementById('avatar');
const emailEl = document.getElementById('email');
const btnLogout = document.getElementById('btn-logout');
const inforEl = document.querySelector('.info');
const formEl = document.querySelector('.form');

btnLogin.addEventListener('click', async function() {
    try {
        let username = inputUsername.value;
        let password = inputPassword.value;

        let res = await axios.post('http://localhost:8080/login',{
            username: username,
            password: password
        })
        console.log(res);
        renderInfoForm(res.data);
    } catch (error) {
        console.log(error);
        alert(error.response.data.message)
    }
})

function renderInfoForm(user) {
    inforEl.classList.remove('hide');
    formEl.classList.add('hide');
    avatarEl.src = user.avatar;
    nameEl.innerText = user.username;
    emailEl.innerText = user.email;
}

btnLogout.addEventListener('click',()=>{
    inforEl.classList.add('hide');
    formEl.classList.remove('hide');
    avatarEl.src ="";
    nameEl.innerText = "";
    emailEl.innerText = "";
})