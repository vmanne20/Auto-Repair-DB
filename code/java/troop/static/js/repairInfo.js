    // PHONE NUMBERS
    $(document).ready(function () {
        $('#RepairInfoTableContainer').jtable({
          title: 'PAST REPAIRS',
          fields: {
            r_name: {
                title: 'Repair Name'
            },
            m_name: {
                title: 'Mechanic Name'
            },
            make_year: {
                title: 'Make Year'
            },
            make: {
                title: 'Make'
            },
            model: {
                title: 'Model'
            },
            c_name: {
                title: 'Customer Name'
            },
            r_date: {
                title: 'Date of Repair',
                key: true,
                type: 'date'
            }
          },
          actions: {
            listAction: function (postData, jtParams) {
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/get-repair-info',
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
        $('#RepairInfoTableContainer').jtable('load');
      });
      
      
      