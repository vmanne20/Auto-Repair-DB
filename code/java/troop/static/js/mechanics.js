    // PHONE NUMBERS
    $(document).ready(function () {
        $('#MechTableContainer').jtable({
          title: 'MECHANICS',
          fields: {
            //CHILD TABLE DEFINITION FOR "CERTS"
            Certs: {
                title: '',
                width: '1.1%',
                sorting: false,
                edit: false,
                create: false,
                display: function (mechanicData) {
                    //Create an image that will be used to open child table
                    let $img = $('<img src="http://jtable.org/Content/images/Misc/list_metro.png" align="center" style="display:block; cursor: pointer;" width="100%" height="100%"/>');
                    //Open child table when user clicks the image
                    $img.click(function () {
                        $('#MechTableContainer').jtable('openChildTable',
                                $img.closest('tr'),
                                {
                                    title: mechanicData.record.m_id + ' - ' + mechanicData.record.m_name + '\'s Certifications',
                                    actions: {
                                        createAction: function (postData, jtParams) {
                                            console.log("creating certs:");
                                            postData = QueryStringToJSON(postData);
                                            console.log(postData);
                                            return $.Deferred(function ($dfd) {
                                              $.ajax({
                                                url: '/add-certs',
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
                                                url: '/get-mechanic-certs?m_id=' + mechanicData.record.m_id,
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
                                            defaultValue: mechanicData.record.m_id
                                        },
                                        r_id: {
                                            type: 'hidden',
                                            title: 'Repair Id',
                                            defaultValue: 0
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
            m_id: {
                title: 'Mechanic Id',
                key: true,
                width: '3%'
            },
            m_name: {
                title: 'Name'
            },
            years_exp: {
                title: 'Years of Experience'
            },
            hourly_rate: {
                title: 'Hourly Rate'
            }
          },
          actions: {
            createAction: function (postData, jtParams) {
              console.log("creating mechanics:");
              postData = QueryStringToJSON(postData);
              console.log(postData);
              return $.Deferred(function ($dfd) {
                $.ajax({
                  url: '/add-mechanics',
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
                console.log("updating mechanics:");
                postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/update-mechanics',
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
                console.log("deleting mechanics:");
                // postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/delete-mechanics',
                    type: 'DELETE',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(postData['m_id']),
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
                  url: '/get-mechanics',
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
        $('#MechTableContainer').jtable('load');
      });
      
      
      