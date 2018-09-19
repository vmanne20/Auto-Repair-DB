function QueryStringToJSON(str) {
  var pairs = str.split('&');
  var result = {}
  pairs.forEach(function(pair) {
    pair = pair.split('=');
    result[pair[0]] = decodeURIComponent(pair[1] || '');
  });
  return JSON.parse(JSON.stringify(result));
}

$(document).ready(function () {
  $('#ScoutTableContainer').jtable({
    title: 'ACTIVE Scouts',
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
      listAction: function (postData, jtParams) {
        return $.Deferred(function ($dfd) {
          $.ajax({
              url: '/activeScouts',
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
