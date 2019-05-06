$(document).ready(function () {
    let repairNames;
    return $.Deferred(function ($dfd) {
        $.ajax({
            url: '/get-repair-names',
            type: 'GET',
            success: function (data) {
                repairNames = data;
                console.log("All Repair Id's and Names: ");
                for (let i = 0; i < repairNames.length; i++) {
                    console.log(repairNames[i]);
                    let splitIndex = repairNames[i].indexOf(':');
                    let repairId = repairNames[i].substring(0, splitIndex);
                    let repairName = repairNames[i].substring(splitIndex + 1);

                    let label = document.createElement("LABEL");
                    label.setAttribute("class", "container");
                    label.setAttribute("id", "label" + i);
                    
                    let input = document.createElement("INPUT");
                    input.setAttribute("type", "checkbox");
                    input.setAttribute("name", repairId);
                    input.setAttribute("value", repairName);
                    label.appendChild(input);

                    let span = document.createElement("SPAN");
                    span.setAttribute("class", "checkmark");
                    label.appendChild(span);

                    let labelText = document.createTextNode(repairName);
                    label.appendChild(labelText);

                    document.getElementById("estimate_form").appendChild(label);

                    // // ----------REGULAR CHECKBOXES-------------------
                    // let formInput = document.createElement("INPUT");
                    // formInput.setAttribute("type", "checkbox");
                    // formInput.setAttribute("name", "repair" + (i+1));
                    // formInput.setAttribute("value", (i+1));

                    // document.getElementById("estimate_form").appendChild(formInput);

                    // let inputText = document.createTextNode(repairNames[i]);
                    // document.getElementById("estimate_form").appendChild(inputText);
                    // let br = document.createElement("br");
                    // document.getElementById("estimate_form").appendChild(br);
                }

                let submitButton = document.createElement("INPUT");
                submitButton.setAttribute("type", "submit");
                submitButton.setAttribute("value", "Submit");
                document.getElementById("estimate_form").appendChild(submitButton);

                $dfd.resolve({ "Result": "OK", "Records": data, "TotalRecordCount": data.length });
            },
            error: function () {
                $dfd.reject();
            }
        });
    });
});




