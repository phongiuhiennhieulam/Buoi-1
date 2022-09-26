 let table = document.getElementById('table')
function getAllBlog(){
    $.ajax({
        type:"GET",
        url: "http://localhost:8020/api/blogs",
        success:function(data){
            console.log(data)
            showListBlog(data)
        }
    })
}
function showListBlog(data){
    let str = "";
    for(let i = 0;i < data.length;i++){
        str += `<tr>
         <td>${data[i].id}</td>
          <td>${data[i].title}</td>
          <td>${data[i].content}</td>
          <td><img src="${'http://localhost:8080/image/' + data[i].covers.name}" width="100px"></td>
          <td><button onclick="deleteBlog(${data[i].id})">Delete</button></td>`

           



    }
    table.innerHTML = str;

}
 function deleteBlog(id){
     $.ajax({
         type:"GET",
         url:"http://localhost:8020/api/blogs/"+id,
         success:function(data){
             console.log(data)
             getAllBlog()
         }
     })
 }
 function showCreateForm(){

     var x= document.getElementById('showModal');
     let content = `<div class="container">
                    <form id="form-blog">
                        <div class="mb-3">
                            <label for="title" class="form-label">Title</label>
                            <input type="text" name="title" class="form-control" id="title" >
                        </div>
                        <div class="mb-3">
                            <label for="price" class="form-label">Covers</label>
                            <input type="file" name="covers" multiple class="form-control" id="files">
                        </div>
                        <div class="mb-3">
                        <label for="list-cate">Category</label>
                        <select name="category" id="list-cate">
                        </select>
                    </div>
                        <div class="mb-3">
                            <label for="content" class="form-label">Content</label>
                            <input name="content" type="text" class="form-control" id="content">
                        </div>
                    </form>
                </div>
                        <div class="modal-footer">
                             <button type="submit" class="btn btn-primary" onclick="create()">Create</button>
                             <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
                        </div>`

     x.innerHTML = content;
     showCategoryList();


 }
 function showCategoryList() {
    let x = document.getElementById('list-cate')
     $.ajax({

         type: "GET",
         url: "http://localhost:8020/api/blogs/cate",
         success:function (cate){
             console.log(cate)
             let content = '';
             let option = document.createElement("option");

             for (let i = 0; i < cate.length; i++) {
                 content += `<option value="${cate[i].id}">${cate[i].name}</option>`
                 option.value = cate[i].id;
                 option.innerText = cate[i].name;
             }

             x.innerHTML = content;

         }
     })
 }
 function create(){
     let form1 = $('#form-blog')[0];
     let blogForm = new FormData(form1);
     $.ajax({
         type:"POST",
         enctype: 'multipart/form-data',
         processData: false,
         contentType: false,
         data: blogForm,
         url:"http://localhost:8020/api/blogs/create",
         success: function (){

             getAllBlog();
         }
     });
 }