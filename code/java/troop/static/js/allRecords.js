    // CARS
    $(document).ready(function () {

        $('#CustomerTableContainer').jtable({
            title: 'All Records',
            fields: {
                c_id: {
                    title: 'Customer Id',
                    key: true,
                    list: true
                },
                c_name: {
                    title: 'Name'
                },
                c_address: {
                    title: 'Address'
                },
                c_number: {
                    title: 'Address'
                },
                make_year: {
                    title: 'Address'
                },
                make: {
                    title: 'Address'
                },
                model: {
                    title: 'Address'
                },
            },
          actions: {
            listAction: function (postData, jtParams) {
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/allRecords',
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
      