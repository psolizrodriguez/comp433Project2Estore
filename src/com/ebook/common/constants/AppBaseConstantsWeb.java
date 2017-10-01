package com.ebook.common.constants;

import java.util.HashMap;
import java.util.Map;

public class AppBaseConstantsWeb {
	public static final String MAX_BAD_LOGIN_CNT = "MaxBadLoginCnt";
	public static final String PWD_HSTRY_CNT = "PwdHstryCnt";
	public static final String BLANK_STRING = "";
	public static final String PWD_EXPR_DAYS = "PwdExprDays";
	public static final String CHANGE_PWD = "changePwd";
	public static final String FGT_PWD = "forgotPwd";
	public static final String STRING_FALSE = "false";
	public static final String SELECTED_ALL = "all";
	public static String STRING_TRUE = "true";
	public static int INSERT_VALUE = 1;
	public static int UPDATE_VALUE = 2;
	public static int DELETE_VALUE = 3;
	public static int MAX_ROWS_TO_DISPLAY = 0;
	public static String REPORT_VIEWER = "reportViewer.rpt";
	public static int MAX_DIGITS_CODE_FIELD = 7;

	// Application Constants
	public static int BYTES_FOR_ENCRIPTION = 512;
	public static String KEY_FOR_ENCRIPTION = "Cromisoft";
	public static int DECIMALS_TO_DISPLAY = 3;
	public static String STATUS_VALUE_ACTIVE = "01";
	public static String STATUS_VALUE_DELETED = "02";
	public static String MOVIMIENTO_TYPE_PRESTAMOS = "01";
	public static String MOVIMIENTO_TYPE_DEVOLUCIONES = "02";
	public static String MOVIMIENTO_TYPE_PRESTAMOS_INGRESO = "03";
	public static String MOVIMIENTO_TYPE_DEVOLUCIONES_EGRESO = "04";

	// Database Constants
	public static String COD_TABLE_PERSONA_VALUE = "TBLPERSONA";
	public static String COD_TABLE_UNIDAD_VALUE = "tblunidade";
	public static String COD_TABLE_PRODUCTOS_VALUE = "tblproductos";

	// Module Code Values
	public static String MOD_SECURITY = "001";
	public static String MOD_ADMINISTRACION = "ADM";
	public static String MOD_UNIDAD = "UNIDAD";
	public static String MOD_PRODUCTOS = "PRODUCTO";
	public static String MOD_CONSUMO = "COMMON";
	public static String MOD_REPORTS = "REPORTS";

	// Category Code Values
	public static String CAT_SECRET_QUESTION = "SECQUES";
	public static String CAT_DOCUMENTOS_ESTUDIANTE = "DOC_EST";
	public static String CAT_TIPO_UNIDAD = "T_UNI";
	public static String CAT_TIPO_PRODUCTO = "T_PROD";
	public static String CAT_ESTADO_CONSUMO = "VAR_DELETE";
	public static String CAT_PERSONAS_SEARCH_CRITERIA = "PER_SEARCH_CRITERIA";
	public static String CAT_VAL_SEXO = "VAL_SEXO";
	public static String CAT_VAL_MOT_MORTANDAD_TYPE = "VAL_MOT_MORTANDAD_TYPE";

	// tcdCdDesc2 Values
	public static String TCDCDDESC2_ACTIVE_DOCUMENTS = "01";
	public static String TCDCDDESC2_ACTIVE_PRODUCTO = "01";
	public static String TCDCDDESC2_ACTIVE_CONSUMO = "01";

	// For Utils
	public static String DATEFORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	public static String DATEFORMAT_DD_MM_YYYY_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";
	public static int CONCURRENCY_INITIAL_VALUE = 0;
	public static int NUMBER_INITIAL_VALUE = 0;
	public static String SESSION_USER_VARIABLE_NAME = "User";

	// for hugo
	public static String MOD_CAMADA = "CAMADAS";

	// Aux for Now - Jona

	public static String STATUS_CAMADA = "ST";
	public static String MOD_COMMON = "COMMON";
	public static String CAT_VAL_GALPON_STATUS = "VAL_GALPON_STATUS";

	public static Map<String, String> getLangCodeOptions() {
		Map<String, String> langCodeOptions = new HashMap<String, String>();
		langCodeOptions.put("en", "en");
		langCodeOptions.put("es", "es");
		return langCodeOptions;
	}

	public static Map<String, String> getStatusOptions() {
		Map<String, String> langCodeOptions = new HashMap<String, String>();
		langCodeOptions.put("true", "Abled");
		langCodeOptions.put("false", "Disabled");
		return langCodeOptions;
	}
}
