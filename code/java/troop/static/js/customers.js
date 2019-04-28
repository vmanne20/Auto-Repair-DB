    // CUSTOMERS
    $(document).ready(function () {
        $('#CustomerTableContainer').jtable({
          title: 'Customers',
          fields: {
            //CHILD TABLE DEFINITION FOR "PHONE NUMBERS"
            PhoneNumbers: {
                title: '',
                width: '0.5%',
                sorting: false,
                edit: false,
                create: false,
                display: function (customerData) {
                    //Create an image that will be used to open child table
                    let $img = $('<img src="http://jtable.org/Content/images/Misc/phone_metro.png" align="center" style="display:block; cursor: pointer;" width="100%" height="100%"/>');
                    //Open child table when user clicks the image
                    $img.click(function () {
                        $('#CustomerTableContainer').jtable('openChildTable',
                                $img.closest('tr'),
                                {
                                    title: customerData.record.c_name + '\'s Phone Numbers',
                                    actions: {
                                        createAction: function (postData, jtParams) {
                                            console.log("creating phone number:");
                                            postData = QueryStringToJSON(postData);
                                            console.log(postData);
                                            return $.Deferred(function ($dfd) {
                                              $.ajax({
                                                url: '/phoneNumbers',
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
                                              console.log("creating phone number:");
                                              postData = QueryStringToJSON(postData);
                                              console.log(postData);
                                              return $.Deferred(function ($dfd) {
                                                $.ajax({
                                                  url: '/phoneNumbers',
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
                                              console.log("deleting phoneNumber:");
                                              console.log(postData);
                                              return $.Deferred(function ($dfd) {
                                                $.ajax({
                                                  url: '/phoneNumbers',
                                                  type: 'DELETE',
                                                  contentType: "application/json; charset=utf-8",
                                                  data: JSON.stringify(postData['p_id']),
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
                                                url: '/phoneNumbers',
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
                                        c_id: {
                                            type: 'hidden',
                                            title: 'Customer Id',
                                            defaultValue: customerData.record.c_id
                                        },
                                        p_id: {
                                            key: true,
                                            create: false,
                                            edit: false,
                                            list: false
                                        },
                                        p_number: {
                                            title: 'Numbers'
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
            c_id: {
                title: 'Customer Id',
                key: true,
                width: '15%'
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
            updateAction: function (postData, jtParams) {
                console.log("creating customer:");
                postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/customers',
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
                console.log("deleting customer:");
                // postData = QueryStringToJSON(postData);
                console.log(postData);
                return $.Deferred(function ($dfd) {
                  $.ajax({
                    url: '/customers',
                    type: 'DELETE',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(postData['c_id']),
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
      
      
      