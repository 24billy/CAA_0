<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/caa/jsp/common/init.jsp" %>

<div style="text-align:center;font-size:30px;">單位管理</div>

<a href="javascript:void(0);" onclick="addCompany();" class="btn btn-large btn-primary">新增單位</a>
<input type="text" id="addCompanyText">
<hr>

<table id="companyView" class="table table-bordered table-hover dataTable">
</table>


<script type="text/javascript">
$(document).ready(function(){
    var aaData = ${jsonData};
    
    console.log("aaData");
    console.log(aaData);
    
    $("#companyView").dataTable({
        "aaData" : aaData ,
        "aoColumns": 
        [

         {
            "sTitle" : "公司",
            "mData" : "name"
         },
   
  		{
			"sTitle" : "刪除",
			"mRender" : function(obj) {
				var id = obj.id;

				var template = '<button type="button" value="';
				template = template.concat('"');
				template = template.concat(' class="btn btn-small btn-danger"');

				template = template.concat(' onclick="deleteCompany(\'');
				template = template.concat(id);
				template = template.concat('\')" >');
				template = template.concat("刪除");
				template = template.concat('</button>');

				return template;
			},
			"mData" : null
		}
         
        ]
    })
    
    $('[id$=_length]').find("label").hide();
//     $("#companyView_length").find("label").hide();
});

// 新增公司
function addCompany() {

	var name = $('#addCompanyText').val();
	console.log("name : " + name);
	var companyArray = [];

	if (name == "") {
		alert("請輸入公司名稱");
		
		return false
	}
	
	// 判斷公司是否重複
	$( "#companyView tr td:first-child" ).each(function( index ) {
	  console.log( index + ": " + $( this ).text() );
	  
	  companyArray.push($( this ).text());

	});
	
	console.log("companyArray");
	console.log(companyArray);
	
	if ($.inArray( name, companyArray ) !== -1) {
		alert("重複了");
		
		return false
	}
	
	var params = {};
	params.name = name;
	
	bootbox.confirm({
		message : "是否確定要新增?",
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
					url : "addCompany.do",
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

//根據id刪除company
function deleteCompany(id) {
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
					url : "deleteCompany.do",
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