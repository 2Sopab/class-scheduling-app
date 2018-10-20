var request = require('ajax-request');

var temp_course_id = "CS";
function scrape(course_id) {
    request({
        url: 'https://www.coursicle.com/gatech/search.php',
        dataType: 'text',
        method: 'POST',
        headers: { origin: 'https://www.coursicle.com', referer: 'https://www.coursicle.com/gatech/' },
        data: {
            subject: course_id, 
            courseNumber:'', 
            courseNumberInequality: '', 
            attributes : '', 
            minGenEds : '', 
            title : '', 
            days:'', 
            startTime: '', 
            endTime: '', 
            instructor:'', 
            whatPercentAs:'40', 
            atLeastSomePercentAs: 'false', 
            semester:'spring2019',
            isAddingMore: 'false'
        }, 
    }, function(err, res, body) {
        console.log(body);
    });
}

scrape(temp_course_id);