const listUsersEl = document.querySelector("tbody");
const searchInput = document.querySelector(".seach-form-input");
const searchBtn = document.querySelector(".btn");

let render = (arr) => {
  $(".pagination-container").pagination({
    dataSource: arr,
    pageSize: 6,
    callback: function (data, pagination) {
      // template method of yourself
      renderListUsers(data);
    },
  });
};
let listUsers;
const getListUsers = async () => {
  try {
    // lay danh sach user
    let res = await axios.get("https://api.github.com/users");
    console.log(res);
    listUsers = res.data;
    render(listUsers);
  } catch (error) {
    console.log(error);
  }
};

const renderListUsers = (listUsers) => {
  let html = "";
  for (let user of listUsers) {
    html += ` <tr>
                    <td>${user.id}</td>
                    <td>
                        <img src="${user.avatar_url}" alt="${user.login}">
                    </td>
                    <td>${user.login}</td>
                    <td>${user.html_url}</td>
                    <td>${user.repos_url}</td>
                </tr>`;
  }
  listUsersEl.innerHTML = html;
};
getListUsers();

// tim kiem
searchInput.addEventListener("keydown", (event) => {
  if (event.keyCode == 13) {
    let text = searchInput.value;
    console.log(text);
    let subList = listUsers.filter((user) => user.login.includes(text));
    render(subList);
  }
});

searchBtn.addEventListener("click", () => {
  let text = searchInput.value;
  console.log(text);
  let subList = listUsers.filter((user) => user.login.includes(text));
  render(subList);
});
