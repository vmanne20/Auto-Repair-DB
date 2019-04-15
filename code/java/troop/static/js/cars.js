    // CARS
    $(document).ready(function () {
        $('#CarTableContainer').jtable({
          title: 'Cars',
          fields: {
            id: {
                title: 'Car Id',
                key: true,
                list: true
            },
            customer_id: {
                title: 'Customer Id'
            },
            make_year: {
                title: 'Make Year'
            },
            make: {
                title: 'Make'
            },
            model: {
                title: 'Model'
            }
          },
          actions: {
            createAction: function (postData, jtParams) {
              console.log("creating car:");
              postData = QueryStringToJSON(postData);
              console.log(postData);
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/cars',
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
            updateAction: function (postData, jtParams) {
                console.log("creating car:");
                postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/cars',
                    type: 'PUT',
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
                  url: '/cars',
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
        $('#CarTableContainer').jtable('load');
      });
      
      
      