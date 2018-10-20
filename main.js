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
let express = require('express');
let app = express();

let majorArr = [];
// app.get('/', (req, res) => res.json(res));
// app.listen(3000, () => console.log('Example app listening on port 3000!'));

//gets all terms
request.get('https://soc.courseoff.com/gatech/terms', (error, response, body) => {
    if (error != null) {
        console.log(error);
    }
    let jsonData = JSON.parse(body);
    jsonData.forEach(element => {
        console.log(element);
    });
});

//gets Spring semester
request.get('https://soc.courseoff.com/gatech/terms/201901', (error, response, body) => {
    if (error != null) {
        console.log(error);
    }
    let jsonData = JSON.parse(body);
    console.log(jsonData);
});

/**
 * gets all majors-has ident(abbreviation)and name(full subject name) fields;
 * also pushes the major names into array
 */
request.get('https://soc.courseoff.com/gatech/terms/201901/majors', (error, response, body) => {
    if (error != null) {
        console.log(error);
    }
    let jsonData = JSON.parse(body);
    jsonData.forEach(element => {
        majorArr.push(element.ident);
        console.log(element);
    });
});

//loops through all majors and gets their courses, waits 5 secs for all majors to be pushed into array
setTimeout((() => {
    for (i = 0; i < majorArr.length; i++) {
        request.get(`https://soc.courseoff.com/gatech/terms/201901/majors/${majorArr[i]}/courses`, (error, response, body) => {
            if (error != null) {
                console.log(error);
            }
            let jsonData = JSON.parse(body);
            jsonData.forEach(element => {
                console.log(element);
            });
        });
    }
}), 5000)

