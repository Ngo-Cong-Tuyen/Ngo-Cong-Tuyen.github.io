const todoOptionEls = document.querySelectorAll(".todo-option-item input");
const todoListEl = document.querySelector(".todo-list");
const inputEl = document.querySelector("#todo-input");
const btnAdd = document.getElementById("btn-add");
const btnUpdate = document.getElementById("btn-update");

const API_URL = "http://localhost:8080/api/v1/todos";

let todos;

const getTodosAPI = (status) => {
  switch (status) {
    case "all": {
      return axios.get(API_URL);
    }
    case "unactive": {
      return axios.get(`${API_URL}?status=false`);
    }
    case "active": {
      return axios.get(`${API_URL}?status=true`);
    }
    default: {
      return axios.get(API_URL);
    }
  }
};

const getTodos = async (status = "") => {
  try {
    let res = await getTodosAPI(status);
    console.log(res);
    todos = res.data;
    renderTodos(todos);
  } catch (error) {
    console.log(error);
  }
};

getTodos();

todoOptionEls.forEach((input) => {
  input.addEventListener("change", () => {
    let status = input.value;
    console.log(status);
    getTodos(status);
  });
});

function renderTodos(arr) {
  todoListEl.innerHTML = "";
  if (arr.length == 0) {
    todoListEl.innerHTML = "Danh sach cong viec rong";
  }
  let html = "";
  arr.forEach((todo) => {
    html += `<div class="todo-item ${todo.status ? "active-todo" : ""}">
        <div class="todo-item-title">
            <input type="checkbox" ${
              todo.status ? "checked" : ""
            } onclick="toggleStatus(${todo.id})"/>
            <p>${todo.title}</p>
        </div>
        <div class="option">
            <button class="btn btn-update" onclick="updateTodo(${todo.id})">
                <img src="./img/pencil.svg" alt="icon" />
            </button>
            <button class="btn btn-delete" onclick="deleteTodo(${todo.id})">
                <img src="./img/remove.svg" alt="icon" />
            </button>
        </div>
    </div>`;
  });
  todoListEl.innerHTML = html;
}

const deleteTodo = async (id) => {
  try {
    let isConfirm = confirm("BAn co muon xoa ko");
    if (isConfirm) {
      axios.delete(`${API_URL}/${id}`);

      todos.forEach((t, index) => {
        if (t.id == id) {
          todos.splice(index, 1);
        }
      });
      renderTodos(todos);
    }
  } catch (error) {
    console.log(error);
  }
};
const toggleStatus = async (id) => {
  try {
    let todo = todos.find((t) => t.id == id);

    todo.status = !todo.status;
    axios.put(`${API_URL}/${id}`, {
      title: todo.title,
      status: todo.status,
    });

    renderTodos(todos);
  } catch (error) {
    console.log(error);
  }
};

let updateId;
const updateTodo = id => {
    // Cập nhật nút thêm -> cập nhật
    btnAdd.classList.add("hide");
    btnUpdate.classList.remove("hide");
    updateId=id;
};

btnUpdate.addEventListener('click', async() => {
  try {
    let todo = todos.find((t) => t.id == updateId);
    // Cập nhật todos;
    todo.title = inputEl.value;
    axios.put(`${API_URL}/${updateId}`, {
      title: todo.title,
      status: todo.status,
    });

    renderTodos(todos);

    // Trả lại ban đầu.
    btnAdd.classList.remove("hide");
    btnUpdate.classList.add("hide");
    inputEl.value = "";
  } catch (error) {
    console.log(error);
  }
})

btnAdd.addEventListener('click', async() => {
  try {
    axios.post(API_URL, {
      title: inputEl.value
    });

    getTodos();
    inputEl.value = "";
  } catch (error) {
    console.log(error);
  }
})

// const updateTodo(id){

// }

// for (let box of checkBoxs) {
//     box.addEventListener('click',async function(){
//         if(box.value=='all'){

//         }
//     })
// }

// async function renderALL(){
//     try {
//         let res = await axios.get("http://localhost:8080/api/v1/todos");

//     } catch (error) {
//        console.log(error)
//     }
// }

// function render(arr){

// }
