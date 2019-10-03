//var fqdn="https://pansari-promoter-api-dot-pansari-promoter-app.appspot.com"
var fqdn="http://localhost:8080"

async function getItems() {
  $(".item tr>td").remove();
    //TODO: clear the table here so as not to have duplicate in table after creation
    var data = [];
    showLoader();
    await $.ajax({
        url: fqdn+"/items/list",
        type: "GET",
        contentType: 'application/json',
        "headers": {
          "accept": "application/json",
          "Access-Control-Allow-Origin":"*"
        }
      }).then(function(result) {
        hideLoader()
        data = result
        var items = $();
        data.forEach(function(item, i) {
          items = items.add(itemMethod(item));
        });
        $("#item_table_id tbody").empty();
        $(function() {
          $('#tbody').append(items);
        });
    },function(error){
      hideLoader();
      data = [{itemId : 123,itemName : "Iphone",primaryCategory : "Mobile Phone", secondaryCategory :"Smart Phone"},{itemId : 123,itemName : "Iphone",primaryCategory : "Mobile Phone", secondaryCategory :"Smart Phone"},{itemId : 123,itemName : "Iphone",primaryCategory : "Mobile Phone", secondaryCategory :"Smart Phone"}];

      var items = $();
      data.forEach(function(item, i) {
        items = items.add(itemMethod(item));
      });
      $("#item_table_id tbody").empty();
      $(function() {
        $('#tbody').append(items);
      });
      console.log("err",error);
    });
    $('#item_table_id').DataTable();


}
getItems()

 function itemMethod(itemData) {
    var itemTemplate = [

    '<tr>',
        '<td>',
            itemData.itemId,
        '</td>',
        '<td>',
            itemData.itemName,
        '</td>',
        '<td>',
            itemData.primaryCategory,
        '</td>',
        '<td>',
            itemData.secondaryCategory,
        '</td>',
        '<td>',
            '<button id=" '+itemData.itemId+'" onclick="getId(this.id,this.value)"  data-id="'+itemData.itemId+'" class="btn btn-danger btnDel" data-toggle="modal" data-target="#deleteModal" value="'+itemData.itemName+'"  ><i class="fa fa-trash" aria-hidden="true"></i> Delete</button>',
        '</td>',
    '</tr>',
    ];

    // a jQuery node
    return $(itemTemplate.join(''));
  }

  var deleteItemId;

  function getId(id,value){
    deleteItemId = id;
    $('#deleteItemName').text(value);
  }

    function createItem(){
      showLoader();
      var name = $('#name').val();
      var primaryCategory = $('#primaryCategory').val();
      var secondaryCategory = $('#secondaryCategory').val();

        $.ajax({
          url:fqdn+ "/items/create",
          type: "POST",
          data:  JSON.stringify({
            "itemname":name,
            "primaryCategory" : primaryCategory,
            "secondaryCategory" : secondaryCategory
          }),
          contentType: 'application/json',
          "headers": {
            "accept": "application/json",
            "Access-Control-Allow-Origin":"*"
          }
        }).then(function(data) {
          alert("Item added successfully")
          hideLoader()
          $('#myModal').modal('toggle');
          getItems()
      },function(error){
        hideLoader()
        alert(error.statusText)
        // $('#modalBody').val(error.statusText)
        console.log("err",error)
      });
    }

    function deleteItem(id){
      showLoader()
        $.ajax({
          url: fqdn+"/items/delete?itemId=" + id,
          type: "DELETE",
        }).then(function(data) {
          alert("Item deleted successfully")
          hideLoader()
          $('#deleteModal').modal('toggle');
          getItems()
      },function(error){
          hideLoader()
          $('#deleteModal').modal('toggle');
          alert(error.statusText)
          console.log("err",error)
          getItems()
        });
    }


  $(document).ready( function () {
    $('#item_table_id tbody').DataTable();
    $("#item_table_id").ajax.reload();
  } );