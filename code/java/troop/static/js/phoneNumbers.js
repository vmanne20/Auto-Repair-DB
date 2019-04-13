    // PHONE NUMBERS
    $(document).ready(function () {
        $('#PhoneTableContainer').jtable({
          title: 'Phone Numbers',
          fields: {
            customer_id: {
                title: 'Customer ID',
                key: true,
                list: true
            },
            c_name: {
                title: 'Name'
            },
            c_number: {
                title: 'Number',
                key: true,
                list: true
            }
          },
          actions: {
            createAction: function (postData, jtParams) {
              console.log("creating phone number:");
              postData = QueryStringToJSON(postData);
              console.log(postData);
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/numbers',
                  type: 'POST',
                  contentType: "application/json; charset=utf-8",
                  data: JSON.stringify(postData),
                  dataType: 'json',
                  success: function (data) {
                    $dfd.resolve({ "Result": "OK", "Record": data });
                  },
                  error: function (xhr, options, error) {
                    console.log("error");
                    console.log(xhr.responseText);
                    $dfd.reject();
                  }
                });
              });
            }
            ,
            listAction: function (postData, jtParams) {
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/numbers',
                  type: 'GET',
                  success: function (data) {
                    $dfd.resolve({ "Result": "OK", "Records": data, "TotalRecordCount": data.length });
                  },
                  error: function () {
                    $dfd.reject();
                  }
                });
              });
            }
          }
        });
        $('#PhoneTableContainer').jtable('load');
      });
      
      
      