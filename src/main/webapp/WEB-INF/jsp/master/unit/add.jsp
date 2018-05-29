<form id="form-unit" method="POST" class="form-horizontal form-label-left">

	<!-- Validasi Form -->
	<input type="hidden" id="action" name="action" value="tambah" />
	<input type="hidden" id="id" name="id" value="0" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="code">Code</label>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="text" id="code" name="code" class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	
	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name</label>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="text" id="name" name="name" class="form-control col-md-7 col-xs-12">
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3 col-sm-3 col-xs-12" for="description">Description</label>
		<div class="col-md-6 col-sm-6 col-xs-12">
			<input type="text" id="description" name="description" class="form-control col-md-7 col-xs-12">
		</div>
	</div>
<div class="ln_solid"></div>
<div class="form-group">
	<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		<button class="btn btn-primary" type="button">Cancel</button>
		<button class="btn btn-primary" type="reset">Reset</button>
		<button type="submit" class="btn btn-success">Submit</button>
</form>