package com.ebook.common.constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppTLIConstantsWeb {

	// EJB Application Constants
	public static String EJBAPPAVISOLMODCAMIONES = "ejbAppAvisolModCamiones";
	public static String EJB_CONFIGURATION_FILE = "classpath:ejbConfigurationContext.xml";
	public static String EJB_MOD_SECURITY_ID = "ejbAppCromisoftModSecurityEjb";
	public static String EJB_MOD_GENERAL_ID = "ejbAppCromisoftModGeneral";
	public static String EJB_MOD_PERSONA_ID = "ejbAppCromisoftModPersona";
	public static String EJB_MOD_VINCULACION_ID = "ejbAppCromisoftModVinculacion";
	public static String EJB_MOD_GESTIONE_ID = "ejbAppCromisoftModGestionContable";
	public static String EJB_MOD_RECURSOSHUMANOS_ID = "ejbAppCromisoftModRecursosHumanos";
	public static String EJB_MOD_AADUANERA = "ejbAppTLUModAAduanera";
	public static String EJB_MOD_IMPUESTOS_ID = "ejbAppTLIModImpuesto";
	public static String EJB_MOD_TEmbalaje_ID = "ejbAppTLIModTEmbalajes";
	public static String EJB_MOD_PRIMAS_ID = "ejbAppTLIModPrimas";
	public static String EJB_MOD_COTIZACIONES_ID = "ejbAppTLIModCotizaciones";
	public static String EJB_MOD_PRELIQUIDACION_ID = "ejbAppTLIModPreliquidaciones";
	public static String EJB_MOD_TRANSPORTE_ID = "ejbAppTLIModTransporte";
	public static final String EJB_MOD_LIBERACIONES = "ejbAppTLIModLiberaciones";
	public static final String EJB_MOD_INSUMOS = "ejbAppAvisolModInsumos";
	public static final String EJB_MOD_PERSONAS = "AppAvisolModPersonas";
	public static final String EJB_MOD_PRODUCTOS = "ejbAppAvisolModProductos";
	public static final String EJB_MOD_UNIDADES = "ejbAppAvisolModuloUnidades";
	public static final String EJB_MOD_PREPARACIONES = "ejbAppAvisolModuloPreparaciones";
	// Application Constants
	public static int BYTES_FOR_ENCRIPTION = 512;
	public static String KEY_FOR_ENCRIPTION = "Cromisoft";
	public static int DECIMALS_TO_DISPLAY = 2;

	// Values for iEstado_fl Activo
	public static String STATUS_VALUE_ACTIVE = "01";
	public static String STATUS_VALUE_INACTIVE = "02";

	// Values for iEliminado_fl
	public static String DELETED_VALUE_FALSE = "01";
	public static String DELETED_VALUE_TRUE = "02";

	public static String MOVIMIENTO_TYPE_PRESTAMOS = "01";
	public static String MOVIMIENTO_TYPE_DEVOLUCIONES = "02";
	public static String VAL_SEXO_F = "02";
	public static String VAL_SEXO_M = "01";
	public static String VAL_NOMBRE_COMPLETO = "01";
	public static String VAL_NOMBRE = "02";
	public static String VAL_NOMBRE_APATERNO = "03";

	public static String VAL_DIRECCION_COD = "01";
	public static String VAL_TELEFONO_COD = "02";
	public static String VAL_TELEFONO_CELULAR_COD = "03";
	public static String VAL_TELEFONO_EMAIL_COD = "08";
	public static String VAL_TELEFONO_EMAIL_2_COD = "09";
	// Database Constants
	public static String COD_TABLE_PERSONA_VALUE = "TBLPERSONA";
	public static String COD_TABLE_UNIDAD_VALUE = "tblunidade";
	public static String COD_TABLE_PRODUCTOS_VALUE = "tblproductos";
	// Values for Persona Type
	public static final String PERSONA_TYPE_FISICA = "01";
	public static final String PERSONA_TYPE_JURIDICA = "02";
	public static final String PERSONA_BOTH = "03";

	// Values for Transporte
	public static final String CAT_ESTADO_SEGUIMIENTO_EMBARQUE = "ESTADO_EMBARQUE";

	// Values for Atributos de Personas
	public static final String TATRIBUTOS_REQUERIDO_TRUE = "01";
	public static final String VATRIBUTOS_DEFAULT_TRUE = "01";
	public static final String CAT_CONT_GESTION_CONTABLE_SEARCH_CRITERIA = "CONT_GESTION_CONTABLE_SEARCH_CRITERIA";
	public static final String CAT_CFLUJO_SEARCH_CRITERIA = "CFLUJO_SEARCH_CRITERIA";

	public static final String CAT_UNIDAD_MEDIDA_TYPE = "UNIDAD_MEDIDA_TYPE";
	public static final String CAT_AUTORIZADO_TYPE = "AUTORIZADO_TYPE";
	public static final String CAT_VENTA_TYPE_COT = "VENTA_TYPE_COT";
	public static final String CAT_COTIZACION_TYPE = "COTIZACION_TYPE";
	public static final String CAT_PERMISOS_ESPECIALES_TYPE = "PERMISOS_ESPECIALES_TYPE";
	public static final String CAT_IS_SEGURO_TYPE = "SEGURO_TYPE";
	public static final String CAT_IS_SEGURO_FLETE_TYPE = "SEGURO_FLETE_TYPE";
	public static final String CAT_CARGA_TYPE = "CARGA_TYPE";
	public static final String CAT_DESPACHO_TYPE = "DESPACHO_TYPE";
	public static final String CAT_VOLUMEN_TYPE = "VOLUMEN_TYPE";
	public static final String CAT_AUTORIZACION_TYPE = "AUTORIZADOS_TYPE";
	public static final String VAL_PENDIENTE = "01";
	public static final String VAL_CONFIRMADO = "03";
	public static final String VAL_RECHAZADO = "02";
	public static final String VAL_EMAIL = "08";
	public static final String VAL_EMAIL2 = "09";
	public static String NUMBER_OF_ZEROS_COTIZACIONES = "9";
	public static String CAT_EMBARQUE_TYPE = "EMBARQUE_TYPES";
	public static String CAT_BILLOFLADING_TYPE = "BOL_TYPE";
	public static String CAT_LUGARES_TYPE = "LUGARES_TYPE";

	public static String MOD_COTIZACIONES = "COTIZACIONES";

	public static String CSS_RECORD_IS_ACTIVE = "cssRecordIsActive";
	public static String CSS_RECORD_IS_INACTIVE = "cssRecordIsInactive";
	public static String CUENTA_CONTABLE_SEARCH_CRITERIA = "CUENTA_CONTABLE_SEARCH_CRITERIA";
	public static String VAL_CUENTA_CONTABLE_SISTEMA = "02";
	public static String CAT_CUENTA_CONTABLE_TYPE = "CUENTA_CONTABLE_CONTROL_TYPE";
	public static String CAT_PRESUPUESTOS_SEARCH_CRITERIA = "PRESUPUESTOS_SEARCH_CRITERIA";
	public static String CAT_LIBRO_COMPRAS_SEARCH_CRITERIA = "LIBRO_COMPRAS_SEARCH_CRITERIA";
	public static String CAT_LVENTAS_SEARCH_CRITERIA = "LVENTAS_SEARCH_CRITERIA";
	public static String CAT_DEVOLUCION_MOVIMIENTO = "CONT_MOVIMIENTO_TYPE";
	public static String CAT_DEVOLUCION_MOTIVO_FL = "CONT_DOSIFICACION_MOTIVO_TYPE";
	public static String CAT_IMPUESTOS_TYPE = "IMPUESTOS_TYPE";
	public static String CAT_UNIDAD_DE_NEGOCIO_TYPE = "UNIDAD_DE_NEGOCIO_TYPE";
	public static String CAT_SDOCUMENTO_FILTER_TYPE = "SDOCUMENTO_FILTER_TYPE";
	public static String CAT_SDOCUMENTO_TYPE = "SDOCUMENTO_TYPE";
	public static String CAT_CONT_DOCUMENT_TYPE = "CONT_DOCUMENT_TYPE";
	public static String CAT_LIBROS_SEARCH_CRITERIA = "LIBROS_SEARCH_CRITERIA";
	public static String CAT_ORIGEN_TRANSACCION_TYPE = "ORIGEN_TRANSACCION_TYPE";
	public static String CAT_CONT_PERIODO_SEARCH_CRITERIA = "CONT_PERIODO_SEARCH_CRITERIA";
	public static String CAT_IMPUESTOS_SEARCH_CRITERIA = "IMPUESTOS_SEARCH_CRITERIA";
	// Parameter Categories Code Values
	public static String PARAM_COD_USER_PROFILES_CONSTANTS = "USER_PROFILES_CONSTANTS";
	public static String PARAM_COD_PERSONA_FISICA_CONSTANTS = "PERSONA_FISICA_CONSTANTS";
	public static String DEFAULT_VALUE_VATRIBUTO = "DEFAULT_VALUE_VATRIBUTO";
	public static String PARAM_COD_COMMON_CONSTANTS = "COMMON_CONSTANTS";
	public static String PARAM_COD_SECURITY_CONSTANTS = "SECURITY_CONSTANTS";

	// Parameter Name Values
	public static String PARAM_PWD_MAX_LENGTH = "PWD_MAX_LENGTH";
	public static String PARAM_PWD_MIN_LENGTH = "PWD_MIN_LENGTH";
	public static String PARAM_ORIGEN_DEFAULT_VALUE = "ORIGEN_DEFAULT_VALUE";
	public static String PARAM_PWD_VALID_DAYS = "PWD_VALID_DAYS";
	public static String PARAM_LOGIN_ALLOWED_ATTEMPS = "LOGIN_ALLOWED_ATTEMPS";
	public static String PARAM_PWD_REPETITION_TIMES = "PWD_REPETITION_TIMES";
	public static String PARAM_DIGITALES_STORE_FOLDER = "DIGITALES_STORE_FOLDER";
	public static String PARAM_LOGOTIPOS_STORE_FOLDER = "LOGOTIPOS_STORE_FOLDER";
	public static String PARAM_DIGITALES_UPLOADED_COUNT = "DIGITALES_UPLOADED_COUNT";
	public static String PARAM_LOGOTIPOS_UPLOADED_COUNT = "LOGOTIPOS_UPLOADED_COUNT";
	public static String PARAM_LOCKED_USER_STATUS_VALUE = "LOCKED_USER_STATUS_VALUE";
	public static String PARAM_WAITING_TIME_NEXT_LOGIN = "WAITING_TIME_NEXT_LOGIN";
	public static String PARAM_MIN_DAYS_QTY_FOR_PASSWORD_CHANGE = "MIN_DAYS_QTY_FOR_PASSWORD_CHANGE";
	public static String PARAM_DIGITAL_TYPE_IMAGE = "01";

	// Module Code Values
	public static String MOD_SECURITY = "001";
	public static String MOD_ADMINISTRACION = "ADM";
	public static String MOD_UNIDAD = "UNIDAD";
	public static String MOD_PRODUCTOS = "PRODUCTO";
	public static String MOD_COMMON = "COMMON";
	public static String MOD_REPORTS = "REPORTS";
	public static String MOD_PERSONA = "PERSONA";
	public static String MOD_DOCUMENTOS = "PERSONA";
	public static String MOD_STATUS = "COMMON";
	public static String MOD_ADMINISTRACION_ACADEMICA = "ADMINISTRACION_ACADEMICA";
	public static String MOD_CONTABILIDAD = "CONTABILIDAD";
	public static String MOD_SECURITY2 = "SECURITY";
	public static String MOD_TRANSPORTE = "TRANSPORTE";
	// Category Code Values
	public static String CAT_SECRET_QUESTION = "SECQUES";
	public static String CAT_MONEDA_TYPE = "MONEDA_TYPE";
	public static String CAT_RUBROS_LIBRO_TYPE = "RUBROS_LIBRO_TYPE";
	public static String CAT_CLASE_LIBROS_TYPE = "CLASE_LIBROS_TYPE";

	public static String CAT_DOCUMENTOS_ESTUDIANTE = "DOC_EST";
	public static String CAT_TIPO_UNIDAD = "T_UNI";
	public static String CAT_TIPO_PRODUCTO = "T_PROD";
	public static String CAT_ESTADO_CONSUMO = "VAR_DELETE";
	public static String CAT_PERSONAS_SEARCH_CRITERIA = "PER_SEARCH_CRITERIA";
	public static String CAT_VAL_SEXO = "VAL_SEXO";
	public static String CAT_PERSONA_CONTACTO = "CONTACTO_TYPE";
	public static String CAT_PERSONAS_TRATOS_TYPE = "TRATOS_TYPE";
	public static String CAT_PERSONAS_ECIVIL_TYPE = "ECIVIL_TYPE";
	public static String CAT_PERSONAS_ORIGEN_TYPE = "ORIGEN_TYPE";
	public static String CAT_PERSONA_TYPE_FISICA = "01";
	public static String CAT_PERSONA_TYPE_JURIDICA = "02";
	public static String CAT_DOCUMENTOS_TYPE = "DOCUMENTO_TYPE";
	public static String CAT_PDOCUMENTOS_TYPE = "DOCUMENTO_PRESENTACION";
	public static String CAT_DIGITAL_TYPE = "DIGITAL_TYPE";
	public static String CAT_STATUS_VALUE = "STATUS_VALUE";
	public static String CAT_STATUS_SEARCH_CRITERIA = "STATUS_SEARCH_CRITERIA";
	public static String CAT_PERSONA_TYPE = "PERSONA_TYPE";
	public static String CAT_ORGANIZACION_TYPE = "ORGANIZACION_TYPE";
	public static String CAT_RUBRO_TYPE = "RUBRO_TYPE";
	public static String CAT_CONCEPTOS_SEARCH_CRITERIA = "CONCEPTOS_SEARCH_CRITERIA";
	public static String CAT_FLUJO_CONTABLE_TYPE = "FLUJO_CONTABLE_TYPE";
	public static String RUBROS_LIBRO_TYPE = "RUBROS_LIBRO_TYPE";

	public static String CAT_PERSONA_FILTER_TYPE = "PERSONA_FILTER_TYPE";
	public static String CAT_REPRESENTANTE_TYPE = "REPRESENTANTE_TYPE";
	public static String CAT_VINCULACIONES_TYPE = "VINCULACIONES_TYPE";
	public static String CAT_NIVEL_TYPE = "NIVEL_TYPE";
	public static String CAT_NEGOCIO_TYPE = "UNIDAD_DE_NEGOCIO_TYPE";
	public static String CAT_SALDO_TYPE = "SALDO_TYPE";
	public static String CAT_CONCEPTO_TYPE = "CONCEPTOS_TYPE";
	public static String CAT_IS_CENTRO_COSTO = "IS_CENTRO_COSTO";
	public static String CAT_TRANSACTION = "DB_TRANSACTION_TYPE";
	public static String CAT_PCC_CLASE_TYPE = "PCC_CLASE_TYPE";
	public static String CAT_PCC_CONTRACUENTA_TYPE = "PCC_CONTRACUENTA_TYPE";
	public static String CAT_PROGRAMA_STATUS_VALUE = "PROGRAMA_STATUS_VALUE";
	public static String CAT_CENCOS_CLASE_TYPE = "CENCOS_CLASE_TYPE";
	public static String CAT_MOD_CONT_TYPE = "MOD_CONT_TYPE";
	public static String CAT_FACTURACION_TYPE = "FACTURACION_TYPE";
	public static String CAT_CCOSTO_SEARCH_CRITERIA = "CCOSTO_SEARCH_CRITERIA";
	// tcdCdDesc2 Values
	public static String TCDCDDESC2_ACTIVE_DOCUMENTS = "01";
	public static String TCDCDDESC2_ACTIVE_PRODUCTO = "01";
	public static String TCDCDDESC2_ACTIVE_CONSUMO = "01";

	// For Utils
	public static String DATEFORMAT_DD_MM_YYYY = "dd/MM/yyyy";
	public static String DATEFORMAT_DD_MM_YYYY_HH_mm_ss = "dd/MM/yyyy HH:mm:ss";
	public static int CONCURRENCY_INITIAL_VALUE = 0;
	public static int NUMBER_INITIAL_VALUE = 0;
	public static String MAIN_MENU_SESSION_VARIABLE = "mainMenuMap";
	public static String TABS_MODULE_LIST_VARIABLE = "tabsModuleList";
	public static String ACTIVE_MENU_TAB_VAR = "activeMenuTab";
	public static String HEADER_EXTRA_COMPONENTS = "headerExtraComponents";
	public static String SECURITY_EXISTING_URLS_SESSION_VARIABLE = "existingUrlsIntoPrograms";
	public static String SECURITY_USER_ALLOWED_URLS_SESSION_VARIABLE = "usersAllowedUrlsPrograms";
	public static String SYSTEM_SEPARATOR = System.getProperty("file.separator");
	public static int DIGITAL_COUNTER_LENGTH = 11;
	public static String EXTENSION_SEPARATOR = ".";
	public static String REPORT_VIEWER = "reportViewer.pdf";
	public static String DATA_PAGINATION_CURRENT_VALUE_VARIABLE = "dataPaginationCurrValueVar";
	public static String DATA_PAGINATION_CURRENT_VALUE_VARIABLE2 = "dataPaginationCurrValueVarother";

	// Security Constants
	public static String FIRST_TIME_LOGIN = "01";
	public static String CHANGE_PROFILE_SETTING_LOGIN = "02";

	// User Constants
	public static String ACTION_TYPE_LOGIN_HISTORY_IN = "01";
	public static String ACTION_TYPE_LOGIN_HISTORY_OUT = "02";
	public static String ILOGGED_FL_ONLINE = "01";
	public static String ILOGGED_FL_OFFLINE = "02";

	// Programas Type Flag
	public static String PROGRAMA_TYPE_URL = "01";
	public static String PROGRAMA_TYPE_MENU = "02";
	public static String PROGRAMA_TYPE_SUB_MENU = "03";

	// fDocumentos cdc
	public static String FIRMAS_DOCUMENTOS_SEARCH_CRITERIA = "FIRMAS_DOCUMENTOS_SEARCH_CRITERIA";
	public static String FDOCUMENTOS_SEARCH_CRITERIA_BY_STATUS = "FDOCUMENTOS_SEARCH_CRITERIA_BY_STATUS";
	// fDocumentos flag
	public static String FDOCUMENTOS_ACTIVO = "01";
	public static String FDOCUMENTOS_INACTIVO = "02";
	public static String FDOCUMENTOS_ALL = "03";
	public static String FIRMAS_ASOCIADAS = "01";
	public static String FIRMAS_DESASOCIADAS = "02";
	public static String CAT_COTIZACIONES_SEARCH_CRITERIA = "COTIZACIONES_SEARCH_CRITERIA";
	// JSP
	public static String CSS_CLASS_ACTIVE = "cssRecordIsActive";
	public static String CSS_CLASS_INACTIVE = "cssRecordIsInactive";

	// Javascript
	public static String AJAX_FIELD_SEPARATOR = "&";
	public static String BACK_SESSION_NAME = "backUrl";
	public static String BACK_SESSION_URL = "backUrlName";
	public static String BACK_TYPE_DOMAIN = "backTypeDomain";

	public static List<String> PERSONA_LETTER_SEARCH_CRITERIA = new ArrayList<String>(Arrays.asList(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
			"R", "S", "T", "U", "V", "W", "X", "Y", "Z" }));

	public static String PREVIOUS_URL = "previousURL";
	public static String POSITION_IN_LIST = "posInList";
	public static String PARENT_POS_IN_LIST = "parentPosInList";

	// Common constants
	public static String JAVASCRIPT_FILES_EXTENSION = "js";
	public static String CASCADE_STYLE_SHEET_FILES_EXTENSION = "css";

	// Cuentas contables values

	public static String CCONTABLE_CONTROL_MATRIZ = "00";
	public static String CCONTABLE_CONTROL_SOLO_CONTABILIDAD = "01";
	public static String CCONTABLE_CONTROL_MODULOS_DEL_SISTEMA = "02";

	// participacions
	public static final String CAT_PARTICIPANTE_TYPE = "PARTICIPANTES_TYPE";
	public static final String CAT_PARTICIPANTE_TYPE_FISICA = "pfisica";
	public static final String CAT_PARTICIPANTE_TYPE_JURIDICA = "pjuridica";

	public static final String CAT_SEARCH_CRITERIA_PARTICIPANTE = "SEARCH_CRITERIA_PARTICIPANTE";

	public static final Integer PERSONA_PARTICIPANTE_FISICA = 1;
	public static final Integer PERSONA_PARTICIPANTE_JURIDICA = 2;
	public static String PARTICIPANTE_TODOS = "00";

	// Estado de iCotizacion_fl

	public static final String VAL_SEGURO_CLIENTE = "02";

	// Estado de iCotizacion_fl

	public static final String CAT_COTIZACION_TYPE_PENDIENTE = "01";
	public static final String CAT_COTIZACION_TYPE_RECHAZADO = "02";
	public static final String CAT_COTIZACION_TYPE_CONFIRMADO = "03";
	public static final String CAT_COTIZACION_TYPE_TODOS = "04";
	// Criterio de Busqueda de Aprobaciones
	public static final String APROBACIONES_SEARCH_CRITERIA = "APROBACIONES_SEARCH_CRITERIA";
	public static final String APROBACIONES_SEARCH_CRITERIA_DESC = "01";
	public static final String APROBACIONES_SEARCH_CRITERIA_NroCod = "02";
	public static final String APROBACIONES_SEARCH_CRITERIA_Cli = "03";

	// Navigation Menu Variables

	public static String NAV_MENU_RESET_VAR = "navMenuResetVar";
	public static String NAV_MENU_HOME_LABEL = "Home";
	public static String NAV_MENU_DEFAULT_LABEL = "Label Not Found";
	public static String URL_EXTENSION = ".html";
	public static String VAL_OPERADOR = "02";
	public static String VAL_AADUANERA = "03";
	public static String VAL_ADUANA = "04";
	public static String VAL_PROVEEDOR = "06";
	public static String VAL_SEGURO = "07";

	// Participante
	public static final String VAL_PFISICA = "01";
	public static final String VAL_PJURIDICA = "02";
	public static final String VAL_CLIENTE = "01";
	public static final String VAL_NIT = "04";
	public static final String ITIPO_FL_CHOFER = "08";

	// Preliquidaciones
	public static final String PORCENTAJE_PRELIQUIDACIONES = "PORCENTAJE_PRELIQUIDACIONES";
	public static final String PORC_INTERNACIONAL = "PORC_INTERNACIONAL";
	public static final String PORC_NACIONAL = "PORC_NACIONAL";
	public static final String PORC_TYPE_NACIONAL = "NACIONAL";
	public static final String PORC_TYPE_INTERNACIONAL = "INTERNACIONAL";
	public static final String CONTACTO_TYPE_DIRECCION = "01";
	public static final String CONTACTO_TYPE_TELF = "02";
	public static final String CONTACTO_TYPE_CEL = "03";
	public static final String CONTACTO_TYPE_FAX = "04";
	public static final String CONTACTO_TYPE_TELF_CENTRAL = "05";
	public static final String CONTACTO_TYPE_CALL_CENTER = "06";
	public static final String CONTACTO_TYPE_DIRECCION_CENTRAL = "07";
	public static final String CONTACTO_TYPE_EMAIL = "08";
	public static final String CONTACTO_TYPE_EMAIL_2 = "09";
	public static final String CONTACTO_NIT = "04";

	// CPreliquidaciones
	public static final String TRANSACTION_TYPE_CPLIQUIDACIONE = "TRANSACTION_TYPE_CPLIQUIDACIONE";
	public static final String TRANS_TYPE_INGRESO = "01";
	public static final String TRANS_TYPE_EGRESO = "02";
	public static final String VAL_TRANSPORTADORA = "11";
	public static final String VAL_AUTORIZADO_CLIENTE = "03";
	public static final String VAL_BOTH = "03";
	public static final String VAL_APROBADO = "01";
	public static String CAT_RUTAS_FL = "RUTA_TYPE";

	public static String VAL_TRANSACCION_INGRESO = "01";
	public static String VAL_TRANSACCION_EGRESO = "02";
	public static String DESC2_PERSONAL_TYPE = "personalInterno";
	public static String CAT_SEARCH_VEHICULOS = "SEARCH_VEHICULOS";
	public static String VAL_PROPIETARIO = "09";
	public static String CAT_OPERACIONES_SEARCH = "OPERACIONES_SEARCH_CRITERIA";
}
