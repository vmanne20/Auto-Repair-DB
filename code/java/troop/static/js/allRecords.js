    // CARS
    $(document).ready(function () {
        $('#CustomerTableContainer').jtable({
            title: 'Customers',
            fields: {
                id: {
                    title: 'Customer Id',
                    key: true
                    // list: false
                },
                c_name: {
                    title: 'Name'
                },
                c_address: {
                    title: 'Address'
                }
            },
          actions: {
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
        $('#CustomerTableContainer').jtable('load');
      });
      
    //   function fetchAllRecords() {
    //     $('#CustomerTableContainer').jtable('load');
    //   }
      