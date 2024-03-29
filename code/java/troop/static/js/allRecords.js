
    $(document).ready(function () {

        $('#AllTableContainer').jtable({
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
                    title: 'Number'
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
        $('#AllTableContainer').jtable('load');
    });
      
    //   function fetchAllRecords() {
    //     $('#CustomerTableContainer').jtable('load');
    //   }
      