/***************************************************************************
 *
 * Licensed Materials - Property of IBM
 *
 * IBM Informix Dynamic Server
 * (c) Copyright IBM Corporation 2008, 2009 All rights reserved.
 *
 *  ���⣺        snooptab.h
 *
 *  ������
 *
 *      ʹ�� LOG capture API �Ŀͻ�������
 *
 *      �˳���ʼ��һ���������ϲ���
 *	      ������ѡ��Ϊ��
 *		-D <database_name where table is resides>
 *		-T <Table name Format : "owner.tabname">
 *		-C <Column name>
 *		-t <timeout in second>
 *      -R <max records per read>
 *		-L <LSN to start >
 *		
 *	����
 *	   cdcapi -D db1 -T user1.t1 -C "a,b" -T t2 -C "a,c"
 *     
 *	     �������յ���ʱ��¼ʱ��ֹ��
 *
 *     Ҫ���룺
 *     �� Unix �ϣ�
 *		       esql -g -static -o cdcapi
 *			cdcapi.ec $INFORMIXDIR/lib/dmi/libdmi.a
 *      �� Windows �ϣ�
 *		       esql -g -static -o cdcapi.exe
 *			cdcapi.ec %INFORMIXDIR%\lib\dmi\libthdmi.lib
 *	ע�⣺���Ҫ���ⲿ������ļ����ȥ getopt��
 *
 ***************************************************************************
 */

#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <memory.h>
#include <ctype.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <stdarg.h>
#include <assert.h>

#ifdef _WIN32
#include <windows.h>
#define sleep(x) Sleep(x*1000)
#else
#include <unistd.h>
#endif

EXEC SQL include    sqlca.h ;
EXEC SQL include    sqltypes;
EXEC SQL include    sqlca;
EXEC SQL include    sqlda;
EXEC SQL include    decimal;

#ifndef TRUE
#define TRUE 1
#endif

#ifndef FALSE
#define FALSE 0
#endif

#ifndef SQLINFXBIGINT
#define SQLINFXBIGINT  SQLBIGINT
#endif

/* varchar ���Ȱ��� 1 ���ֽ��Ա�����
 * �����ݵĳ���
 */
#define VARCHAR_LEN_OFFSET      1  

/* lvarchar ���Ȱ��� 3 ���ֽ��Ա�����
 * �����ݵĳ���
 */
#define LVARCHAR_LEN_OFFSET     3

/* Int8 ���ݾ��� 2 ���ֽڵķ��š�4 ���ֽڵĽ�С�� int
 * �Լ� 4 ���ֽڵĽϴ�� int
 */
#define INT8_LO_OFFSET          2
#define INT8_HI_OFFSET          6

/* LOB ���ƫ���� */
#define LOHANDLE_OFFSET         4

/* BOOL �ؿڴ�С */
#define BOOL_COL_LEN			2



/* ��ֵ����ʾ���� */
#define DISPLAY_LEN             31



#define BYTESHIFT 8
#define BYTEMASK 0xFF

#define ld2(p) ((int4)(((p)[0]<<BYTESHIFT)+((p)[1]&BYTEMASK)))


int isLittleEndian = 0;

void checkPlatformEndianess()
{
  short  i;
  char *a=(char*)&i;

  a[0]=0; a[1]=1;

  if ( i == 1)
        isLittleEndian = 0;
  else
        isLittleEndian = 1;

}

/* ˫���Ⱥ͸������Դ�β������ʽ��ʾ��������Ҫ
 * ʹ�����̸������д˳����ƽ̨�����ǽ���
 * ��ȡ��
 */
double mylddbl(const char *p)
{
    double fval;

    if (isLittleEndian)
        {
        char *f;
        int c;
        int i = 0;
        f = (char *) &fval + sizeof(double)-1;
    c = sizeof(double);
    do
          *f-- = *p++;
    while (--c);
        }
   else
        memcpy((char*)&fval,p,sizeof(double));

    return(fval);
}

float myldfloat(const char *p)
{
    float fval;

    if (isLittleEndian)
        {
        char *f;
        int c;
        int i = 0;
        f = (char *) &fval + sizeof(float)-1;
    c = sizeof(float);
    do
          *f-- = *p++;
    while (--c);
        }
   else
        memcpy((char*)&fval,p,sizeof(float));

    return(fval);
}

/* �˳������ CDC_ ��־��¼���б� */
typedef enum {
	CDC_REC_BEGINTX=0,
	CDC_REC_COMMTX,
	CDC_REC_RBTX,
	CDC_REC_INSERT,
	CDC_REC_DELETE,
	CDC_REC_UPDBEF,
	CDC_REC_UPDAFT,
	CDC_REC_DISCARD,
	CDC_REC_TRUNCATE,
	CDC_REC_TABSCHEMA,
	CDC_REC_TIMEOUT,
	CDC_REC_ERROR,
	NUM_CDCLOGRECTYPES
} cdc_log_type_t;

struct cdc_logrec
{
	cdc_log_type_t rectype;
	char recname[17];
} ;

typedef struct cdc_logrec cdc_logrec_t;

/* �ֲ��з����� CDC_ ��־��¼����
 * ����������Ƶı�
 */
cdc_logrec_t  logrectab[NUM_CDCLOGRECTYPES] = 
{
	{CDC_REC_BEGINTX,	"CDC_REC_BEGINTX"},
	{CDC_REC_COMMTX,	"CDC_REC_COMMTX"},
	{CDC_REC_RBTX,		"CDC_REC_RBTX"},
	{CDC_REC_INSERT,	"CDC_REC_INSERT"},
	{CDC_REC_DELETE,	"CDC_REC_DELETE"},
	{CDC_REC_UPDBEF,	"CDC_REC_UPDBEF"},
	{CDC_REC_UPDAFT,	"CDC_REC_UPDAFT"},
	{CDC_REC_DISCARD,	"CDC_REC_DISCARD"},
	{CDC_REC_TRUNCATE,	"CDC_REC_TRUNCATE"},
	{CDC_REC_TABSCHEMA,	"CDC_REC_TABSCHEM"},
	{CDC_REC_TIMEOUT,	"CDC_REC_TIMEOUT"},
	{CDC_REC_ERROR,		"CDC_REC_ERROR"}
	
};

/* ���ڱ�ʾ�ʹ洢���� syscdcrectype ������ݵĽṹ */
struct _syscdcrectypes
{
	int	recnum;	
	char	recname[17];
	char	recdesc[128];
};

typedef struct _syscdcrectypes syscdcrectypes_t;
syscdcrectypes_t  *syscdcrectypes_tab;
int num_cdc_log_recs;

/* ���ڱ�ʾ�ʹ洢���� syscdcerrorcode ������ݵĽṹ */
struct _syscdcerrcode
{
	int	errcode;	
	char	errname[17];
	char	errdesc[128];
};

typedef struct _syscdcerrcode syscdcerrcode_t;
syscdcerrcode_t  *syscdcerrcode_tab;
int num_cdc_err_recs;

char    outfile[512]={0};
FILE    *outfilefp = NULL;


void 	get_cdc_rectype_name(int recnum, char* recsymb, char* recdesc);
cdc_log_type_t get_cdc_log_type(char* recsymb);
void 	get_cdc_error_info(int cdcerr, char* cdcerrsymb, char* cdcerrdesc);
void 	loadSyscdcrectypes(void);
void 	loadSyscdcerrorcodes(void);

int	num_of_var_col(int);
void 	get_col_types(int, char *);
void	get_col_values(int, char *);
void	set_num_of_var_col(int, int);
void	close_session(int);
void	dump_hex(char *, char *, int);
void	sw_CheckSQLCode(char *, char *, int);
void	sw_SQLExecImmed(char *, char *, int);
void 	get_lob_data(char* dbuf);
void 	printStdoutAndFile(char*  msg, ...);

/* CDC ��¼�Ĺ��ñ����С */
typedef struct
    {
    int4 ch_size_hdr;
    int4 ch_size_payload;
    int4 ch_payload_type;
    } common_header_t;

#define CDC_CMNHDR_SIZE	(sizeof(common_header_t))
#define CDC_LOGRECTYPE_SIZE   4


/* ���ڻ�ȡ�Ѳ�������������Ϣ�Ľṹ */
typedef struct column_obj {
	int		coltype;
	int     colxid;
	int		colsize;
	char	*colname;
} column_obj_t;

#define MAXCOL 50
typedef struct column_desc {
    int			num_of_columns;
    int			num_of_vchar;
    column_obj_t	colobj[MAXCOL];
} column_des_t;

#define		MAXTAB	5
column_des_t        g_coldesc[MAXTAB];

/*  ʹ�������� */
#define CHK_SQL_CODE(message) \
        sw_CheckSQLCode(message, __FILE__, __LINE__)

#define SQL_EXEC_I(command) \
        sw_SQLExecImmed(command, __FILE__, __LINE__)

#define CHK_CDC_RETVAL(message,cdenum) \
        sw_checkCDCRetval(message,cdenum, __FILE__, __LINE__)

#ifndef MAX
#define MAX(a,b) (((a) > (b)) ? (a) : (b))
#endif
#ifndef MIN
#define MIN(a,b) (((a) < (b)) ? (a) : (b))
#endif

/* �����ȫ�ֱ��� */
int nodebug=0;

EXEC SQL begin declare section;
EXEC SQL Define NAMELEN		100;
EXEC SQL Define MAXARGSIZE	512;
char	dbname[NAMELEN];
char	svrname[NAMELEN];
char	arg1[MAXARGSIZE];
char	arg2[MAXARGSIZE];
int	sessionid = 0;
int	timeout = 300;
int max_recs_per_read = 1;
int bytes_per_read = 64*1024;
bigint	lsn;
EXEC SQL end declare section;

int     remainderBytes = 0;

/* �������صı��� */
char    datafile[512]={0};
char    system_str[1024]={0};
char    schema_expected[2048]={0};
char    *schema_str;
int     schema_fix_bytes=0;
int     schema_no_fix_cols=0;
int     schema_no_var_cols=0;
int     caperrcode=0;
int     CmpSchema=0;


/* �� Windows �ϣ�δ��ȷ���� ldbigint���������Ǳ�ͨ���� */

#ifdef _WIN32
#define BYTESHFTx 8
#define BYTEMASKx 0xFF

void ldbigintx(bigint *bint, char *p)
{
    *bint = ((((((((((((((((bigint) p[0]
        << BYTESHFTx) + (p[1] & BYTEMASKx))
        << BYTESHFTx) + (p[2] & BYTEMASKx))
        << BYTESHFTx) + (p[3] & BYTEMASKx))
        << BYTESHFTx) + (p[4] & BYTEMASKx))
        << BYTESHFTx) + (p[5] & BYTEMASKx))
        << BYTESHFTx) + (p[6] & BYTEMASKx))
        << BYTESHFTx) + (p[7] & BYTEMASKx)));
}
#else
#define ldbigintx ldbigint
#endif

void
Usage(char *progname)
{

 fprintf(stdout,"%s -D <db> [-t <timeout>] [-R <max records per read>] [-L <start lsn>] [-f outfile] \n",
		progname);
 fprintf(stdout,"\t list of tables and col list -T <tab1> -C <col list> \n");
 fprintf(stdout,"\nCommand Line Options are :\n");
 fprintf(stdout,"\t-D <database_name where table is resides>\n");
 fprintf(stdout,"\t-t <timeout in second>\n");
 fprintf(stdout,"\t\tDefault: 300 sec\n");
 fprintf(stdout,"\t-R <max records per read>\n");
 fprintf(stdout,"\t\tDefault: 1\n");
 fprintf(stdout,"\t-L <LSN to start capture. Format \"<uniq id>:0x<pos>\">\n" );
 fprintf(stdout,"\t\tDefault: current LSN\n");
 fprintf(stdout,"\t-T <Name of the table to be captured. Format \"owner.tabname\">\n");
 fprintf(stdout,"\t-C <List of Columns to be captured in format \"c1,c2\"  >\n");
 fprintf(stdout,"\t-f <Name of the file to dump the CDC log records>\n");
 fprintf(stdout,"\nProgram Description\n");
 fprintf(stdout,"\tThis program starts capture on one or more tables.\n");
 fprintf(stdout,"\tProgram terminates when timeout record is received.\n");
 fprintf(stdout,"\n\tExample:\n");
 fprintf(stdout,"\t  %s -D db1 -T \"bill.t1\" -C \"a,b\" -T t2 -C \"a,c\"\n",progname);
exit(0);
}

int
num_of_var_column(int tabid)
{
    return g_coldesc[tabid].num_of_vchar;
}

void
set_num_of_var_col(int tabid, int no)
{
    g_coldesc[tabid].num_of_vchar = no;
}

void
sw_SQLExecImmed(command, fname, lnum)
EXEC SQL begin declare section;
char    *command;
EXEC SQL end declare section;
int     lnum;
char    *fname;
{
    if (nodebug != 1)
    	printf("%s at %s:%d\n", command, fname, lnum);
    EXEC SQL execute immediate :command;
    sw_CheckSQLCode(command, fname, lnum);
}


void
sw_CheckSQLCode(char *msgptr, char *fname, int lnum)
{
    if(SQLCODE < 0)
	{
   	printf("\nStatment %s Failed at %s:%d. SQLCODE = %d ISAM = %d",
 	  msgptr, fname, lnum, SQLCODE,(long)sqlca.sqlerrd[1]);

	close_session(0);
	}
}

void
sw_checkCDCRetval(char *msgptr,  int cdcenum,  char *fname, int lnum)
{
	char cdcerrdesc[128];
	char cdcerrcode[17];

	if (cdcenum < 0)
		{
		get_cdc_error_info(cdcenum,cdcerrcode,cdcerrdesc);
   		printf("\nCDC API '%s' Failed at %s:%d.",
										msgptr, fname, lnum);
		printf("\n\tCDCAPI_RETVAL = %d,  CDC_ERRORCODE = %s",
				 						cdcenum, cdcerrcode);
	 	printf("\nCDC Error Description is \n\t%s\n", cdcerrdesc);
		}
	sw_CheckSQLCode(msgptr,fname,lnum);
}

EXEC SQL Define SQL_STMT_LEN	8192;
EXEC SQL DEFINE IDS_MAX_LEN	1024;

void
get_col_values(int tabid, char *databuf)
{
    int 			col, len, total_len, host_len, nullflag, maxlen;
    short			c_smallint;
    int				c_integer;
    float			c_float;
    double			c_double;
    dec_t			c_decimal;
    dtime_t			c_datetime;
    char			dec_str[DISPLAY_LEN+1], data_ptr[DISPLAY_LEN+1];
    char			vlen;
    ifx_sqlvar_t 		*colp;
	char			*vcharlen_array;
	int				vcharlen=0;
    int				collen;
    column_des_t		coldesc = g_coldesc[tabid];
    bigint			c_bigint;
    ifx_int8_t		c_int8;
	$boolean		c_boolean;

    /* �����ɱ䳤���д�С�Ĳ��ֳ�ʼ���� */
    vcharlen_array = (databuf - coldesc.num_of_vchar * sizeof(int));

    for (col=0; col < coldesc.num_of_columns; col++)
	{
    int advanced_to_next_col = FALSE;

	switch (MASKNONULL (coldesc.colobj[col].coltype)) {
	    case SQLINT8 :
	    case SQLSERIAL8:
			c_int8.sign = ld2(databuf);
			c_int8.data[0] = ldlong(databuf+INT8_LO_OFFSET);
			c_int8.data[1] = ldlong(databuf+INT8_HI_OFFSET);

			if (risnull(CINT8TYPE,(char*)&c_int8))
				sprintf(data_ptr, "NULL");
			else
				{
			ifx_int8toasc(&c_int8, data_ptr, DISPLAY_LEN);
			data_ptr[DISPLAY_LEN] = '\0';
				}
		printStdoutAndFile("\tColumn Value = %s\n", data_ptr);
		break;
	    case SQLSERIAL :
	    case SQLDATE :
	    case SQLINT :
		c_integer = ldlong(databuf);
			if (risnull(CINTTYPE,(char*)&c_integer))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
		printStdoutAndFile("\tColumn Value = %d\n", c_integer);
		break;
	    case SQLBOOL :
			/* �������� 2 ���ֽڣ���һ���ֽڱ�ʾ���ֽ�
             * �ڶ����ֽڱ�ʾ 1 (ture) �� 0 (false)
			 */
			if (*databuf == 1)
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
				{
				c_boolean = *(databuf+1);
				printStdoutAndFile("\tColumn Value = %d\n", c_boolean);
				}
            advanced_to_next_col = TRUE;
            databuf += BOOL_COL_LEN;
		break;
	    case SQLCHAR :
			if (risnull(CCHARTYPE,databuf))
				sprintf(data_ptr, "NULL");
			else
				{
			maxlen = MIN(coldesc.colobj[col].colsize, DISPLAY_LEN);
	        memcpy(data_ptr, databuf, maxlen);
			data_ptr[maxlen] = '\0';
				}
		printStdoutAndFile("\tColumn Value = '%s'\n", data_ptr);
		break;
	    case SQLNVCHAR :
	    case SQLVCHAR :
            /*
             * vcharlen_array ���б�����ʽ��ֵ
             */
			memcpy((char*)&vcharlen, vcharlen_array,sizeof(int));

			collen = vcharlen - VARCHAR_LEN_OFFSET;
			maxlen = MIN(collen, DISPLAY_LEN);
			if (risnull(CVCHARTYPE, (databuf+VARCHAR_LEN_OFFSET)))
				sprintf(data_ptr, "NULL");
			else
				{
	        memcpy(data_ptr, databuf+VARCHAR_LEN_OFFSET, maxlen);
			data_ptr[maxlen] = '\0';
				}
		printStdoutAndFile("\tColumn Value = '%s'\n", data_ptr);

            advanced_to_next_col = TRUE;
            databuf += collen+VARCHAR_LEN_OFFSET;
			vcharlen_array += sizeof(int);
		break;
	    case SQLINFXBIGINT :
		ldbigint(&c_bigint, databuf);
			if (risnull(CBIGINTTYPE,(char*)&c_bigint))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
            		printStdoutAndFile("\tColumn Value = %lld\n", c_bigint);
		break;
	    case SQLFLOAT :
			c_double = mylddbl(databuf);
			if (risnull(CDOUBLETYPE,(char*)&c_double))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
		printStdoutAndFile("\tColumn Value = %lf\n", c_double);
		break;
	    case SQLSMFLOAT :
			c_float = myldfloat(databuf);
			if (risnull(CFLOATTYPE,(char*)&c_float))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
		printStdoutAndFile("\tColumn Value = %f\n", c_float);
		break;
	    case SQLSMINT :
			c_smallint = ld2(databuf);
			if (risnull(CSHORTTYPE,(char*)&c_smallint))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
		printStdoutAndFile("\tColumn Value = %hd\n", c_smallint);
		break;
	    case SQLMONEY :
	    case SQLDECIMAL :
		lddecimal(databuf, coldesc.colobj[col].colsize, &c_decimal);
			if (risnull(CDECIMALTYPE,(char*)&c_decimal))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
				{
		dectoasc(&c_decimal, data_ptr,
			31,  coldesc.colobj[col].colsize);
		printStdoutAndFile("\tColumn Value = %s\n", data_ptr);
				}
		break;
	    case SQLDTIME:
	    case SQLINTERVAL:
		lddecimal(databuf, coldesc.colobj[col].colsize,
					&(c_datetime.dt_dec));
			if (risnull(CDTIMETYPE,(char*)&(c_datetime.dt_dec)))
				printStdoutAndFile("\tColumn Value = %s\n", "NULL");
			else
				{
		    memset (dec_str, 0, DISPLAY_LEN+1);
           	dectoasc (&c_datetime.dt_dec, data_ptr, DISPLAY_LEN, 
					coldesc.colobj[col].colsize);
		printStdoutAndFile("\tColumn Value = %s\n", data_ptr);
				}
		break;
	    case SQLLVARCHAR :
            /* 
             * vcharlen_array ���б�����ʽ��ֵ
			 */
			memcpy((char*)&vcharlen, vcharlen_array,sizeof(int));

			collen = vcharlen - LVARCHAR_LEN_OFFSET;
			maxlen = MIN(collen, DISPLAY_LEN);
			if (risnull(CLVCHARTYPE,databuf+LVARCHAR_LEN_OFFSET))
				sprintf(data_ptr, "NULL");
			else
				{
	        memcpy(data_ptr, databuf+LVARCHAR_LEN_OFFSET, maxlen);
			data_ptr[maxlen] = '\0';
				}
		printStdoutAndFile("\tColumn Value = '%s'\n", data_ptr);

            advanced_to_next_col = TRUE;

			databuf += collen + LVARCHAR_LEN_OFFSET; 

			vcharlen_array += sizeof(int);
		break;
case SQLUDTFIXED :
            if ((coldesc.colobj[col].colxid == XID_BLOB) ||
                (coldesc.colobj[col].colxid == XID_CLOB))
            {
            		get_lob_data(databuf);
            databuf += LOHANDLE_OFFSET; 
            }
        else
            		printf("Could not find data type %d xid %d\n",
                coldesc.colobj[col].coltype,
                			coldesc.colobj[col].colxid);
        break;

	    default:
		printf("Could not find data type %d\n",
							coldesc.colobj[col].coltype);
		break;
	    }

    /*
     * �ƽ�����һ�С�ĳЩ����Ѿ���ʽ��ִ�д˲�����
     */
    if (! advanced_to_next_col)
        {
        	databuf += coldesc.colobj[col].colsize;
        }
	}

}

void
get_col_types(int tabid, char *colstring)
{
    $char 			sql_stm[SQL_STMT_LEN];
    char 			tabname[IDS_MAX_LEN];
ifx_sqlda_t			*sqlda;
    int				col, colsize;
    column_des_t 		coldesc;

    sprintf(tabname, "apitest%d%d", tabid, getpid());
    sprintf(sql_stm, "create temp table %s( %s )",
				tabname, colstring);
    SQL_EXEC_I(sql_stm);

    sprintf(sql_stm, "select * from %s", tabname);
    $prepare select_id from $sql_stm;
    CHK_SQL_CODE(sql_stm);

    $describe select_id into sqlda;
    CHK_SQL_CODE("Describe");

    for (col = 0; col < sqlda->sqld; col++)
		{
	colsize = rtypsize(sqlda->sqlvar[col].sqltype,
					sqlda->sqlvar[col].sqllen);
	printStdoutAndFile("\tColumn %d is %s, type = %d, size = %d\n", col,
	sqlda->sqlvar[col].sqlname, sqlda->sqlvar[col].sqltype, colsize);

    	coldesc.colobj[col].coltype = sqlda->sqlvar[col].sqltype;
	coldesc.colobj[col].colsize = colsize;
	coldesc.colobj[col].colxid = sqlda->sqlvar[col].sqlxid;
		coldesc.colobj[col].colname = 
	malloc(strlen(sqlda->sqlvar[col].sqlname)+1);
	strcpy(coldesc.colobj[col].colname, sqlda->sqlvar[col].sqlname);
		}
coldesc.num_of_columns = col;

    g_coldesc[tabid] = coldesc;

    sprintf(sql_stm, "drop table %s", tabname);
    SQL_EXEC_I(sql_stm);
}


void
close_session(int return_from_fun)
{
    $integer retval;

    if (sessionid > 0)
        {
        fprintf(stdout, "\nCDC_CLOSESESS on session %d\n", sessionid);
        $execute function informix.cdc_closesess(:sessionid)
                    into :retval;
    	CHK_CDC_RETVAL("cdc_closesess",retval);
        }

    if(return_from_fun)
		return;
    else
		{
	if (outfilefp)
           fclose(outfilefp);
     	exit(caperrcode);
		}
}

/* CDC_REC_TRUNCATE ��־��¼�ĸ����ֶ�λ�� */
#define TRUNCATE_LSN_HI_OFFSET           0
#define TRUNCATE_LSN_LO_OFFSET           (TRUNCATE_LSN_HI_OFFSET + 4) 
#define TRUNCATE_TXNID_OFFSET            (TRUNCATE_LSN_LO_OFFSET + 4)
#define TRUNCATE_USERDATA_OFFSET         (TRUNCATE_TXNID_OFFSET + 4)


void
process_truncate(char *databuf, int size)
{
    int     lsn_lo;
    int     lsn_hi;
    int     txid;
    char    *insertdata;
    int     tabid = 0;
    
    lsn_hi = ldlong(databuf + TRUNCATE_LSN_HI_OFFSET);
    lsn_lo = ldlong(databuf + TRUNCATE_LSN_LO_OFFSET); 
    printf("LSN = %d:0x%x. ", lsn_hi, lsn_lo);

    txid = ldlong(databuf + TRUNCATE_TXNID_OFFSET);
    printf("TXID = %d", txid);
    printStdoutAndFile("\n");

    tabid = ldlong(databuf + TRUNCATE_USERDATA_OFFSET);
    printf("tabid = %d\n", tabid);
}


/* CDC_REC_TABSCHEMA ��¼�ĸ����ֶ�ƫ���� */
#define TABSCHEMA_USERDATA_OFFSET           0
#define TABSCHEMA_RESERVED_OFFSET           (TABSCHEMA_USERDATA_OFFSET + 4)
#define TABSCHEMA_FIXEDCOLWIDTH_OFFSET      (TABSCHEMA_RESERVED_OFFSET + 4)
#define TABSCHEMA_NUMFIXEDCOL_OFFSET        (TABSCHEMA_FIXEDCOLWIDTH_OFFSET + 4)
#define TABSCHEMA_NUMVARCOL_OFFSET          (TABSCHEMA_NUMFIXEDCOL_OFFSET + 4)
#define TABSCHEMA_COLDESC_OFFSET            (TABSCHEMA_NUMVARCOL_OFFSET + 4)

void
process_tabschema(char *databuf)
{
	char	*coldesc_data;
	int	fixed_col_width;
	int	no_of_fixed_col;
	int	no_of_var_col;
   	int	tabid = 0;

    /* ǰ 4 ���ֽ����û����� */
    tabid = ldlong(databuf+TABSCHEMA_USERDATA_OFFSET);
    printf("\tTabID : %d", tabid);
    printStdoutAndFile("\n");

    /* ǰ 8 ���ֽ�֮��� 4 ���ֽ��ǹ̶��е��ܴ�С */
    fixed_col_width = ldlong(databuf+TABSCHEMA_FIXEDCOLWIDTH_OFFSET);
    printf("\tFixed length column size (total) : %d\n", fixed_col_width);

/* �������صĸ��� */
	if ((CmpSchema) && fixed_col_width != schema_fix_bytes)
       {
       printf("\tFAILED, Expected fixed col bytes is %d\n", schema_fix_bytes);
       caperrcode++;
       }


    /* �������� 4 ���ֽ��ǹ̶������еı�� */
    no_of_fixed_col = ldlong(databuf + TABSCHEMA_NUMFIXEDCOL_OFFSET);
    printf("\tNumber of fixed lenth column is %d\n", no_of_fixed_col);

/* �������صĸ��� */
	if ((CmpSchema) && no_of_fixed_col != schema_no_fix_cols)
       {
       printf("\tFAILED, Expected fixed col numbers is %d\n", 
						schema_no_fix_cols);
       caperrcode++;
       }



    /* �������� 4 ���ֽ��ǿɱ䳤���еı�� */
    no_of_var_col = ldlong(databuf + TABSCHEMA_NUMVARCOL_OFFSET);
    printf("\tNumber of variable lenth column is %d\n", no_of_var_col);

/* �������صĸ��� */
	if ((CmpSchema) && no_of_var_col != schema_no_var_cols)
       {
       printf("\tFAILED, Expected variable col numbers is %d\n", 
						schema_no_var_cols);
       caperrcode++;
       }


    /* �������������ַ��� */
    coldesc_data = databuf + TABSCHEMA_COLDESC_OFFSET;
    printStdoutAndFile("\tSchema for Table is: '%s'\n", coldesc_data);

/* �������صĸ��� */
	if ((CmpSchema) && strcmp(coldesc_data, schema_str))
        {
        printf("\tExpected Schema for Table is: '%s'\n", schema_str);
        printf("\tSchema doesn't match: FAILED\n");
        caperrcode++;
        }
    else
        printf("\tSchema matchs: PASSED\n");



    get_col_types(tabid, coldesc_data);
    set_num_of_var_col(tabid, no_of_var_col);
}

char *
FmtUTCTime(char *buf, time_t t)
{
    struct tm   *ltime = localtime(&t);

    sprintf(buf, "%04u-%02u-%02u %02u:%02u:%02u",
            (1900 + ltime->tm_year)%10000, ltime->tm_mon + 1, ltime->tm_mday,
            ltime->tm_hour, ltime->tm_min, ltime->tm_sec);
    return buf;
}

/*  �����¼�ĸ����ֶ�ƫ����
 *  CDC_REC_BEGINTX
 *  CDC_REC_COMMTX
 *  CDC_REC_RBTX
 */
#define TXN_LSN_HI_OFFSET           0
#define TXN_LSN_LO_OFFSET           (TXN_LSN_HI_OFFSET + 4)
#define TXN_TXNID_OFFSET            (TXN_LSN_LO_OFFSET + 4)
#define TXN_USERDATA_OFFSET         (TXN_TXNID_OFFSET + 4)
#define TXN_TIME_OFFSET             (TXN_USERDATA_OFFSET + 4)

void
process_TXN_Records(char *databuf, int size)
{
    int		lsn_lo;
    int		lsn_hi;
    int		txid;
	int		longtime;
    int		tabid = 0;
    char	timebuf[512];

    lsn_hi = ldlong(databuf + TXN_LSN_HI_OFFSET);
    lsn_lo = ldlong(databuf + TXN_LSN_LO_OFFSET);
    printf("LSN = %d:0x%x. ", lsn_hi, lsn_lo);

    txid = ldlong(databuf + TXN_TXNID_OFFSET);
    printf("TXID = %d", txid);
    printStdoutAndFile("\n");

    tabid = ldlong(databuf + TXN_USERDATA_OFFSET);

    longtime = ldlong(databuf + TXN_TIME_OFFSET);
    FmtUTCTime(timebuf,(time_t)longtime);	
    printf("\tTime = %s\n", timebuf);

    dump_hex("Raw Data: ", databuf, size);
}

/* CDC_REC_DISCARD ��־��¼�ĸ����ֶ�ƫ���� */
#define DISCARD_LSN_HI_OFFSET           0
#define DISCARD_LSN_LO_OFFSET           (DISCARD_LSN_HI_OFFSET + 4)
#define DISCARD_TXNID_OFFSET            (DISCARD_LSN_LO_OFFSET + 4)
#define DISCARD_USERDATA_OFFSET         (DISCARD_TXNID_OFFSET + 4)


void
process_discard(char *databuf, int size)
{
    int		lsn_lo;
    int		lsn_hi;
    int		txid;
    int		tabid = 0;

    dump_hex("Raw Data: ", databuf, 3);
    printf("\tTotal record size = %d\n", size);

    lsn_hi = ldlong(databuf + DISCARD_LSN_HI_OFFSET);
    lsn_lo = ldlong(databuf + DISCARD_LSN_LO_OFFSET);
    printf("\tLSN = %d:0x%x\n", lsn_hi, lsn_lo);

    txid = ldlong(databuf + DISCARD_TXNID_OFFSET);
    printf("\tTXID = %d", txid);
    printStdoutAndFile("\n");

    tabid = ldlong(databuf + DISCARD_USERDATA_OFFSET);
    dump_hex("Raw Data: ", databuf, size);
}


/* IUD (INSERT/UPDATE/DELETE) ��¼�ĸ����ֶ�ƫ����
 *  CDC_REC_INSERT,
 *  CDC_REC_DELETE,
 *  CDC_REC_UPDBEF,
 *  CDC_REC_UPDAFT,
 */
#define IUD_LSN_HI_OFFSET           0
#define IUD_LSN_LO_OFFSET           (IUD_LSN_HI_OFFSET + 4)
#define IUD_TXNID_OFFSET            (IUD_LSN_LO_OFFSET + 4)
#define IUD_USERDATA_OFFSET         (IUD_TXNID_OFFSET + 4)
#define IUD_FLAG_OFFSET             (IUD_USERDATA_OFFSET + 4)
/* ����ÿ���ɱ䳤���У��� 4 ���ֽڱ�ʾ���� */
#define IUD_ROWDATA_OFFSET(nvarchars)       (IUD_FLAG_OFFSET + 4 + \
                                                 (nvarchars * sizeof(int)))


void
process_IUD_Records(char *databuf, int size)
{
    int		lsn_lo;
    int		lsn_hi;
    int		txid;
    char	*insertdata;
    int		tabid = 0;
	int		numvarchars=0;

    lsn_hi = ldlong(databuf + IUD_LSN_HI_OFFSET);
    lsn_lo = ldlong(databuf + IUD_LSN_LO_OFFSET);
    printf("LSN = %d:0x%x. ", lsn_hi, lsn_lo);

    txid = ldlong(databuf + IUD_TXNID_OFFSET);
    printf("TXID = %d", txid);
    printStdoutAndFile("\n");

    tabid = ldlong(databuf + IUD_USERDATA_OFFSET);
    printf("\tTabID = %d\n", tabid);

	numvarchars = num_of_var_column(tabid);
    insertdata = databuf+IUD_ROWDATA_OFFSET(numvarchars);
    dump_hex("Raw IUD Data: ", insertdata, size);

	/* ��������ָ����ֵ�Ŀ�ͷ
     * ��ȡÿ�е�ֵ���ڽ����ʽ��Ϊ
     * ��ȷ���ͺ���д�ӡ
*/
    get_col_values(tabid, insertdata);
}

int
isIUDRecord(cdc_log_type_t logrec)
{
	switch(logrec)
	{
	case CDC_REC_INSERT:
        case CDC_REC_DELETE:
        case CDC_REC_UPDBEF:
        case CDC_REC_UPDAFT:
		return 1;
        break;
		default:
	return 0;
	}
}

cdc_log_type_t  	cur_logrec_type;
char				*cur_record_ptr;
common_header_t		cur_log_header;


/*
 ****************************************************************************
 * process_record()
 *
 *  ������
 *       ����һ��¼��
 *
 * ���룺
 *     databuf      ָ���¼��ͷ��������¼����λ��
 *                  databuf �С�
 * �����
 *      o_bytes_processed   ������ֽ�����
 *
 * ���أ�
 *      0 һ���������Ѵ���ȫ����¼
 *      2 ������ʱ
 *      < 0 ����
 ****************************************************************************
 */
mint
process_record(char* a_recordbuf, int a_bytes_in_buf, int *o_bytes_processed)
{
    int		logrectype;
    char	recsymb[17], recdesc[128];
    int bytes_in_this_rec = 0;

    *o_bytes_processed = 0;

    	/* �� CDC ����ȡ���ñ�����Ϣ */
    cur_log_header.ch_size_hdr 	= ldlong(a_recordbuf); 
    cur_log_header.ch_size_payload 	= ldlong(a_recordbuf+4);
    cur_log_header.ch_payload_type 	= ldlong(a_recordbuf+8);

    bytes_in_this_rec = cur_log_header.ch_size_hdr + 
                                    cur_log_header.ch_size_payload;

    if (a_bytes_in_buf < bytes_in_this_rec)
        {
        fprintf(stderr,
                "process_record: Too few bytes in recordbuf: %d need %d\n", 
                 a_bytes_in_buf, bytes_in_this_rec);

        		return -1;
        }

    /* ������ǻ�õ� CDC ���Ƿ���ȷ��
     * 66 �� syscdcpacketschemes ���е�
     * CDC_PKTSCHEME_LRECBINARY ��ֵ��
     */
    if (cur_log_header.ch_payload_type != 66)
        {
        fprintf(stderr, "Unknown packet type: 0x%x\n",
                            cur_log_header.ch_payload_type);
        		return -1;
        }

    /*
     	 * ���ñ���֮��� 4 ���ֽ�Ϊ��־��¼���͡�
     */
    logrectype = ldlong(a_recordbuf + CDC_CMNHDR_SIZE);

    /*
     	 * ���� cur_record_ptr ��ָ������ڰ�����֮���λ��
     */
    cur_record_ptr = a_recordbuf + (CDC_CMNHDR_SIZE + CDC_LOGRECTYPE_SIZE);


    	/* ��ȡ����־��¼���͵ķ������ƺ����� */
    	get_cdc_rectype_name(logrectype, recsymb,recdesc);
    printStdoutAndFile("Got Record type %17s. Size = %4d ",
                    			recsymb,cur_log_header.ch_size_payload);

    	/* �� logrectype ӳ�䵽�˳����ע������ */
    	cur_logrec_type = get_cdc_log_type(recsymb);

   	/*
   	 * �����л���־��¼���ͣ�Ȼ������ȡ���ݡ�
 	 */
    	switch (cur_logrec_type)
        {
    	case CDC_REC_BEGINTX:
	    	process_TXN_Records(cur_record_ptr, cur_log_header.ch_size_payload);
        break;
	case CDC_REC_COMMTX:
	    	process_TXN_Records(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
	case CDC_REC_RBTX:
	    	process_TXN_Records(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
	case CDC_REC_INSERT:
	    	process_IUD_Records(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
case CDC_REC_DELETE:
	    	process_IUD_Records(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
case CDC_REC_UPDBEF:
	    	process_IUD_Records(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
case CDC_REC_UPDAFT:
	    	process_IUD_Records(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
	case CDC_REC_DISCARD:
	    	process_discard(cur_record_ptr, cur_log_header.ch_size_payload);
	   	break;
	case CDC_REC_TRUNCATE:
			process_truncate(cur_record_ptr, cur_log_header.ch_size_payload);
	    	break;
	case CDC_REC_TABSCHEMA:
	    	process_tabschema(cur_record_ptr);
	   	break;
	case CDC_REC_TIMEOUT:
                *o_bytes_processed = bytes_in_this_rec;
		return 2;
	   	break;

	case CDC_REC_ERROR:
			/* δ�ڴ˳����д���˼�¼ */
	   	break;

		case NUM_CDCLOGRECTYPES:
    	default:
		break;
        }
    *o_bytes_processed = bytes_in_this_rec;

	return 0;
}




#define MAXTAB	5

int	no_of_tab = -1;
char	dbname[NAMELEN];
char	tabname[MAXTAB][NAMELEN];
char	columns[MAXTAB][10*NAMELEN];
char	tab_schema[MAXTAB][NAMELEN];

void
init_default(char *progname)
{
    strcpy(dbname, "foo");
    strcpy(tabname[0], "informix.t1");
    strcpy(columns[0], "aa,bb");
    lsn = 0LL;
}

#define QUESTION_MARK   '?'
int optind = 1;
int opterr = 1;
int optopt;
char *optarg;

int
getsubopt(char **optionsp, char * const *tokens, char ** valuep)
{
    char *op, *vp = *valuep;
    char *tp;
    char *p;
    	int i;

    while(**optionsp)
    {
    op = *optionsp;
        if  (p = strchr(op, ','))
    {
        *p = 0;
        *optionsp = p+1;
    }
    else
        *optionsp += strlen(op);

    for(i = 0, tp = *tokens; tp; i++, tp = *(tokens+i))
    {
        if(!strcmp(tp, op))
        break;
    }

    if(!tp)
    {
        *valuep = op;
        		return -1;
    }

    *valuep = NULL;
    if(p = strchr(op, '='))
        *valuep = ++p;
    return i;
    }

    		return -1;
}


int
getopt(int argc, char * const *argv, const char *optstr)
{
    int i, k, ret_opt;
    char *p;

    for(i = optind; i < argc; i++, optind++)
    {
    if(argv[i][0] == '-' && argv[i][1] == '-')
        return EOF;

    if(argv[i][0] == '-')
    {
        ret_opt = argv[i][1];
        p = strchr(optstr, ret_opt);
        if(!p)
        {
        optopt = ret_opt;
        if(opterr)
                    fprintf(stderr, "%s: illegal option -- %c\n",
                            argv[0], ret_opt);

        ret_opt = QUESTION_MARK;
        optind++;
        return ret_opt;
        }

        if(*(p+1) == ':')
        {
        k = 0;
        if(!argv[optind][2])
        {
                optind++;
                    if  (optind >= argc || argv[optind][1] == '-')
            {
                optopt = ret_opt;
                        if  (opterr)
                            fprintf(stderr,
                                "%s: option requires an argument -- %c\n",
                    argv[0], ret_opt);
                ret_opt = QUESTION_MARK;
                optind++;
                return ret_opt;
            }
        }
        else
        {
            optarg = &argv[optind][2];
            optind++;
            return ret_opt;
        }

            optarg = argv[optind];
        }
        else
        optarg = NULL;

        optind++;
        return ret_opt;
    }
    else
        return EOF;
    }
    return EOF;
}

void
ProcessOption(int ac, char *av[])
{
    int         opt, lsn1, lsn2;
    int         ignore_err;
    char	lsn_string[1024];
char*       token;

    if (ac <= 1)
	Usage(av[0]);

    init_default(av[0]);

    while ((opt = getopt(ac, av, "C:D:L:R:t:T:h:n:f:S:d:")) != EOF)
        switch(opt) {
        case 'C' :
           	strncpy(columns[no_of_tab], optarg, 10*NAMELEN);
           break;
        case 'D' :
           	strncpy(dbname, optarg, NAMELEN);
           break;
	    case 'L' :
		strncpy(lsn_string, optarg, 1024);
		sscanf(lsn_string, "%d:%x", &lsn1, &lsn2);
    		lsn = ((((bigint)lsn1 << 32)) | (bigint)lsn2);
		printf("LSN to start snoop(%d:0x%x = %lld\n",
					lsn1, lsn2, lsn);
			break;
        case 'R':
		timeout = atoi(optarg);
            break;
	    case 't':
		timeout = atoi(optarg);
			break;
        case 'T' :
			no_of_tab++;
            	strncpy(tabname[no_of_tab], optarg, NAMELEN);
            break;
	    case 'n' :
            nodebug = 1; 
			break;
	case 'f' :
          	strncpy(outfile, optarg, NAMELEN);
          	outfilefp = fopen(outfile, "w");
          	if (!outfilefp)
             	{
             	printf("file %s open failed\n", outfile);
             	exit(-1);
             	}
       		break;
		case 'S':
	endofread = 1;
			strncpy(schema_expected, optarg, 2000);
			token = strtok(schema_expected, ":");
			schema_fix_bytes = atoi(token);
			token = strtok(NULL, ":");
			schema_no_fix_cols = atoi(token);
			token = strtok(NULL, ":");
			schema_no_var_cols = atoi(token);
			schema_str = strtok(NULL, ":");
			break;
		case 'd':	
			strncpy(datafile, optarg, NAMELEN);
			break;

	case '?' :
	    case 'h' :
                Usage(av[0]);
			break;
	}
}


int
main(int argc, char **argv)
{
    char		*progname;
    char*		databuf = NULL;
    int			capture_started = 0;
    int			i, endofread=0;
    char		*servername;
	int			status;
    int         stat_bufs_read = 0;         /* statistics - how many buffers */
    int         stat_recs_extracted = 0;    /* statistics - how many records */
    int         bytes_left_over_in_previous_buf = 0;
    $integer	retval, tabid;

    progname = argv[0];

    checkPlatformEndianess();
    
/* �����ݵ��˳���Ĳ��� */
    ProcessOption(argc, argv);
    if(no_of_tab < 0)
		no_of_tab = 0;

    databuf = malloc(128*1024);
    if (! databuf)
        {
		fprintf(stderr, "%s: Malloc failed\n", progname);
        exit (-3);
        }

/* ��Ե�ǰ�� IDS ʵ������
     * �� syscdcv1 ���ݿ������
	 */
    servername = getenv("INFORMIXSERVER");
    if(servername != NULL)
    	sprintf(arg1, servername);
    else
		{
	fprintf(stderr, "INFORMIXSERVER env variable not set.\n");
	exit (-1);
		}

    $connect to "syscdcv1";
    CHK_SQL_CODE("connect to syscdcv1");
    fprintf(stdout, "Connected to syscdcv1@%s\n", servername);

    retval = 0;

/* װ�� syscdcrectypes �� syscdcerrcodes ���� */
	loadSyscdcrectypes();
	loadSyscdcerrorcodes();

/* ���� CDC �Ự */
    	fprintf(stdout,
        "CDC_OPENSESS for server %s with  Timeout %d Max recs per read %d\n", 
				arg1,timeout, max_recs_per_read);
    $execute function informix.cdc_opensess(:arg1, 0,
		:timeout, :max_recs_per_read, 1, 0) into :retval;
    CHK_CDC_RETVAL("cdc_opensess",retval);

/* ���� CDC �Ự��ʶ */
    sessionid = retval;

    if (retval < 0)
        goto done;

    for(i=0; i <= no_of_tab; i++)
    {
    sprintf(arg1, "%s:%s", dbname, tabname[i]);

	/* Ϊ������������־��¼ */
    fprintf(stdout, "Enable for full row logging on Table '%s'\n", arg1);
    $execute function informix.cdc_set_fullrowlogging(:arg1, 1) into :retval;
    CHK_CDC_RETVAL("cdc_set_fullrowlogging",retval);
    if (retval < 0)
        goto done;

	/* ��ʼ����� */
    fprintf(stdout, "CDC_STARTCAPTURE of %s on session %d\n", arg1,sessionid);
    sprintf(arg2, "%s", columns[i]);
    tabid = i;
    $execute function informix.cdc_startcapture(:sessionid, 0,
                :arg1, :arg2, :tabid)
                into :retval;
    CHK_CDC_RETVAL("cdc_startcapture",retval);
    if (retval < 0)
        goto done;
    capture_started = 1;
    }

	/* ���� CDC �Ự */
    fprintf(stdout, "CDC_ACTIVATESESS on  %d \n", sessionid);
    $execute function informix.cdc_activatesess(:sessionid, :lsn)
                into :retval;
    CHK_CDC_RETVAL("cdc_activatesess",retval);
    if (retval < 0)
        goto done;

/* �������صĸ��� */
	if (datafile[0] != '\0')
		{
		sleep(5);
		fprintf(stdout, "invoking dbaccess to run %s\n", datafile);
		sprintf(system_str, "dbaccess - %s > %s.out  2>&1", datafile,datafile);
		system(system_str);
		system("onmode -c");
		}


    fprintf(stdout, "Start Reading the log records...\n");
    bytes_left_over_in_previous_buf = 0;

    while (!endofread )
        {
        int bytesread;
        int loreaderr = 0;
        char* recptr;           /* ��¼��ͷ */

        /*
         * �����ǰ�����ָ�ĳ����¼����ô������ӵ�е�
         * ���Ƶ��������Ŀ�ͷ�Ա㽫����ɡ�
         */
        if (bytes_left_over_in_previous_buf > 0)
            {
            memcpy(databuf, recptr, bytes_left_over_in_previous_buf);
            }

        recptr = databuf;

        /*
         * ���������ݶ�ȡ��������
         */
        bytesread = ifx_lo_read(sessionid, 
                                &databuf[bytes_left_over_in_previous_buf],
                                        bytes_per_read, &loreaderr);
		if (nodebug != 1)
        	fprintf(stdout, "bytesread is %d loreaderr is %d SQLCODE %d\n",
                        bytesread, loreaderr, SQLCODE);

     	if(loreaderr < 0)
            {
            fprintf(stderr, "%s: loreaderr %d SQLCODE %d\n",
                                progname, loreaderr, SQLCODE);
            printStdoutAndFile("%s: ifx_lo_read loreaderr %d SQLCODE %d\n",
                                progname, loreaderr, SQLCODE);
	    	goto done;
            }

        stat_bufs_read ++;

        /*
         * �ڻ���������ÿ����¼��
         */
 	if (bytesread > 0)
			{
            int bytes_in_buf;

            bytes_in_buf = bytesread + bytes_left_over_in_previous_buf;
            bytes_left_over_in_previous_buf = 0;

            /*
             * �����ݻ������д���ÿ�������ļ�¼��recptr ����
             * ָ���¼�Ŀ�ͷ��
             */

            while (bytes_in_buf > 0)
                {
                int4 hdrsize, payloadsize;

                hdrsize = ldlong(recptr); 
                payloadsize = ldlong(recptr+4);

                if (bytes_in_buf >= hdrsize + payloadsize)
                    {
                    int recstatus;
                    int bytes_processed;

                    recstatus = process_record(recptr, bytes_in_buf, 
                                                    &bytes_processed);
                    if (recstatus < 0)
                        {
                        goto extraction_error;
                        }

                    assert(bytes_processed > 0);
                    stat_recs_extracted++;

                    recptr += bytes_processed;
                    bytes_in_buf -= bytes_processed;

                    if (recstatus == 2)
                        {
                        goto timeout_occurred;
                        }

                    }
                else
                    {
                    bytes_left_over_in_previous_buf = bytes_in_buf;
                    bytes_in_buf = 0;
                    }
                }
        	}
        else
            {
            fprintf(stderr, "%s: ifx_lo_read returned 0 bytes read. Exiting\n",
                    		progname);
            goto done;
            }
        }

timeout_occurred:

    fprintf(stdout, "\nGoing to End the CDC session....\n");

done:
     if (retval < 0)
       caperrcode ++;

    if (capture_started)
    	{
    	for(i=0; i <= no_of_tab; i++)
    		{
    	sprintf(arg1, "%s:%s", dbname, tabname[i]);
        fprintf(stdout, "CDC_ENDCAPTURE of '%s' on session %d\n",
							arg1,sessionid);
$execute function informix.cdc_endcapture(:sessionid, 0,
                    				:arg1)
                    into :retval;
    	CHK_CDC_RETVAL("cdc_endcapture",retval);
	$execute function informix.cdc_set_fullrowlogging(:arg1, 0)
into :retval;

    	CHK_CDC_RETVAL("cdc_endcapture",retval);
		}
        }
    if (sessionid > 0)
        {
        fprintf(stdout, "cdc_closesess on session %d\n", sessionid);
        $execute function informix.cdc_closesess(:sessionid)
                    into :retval;
    	CHK_CDC_RETVAL("cdc_closesess",retval);
        }


    if (databuf)
        free(databuf);

    if (nodebug != 1)
        {
        /* ��ͬ�� printf �����б��е� ?: ����
         * ����������·���������в���*/
        float avg_recs;
        if (stat_bufs_read == 0)
            avg_recs = 0.0;
        else
            avg_recs = ((float) stat_recs_extracted) / ((float) stat_bufs_read);

        fprintf(stdout, "Total buffers read: %d\n", stat_bufs_read);
        fprintf(stdout, "Total records extracted: %d\n", stat_recs_extracted);
        fprintf(stdout, "Average recs per buffer: %f\n", avg_recs);
        }

    exit(caperrcode);

extraction_error:
    fprintf(stderr, "%s: Record extraction failed.\n", progname);
    goto done;
} /* main() */

#define PRINTABLE(c) (isprint(c) ? (c) : '.')

void
dump_hex (char *str, char *rec, int len)
{
  int i, j;

  if (nodebug==1) return;

  fprintf(stdout,"%s (%d/0x%x bytes at address 0x%x)\n", 
				str, len, len, rec);
	

  if (rec == NULL || len < 1)
    return;

  for (i = 0; i < len; i += 16)
  {
    for (j = i; j < i + 16; j++)
    {
      if (j < len)
                printStdoutAndFile("%02x ", rec[j] & 0xff);
      else
        printStdoutAndFile ("   ");
    }
    for (j = i; j < i + 16; j++)
      if (j < len)
        printStdoutAndFile ("%c", PRINTABLE(rec[j] & 0xff));
    printStdoutAndFile ("\n");
  }
}

/* ����־��¼�� LO ������Ϣ��ȡ BLOB �� CLOB ����*/
void
get_lob_data(char* dbuf)
{
  int err;
  ifx_lo_t   LO={0};
  $int lofd;
  $ifx_lo_stat_t *stats;
  $ifx_int8_t size;
  int isize;
  char *lobuff ;

do {
   	printStdoutAndFile("\tColumn Value = <SBLOB Data>\n");
    memcpy((char*)&LO, dbuf+4, sizeof(ifx_lo_t));
	
    $set lock mode to wait;

    lofd = ifx_lo_open(&LO, LO_RDONLY, &err);
	if (lofd < 0)
	{
       	printStdoutAndFile("\tSBLOB Data is NULL\n");
	break;
	}
     if(ifx_lo_stat(lofd, &stats) < 0)
        {
       	printStdoutAndFile("\tSBLOB Data is NULL\n");
	break;
        }
    if((ifx_lo_stat_size(stats, &size)) < 0)
            isize = 0;
    else if(ifx_int8toint(&size, &isize) !=  0)
        {
        fprintf(stdout,"\nFailed to convert size");
        isize = 0;
        break;
        }
    printStdoutAndFile("\tSBLOB size is %d\n",isize);

    lobuff = malloc(isize);

    isize = ifx_lo_read(lofd, lobuff, isize, &err);
    if (isize < 0)
        {
        fprintf(stdout,"\t cant read LO %d\n", err);
		CHK_SQL_CODE("cant read LO");
        break;
        }

    printStdoutAndFile("\tifx_lo_read output  size=%d \n",isize);
    dump_hex("SBLOB Data:", lobuff, isize);
    } while(0);


   /* �ر����ܴ���� */
    ifx_lo_close(lofd);
}

void
printStdoutAndFile(char*  msg, ...)
{
  	va_list ap;
	char	bigbuf[256];

   	va_start(ap, msg);
    vsprintf(bigbuf,msg,ap);
	va_end(ap);

	fprintf(stdout,"%s",bigbuf);
	if (outfilefp)
		{
		fprintf(outfilefp,"%s",bigbuf);
		fflush(outfilefp);
		}
	return;
}

/* �������Ǽ����ĸ��� CDC ��־��¼���ͣ�����ҷ�������
 * ������
 */
void
get_cdc_rectype_name(int i_recnum, char* o_recsymb, char* o_recdesc)
{
	int i ;
	for (i=0; i < num_cdc_log_recs; i++)
		{
		if (syscdcrectypes_tab[i].recnum == i_recnum)
			{
			if (o_recsymb)
				strcpy(o_recsymb, syscdcrectypes_tab[i].recname);
			if (o_recdesc)
		 		strcpy(o_recdesc,syscdcrectypes_tab[i].recdesc);
			return;
			}
		}
	
	if (o_recsymb)
		strcpy(o_recsymb, "UNKNOWN");
	if (o_recdesc)
		 strcpy(o_recdesc, "Unknown/UnDocumented Log record");
}

/* ���� CDC ��־��¼�ĸ����������ƣ�����Ҵ˳���
 * �������־��¼����
 */
cdc_log_type_t
get_cdc_log_type(char* i_recname)
{
	int i;
	for (i=0; i < NUM_CDCLOGRECTYPES; i++)
	{
		if (strcmp(i_recname, logrectab[i].recname) == 0)
			return logrectab[i].rectype;	
	}

	printf("Error: Did not find value for %s log rec symbol table\n",i_recname);
	return NUM_CDCLOGRECTYPES; 
}

/* ���� CDC API ���صĸ�������������ϸ CDC ������Ϣ
 * �� CDC �����������
*/
void
get_cdc_error_info(int i_cdcerr, char* o_cdcerrsymb, char* o_cdcerrdesc)
{
	int i ;
	for (i=0; i < num_cdc_err_recs; i++)
		{
		if (syscdcerrcode_tab[i].errcode == i_cdcerr)
			{
			if (o_cdcerrsymb)
				strcpy(o_cdcerrsymb, syscdcerrcode_tab[i].errname);
			if (o_cdcerrdesc)
		 		strcpy(o_cdcerrdesc,syscdcerrcode_tab[i].errdesc);
			return;
			}
		}
	
	if (o_cdcerrsymb)
		strcpy(o_cdcerrsymb, "UNKNOWN");
	if (o_cdcerrdesc)
		 strcpy(o_cdcerrdesc, "Unknown/Undocumented CDC API Error");
	
}


/* ��ѯ syscdcrectype ������洢���ڴ��б��� */
void
loadSyscdcrectypes(void)
{
	$int sys_recnum;
	$varchar sys_recname[17];
	$varchar sys_recdesc[128];
	$int numrec=0;
	int i=0;

	EXEC SQL select count(*) into :numrec from syscdcrectypes;

	if (numrec <= 0)
		{
		num_cdc_log_recs=0;
		return;
		}

	syscdcrectypes_tab = (syscdcrectypes_t*) malloc(numrec *
					sizeof(syscdcrectypes_t));

	num_cdc_log_recs=numrec;
	EXEC SQL DECLARE rectype_cur CURSOR FOR
   		SELECT recnum, recname, recdesc
      		INTO :sys_recnum, :sys_recname, :sys_recdesc
      		FROM syscdcrectypes
		WHERE recname LIKE "CDC%"
   		FOR READ ONLY;

	EXEC SQL OPEN rectype_cur;

	while(SQLCODE == 0)
	{
   	EXEC SQL FETCH rectype_cur;
   	if(SQLCODE == 0)
		{
		sys_recname[16]='\0';
		sys_recdesc[127]='\0';
		syscdcrectypes_tab[i].recnum = sys_recnum;
		strcpy(syscdcrectypes_tab[i].recname, sys_recname);
		strcpy(syscdcrectypes_tab[i].recdesc, sys_recdesc);
		i++;
		}
	}

	EXEC SQL CLOSE rectype_cur;
}

/* ��ѯ syscdcerrocdoes ������洢���ڴ��б��� */
void
loadSyscdcerrorcodes(void)
{
	$int sys_errcode;
	$varchar sys_errname[16];
	$varchar sys_errdesc[128];
	$int enumrec=0;
	int i=0;

	EXEC SQL select count(*) into :enumrec from syscdcerrcodes;

	if (enumrec <= 0)
		{
		num_cdc_err_recs=0;
		return;
		}

	syscdcerrcode_tab = (syscdcerrcode_t*) malloc(enumrec *
					sizeof(syscdcerrcode_t));

	num_cdc_err_recs=enumrec;
	EXEC SQL DECLARE errcode_cur CURSOR FOR
   		SELECT errcode, errname, errdesc
      		INTO :sys_errcode, :sys_errname, :sys_errdesc
      		FROM syscdcerrcodes
   		FOR READ ONLY;

	EXEC SQL OPEN errcode_cur;

	while(SQLCODE == 0)
	{
   	EXEC SQL FETCH errcode_cur;
   	if(SQLCODE == 0)
		{
		syscdcerrcode_tab[i].errcode = sys_errcode;
		strcpy(syscdcerrcode_tab[i].errname, sys_errname);
		strcpy(syscdcerrcode_tab[i].errdesc, sys_errdesc);
		i++;
		}
	}

	EXEC SQL CLOSE errcode_cur;
}

