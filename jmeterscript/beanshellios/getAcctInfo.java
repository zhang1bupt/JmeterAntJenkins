import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;  
import java.util.HashMap;  
try{
/* �����ӡ�ļ���Ϣ�� ---> */
String filename = "E:\\IOtest\\Top20\\test_resultios\\getAcctInfo.txt";
File file =new File(filename);
if(!file.exists())
{
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,false);//��true��Ϊfalse�������Ը��ǵķ�ʽд�����ݡ�
OutputStreamWriter out =new OutputStreamWriter(fs,"utf-8");//???? ������û������
PrintStream p = new PrintStream(fs);


/*��װ����*/

Map sex = new HashMap();  
sex.put(0, "����");  
sex.put(1, "Ů��");  
Map ispaymonth = new HashMap();  
ispaymonth.put(true, "����");  
ispaymonth.put(false, "δ����");  

int message_num = 0;
String jsonString = prev.getResponseDataAsString();			//��ȡjson��,
JSONObject List = JSONValue.parse(jsonString);				//����ȡjson������List

boolean ass = false;	//assert����flg
/*�����߼�������*/
String Errmessage_str = "Error:δ�����ֶΣ�";
SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
p.println( "\n" );
p.println( "�Զ������Կ�ʼ����ʼͳ�Ʋ�����Ϣ,��ǰ�Ĳ���ʱ��Ϊ��" +  df.format(new Date()) );
p.println( "-----------------------------------------------------" );
	
/*������*/
//���ܵ�1: ��¼״̬
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("isLogin"))										
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else{
	String isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == false)
	{
		p.println( "Error����¼״̬Ϊ��δ��¼" );
		ass = true;
	}else{
		p.println( "Pass����¼״̬Ϊ��������¼");
	}
}
//���ܵ�2:��Ա�ȼ�����Ӧ��ɫ��ǩ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("vipLevel"))										
{
	p.println( Errmessage_str + "vipLevel" );
	ass = true;
}else{
	int vipLevel_int = List.get("vipLevel");
	if(vipLevel_int < 0)
	{
		p.println( "Error��vipLevel�ֶη��ش���" );
		ass = true;
	}else if(vipLevel_int == 0){
		p.println( "Pass����¼�˺Ų��ǻ�Ա");
	}else{
		p.println( "Pass����¼�˺�Ϊ��Ա����¼��Vip�ȼ�Ϊ��" + vipLevel_int);
	}
}
//���ܵ�3:�ɳ��ȼ�����Ӧ��ɫ��ǩ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("norLevel"))										
{
	p.println( Errmessage_str + "norLevel" );
	ass = true;
}else{
	int norLevel_int = List.get("norLevel");
	if(norLevel_int < 0)
	{
		p.println( "Error��growLevel�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass����¼���˺ųɳ��ȼ��ȼ�Ϊ��" + norLevel_int);
	}
}
//���ܵ�4:�Ƿ���£���Ӧicon��ʾ�����½ǵ�С��ͼ�꣺
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("isMVip"))										
{
	p.println( Errmessage_str + "isMVip" );
	ass = true;
}else{
	boolean isPayMonth_boolean =  List.get("isMVip") ;
	p.println( "Pass�����û�" + ispaymonth.get(isPayMonth_boolean));
}
//���ܵ�5: ��¼�û�����������ʾ���ۼ��Ķ�����ʱ�䡱
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("readTimeStr"))										
{
	p.println( Errmessage_str + "readTimeStr" );
	ass = true;
}
else{
	String readTimeStr_str = List.get("readTimeStr") + "";
	if(isLogin_str.equals(""))
	{
		p.println( "Error������ʾ�Ķ�ʱ��" );
		ass = true;
	}else{
		p.println( "pass����ʾ��" + readTimeStr_str );
	}
}

//���ܵ�6:��Ʊ��ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("leftMTicket"))										
{
	p.println( Errmessage_str + "leftMTicket" );
	ass = true;
	}else{
		int leftMTicket_int = List.get("leftMTicket") ;
		if(leftMTicket_int < 0){
			p.println( "Error��leftMTicket �ֶη��ش���" );
			}else{
				p.println( "Pass����Ʊ��ʾ��" + leftMTicket_int );
				}	
	}
//���ܵ�7:�Ƽ�Ʊ��ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("leftTicket"))										
{
	p.println( Errmessage_str + "leftTicket" );
	ass = true;
	}else{
		int vipComment_int = List.get("leftTicket") ;
		if(vipComment_int == null){
			p.println( "Error��leftTicket �ֶη��ش���" );
			}else{
				p.println( "Pass���Ƽ�Ʊ��ʾ��" + vipComment_int );
				}	
	}
//���ܵ�8���ֿ�ȯ��ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("combine"))										
{
	p.println( Errmessage_str + "combine" );
	ass = true;
}else{
	int combine_int = List.get("combine");
	if(combine_int < 0 )
	{
		p.println( "Error��combine�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���ۿ�ȯ��ʾ��" + combine_int);
	}
}
//���ܵ�9���ҵİ�����ʾ����ʾ��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("vipComment")){
	p.println( Errmessage_str + "vipComment" );
	ss = true;
}else{
	String vipComment_str = List.get("vipComment") ;
	if(vipComment_str == null){
		p.println( "Error��vipComment �ֶη��ش���" );
	}else{
		p.println( "Pass���ҵİ�����ʾ��" + vipComment_str );
	}
}

if(ass)
{
	prev.setSuccessful(false);
	p.println( "\n" );
	p.println( "���Խ�������ǰʱ��Ϊ��" + df.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}else{
	p.println( "\n" );
	p.println( "���Խ�������ǰʱ��Ϊ��" + df.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
