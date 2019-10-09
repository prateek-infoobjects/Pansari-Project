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
      console.log("err",error)
    });
    $('#user_table_id').DataTable();

}
getUsers()


function userMethod(userData) {
  userData.password = "qwerty"
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
            '<button id=" '+userData.userid+'" name="'+userData.name+'" password="'+userData.password+'" storeName="'+userData.store.storeName+'" zone="'+userData.store.zone+'" onclick="createUserId(this.id,this) "  data-id="'+userData.userid+'" class="btn btn-primary btnDel" data-toggle="modal" data-target="#changeUserModal" value="'+userData.username+'"  ><i class="fa fa-user-plus" aria-hidden="true"></i> Update User</button>',
        '</td>',
        '<td>',
          '<button id=" '+userData.userid+'" name="'+userData.name+'" password="'+userData.password+'" storeName="'+userData.store.storeName+'" zone="'+userData.store.zone+'" onclick="createUserId(this.id,this) "  data-id="'+userData.userid+'" class="btn btn-primary btnDel" data-toggle="modal" data-target="#changeStoreModal" value="'+userData.username+'"  ><i class="fa fa-user-plus" aria-hidden="true"></i> Update Store</button>',
        '</td>',
        '<td>',
            '<button id=" '+userData.userid+'" onclick="getId(this.id,this.value)"  data-id="'+userData.userid+'" class="btn btn-danger btnDel" data-toggle="modal" data-target="#deleteModal" value="'+userData.username+'"  ><i class="fa fa-trash" aria-hidden="true"></i> Delete</button>',
        '</td>',
    '</tr>',
    ];

    // a jQuery node
    return $(userTemplate.join(''));
  }

  var changeUserId

  function createUserId(id,button){
    changeUserId = id
    console.log("createUserId - ",id);
    var zone = $(button).attr('zone')
    $('.changeUsername').text(id)
    $('#updateUserName').val($(button).attr('name'))
    $('#updateUserUserName').val($(button).attr('value'))
    $('#updateUserPassword').val($(button).attr('password'))
    $('#updateUserZoneSelect').val('Zone')
    $('#updateUserStoreSelect').val($(button).attr('storeName'))
    getZones()
  }

  var deleteUserId

  function getId(id,value){
    deleteUserId = id
    $('#deleteUserName').text(value)
  }

  function getZones(){
    console.log("calling get zones");
    showLoader()
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
        var select = document.getElementById('createUserZoneSelect');
        var updateSelect = document.getElementById('updateUserZoneSelect');
        for (var i in data) {
          $(select).append('<option class="zone" value=' + data[i] + '>' + data[i] + '</option>');
          $(updateSelect).append('<option class="zone" value=' + data[i] + '>' + data[i] + '</option>');
        }
        document.getElementById('createUserZoneSelect').selectedIndex = -1;
        document.getElementById('updateUserZoneSelect').selectedIndex = -1;
    },function(error){
      hideLoader()
      alert(error.statusText)
    });
  }

  function getStores(zone){
    console.log("calling get stores",zone);
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
        var select = document.getElementById('createUserStoreSelect');
        var updateSelect = document.getElementById('updateUserStoreSelect');
        for (var i in data) {
          $(select).append('<option class="store" value=' + data[i].storeId + '>' + data[i].storeName + '</option>');
          $(updateSelect).append('<option class="store" value=' + data[i].storeId + '>' + data[i].storeName + '</option>');
        }
        document.getElementById('createUserStoreSelect').selectedIndex = -1;
        document.getElementById('updateUserStoreSelect').selectedIndex = -1;
    },function(error){
      hideLoader()
      alert(error.statusText)
    });
  }
  var changeStoreId
  function getStoreId(id){
    changeStoreId = id
  }

  function createUser(){
    showLoader()
    var name = $('#createUserModalName').val()
    var username = $('#createUserModalUsername').val()
    var password = $('#createUserModalPassword').val()

      $.ajax({
        url:fqdn+ "/users/create",
        type: "POST",
        data:  JSON.stringify({
          "username":username,
          "name":name,
          "password" : password,
          "storeid" : changeStoreId,
        }),
        contentType: 'application/json',
        "headers": {
          "accept": "application/json",
          "Access-Control-Allow-Origin":"*"
        }
      }).then(function(data) {
        alert("User added successfully")
        hideLoader()
        $('#createUserModal').modal('toggle');
        getUsers()
    },function(error){
      hideLoader()
      alert(error.statusText)
      console.log("err",error)
    });
  }

  function updateUser(){
    showLoader()
    var name = $('#updateUserName').val()
    var username = $('#updateUserUserName').val()
    var password = $('#updateUserPassword').val()
    console.log("testing",changeUserId,name,username,password)
    $.ajax({
      url: fqdn+"/users/update",
      type: "PUT",
      data:  JSON.stringify({
        "userid" : changeUserId,
        "username":username,
        "name":name,
        "password" : password,
      }),
      contentType: 'application/json',
      "headers": {
        "accept": "application/json",
        "Access-Control-Allow-Origin":"*"
      }
    }).then(function(data) {
      hideLoader()
      alert("User updated successfully")
      $('#changeUserModal').modal('toggle');
      getUsers()
  },function(error){
      hideLoader()
      alert(error.statusText)
      console.log("err",error)
      getUsers()
    });
  }

  function updateStore(){
    showLoader()
    var userid = $('.changeUsername').text()
    console.log(userid,changeStoreId)
    $.ajax({
      url: fqdn+"/users/update",
      type: "PUT",
      data:  JSON.stringify({
        "userid":userid,
        "storeid" : changeStoreId,
      }),
      contentType: 'application/json',
      "headers": {
        "accept": "application/json",
        "Access-Control-Allow-Origin":"*"
      }
    }).then(function(data) {
      hideLoader()
      alert("Store updated successfully")
      $('#changeStoreModal').modal('toggle');
      getUsers()
  },function(error){
      hideLoader()
      alert(error.statusText)
      console.log("err",error)
      getUsers()
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
        getUsers()
      });
  }

  $(document).ready( function () {
    $('#user_table_id tbody').DataTable();
    $("#user_table_id").ajax.reload();
  } );
