const btnRandom = document.getElementById("btn");
const imageEl = document.getElementById("image");

//fetch API
// axios
btnRandom.addEventListener('click',async function() {
    try {
    //goi api
    let res = await axios.get("https://dog.ceo/api/breeds/image/random");
    console.log(res);
    // gan ket qua tra ve tu API -> imagleEl
    imageEl.src= res.data.message;
    } catch (error) {
        console.log(error)
    }

})
// ajax + jquery
