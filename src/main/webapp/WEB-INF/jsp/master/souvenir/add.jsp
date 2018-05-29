<form id="form-souvenir" method="POST" class="form-horizontal form-label-left">

	<!-- Validasi Form -->
	<input type="hidden" id="action" name="action" value="tambah" />
	<input type="hidden" id="id" name="id" value="0" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">Code</label>
		<div class="col-md-9 col-sm-9 col-xs-12">
			<input type="text" id="code" name="code" value="${newCode}" class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name</label>
		<div class="col-md-9 col-sm-9 col-xs-12">
			<input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">Description</label>
		<div class="col-md-9 col-sm-9 col-xs-12">
			<input type="text" id="description" name="description" class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="form-group">
       <label class="control-label col-md-3 col-sm-3 col-xs-12">Master Unit Id</label><div class="col-md-9 col-sm-9 col-xs-12">
         <select id="mUnitId" name="mUnitId" class="form-control">
           <option>= Pilih =</option>
           <option value="1">1</option>
           <option value="2">2</option>
           <option value="3">3</option>
           <option value="4">4</option>
         </select>
       </div>
     </div>
<div class="ln_solid"></div>
<div class="modal-footer">
  <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
  <button type="submit" class="btn btn-primary">Save</button>
</div>
</form>