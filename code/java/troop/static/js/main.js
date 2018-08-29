$(document).ready(function () {
  $('#ScoutTableContainer').jtable({
    title: 'Scouts',
    fields: {
      id: {
        title: 'Id',
        key: true,
        list: false
      },
      name: {
        title: 'Name'
      },
      rank: {
        title: 'Rank',
        options: ['Scout', 'Tenderfoot', 'Second Class', 'First Class', 'Star', 'Life', 'Eagle'],
      },
      dob: {
	      title: 'Birth Date',
        type: 'date'
      }
    },
    actions: {
      deleteAction: function (postData) {
        console.log("deleting scout...");
        return $.Deferred(function ($dfd) {
          $.ajax({
              url: '/deleteScout',
              type: 'POST',
              dataType: 'json',
              data: postData,
              success: function (data) {
                  $dfd.resolve({"Result": "OK"});
              },
              error: function () {
                  $dfd.reject();
              }
          });
        });
      },
      createAction: function (postData, jtParams) {
        return $.Deferred(function ($dfd) {
          $.ajax({
              url: '/scouts',
              type: 'POST',
              success: function (data) {
                  $dfd.resolve({ "Result": "OK", "Record": data });
              },
              error: function () {
                  $dfd.reject();
              }
          });
        });
      }
      ,
      listAction: function (postData, jtParams) {
        return $.Deferred(function ($dfd) {
          $.ajax({
              url: '/scouts',
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
  $('#ScoutTableContainer').jtable('load');
});
