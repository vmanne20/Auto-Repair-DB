    // PHONE NUMBERS
    $(document).ready(function () {
        $('#RepairTableContainer').jtable({
          title: 'REPAIRS',
          fields: {
            r_id: {
                title: 'Repair Id',
                key: true,
                width: '3%'
            },
            r_name: {
                title: 'Name'
            },
            r_descript: {
                title: 'Description'
            },
            parts_cost: {
                title: 'Parts Cost'
            },
            r_time: {
                title: 'Time (hrs)'
            }
          },
          actions: {
            createAction: function (postData, jtParams) {
              console.log("creating repair:");
              postData = QueryStringToJSON(postData);
              console.log(postData);
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/add-repairs',
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
                console.log("updating repair:");
                postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/update-repairs',
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
            deleteAction: function (postData, jtParams) {
                console.log("deleting repair:");
                // postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/delete-repairs',
                    type: 'DELETE',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(postData['r_id']),
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
                  url: '/get-repairs',
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
        $('#RepairTableContainer').jtable('load');
      });
      
      
      