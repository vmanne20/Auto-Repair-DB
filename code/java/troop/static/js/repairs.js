    // PHONE NUMBERS
    $(document).ready(function () {
        $('#RepairTableContainer').jtable({
          title: 'REPAIRS',
          fields: {
            //CHILD TABLE DEFINITION FOR "CERTS"
            Certs: {
                title: '',
                width: '1.2%',
                sorting: false,
                edit: false,
                create: false,
                display: function (repairData) {
                    //Create an image that will be used to open child table
                    let $img = $('<img src="http://jtable.org/Content/images/Misc/list_metro.png" align="center" style="display:block; cursor: pointer;" width="100%" height="100%"/>');
                    //Open child table when user clicks the image
                    $img.click(function () {
                        $('#RepairTableContainer').jtable('openChildTable',
                                $img.closest('tr'),
                                {
                                    title: repairData.record.r_id + ' - ' + repairData.record.r_name + ' Certifications',
                                    actions: {
                                        createAction: function (postData, jtParams) {
                                            console.log("creating certs:");
                                            postData = QueryStringToJSON(postData);
                                            console.log(postData);
                                            return $.Deferred(function ($dfd) {
                                              $.ajax({
                                                url: '/add-certs?r_id=' + repairData.record.r_id,
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
                                              console.log("updating certs:");
                                              postData = QueryStringToJSON(postData);
                                              console.log(postData);
                                              return $.Deferred(function ($dfd) {
                                                $.ajax({
                                                  url: '/update-certs',
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
                                              console.log("deleting certs:");
                                              console.log(postData);
                                              return $.Deferred(function ($dfd) {
                                                $.ajax({
                                                  url: '/delete-certs',
                                                  type: 'DELETE',
                                                  contentType: "application/json; charset=utf-8",
                                                  data: JSON.stringify(postData['cert_id']),
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
                                                url: '/get-repair-certs?r_id=' + repairData.record.r_id,
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
                                    },
                                    fields: {
                                        cert_id: {
                                            key: true,
                                            create: false,
                                            edit: false,
                                            list: false
                                        },
                                        cert_name: {
                                            title: 'Name'
                                        },
                                        m_id: {
                                            type: 'hidden',
                                            title: 'Mechanic Id',
                                            defaultValue: 0
                                        },
                                        r_id: {
                                            type: 'hidden',
                                            title: 'Repair Id',
                                            defaultValue: repairData.record.r_id
                                        }
                                    }
                                }, function (data) { //opened handler
                                    data.childTable.jtable('load');
                                });
                    });
                    //Return image to show on the person row
                    return $img;
                }
            },
            r_id: {
                title: 'Repair Id',
                key: true,
                width: '3%'
            },
            r_name: {
                title: 'Name', 
                width: '8%'
            },
            r_descript: {
                title: 'Description'
            },
            parts_cost: {
                title: 'Parts Cost',
                width: '5%'
            },
            r_time: {
                title: 'Time (hrs)',
                width: '5%'
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
      
      
      