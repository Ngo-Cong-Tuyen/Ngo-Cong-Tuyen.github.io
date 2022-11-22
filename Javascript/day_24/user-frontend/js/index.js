const tableEl = document.querySelector(".table tbody");
const searchInput = document.getElementById('search');

const API_URL = "http://localhost:8080/api/v1/users";
let users;

async function getUsers(){
    try {
        let res = await axios.get("http://localhost:8080/api/v1/users");
        console.log(res);
        users= res.data;
        console.log(users);
        renderUsers(users);
    } catch (error) {
        console.log(error)
    }
}

getUsers();

function renderUsers(users){
    tableEl.innerHTML='';
    html='';
    for (let i=0;i< users.length; i++){
        html+=`<tr>
        <td>${i+1}</td>
        <td>${users[i].name}</td>
        <td>${users[i].email}</td>
        <td>${users[i].phone}</td>
        <td>${users[i].address}</td>
        <td>
            <a href="./detail.html?id=${users[i].id}" class="btn btn-success">Xem chi tiết</a>
            <button class="btn btn-danger" onclick="deleteUser(${users[i].id})">Xóa</button>
        </td>
    </tr>`
    }
    tableEl.innerHTML=html;
}

searchInput.addEventListener('keypress', async()=>{
    try {
        let res = await axios.get(`${API_URL}/search?name=${searchInput.value}`);
        renderUsers(res.data);
    } catch (error) {
        console.log(error);
    }
})

async function deleteUser(id){
    try {
        await axios.delete(`${API_URL}/${id}`);
        for (let index=0; index< users.length;index++){
            if (users[index].id==id){
                console.log(id);
                users.splice(index,1);
            }
        }
        console.log(users);
        renderUsers(users);
    } catch (error) {
        console.log(error);
    }
}