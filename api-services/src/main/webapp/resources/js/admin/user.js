//var fqdn="https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com"
var fqdn="http://localhost:8080"

async function getUsers() {
  $(".user tr>td").remove();
    //TODO: clear the table here so as not to have duplicate in table after creation
    var data = []
    showLoader()
    await $.ajax({
        url: fqdn+"/users",
        type: "GET",
        contentType: 'application/json',
        "headers": {
          "accept": "application/json",
          "Access-Control-Allow-Origin":"*"
        }
      }).then(function(result) {
        hideLoader()
        data = result
        var users = $();
        data.forEach(function(item, i) {
          users = users.add(userMethod(item));
        });
        $("#user_table_id tbody").empty();
        $(function() {
          $('#tbody').append(users);
        });
    },function(error){
      hideLoader()
      data = [{userid : 1,name : "Raghav",username : "raghav",store :{storeName : "test",zone : "zone"}}]
      var users = $();
      data.forEach(function(item, i) {
        users = users.add(userMethod(item));
      });
      $("#user_table_id tbody").empty();
      $(function() {
        $('#tbody').append(users);
      });
      console.log("err",error)
    });
    $('#user_table_id').DataTable();

}
getUsers()


function userMethod(userData) {
  var userTemplate = [

    '<tr>',
        '<td>',
            userData.userid,
        '</td>',
        '<td>',
            userData.name,
        '</td>',
        '<td>',
            userData.username,
        '</td>',
        '<td>',
            userData.store.storeName,
        '</td>',
        '<td>',
            userData.store.zone,
        '</td>',
        '<td>',
            '<button id=" '+userData.userid+'" onclick="getAssignStoreId(this.id,this.value)"  data-id="'+userData.userid+'" class="btn btn-primary btnDel" data-toggle="modal" data-target="#assignStoreModal" value="'+userData.username+'"  ><i class="fa fa-user-plus" aria-hidden="true"></i> Assign</button>',
        '</td>',
        '<td>',
            '<button id=" '+userData.userid+'" onclick="getId(this.id,this.value)"  data-id="'+userData.userid+'" class="btn btn-danger btnDel" data-toggle="modal" data-target="#deleteModal" value="'+userData.username+'"  ><i class="fa fa-trash" aria-hidden="true"></i> Delete</button>',
        '</td>',
    '</tr>',
    ];

    // a jQuery node
    return $(userTemplate.join(''));
  }

  var assignUserId

  function getAssignStoreId(id,value){
    console.log("assignUserId - "+id+","+value);
    assignUserId = id
    $('#assignStoreUsername').text(value)
  }

  var deleteUserId

  function getId(id,value){
    deleteUserId = id
    $('#deleteUserName').text(value)
  }

  function getZones(){
    showLoader()
    console.log("test")
    $(".zone").remove();
    $.ajax({
        url:fqdn+ "/stores/getzones",
        type: "GET",
        contentType: 'application/json',
        "headers": {
            "accept": "application/json",
            "Access-Control-Allow-Origin":"*"
          }
        }).then(function(data) {
        hideLoader()
        // Get select
        var select = document.getElementById('zoneSelect');
        // Add options
        for (var i in data) {
          $(select).append('<option class="zone" value=' + data[i] + '>' + data[i] + '</option>');
        }
        // Set selected value
        $(select).val(data[1]);
    },function(error){
      hideLoader()
      data = [12,23,4,5,6,6]
      // Get select
      var select = document.getElementById('zoneSelect');
      // Add options
      for (var i in data) {
        $(select).append('<option class="zone" value=' + data[i] + '>' + data[i] + '</option>');
      }
      // Set selected value
      $(select).val(data[1]);
      // alert(error.statusText)
      console.log("err",error)
    });
  }

  function getStores(zone){
    showLoader()
    $(".store").remove();
    $.ajax({
        url:fqdn+ "/stores/listbyzone?zone=" + zone,
        type: "GET",
        contentType: 'application/json',
        "headers": {
            "accept": "application/json",
            "Access-Control-Allow-Origin":"*"
          }
        }).then(function(data) {
        hideLoader()
        // Get select
        var select = document.getElementById('storeSelect');
        // Add options
        for (var i in data) {
          $(select).append('<option class="store" value=' + data[i] + '>' + data[i] + '</option>');
        }
        // Set selected value
        $(select).val(data[1]);
    },function(error){
      hideLoader()
      data = [{
        "storeId": 48,
        "storeName": "WEEKLY OFF",
        "zone": "NORTH-DELHI"
    },
    {
        "storeId": 49,
        "storeName": "AGGARWAL BACHAT BAZAAR",
        "zone": "NORTH-DELHI"
    },
    {
        "storeId": 50,
        "storeName": "APNA STORE- MANGOLPURI",
        "zone": "NORTH-DELHI"
    }]
      // Get select
      var select = document.getElementById('storeSelect');
      // Add options
      for (var i in data) {
        $(select).append('<option class="store"  value=' + data[i].storeId + '>' + data[i].storeName + '</option>');
      }
      // Set selected value
      $(select).val(data[1]);
      // alert(error.statusText)
      console.log("err",error)
    });
  }
  var storeId
  function getStoreId(id){
    storeId = id
  }

  function createUser(){
    showLoader()
    var name = $('#name').val()
    var username = $('#username').val()
    var password = $('#password').val()
    console.log("check",storeId)
      $.ajax({
        url:fqdn+ "/users/create",
        type: "POST",
        data:  JSON.stringify({
          "username":username,
          "name":name,
          "password" : password,
          "storeid" : storeId,
        }),
        contentType: 'application/json',
        "headers": {
          "accept": "application/json",
          "Access-Control-Allow-Origin":"*"
        }
      }).then(function(data) {
        alert("User added successfully")
        hideLoader()
        $('#myModal').modal('toggle');
        getUsers()
    },function(error){
      hideLoader()
      alert(error.statusText)
      // $('#modalBody').val(error.statusText)
      console.log("err",error)
    });
  }

  function deleteUser(id){
    showLoader()
      $.ajax({
        url: fqdn+"/users/delete?userId=" + id,
        type: "DELETE",
      }).then(function(data) {
        alert("User deleted successfully")
        hideLoader()
        $('#deleteModal').modal('toggle');
        getUsers()
    },function(error){
        hideLoader()
        alert(error.statusText)
        console.log("err",error)
        $('#deleteModal').modal('toggle');
        getUsers()
      });
  }

  $(document).ready( function () {
    $('#user_table_id tbody').DataTable();
    $("#user_table_id").ajax.reload();
  } );