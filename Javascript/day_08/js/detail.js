let params = new URLSearchParams(window.location.search);
let id = params.get("id");
console.log(id);

// Lay ra khao hoc bang id
const getCourse = (id, arr) => {
  return arr.filter((c) => c.id == id)[0];
};

const course = getCourse(id, courses);
console.log(course);

// Lay ra giang vien bang suppoterId
const getSupporter = (supporterId, arr) => {
  return arr.filter((sp) => sp.id == supporterId)[0];
};

const supporter = getSupporter(course.supporterId, suppoters);

//Thay doi du lieu tren tran detail
document.title = course.title;

const bcCourseEl = document.querySelector(".breadcrumb .active");
bcCourseEl.innerHTML = course.title;

const courseTitleEl = document.querySelector(".course-title");
courseTitleEl.innerHTML = course.title;

const supporterAvatarEl = document.querySelector(".supporter-image img");
console.log(supporterAvatarEl);
supporterAvatarEl.src = supporter.avatar;

const supporterInfoDiv = document.querySelector(".supporter-info");
supporterInfoDiv.innerHTML = `<p>
                            <b>Tư vấn viên :</b>
                            ${supporter.name}
                            </p>
                            <p>
                            <b>Email :</b>
                            ${supporter.email}
                            </p>
                            <p>
                            <b>Số điện thoại :</b>
                            ${supporter.phone}
                            </p>
                            <p>
                            <button class="btn btn-primary shadow-sm">Nhận tư vấn</button>
                            </p>`;

const courseDescriptionDiv = document.querySelector(".course-description");
courseDescriptionDiv.innerHTML = `<p>${course.content}</p>`;
