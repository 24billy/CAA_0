<%-- 頁面名稱：dialog --%>

<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/caa/jsp/common/init.jsp" %>

<!-- Page Content -->
<div class="container">

    <form class="well form-horizontal" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>編輯受試者資料</legend>

            <div class="form-group">
                <label class="col-md-4 control-label">病歷號碼</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="medical_no" placeholder="病歷號碼" class="form-control" type="text" value="${subjectVo.medical_no}" disabled>
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label">姓名</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="name" placeholder="姓名" class="form-control" type="text" value="${subjectVo.name}">
                    </div>
                </div>
            </div>

            <!-- Select Basic -->

            <div class="form-group">
                <label class="col-md-4 control-label">性別</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select name="gender_select" class="form-control selectpicker">
<%--                             	<c:if test="${subjectVo.gender eq 'F'}"> --%>
<%-- 									<option value="${company.id}" selected>女</option> --%>
<%-- 								</c:if> --%>
                            <option value="">請選擇性別</option>
                            <option value="M">男</option>
                            <option value="F">女</option>
                        </select>
                    </div>
                </div>
            </div>
            
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button class="btn btn-warning" type="button" onclick="updateSubject();">送出 <span class="glyphicon glyphicon-send"></span></button>
                    <button class="btn btn-default" type="button" onclick="openmenu('showSubjectManagementView.do');">取消 <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </div>

        </fieldset>
    </form>
</div>

<script>
$( document ).ready(function() {

	$("select").val("${subjectVo.gender}");
	
});

// 儲存受試者
function updateSubject() {
	alert("更新 受試者");
	var medical_no = $("input[name = 'medical_no']").val();
	var name = $("input[name = 'name']").val();
	
	var gender = $("select[name = 'gender_select'] option:selected").val();
	
	
	console.log(medical_no);
	console.log(gender);
	console.log(name);
	
	// 判斷是否空值
	if ($.trim(medical_no) == "" || $.trim(name) == "" || $.trim(gender) == "") {
		alert("不得為空");
		return false
	}
	
	var params = {};
	params.medical_no = medical_no;
	params.name = name;
	params.gender = gender;
	
	bootbox.confirm({
		message : "是否確定要更新受試者?",
		backdrop: true,
		buttons : {
			confirm : {
				label : 'Yes',
				className : 'btn-success'
			},
			cancel : {
				label : 'No',
				className : 'btn-danger'
			}
		},
		callback : function(result) {
			if (result) {
				
				$.ajax({
					type : "POST",
					url : "editSubject.do",
					data : params,
					dataType : 'html',
					success : function(data) {
						
						if($.trim(data) !== "true") {
							alert("更新失敗!");
						}
						
						// 回受試者主頁
						openmenu('showSubjectManagementView.do');
						
					},
					error : function(dataMp) {
					}
				});
			}
		}
	});
	
}


</script>