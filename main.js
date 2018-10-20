let fetch = require('node-fetch')
let getData = async () => {
    let response = await fetch('https://soc.courseoff.com/gatech/terms/201808/majors/MATH/courses') //add any request url from courseoff here
    let data = await response.json();
    //loop through data
    data.forEach(element => {
        console.log(element);
    });
    //console.log(data);
}
getData().catch((err) => {
    console.log(err);
})