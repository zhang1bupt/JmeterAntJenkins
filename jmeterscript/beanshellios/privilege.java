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
String filename = "E:\\IOtest\\Top20\\test_resultios\\privilege.txt";
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
//���ܵ�1���û��������ͣ����¡���ѡ��ǰ��£�
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("monthStatus"))										
{
	p.println( Errmessage_str + "monthStatus" );
	ass = true;
}else{
	int monthStatus_int = List.get("monthStatus");
	if(monthStatus_int < -1 || monthStatus_int > 2)
	{
		p.println( "Error��monthStatus �ֶη��ش���" );
		ass = true;
	}else if(monthStatus_int == -1){
		p.println( "Pass�����û�δ����" );
	}else if(monthStatus_int == 1){
		p.println( "Pass��#####���û�Ϊ�����û�#####��" );
			//���ܵ�2:ͼ���Ƿ���ͼ
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("icon"))										
	{
		p.println( Errmessage_str + "icon" );
		ass = true;
		}else{
			String icon_str = List.get("icon") ;
			if(icon_str.equals("")){
				p.println( "Error��icon �˺�û��ͼ����ʾ" );
				ass = true;
				}else{
					p.println( "Pass��ͼ�����������ʾ��ͼ�������Ϊ��" + icon_str );
					}	
		}
	//���ܵ�3:�ǳ���ʾ��
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("nick"))										
	{
		p.println( Errmessage_str + "nick" );
		ass = true;
		}else{
			 String nick_str = List.get("nick") ;
			 if(nick_str.equals("")){
				p.println( "Error���ǳ���ʾ����" );
				ass = true;
			}else{
				p.println( "Pass���ǳ���ʾ��" + nick_str  );
			}
		}
	//���ܵ�4:���µ���ʱ����ʾ��ʾ
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("vipEndTime")){
		p.println( Errmessage_str + "vipEndTime" );
		ass = true;	
	}else{
		String vipEndTime_str = List.get("vipEndTime");
		if(vipEndTime_str.equals("")){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass����ʾ����ʣ��ʱ�䣺" + vipEndTime_str );
		}
	}

	//���ܵ�5:��ݳ���ʱ��
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("dayCount")){
		p.println( Errmessage_str + "dayCount" );
		ass = true;	
	}else{
		int dayCount_int = List.get("dayCount");
		if(dayCount_int < 0){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass����ݳ�������Ϊ��" + dayCount_int );
		}
	}
	//���ܵ�6:�������Ķ���
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("readCount")){
		p.println( Errmessage_str + "readCount" );
		ass = true;	
	}else{
		int readCount_int = List.get("readCount");
		if(readCount_int < 0){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass���������Ķ���Ϊ��" + readCount_int );
		}
	}
	//���ܵ�7:��Ȩ��ʡ�ĵ�
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("saveCoin")){
		p.println( Errmessage_str + "saveCoin" );
		ass = true;	
	}else{
		int saveCoin_int = List.get("saveCoin");
		if(saveCoin_int < 0){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass����Ȩ��ʡ�ĵ�Ϊ��" + saveCoin_int );
		}
	}
	}else if(monthStatus_int == 2){
		p.println( "Pass��#####���û�Ϊ�����û�#####��" );
			//���ܵ�2:ͼ���Ƿ���ͼ
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("icon"))										
	{
		p.println( Errmessage_str + "icon" );
		ass = true;
		}else{
			String icon_str = List.get("icon") ;
			if(icon_str.equals("")){
				p.println( "Error��icon �˺�û��ͼ����ʾ" );
				ass = true;
				}else{
					p.println( "Pass��ͼ�����������ʾ��ͼ�������Ϊ��" + icon_str );
					}	
		}
	//���ܵ�3:�ǳ���ʾ��
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("nick"))										
	{
		p.println( Errmessage_str + "nick" );
		ass = true;
		}else{
			 String nick_str = List.get("nick") ;
			 if(nick_str.equals("")){
				p.println( "Error���ǳ���ʾ����" );
				ass = true;
			}else{
				p.println( "Pass���ǳ���ʾ��" + nick_str  );
			}
		}
	//���ܵ�4:���µ���ʱ����ʾ��ʾ
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("vipEndTime")){
		p.println( Errmessage_str + "vipEndTime" );
		ass = true;	
	}else{
		String vipEndTime_str = List.get("vipEndTime");
		if(vipEndTime_str.equals("")){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass����ʾ����ʣ��ʱ�䣺" + vipEndTime_str );
		}
	}

	//���ܵ�5:��ݳ���ʱ��
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("dayCount")){
		p.println( Errmessage_str + "dayCount" );
		ass = true;	
	}else{
		int dayCount_int = List.get("dayCount");
		if(dayCount_int < 0){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass����ݳ�������Ϊ��" + dayCount_int );
		}
	}
	//���ܵ�6:�������Ķ���
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("readCount")){
		p.println( Errmessage_str + "readCount" );
		ass = true;	
	}else{
		int readCount_int = List.get("readCount");
		if(readCount_int < 0){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass���������Ķ���Ϊ��" + readCount_int );
		}
	}
	//���ܵ�7:��Ȩ��ʡ�ĵ�
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!List.containsKey("saveCoin")){
		p.println( Errmessage_str + "saveCoin" );
		ass = true;	
	}else{
		int saveCoin_int = List.get("saveCoin");
		if(saveCoin_int < 0){
			p.println( "Error��vipEndTime �ֶη��ش���" );
		}else{
			p.println( "Pass����Ȩ��ʡ�ĵ�Ϊ��" + saveCoin_int );
		}
	}
	}else{
		p.println( "Pass�����û�����ʲô�û�,monthStatus��Ӧ���ֶ�Ϊ��" + monthStatus_int );
	}
}

//���ܵ�8:����VIPÿ��ר�������ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("giftRewardInfo"))										
{
	p.println( Errmessage_str + "giftRewardInfo" );
	ass = true;
	}else{
		String giftRewardInfo_str = List.get("giftRewardInfo") ;
		if(giftRewardInfo_str.equals("")){
			p.println( "Error��leftTicket �ֶη��ش���" );
			}else{
				p.println( "Pass������VIPÿ��ר�������ʾΪ��" + giftRewardInfo_str );
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
