const btnRandomColorName = document.getElementById("random-color-name");
const btnHexaColor = document.getElementById("random-hexa-color");
const btnRgbColor = document.getElementById("random-rgb-color");
btnRandomColorName.addEventListener("click",async function(){
    try {
        let res = await axios.get("http://localhost:8080/random-color?type=1");
        console.log(res);
        document.body.style.backgroundColor = res.data;
    } catch (error) {
        console.log(error.response.data.message);
    }
})


btnHexaColor.addEventListener("click",async function(){
    try {
        let res = await axios.get("http://localhost:8080/random-color?type=2");
        console.log(res);
        document.body.style.backgroundColor = res.data;
    } catch (error) {
        console.log(error.response.data.message);
    }
})


btnRgbColor.addEventListener("click",async function(){
    try {
        let res = await axios.get("http://localhost:8080/random-color?type=3");
        console.log(res);
        document.body.style.backgroundColor = res.data;
    } catch (error) {
        console.log(error.response.data.message);
    }
})