<%-- 頁面名稱：dialog --%>

<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/caa/jsp/common/init.jsp" %>

<!-- Page Content -->
<div class="container">

    <form class="well form-horizontal" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>編輯施測者帳號資料</legend>

            <!-- Text input-->
            <input name="id" class="hide" type="text" value="${examinerVo.id}">

            <div class="form-group">
                <label class="col-md-4 control-label">帳號</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="userid" placeholder="帳號" class="form-control" type="text" value="${examinerVo.userid}" disabled>
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label">密碼</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="password" placeholder="密碼" class="form-control" type="text" value="${examinerVo.password}">
                    </div>
                </div>
            </div>


            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">姓名</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="name" placeholder="姓名" class="form-control" type="text" value="${examinerVo.name}">
                    </div>
                </div>
            </div>

            <!-- Select Basic -->

            <div class="form-group">
                <label class="col-md-4 control-label">所屬單位</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select name="state" class="form-control selectpicker" id="company_select">
                            <option value=" ">請選擇單位</option>
                            <c:forEach var="company" items="${result}">
								
								<c:choose>
								  <c:when test="${company.id == examinerVo.companyid}">
								    <option value="${company.id}" selected>${company.name}</option>
								  </c:when>
								  <c:otherwise>
								   <option value="${company.id}" >${company.name}</option>
								  </c:otherwise>
								</c:choose>
							</c:forEach>

                        </select>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">職稱</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select name="state" class="form-control selectpicker" id="title_select">
                            <option value="">請選擇職稱</option>
                            <option value="1">治療師</option>
                            <option value="2">研究生</option>
                            <option value="3">研究助理</option>
                            <option value="4">學生</option>
                        </select>
                    </div>
                </div>
            </div>

           
            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4">
                    <button class="btn btn-warning" type="button" onclick="updateExaminer();">送出 <span class="glyphicon glyphicon-send"></span></button>
                    <button class="btn btn-default" type="button" onclick="openmenu('showExaminerManagementView.do');">取消 <span class="glyphicon glyphicon-send"></span></button>
                </div>
            </div>

        </fieldset>
    </form>
</div>

<script>
$( document ).ready(function() {
	
	$("select#title_select").val("${examinerVo.title}");
});

// 儲存訪員
function updateExaminer() {
	alert("更新訪員");
	var id = $("input[name = 'id']").val();
	var userid = $("input[name = 'userid']").val();
	var password = $("input[name = 'password']").val();
	var name = $("input[name = 'name']").val();
	
	var companyid = $("#company_select option:selected").val();
	var titleid = $("#title_select option:selected").val();
	
	console.log("companyid = " + companyid);
	console.log("titleid = " + titleid);
	
	console.log(userid);
	console.log(password);
	console.log(name);
	
	// 判斷是否空值
	if ($.trim(userid) == "" || $.trim(password) == "" || $.trim(name) == "" ) {
		alert("不得為空");
		return false
	}
	
	// TODO 判斷userid是否重複
	
	var params = {};
	params.id = id;
	params.userid = userid;
	params.password = password;
	params.name = name;
	params.companyid = companyid;
	params.titleid = titleid;
	
	bootbox.confirm({
		message : "是否確定要更新?",
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
					url : "editExaminer.do",
					data : params,
					dataType : 'html',
					success : function(data) {
						
						console.log("editExaminer : @@" + $.trim(data) + "@@");
						alert($.trim(data));
						
						if($.trim(data) !== "true") {
							alert("更新失敗!");
						}
						
						// 回訪員主頁
						openmenu('showExaminerManagementView.do');
						
					},
					error : function(dataMp) {
					}
				});
			}
		}
	});
	
}


</script>