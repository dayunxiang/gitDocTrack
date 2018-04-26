var calender = new Date();
calender.setDate(calender.getDate() - 1);
calender = calender.pattern("yyyy-MM-dd");
var maxDate = calender;

$(function () {
    initCalender();
});

function initCalender() {
    $("#input-calender").calendar({
        maxDate:maxDate,
        value:[calender],
        onChange: function (p, values, displayValues) {
            calender = values;
        }
    });
}

function btnSubmit() {

    $.showLoading();

    localStorage.setItem("ltot-calender", calender);

    window.location.href = 'skip?path=passengerflow/line/listDetail_total';
}
