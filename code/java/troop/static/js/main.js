$(document).ready(function() {
    $.ajax({
        url: "/scouts/Timmy"
    }).then(function(data) {
       $('.greeting-id').append(data.rank);
    });
});
