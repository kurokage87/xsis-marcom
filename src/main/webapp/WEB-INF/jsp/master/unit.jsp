<% request.setAttribute("contextName", request.getContextPath()); %>
<div class="col-md-12 col-sm-12 col-xs-12">
	<div class="x_panel">
		<div class="x_title">
			<h2>
				Tabel Data Master <small>Souvenir</small>
			</h2>
			<ul class="nav navbar-right panel_toolbox">
				<li class=""><button type="button"
						class="btn btn-primary" data-toggle="modal" id="btn-add"
						data-target=".bs-example-modal-lg">Tambah File</button></li>
				<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
				</li>
			</ul>
			<div class="clearfix"></div>
		</div>
		<div class="x_content">

			<table class="table table-bordered">
				<thead>
					<tr>
						<th>No</th>
						<th>Code</th>
						<th>Name</th>
						<th>Description</th>
						<th>Master Unit Id</th>
						<th>Is Delete</th>
						<th>Created By</th>
						<th>Created Date</th>
						<th>Update By</th>
						<th>Update Date</th>
					</tr>
				</thead>
				<tbody id="list-data">

				</tbody>
			</table>

		</div>
	</div>

	<div id="modal-form" class="modal fade bs-example-modal-lg"
		tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Form Master Souvenir</h4>
				</div>
				<div class="modal-body"></div>
				<!--  <div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Save changes</button>
			</div>-->

			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	// menampilkan data pertama kali
	function loadData(){
		$.ajax({
			url:'${contextName}/master/unit/list',
			dataType:'html',
			type:'get',
			success:function(result){
				$("#list-data").html(result);
			}
		});
	}
	
	$(document).ready(function(){
		// load data first display
		loadData();
		// ketika btn add di klick
		$("#btn-add").click(function(){
			$.ajax({
				url:'${contextName}/master/unit/add',
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menambah Jurusan Baru");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		// search
		$("#btn-search").click(function(){
			var key = $("#txt-search").val();
			$.ajax({
				url:'${contextName}/master/unit/search',
				data:{'key':key},
				dataType:'html',
				type:'get',
				success:function(result){
					$("#list-data").html(result);
				}
			});
		});
		//
		$("#list-data").on('click','.btn-edit',function(){
			var id = $(this).val();
			$.ajax({
				url:'${contextName}/master/souvenir/ubah',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Merubah Data Jurusan");
					$("#modal-form").removeClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		$("#list-data").on('click','.btn-delete',function(){
			var id = $(this).val();
			$.ajax({
				url:'${contextName}/master/unit/hapus',
				data:{'id':id},
				type:'get',
				dataType:'html',
				success:function(result){
					$("#modal-form").find(".modal-body").html(result);
					$("#modal-title").html("Menghapus Data Jurusan");
					$("#modal-form").addClass("modal-danger");
					$("#modal-form").modal("show");
				}
			});
		});
		
		// simpan data dari form
		$("#modal-form").on("submit","#form-unit", function(){
			$.ajax({
				url:'${contextName}//master/unit/save.json',
				type:'post',
				//this mengacu ke form-fakultas
				data:$(this).serialize(),
				success:function(result){
					if(result.message=="success"){
						$("#modal-form").modal("hide");
						loadData();
					}
				}
			});				
			return false;
		});
	});
</script>