$(document).ready(function () {
    let repairNames;
    return $.Deferred(function ($dfd) {
        $.ajax({
          url: '/get-repair-names',
          type: 'GET',
          success: function (data) {
            repairNames = data;
            console.log("All Repair Names: ");
            console.log(repairNames);
            $dfd.resolve({ "Result": "OK", "Records": data, "TotalRecordCount": data.length });
          },
          error: function () {
            $dfd.reject();
          }
        });
    });

});