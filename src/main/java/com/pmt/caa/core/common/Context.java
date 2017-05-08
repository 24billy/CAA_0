package com.pmt.caa.core.common;

/**
 * 系統變數
 * 
 * @author VJChou, JinChen, RichardHuang, Billy
 */
public class Context {

    // System
    public static final String CONFIG_FILE = "caa";

    // Security
    public static final String NSP_CRET_KEY = "C2M0S14~"; // DES加密用的KEY
    public static final String URL_PARAM = "param";

    // session
    public static final String S_SESSION_KEY = "sessioninfo";
    public static final String S_BREADCRUMB_KEY = "breadcrumbinfo";

    public static final String S_SALESID_KEY = "salesId";
    public static final String S_ROLETYPE_KEY = "roleType";

    // parameter
    public static final String P_STATUS_LIST_KEY = "outboundStatusDetailList";
    public static final String P_VISITOR_DUE_DAYS_LIST_KEY = "visitorDueDaysList";
    public static final String P_ASSIGN_CONDITION_MAP = "assignConditionMap";
    public static final String P_ASSIGN_STATUS_LIST_KEY = "assignStatusList";
    public static final String P_OUTBOUND_STATUS_LIST_KEY = "outboundStatusList";
    public static final String P_MEMBER_LIST_KEY = "memberList";
    public static final String P_RANK_LIST_KEY = "rankList";
    public static final String P_OUTBOUND_INFO_LIST_KEY = "outboundInfoList";
    public static final String P_CLOSE_STATUS_KEY = "closeStatusList";
    
    // request result key
    public static final String REQ_AA_DATA_KEY      = "aaData";
    public static final String R_RESULT_TARGET = "result";
    public static final String R_RESULT_ATTR_KEY = "dataStr";
    public static final String R_RESULT_PROCESS_KEY = "process";
    public static final String R_RESULT_MESSAGE_KEY = "message";
    public static final String R_FILE_IMPORT_LIST_KEY = "fileImportList";
    public static final String R_FILE_EXPORT_LIST_KEY = "fileExportList";
    public static final String R_CONDITION_YEAR_KEY = "conditionYear";
    public static final String R_CONDITION_MONTH_KEY = "conditionMonth";
    public static final String R_CONDITION_RANK_KEY = "conditionRank";
    public static final String R_SECTION_LIST_KEY = "sectionList";
    public static final String R_AREA_LIST_KEY = "areaList";
    public static final String R_STORE_LIST_KEY = "storeList";
    public static final String R_MEMBER_LIST_KEY = "memberList";
    public static final String R_CONTRACT_INFO_LIST_KEY = "contractInfoList";
    public static final String R_OUTBOUND_NOTE_LIST_KEY = "outboundNoteList";
    public static final String R_ASSIGN_LIST_KEY = "assignList";
    public static final String R_ASSIGN_HIS_INFO_MAP_KEY = "assignHisInfoMap";

    // json template replace token
    public static final String T_S_ECHO = "@sEcho@";
    public static final String T_I_TOTAL_RECORDS = "@iTotalRecords@";
    public static final String T_AA_DATA = "@aaData@";
    public static final String T_RETURN_CODE = "@returnCode@";
    public static final String T_RETURN_MESSAGES = "@returnMessage@";

    // request json paramameter name
    public static final String REQ_PARAM_NAME = "jsonData";
    public static final String REQ_PARAM_MESSAGE = "message";

    // Date format pattern
    public static final String P_DATE_FORMAT = "yyyy/MM/dd";

}
