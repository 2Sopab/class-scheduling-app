// let fetch = require('node-fetch')
// let getData = async () => {
//     let response = await fetch('https://soc.courseoff.com/gatech/terms/201808/majors/MATH/courses') //add any request url from courseoff here
//     let data = await response.json();
//     //loop through data
//     data.forEach(element => {
//         console.log(element);
//     });
//     //console.log(data);
// }
// getData().catch((err) => {
//     console.log(err);
// })
//basic form of request: https://soc.courseoff.com/gatech/terms/{term # here}/majors/{Major name}/courses/{course # here}
let request = require('request');
let path = require('path');
let bodyParser = require('body-parser');
let mysql = require('mysql');
let fs = require('fs');

request.get('https://soc.courseoff.com/gatech/terms', (error, response, body) => {
    if (error != null) {
        console.log(error);
    }
    let jsonData = JSON.parse(body);
    jsonData.forEach(element => {
        console.log(element);
    });
});

