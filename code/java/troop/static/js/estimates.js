$(document).ready(function () {
    let repairNames;
    return $.Deferred(function ($dfd) {
        $.ajax({
          url: '/get-repair-names',
          type: 'GET',
          success: function (data) {
            repairNames = data;
            console.log("All Repair Names: ");
            // console.log(repairNames);
            for (let i = 0; i < repairNames.length; i++) {
                console.log(repairNames[i]);
            }
            $dfd.resolve({ "Result": "OK", "Records": data, "TotalRecordCount": data.length });
          },
          error: function () {
            $dfd.reject();
          }
        });
    });

});