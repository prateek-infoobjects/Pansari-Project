async function getStores() {
    showLoader()
    await $.ajax({
        url: "https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com/stores/listall",
        type: "GET",
        contentType: 'application/json',
        "headers": {
          "accept": "application/json",
          "Access-Control-Allow-Origin":"*"
        }
      }).then(function(result) {
        hideLoader()
        var data = result
        var stores = $();        
        data.forEach(function(item, i) {
          stores = stores.add(storeMethod(item));
        });
        $(function() {
          $('.store').append(stores);
        });
    },function(error){
      hideLoader()
      var data = [{storeName : "manish",storeId:12,zone : "zone"}]
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
            '<button id=" '+storeData.storeId+'" onclick="deleteStore(this.id)" class="btn btn-danger btnDel" data-toggle="modal" data-target="#confirm_delete_modal" data-id="',storeData.storeId,'" ><i class="fa fa-trash" aria-hidden="true"></i> Delete</button>',
        '</td>',
    '</tr>',
  '</tbody>'
    ];
  
    // a jQuery node
    return $(storeTemplate.join(''));
  }

    function createStore(){
      showLoader()
      var name = $('#name').val()
      var zone = $('#zone').val()
        $.ajax({
          url: "https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com/stores/create",
          type: "POST",
          data:{
            "storeName":name,
            "zone":zone
          },
          contentType: 'application/json',
          "headers": {
            "accept": "application/json",
            "Access-Control-Allow-Origin":"*"
          }
        }).then(function(data) {
          hideLoader()
          $('#myModal').modal('toggle');
          getStores()
      },function(error){
        hideLoader()
        alert(error.statusText)
        console.log("err",error)
      });
    }

    function deleteStore(id){
      showLoader()
        $.ajax({
          url: "https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com/stores/delete?storeId" + id,
          type: "DELETE", 
        }).then(function(data) {
          hideLoader()
          $('#myModal').modal('toggle');
          getStores()
      },function(error){
          hideLoader()
          alert(error.statusText)
          console.log("err",error)
        });
    }