$(document).ready(function($) {

    $("#search-form").submit(function(event) {
        event.preventDefault();
        sendWeatherRequest();
    });
});

function sendWeatherRequest() {
    var city = $("#city").val();
    $.ajax({
        type : "POST",
        contentType : "application/x-www-form-urlencoded; charset=UTF-8",
        url : "/realTimeWeatherApp-1.0/weather/".concat(city),
        data : JSON.stringify(city),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            renderResponse(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            displayError(e);
        }
    }).complete(function(data) {
	  });
    
}
function renderResponse(data) {
	console.log("TEST: ", data);
    var temp = JSON.stringify(data.temperature);
    var location = JSON.stringify(data.city);
    console.log("Hello: ", data.description);
    var weather = JSON.stringify(data.description);
    var wind = JSON.stringify(data.wind);
    var updatedTime = JSON.stringify(data.updatedTime);

    $('#hide-area').show();
    $('#error-field').text('');
    $('#temp').text(temp.replace(/"/g, ""));
    $('#weather').text(weather.replace(/"/g, ""));
    $('#city-name').text(location.replace(/"/g, ""));
    $('#updated-time').text(updatedTime.replace(/"/g, ""));
    $('#wind').text(wind.replace(/"/g, ""));
}


function displayError() {
    $('#error-field').text("Enter correct city").css('color','red');
}

