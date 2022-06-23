const provincesEl = document.querySelector('#province');
const districtsEl = document.getElementById('district');
const communesEl = document.getElementById('commune');

const getProvinces = async () =>{
    try {
        //goi tinh thanh pho
        let res = await axios.get('https://provinces.open-api.vn/api/p/');
        console.log(res);
        // hien thi
        renderProvinces(res.data);
    } catch (error) {
        console.log(error);
    }
}

const renderProvinces = arr =>{
  
    let html ="<option hidden>'--Chọn thành phố--'</option>";
    for (let pr of arr) {
        html += `<option value ="${pr.code}">${pr.name}</option>`;
    }

    provincesEl.innerHTML = html;
}
getProvinces();

provincesEl.addEventListener('change',async () =>{
    try {
        communesEl.innerHTML = '<option hidden>--Chọn xã phường--</option>';
        //goi quan huyen
        let value = provincesEl.value;
 
        let res = await axios.get(`https://provinces.open-api.vn/api/p/${value}?depth=2`);
        console.log(res);
        // hien thi
        renderDistricts(res.data.districts);
        console.log(res.data.districts);
    } catch (error) {
        console.log(error);
    }
})

const renderDistricts = arr =>{
  
    let html ="<option hidden>--Chọn quận huyện--</option>";
    for (let pr of arr) {
        html += `<option value ="${pr.code}">${pr.name}</option>`;
    }

    districtsEl.innerHTML = html;
}

districtsEl.addEventListener('change',async () =>{
    try {
        //goi xa phuong
        let districtCode = districtsEl.value;
 
        let res = await axios.get(`https://provinces.open-api.vn/api/d/${districtCode}?depth=2`);
        console.log(res);
        // hien thi
        renderCommunes(res.data.wards);
        console.log(res.data.Communes);
    } catch (error) {
        console.log(error);
    }
})

const renderCommunes = arr =>{
  
    let html ="<option hidden>--Chọn xã phường--</option>";
    for (let pr of arr) {
        html += `<option value ="${pr.code}">${pr.name}</option>`;
    }

    communesEl.innerHTML = html;
}
