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
String filename = "E:\\IOtest\\Top20\\test_resultios\\helpcenter.txt";
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

//���ܵ�3��1������ [  �ɳ��ȼ���VIP�ȼ���  ] 
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("typelist"))										
{
	p.println( Errmessage_str + "typelist" );
	ass = true;
}else{
    typelist_arr = List.get("typelist");
	if(typelist_arr.size() == 0){
		p.println( "Error����������Ϊ��");
		ass = true;
	}else{
		for(int i = 0;i < typelist_arr.size();i++){
			p.println( "\n" );
			p.println("**************һ������**************");
			typelist_list = typelist_arr.get(i);
			//һ��������Ŀ
			if(!typelist_list.containsKey("title")){
				p.println( Errmessage_str + "title" );
				ass = true;
			}else{
				String title_str = typelist_list.get("title");  
				if(title_str.equals("")){
					p.println( "Error��title�ֶη���Ϊ��" );
					ass = true;
				}else{
					p.println( "Pass������һ��������ĿΪ��" +  title_str );
				}	
			}
			//2��������Ϣ  { ʲô��QQ�Ķ��ɳ��ȼ���   }
			if(!typelist_list.containsKey("list")){
				p.println( Errmessage_str + "list" );
				ass = true;
			}else{
				list_arr = typelist_list.get("list");  
				if(list_arr.size() == 0){
					p.println( "Error���������κεĶ���������Ϣ");
					ass = true;
				}else{
					for(int j = 0;j < list_arr.size();j++){
						p.println( "\n" );
						p.println("~~~~~~~~~~~~~��������~~~~~~~~~~~~~~~");
						list_list = list_arr.get(j);
						//2������������Ŀ
						if(!list_list.containsKey("title")){
							p.println( Errmessage_str + "title" );
							ass = true;
						}else{
							title1_str = list_list.get("title");  
							if(title1_str.equals("")){
								p.println( "Error�����������е�title�ֶη���Ϊ��" );	
								ass = true;
							}else{
								p.println("Pass����������������ĿΪ��" +  title1_str );
							}	
						}
						//2��������������
						if(!list_list.containsKey("content")){
							p.println( Errmessage_str + "content" );
							ass = true;
						}else{
							content_str = list_list.get("content");  
							if(content_str.equals("")){
								p.println( "Error�����������е�content��������Ϊ��" );	
								ass = true;
							}else{
								p.println("Pass����������������ϢΪ��" +  content_str );
							}	
						}
						p.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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
