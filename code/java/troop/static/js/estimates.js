$(document).ready(function () {
    let repairNames;
    return $.Deferred(function ($dfd) {
        $.ajax({
            url: '/get-repair-names',
            type: 'GET',
            success: function (data) {
                repairNames = data;
                console.log("All Repair Names: ");
                for (let i = 0; i < repairNames.length; i++) {
                    console.log(repairNames[i]);
                    let formInput = document.createElement("INPUT");
                    formInput.setAttribute("type", "checkbox");
                    formInput.setAttribute("name", "repair" + i);
                    formInput.setAttribute("value", repairNames[i]);
                    document.getElementById("estimate_form").appendChild(formInput);
                }

                let submitButton = document.createElement("INPUT");
                submitButton.setAttribute("type", "submit");
                submitButton.setAttribute("value", "Get Estimates");
                document.getElementById("estimate_form").appendChild(submitButton);

                $dfd.resolve({ "Result": "OK", "Records": data, "TotalRecordCount": data.length });
            },
            error: function () {
                $dfd.reject();
            }
        });
    });
});