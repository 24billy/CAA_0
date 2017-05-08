<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/caa/jsp/common/init.jsp" %>

<div style="text-align:center;font-size:30px;">訪員管理</div>
<a href="javascript:void(0);" onclick="openmenu('showAddExaminerView.do');" class="btn btn-large btn-primary">新增訪員</a>
<hr>

<table id="examinerView" class="table table-bordered table-hover dataTable">
</table>

<script type="text/javascript">
$(document).ready(function(){
    var aaData = ${jsonData};
    
    console.log("aaData");
    console.log(aaData);
   
    $("#examinerView").dataTable({
        "aaData" : aaData ,
        "aoColumns": 
        [
         {
             "sTitle" : "userid",
             "mData" : "userid"
         },{
             "sTitle" : "姓名",
             "mData" : "examinername"
         },{
             "sTitle" : "所屬單位",
             "mData" : "companyname"
         },{
        	 "sTitle" : "身分",
 			"mRender" : function(obj) {
				var title = obj.title;
				
				if (title == "1") {
					return "治療師";
				} else if (title == "2") {
					return "研究生";
				} else if (title == "3"){
					return "研究助理";
				} else {
					return "學生";
				}

			},
			"mData" : null
         },{
			"sTitle" : "編輯",
			"mRender" : function(obj) {
				var id = obj.id;
				var userid = obj.userid;
	
				var template = '<button type="button" value="';
				template = template.concat('"');
				template = template.concat(' class="btn btn-small btn-warning"');
	
				template = template.concat(' onclick="modifyExaminer(\'');
				template = template.concat(id);
				template = template.concat('\')" >');
				template = template.concat("編輯");
				template = template.concat('</button>');
				
				if (userid == 'admin') {
					template = '<button type="button" class="btn btn-small btn-warning" disabled>編輯</button>';
				}
	
				return template;
			},
			"mData" : null
		},{
			"sTitle" : "刪除",
			"mRender" : function(obj) {
				var id = obj.id;
				var userid = obj.userid;
	
				var template = '<button type="button" value="';
				template = template.concat('"');
				template = template.concat(' class="btn btn-small btn-danger"');
	
				template = template.concat(' onclick="deleteExaminer(\'');
				template = template.concat(id);
				template = template.concat('\')" >');
				template = template.concat("刪除");
				template = template.concat('</button>');
				
				if (userid == 'admin') {
					template = '<button type="button" class="btn btn-small btn-danger" disabled>刪除</button>';
				}
	
				return template;
			},
			"mData" : null
		}
        ],
        "aoColumnDefs":
        [

        ]
    })
    
    $('[id$=_length]').find("label").hide();
});
    
//編輯主試者
function modifyExaminer(id) {
	var params = {};
	params.id = id;

	$.ajax({
		type : "POST",
		url : "showEditExaminerView.do",
		data : params,
		dataType : 'html',
		success : function(data) {
			
			$('#reflashDiv').empty().html(data);
			
		},
		error : function(dataMp) {
		}
	});
}
   
//根據id刪除 主試者
function deleteExaminer(id) {
	var params = {};
	params.id = id;

	bootbox.confirm({
		message : "是否確定刪除?",
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
					url : "menu/deleteExaminer.do",
					data : params,
					dataType : 'html',
					success : function(data) {
						
						$('#reflashDiv').empty().html(data);
						
					},
					error : function(dataMp) {
					}
				});
			}
		}
	});

}
</script>