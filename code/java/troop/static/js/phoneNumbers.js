    // PHONE NUMBERS
    $(document).ready(function () {
        $('#PhoneTableContainer').jtable({
          title: 'Phone Numbers',
          fields: {
            p_id: {
                title: 'Customer ID',
                key: true,
                list: false
            },
            c_name: {
                title: 'Name'
            },
            c_number: {
                title: 'Number'
            }
          },
          actions: {
            createAction: function (postData, jtParams) {
              console.log("creating phone number:");
              postData = QueryStringToJSON(postData);
              console.log(postData);
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/phonenumbers',
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
                  url: '/phonenumbers',
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
      
      
      