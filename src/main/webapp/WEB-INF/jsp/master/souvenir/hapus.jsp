<p>
Anda yakin akan menghapus data ${item.name}
</p>
<form id="form-souvenir" method="POST" class="form-horizontal form-label-left">

	<!-- Validasi Form -->
	<input type="hidden" id="action" name="action" value="hapus" />
	<input type="hidden" id="id" name="id" value="${item.id}" />
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	
<div class="ln_solid"></div>
<div class="form-group">
	<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
		<button class="btn btn-primary" type="button" data-dismiss="modal">Close</button>
		<button type="submit" class="btn btn-success">Submit</button>
</form>