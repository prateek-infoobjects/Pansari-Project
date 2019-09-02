$(document).ready(function() {
  //$( ".datepicker" ).datepicker();

  var fqdn="https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com"
  // var fqdn="http://localhost:8080"

  var helpers =
  {

    buildDropdown: function(result, dropdown, emptyMessage)
    {
      // Remove current options
      dropdown.html('');
      // Add the empty option with the empty message
      dropdown.append('<option value="">' + emptyMessage + '</option>');
      // Check result isnt empty
      if(result != '')
      {
        // Loop through each of the results and append the option to the dropdown
        $.each(result, function(k, v) {
          dropdown.append('<option value="' + v.userid + '">' + v.name + '</option>');
        });
      }
    }
  }

  $('#user-dropdown').hide();
  $.ajax({
    url: fqdn+"/users",
    type: "GET",
    contentType: 'application/json',
    crossDomain: true,
    dataType: "json",
    success: function (response) {
      $("#loading-button").hide();
      console.log("List of users retrived successfully1");
      // for (var i=0; i<response.length; i++)
      // console.log(JSON.parse(response[i]))
      // for (var i = 0, len = response.length; i < len; i++) {
      // 	console.log(response[i].name);
      // 	console.log(response[i].username);
      // }
      helpers.buildDropdown(
        response,
        $('#user-dropdown'),
        'Select a user'
      );
      $('#user-dropdown').show();

    },


    error: function (xhr, status) {
      $("#loading-button").hide();
      console.error("error");
    }
  });

  $('#submit-details').on('click', function(event) {

    $('#full-screen-loading').show();
    //event.preventDefault(); // To prevent following the link (optional)
    var userid=$( "#user-dropdown option:selected" ).val();
    //var jsDate = $('#datepicker').datepicker('getDate');
    var jsDate = $('#datepicker').val()

    var datestamp=jsDate;
    // if (jsDate !== null) { // if any date selected in datepicker
    //   jsDate instanceof Date; // -> true
    //
    //   var month=jsDate.getMonth() +1//getMonth starts from 0 index
    //   month = (month < 10) ? '0' + month : month;// to make 6 to 06
    //   var day=jsDate.getDate()
    //   day = (day < 10) ? '0' + day : day;//to make 5 to 05
    //   datestamp=jsDate.getFullYear()+"-" + month+ "-"+day
    // }
    console.log(userid+","+datestamp);

    function capitalizeFirstLetter(value) {
      return value.charAt(0).toUpperCase() + value.slice(1);
    }


    $.ajax({
      url: fqdn+"/realtime/getlocationreadings?userid="+userid+"&datestamp="+datestamp,
      type: "GET",
      contentType: 'application/json',
      crossDomain: true,
      dataType: "json",
      success: function (response) {


        var headerRow = '';
        var bodyRows = '';
        console.log(response);
        if(response==""){
          $('#full-screen-loading').hide();
          alert("No response received for the user for "+datestamp)
          return;
        }
        var cols = Object.keys(response[0]);
        cols.map(function(col) {
          headerRow += '<th>' + capitalizeFirstLetter(col) + '</th>';
        });
        headerRow += '<th>' + "Link"+ '</th>';
        response.map(function(row) {
          bodyRows += '<tr>';
          // To do: Loop over object properties and create cells
          cols.map(function(colName) {
            if(colName=="received"){
              var receivedDate=new Date(row[colName]);
              bodyRows += '<td>' +
              receivedDate.toLocaleString('en-US', { hour: 'numeric',minute: 'numeric',second :'numeric', hour12: true })
              + '</td>';
            }
            else{
              bodyRows += '<td>' + row[colName] + '</td>';
            }
          });
          var url="http://maps.google.com/maps?q="+row["latitude"]+","+row["longitude"];
          url='<a href='+url+'  target="_blank">'+
          '<button>Map Location</button>'+
          '</a>';
          bodyRows += '<td>' + url + '</td>';
          bodyRows += '</tr>';

        });


        var x ='<table id="actual-table" class="display" style="width:100%"' +
        '><thead><tr>' +
        headerRow +
        '</tr></thead><tbody>' +
        bodyRows +
        '</tbody></table>';

        $("#example-table").html(x);
        $('#actual-table').DataTable();
        $('#full-screen-loading').hide();

      },

      error: function (xhr, status) {
        console.error("error");
      }
    });
  });

});
