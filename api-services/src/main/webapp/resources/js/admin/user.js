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
        $(function() {
          $('.user').append(users);
        });
    },function(error){
      hideLoader()
      console.log("err",error)
    });

}
getUsers()


function userMethod(userData) {
    var userTemplate = [

    '<tbody>',
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
            '<button id=" '+userData.userid+'" onclick="getId(this.id,this.value)"  data-id="'+userData.userid+'" class="btn btn-danger btnDel" data-toggle="modal" data-target="#deleteModal" value="'+userData.username+'"  ><i class="fa fa-trash" aria-hidden="true"></i> Delete</button>',
        '</td>',
    '</tr>',
  '</tbody>'
    ];

    // a jQuery node
    return $(userTemplate.join(''));
  }

  var deleteUserId

  function getId(id,value){
    deleteUserId = id
    $('#deleteUserName').text(value)
  }


  function createUser(){
    showLoader()
    var name = $('#name').val()
    var username = $('#username').val()
    var password = $('#password').val()
      $.ajax({
        url:fqdn+ "/users/create",
        type: "POST",
        data:  JSON.stringify({
          "username":username,
          "name":name,
          "password" : password
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
