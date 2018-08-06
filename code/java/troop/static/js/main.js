/*
$(document).ready(function() {
$.ajax({
  url: "/scouts/Timmy"
}).then(function(data) {
   $('.greeting-id').append(data.rank);
});
});
*/

$(document).ready(function () {
  $('#ScoutTableContainer').jtable({
    title: 'Scouts',
    fields: {
      name: {
        title: 'Name'
      },
      rank: {
        title: 'Rank'
      },
      dob: {
	      title: 'Birth Date',
        type: 'date'
      }
    },
    actions: {
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
