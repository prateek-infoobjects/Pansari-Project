var fqdn="https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com"
// var fqdn="http://localhost:8080"


async function getStores() {


  $(".store tr>td").remove();



    //TODO: clear the table here so as not to have duplicate in table after creation
    var data = []
    showLoader()
    await $.ajax({
        url: fqdn+"/stores/listall",
        type: "GET",
        contentType: 'application/json',
        "headers": {
          "accept": "application/json",
          "Access-Control-Allow-Origin":"*"
        }
      }).then(function(result) {
        hideLoader()
        data = result
        var stores = $();
        data.forEach(function(item, i) {
          stores = stores.add(storeMethod(item));
        });
        $(function() {
          $('.store').append(stores);
        });
    },function(error){
      hideLoader()
      data = [{storeId : 11,storeName : "Name",zone : "zone"}]
      var stores = $();

      data.forEach(function(item, i) {
        stores = stores.add(storeMethod(item));
      });
      $(function() {
        $('.store').append(stores);
      });
      console.log("err",error)
    });

}
getStores()

 function storeMethod(storeData) {
    var storeTemplate = [

    '<tbody>',
    '<tr>',
        '<td>',
            storeData.storeId,
        '</td>',
        '<td>',
            storeData.storeName,
        '</td>',
        '<td>',
            storeData.zone,
        '</td>',
        '<td>',
            '<button id=" '+storeData.storeId+'" onclick="getId(this.id,this.value)"  data-id="'+storeData.storeId+'" class="btn btn-danger btnDel" data-toggle="modal" data-target="#deleteModal" value="'+storeData.storeName+'"  ><i class="fa fa-trash" aria-hidden="true"></i> Delete</button>',
        '</td>',
    '</tr>',
  '</tbody>'
    ];

    // a jQuery node
    return $(storeTemplate.join(''));
  }

  var deleteStoreId

  function getId(id,value){
    deleteStoreId = id
    $('#deleteStoreName').text(value)
  }

    function createStore(){
      showLoader()
      var name = $('#name').val()
      var zone = $('#zone').val()
        $.ajax({
          url:fqdn+ "/stores/create",
          type: "POST",
          data:  JSON.stringify({
            "storeName":name,
            "zone":zone
          }),
          contentType: 'application/json',
          "headers": {
            "accept": "application/json",
            "Access-Control-Allow-Origin":"*"
          }
        }).then(function(data) {
          alert("Store added successfully")
          hideLoader()
          $('#myModal').modal('toggle');
          getStores()
      },function(error){
        hideLoader()
        alert(error.statusText)
        // $('#modalBody').val(error.statusText)
        console.log("err",error)
      });
    }

    function deleteStore(id){
      showLoader()
        $.ajax({
          url: fqdn+"/stores/delete?storeId=" + id,
          type: "DELETE",
        }).then(function(data) {
          alert("Store deleted successfully")
          hideLoader()
          $('#deleteModal').modal('toggle');
          getStores()
      },function(error){
          hideLoader()
          alert(error.statusText)
          console.log("err",error)
          getStores()
        });
    }
