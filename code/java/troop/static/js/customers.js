    // CUSTOMERS
    $(document).ready(function () {
        $('#CustomerTableContainer').jtable({
          title: 'Customers',
          fields: {
            customer_id: {
                title: 'Customer Id',
                key: true,
                list: false
            },
            c_name: {
                title: 'Name'
            },
            c_address: {
                title: 'Address'
            }
          },
          actions: {
            createAction: function (postData, jtParams) {
              console.log("creating customer:");
              postData = QueryStringToJSON(postData);
              console.log(postData);
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/customers',
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
                  url: '/customers',
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
        $('#CustomerTableContainer').jtable('load');
      });
      
      
      