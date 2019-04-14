function QueryStringToJSON(str) {
  var pairs = str.split('&');
  var result = {}
  pairs.forEach(function (pair) {
    pair = pair.split('=');
    result[pair[0]] = decodeURIComponent(pair[1] || '');
  });
  return JSON.parse(JSON.stringify(result));
}

// SCOUTS
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
      },
      tempfield: {title: 'Temp Field'}
    },
    actions: {
      createAction: function (postData, jtParams) {
        console.log("creating scout:");
        postData = QueryStringToJSON(postData);
        console.log(postData);
        return $.Deferred(function ($dfd) {
          $.ajax({
            url: '/scouts',
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


