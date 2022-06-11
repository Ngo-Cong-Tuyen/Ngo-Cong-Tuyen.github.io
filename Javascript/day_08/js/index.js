//loc khóa hoc theo hình thức
// window.location.search = name?type
let params = new URLSearchParams(window.location.search);
let type = params.get('type');
console.log(type);

let courseList = [...courses];
if (type) {
    // loc theo type
    if (type =='onlab') {
        document.title= "Khóa học onlab";
        courseList = courses.filter(c => c.type == 'onlab');
    } else
    if (type =='online') {
        document.title = "Khóa học online";
        courseList = courses.filter(c => c.type == 'online');
    } else {
        window.location.href = './404.html';
    }
} else { 
    //Danh sach tat ca
    document.title= "Danh sách khóa học";

}
const courseListEl = document.querySelector(".course-list");
const searchEl = document.querySelector(".seach-form-input");
const btnSearch = document.querySelector(".seach-form-button");
const topicEl = document.querySelectorAll('.topic-item input');

// Tim kiem khoa hoc theo chu de
topicEl.forEach(input => {
    input.addEventListener('change', function() {
        let topic = input.value;
        filterCourseByTopic(topic);
    })
});

filterCourseByTopic = topic => {
    let courseFilter = courseList.filter(c => c.topics.includes(topic));
    renderCourses(courseFilter);
}

// chuc nang tim kiem
searchEl.addEventListener("keydown", function (e) {
  if (e.keyCode == 13) {
    let term = e.target.value;
    if (term == "") {
      alert("Noi dung ko dc de trong");
      return;
    }

    filterCourseByTitle(term);
  }
});

btnSearch.addEventListener("click", function () {
  let term = searchEl.value;
  if (term == "") {
    alert("Noi dung ko dc de trong");
    return;
  }

  filterCourseByTitle(term);
});

const filterCourseByTitle = (term) => {
  let courseFilter = courseList.filter((c) =>
    c.title.toLowerCase().includes(term.toLowerCase())
  );
  renderCourses(courseFilter);
};
// Hiển thị danh sách khóa học.
const renderCourses = (arr) => {
  courseListEl.innerHTML = "";
  let html = "";
  for (let c of arr) {
    html += ` <div class="col-md-4">
                <a href="./detail.html?id=${c.id}">
                    <div class="course-item shadow-sm rounded mb-4">
                        <div class="course-item-image">
                            <img src="${c.image}"
                                alt="${c.title}">
                        </div>
                        <div class="course-item-info p-3">
                            <h2 class="fs-5 mb-4 text-dark">${c.title}</h2>
                            <div
                                class="d-flex justify-content-between align-items-center fw-light text-black-50">
                                <p class="type">${c.type}</p>
                                <p class="rating">
                                    5<span class="text-warning"><i class="fa-solid fa-star"></i></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </a>
            </div>`;
  }
  courseListEl.innerHTML = html;
};
renderCourses(courseList);
