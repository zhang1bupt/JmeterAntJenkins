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
String filename = "E:\\IOtest\\Top20\\test_resultios\\getmessage.txt";
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
ispaymonth.put(1, "����");  
ispaymonth.put(0, "δ����");  
Map status_map = new HashMap();  
status_map.put(1, "�ѻش�");  
status_map.put(2, "�ѹ���");  
Map vipstatus_map = new HashMap();  
vipstatus_map.put(1, "����");  
vipstatus_map.put(2, "����");  
vipstatus_map.put(0, "δ����"); 
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
	
//���ܵ�1:QQ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("qq"))											
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}else{
	 long qq_int = List.get("qq");
	if(qq_int == -1)
	{
		p.println( "Error��qq�ֶ�Ϊ-1��δ��¼qq" );
		ass = true;
	}else{
		p.println( "Pass��qq��¼�ɹ�����¼��qqΪ��" + qq_int);
	}
} 
//���ܵ�2: ��¼״̬
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

//���ܵ�3��֪ͨ/���� messages_arr [    ] 
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("messages"))										
{
	p.println( Errmessage_str + "messages" );
	ass = true;
}else{
    messages_arr = List.get("messages");
	if(messages_arr.size() == 0){
		p.println( "Pass��֪ͨ/������ϢΪ��");
	}else{
		for(int i = 0;i < messages_arr.size();i++){
			//ÿһ�� messagelist {    }
			p.println( "\n" );
			p.println("**************֪ͨ/����**************");
			messages_list = messages_arr.get(i);
			//1��ʱ����ʾ
			if(!messages_list.containsKey("ctime")){
				p.println( Errmessage_str + "ctime" );
				ass = true;
			}else{
				String createTime_str = messages_list.get("ctime") + "";  
				Date date= new Date(Long.parseLong(createTime_str.trim()));   
				String date_str = df.format(date);  
				if(date_str.equals("")){
					p.println( "Error��ctime�ֶη���Ϊ��" );	
				}else{
					p.println( "Pass���������ʵ�ʱ����ʾΪ��" +  date_str );
				}	
			}
			//ÿ��֪ͨ/���� data_list{}
			if(!messages_list.containsKey("data")){
				p.println( Errmessage_str + "data" );
				ass = true;
			}else{
				data_list = messages_list.get("data");  
				data_list = messages_list.get("data");  
				//2���������ĸ������֪ͨ�ͻ���
				if(!data_list.containsKey("bname")){
					p.println( Errmessage_str + "bname" );
					ass = true;
				}else{
					bname_str = data_list.get("bname");  
					if(bname_str.equals("")){
						p.println( "Error��ctime�ֶη���Ϊ��" );	
						ass = true;
					}else{
						p.println( "Pass���ڣ�" +  bname_str + "����֪ͨ/����");
					}	
				}
				//3 ����֪ͨ/������Ϣ
				if(!data_list.containsKey("context")){
					p.println( Errmessage_str + "context" );
					ass = true;
				}else{
					context_str = data_list.get("context");  
					if(context_str.equals("")){
						p.println( "Error��context�ֶη���Ϊ��" );
						ass = true;						
					}else{
						p.println( "Pass��������Ϣ��" +  context_str);
					}	
				}
				//4 ����֪ͨ/���� �ظ���Ϣ
				if(!data_list.containsKey("reply")){
					p.println( Errmessage_str + "reply" );
					ass = true;
				}else{
					reply_str = data_list.get("reply");  
					if(reply_str.equals("")){
						p.println( "Error��reply�ֶη���Ϊ��" );
						ass = true;						
					}else{
						p.println( "Pass���ظ���Ϣ��" +  reply_str);
					}	
				}
				//ÿ��֪ͨ/���� sende1_list{   }
				if(!data_list.containsKey("sender")){
					p.println( Errmessage_str + "sender" );
					ass = true;
				}else{
					sender_list = data_list.get("sender");  
					//5 ����֪ͨ/���� �������ǳ�
					if(!sender_list.containsKey("nickname")){
						p.println( Errmessage_str + "nickname" );
						ass = true;
					}else{
						nickname_str = sender_list.get("nickname");  
						if(nickname_str.equals("")){
							p.println( "Error��nickname�ֶη���Ϊ��" );
							ass = true;						
						}else{
							p.println( "Pass�������ߵ��ǳ���ʾΪ��" +  nickname_str);
						}	
					}
					//5 ����֪ͨ/���� ������icon
					if(!sender_list.containsKey("icon")){
						p.println( Errmessage_str + "icon" );
						ass = true;
					}else{
						icon_str = sender_list.get("icon");  
						if(icon_str.equals("")){
							p.println( "Error��icon�ֶη���Ϊ��" );
							ass = true;						
						}else{
							p.println( "Pass�������ߵ�ͼ���ַ����Ϊ��" +  icon_str);
						}	
					}
					//6 ����֪ͨ/���� �����߰���״��
					if(!sender_list.containsKey("vipStatus")){
						p.println( Errmessage_str + "vipStatus" );
						ass = true;
					}else{
						int vipStatus_int = sender_list.get("vipStatus");
						if(vipStatus_int < 0 || vipStatus_int > 3){
							p.println( "Error��vipStatus�ֶη��ش���" );
							ass = true;						
						}else{
							p.println( "Pass�������ߵİ���״��Ϊ��" +  vipstatus_map.get(vipStatus_int));
						}	
					}
				}
			}
			p.println("********************************");
		}
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
