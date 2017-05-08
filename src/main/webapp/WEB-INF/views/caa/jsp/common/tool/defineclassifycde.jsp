<%
/**
 * Copyright (c) 2014 Far Eastone Telecommunications Co., Ltd.
 * All Rights Reserved.
 *
 * This software is the confidential and proprietary information of 
 * Far Eastone Telecommunications Co., Ltd. ("Confidential Information"). 
 * 
 * You shall not disclose such Confidential Information and shall use it 
 * only in accordance with the terms of license agreement you entered
 * into with Far Eastone Telecommunications Co., Ltd.
 */
%>
<%@ page pageEncoding="UTF-8" %>

<!-- 部/區/店 下拉選單 JSP -->

<!-- 顯示操作訊息  -->
<div id="defineClassifyMessageDiv"></div>

<form id="defineClassifyForm" name="defineClassifyForm">
    <div class="control-group">
        <label class="control-label">部/區/店</label>
        
        <div class="controls">
            <select class="span2" id="sectionId" name="sectionId">
                <option value="default">請選擇</option>
            </select>
            
            <select class="span2" id="areaId" name="areaId">
                <option value="default">請選擇</option>
            </select>
            
            <select class="span2" id="storeId" name="storeId">
                <option value="default">請選擇</option>
            </select>
        </div>
        
    </div>
</form>

<script type="text/javascript">
    $(document).ready(function()
    {
        $('#defineClassifyForm #sectionId').change(function()
        {
            getAreaListBySectionId($(this).val(), 'default');
        });
        
        $('#defineClassifyForm #areaId').change(function()
        {
            getStoreListByAreaId($(this).val(), 'default');
        });

        getSectionList();
    });
    
    /**
     * 取得「部」的下拉選單
     */
    function getSectionList()
    {
        var settings =  
        {
            URL : "rest/defineclassify/getSectionList",
            showOperationMessage : false,
            success : function(data)
            {
                var $sectionIdEle = $('#defineClassifyForm #sectionId');
                var sectionId = "";

                for (var i = 0 ; i < data.aaData.length ; i++)
                {
                    var $option = $('<option>');
                    $option.attr('value', data.aaData[i].sectionId);
                    $option.text(data.aaData[i].sectionNm);

                    sectionId = $('#sectionId', '#breadCrumbParamForm').val();
                   
                    if (sectionId == data.aaData[i].sectionId)
                    {
                        $option.prop('selected', true);
                    }

                    $sectionIdEle.append($option);
                }

                // 從麵包屑中取得麵包屑中的「區」代碼為「區」下拉選單預設值
                var defaultAreaId = $('#areaId', '#breadCrumbParamForm').val();
                getAreaListBySectionId(sectionId, defaultAreaId);
            },
            fail : function() 
            {
                $('#defineClassifyMessageDiv').errorMessage('取得「部」清單失敗！', '請洽系統管理員');
            }
        };

        $.formSubmit(settings);
    }

    /**
     * 依據「部別」取得「區別」的下拉選單內容，並設定預設選項
     *
     * param sectionId: 「部別」
     * param defaultAreaId: 「區別」預設值
     */
    function getAreaListBySectionId(sectionId, defaultAreaId)
    {
        // 移除店下拉選單項目
        $('option[value!="default"]', '#defineClassifyForm #storeId').remove();
        var $areaIdEle = $('#defineClassifyForm #areaId');
        // 移除區下拉選單項目
        $('option[value!="default"]', $areaIdEle).remove();

        if('default' != sectionId) 
        {
            var settings =  
            {
                URL : "rest/defineclassify/getAreaListBySectionId",
                showOperationMessage : false,
                dataAreaId : "defineClassifyForm",
                success : function(data)
                {                    
                    for (var i = 0 ; i < data.aaData.length ; i++)
                    {
                        var $option = $('<option>');
                        $option.attr('value', data.aaData[i].areaId);
                        $option.text(data.aaData[i].areaNm);

                        if(defaultAreaId == data.aaData[i].areaId)
                        {
                            $option.prop('selected', true);
                        }

                        $areaIdEle.append($option);
                    }
  
                    // 從麵包屑中取得麵包屑中的「店」代碼為「店」下拉選單預設值
                    var defaultStoreId = $('#storeId', '#breadCrumbParamForm').val();                    
                    getStoreListByAreaId(defaultAreaId, 'default');

                    /*
                    // 先預設「區」選擇第一筆資料
                    $areaIdEle[0].selectedIndex = 1;
                    */

                    // 依據「區」的第一筆資料帶出「店」的下拉選擇
                    //getStoreListByAreaId($areaIdEle.val());
                },
                fail : function()
                {
                    $('#defineClassifyMessageDiv').errorMessage('取得「區」清單失敗！', '請洽系統管理員');
                }
            };

            $.formSubmit(settings);
        }
    }

    /**
     * 依據「區」選的條件，取得「店」的下拉選單
     */
    function getStoreListByAreaId(areaId, defaultStoreId)
    {
        // remove children exclude option value = "default"
        var $storeIdEle = $('#defineClassifyForm #storeId');
        $('option[value!="default"]', $storeIdEle).remove();

        if('default' != areaId)
        {
            var settings =  
            {
                URL : "rest/defineclassify/getStoreListByAreaId",
                showOperationMessage : false,
                dataAreaId : "defineClassifyForm",
                success : function(data)
                {
                	for (var i = 0 ; i < data.aaData.length ; i++)
                    {
                        var $option = $('<option>');
                        $option.attr('value', data.aaData[i].storeId);
                        $option.text(data.aaData[i].storeNm);
                        
                        if (defaultStoreId == data.aaData[i].sectionId)
                        {
                            $option.prop('selected', true);
                        }
                        
                        $storeIdEle.append($option);

                        // 先預設「店」選擇第一筆資料
                        //$storeIdEle[0].selectedIndex = 0;
                    }
                },
                fail : function()
                {
                    $('#defineClassifyMessageDiv').errorMessage('取得「店」清單失敗！', '請洽系統管理員');
                }
            };

            $.formSubmit(settings);
        }
    }

</script>