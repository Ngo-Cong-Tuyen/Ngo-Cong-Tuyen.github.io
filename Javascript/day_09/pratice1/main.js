const breedListEl = document.getElementById('breed-list');
const imgEl = document.querySelector('.result img');

const getBreedList = async () =>{
    try {
        //goi api lay danh sach giong loai chinh
        let res = await axios.get('https://dog.ceo/api/breeds/list/all');
        console.log(res);

        // hien thi
        renderBreedList(res.data.message);
    } catch (error) {
        console.log(error);
    }
}

const renderBreedList = obj =>{
  
    let keys = Object.keys(obj);

    let html = "";
    for (let i=0; i<keys.length; i++){
        html += `<option value="${keys[i]}">${keys[i]}</option>`;
    }
    console.log(html);
    breedListEl.innerHTML = html;
}
getBreedList();
const flethEl = document.getElementById('btn');
flethEl.addEventListener('click', async() =>{
    try {
        let value = breedListEl.value;
        let html = `https://dog.ceo/api/breed/${value}/images/random`;
        let res = await axios.get(html);
        console.log(res);
        imgEl.src = res.data.message;
    } catch (error) {
        console.log(error);
    }
})

