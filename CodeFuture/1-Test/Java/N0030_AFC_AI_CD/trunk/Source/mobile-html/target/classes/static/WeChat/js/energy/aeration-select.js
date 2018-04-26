var calender = null;
var maxDate = new Date().pattern("yyyy-MM-dd");


$(function () {
    initCalender();
});

function initCalender() {
    $("#input-calender").calendar({
        maxDate: maxDate,
        onChange: function (p, values, displayValues) {
            calender = values;
        }
    });
}

function btnSubmit() {

    $.showLoading();

    localStorage.setItem("aer-calender", calender);

    window.location.href = 'skip?path=energy/aeration';
}
