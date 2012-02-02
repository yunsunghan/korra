<jsp:directive.page contentType="text/html;charset=UTF-8" />
<script type="text/javascript">
	function checkForm() {
	    //checkFile();
		var f = document.getElementById("action_form");
	    f.method="POST";
	    f.submit();
	    return false;
	}
	function checkFile() {
		checkFileProcess(window.document.getElementById('_entityFiles').options);
	}	
</script>
