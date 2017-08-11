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
String filename = "E:\\IOtest\\Top20\\test_resultios\\authorhome.txt";
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

//���ܵ�3�����߽��ܣ�λ�ڽ������϶�
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("authorInfo"))										
{
	p.println( Errmessage_str + "authorInfo" );
	ass = true;
}else{
    authorInfo_list = List.get("authorInfo");
	//ͼ����ʾ
	if(!authorInfo_list.containsKey("icon"))										
	{
		p.println( Errmessage_str + "icon" );
		ass = true;
	}else{
		String icon_str = authorInfo_list.get("icon");
		p.println( "Pass����ʾ��ͼ������Ϊ��" + icon_str);
	}
	//������ʾ
	if(!authorInfo_list.containsKey("desc"))
	{
		p.println( Errmessage_str + "desc" );
		ass = true;
	}else{
		String desc_str = authorInfo_list.get("desc");
		p.println( "Pass����ʾ�����߽���Ϊ��" + desc_str);
	}
	//��ʾ����������֧����
	if(!authorInfo_list.containsKey("questionPrice"))
	{
		p.println( Errmessage_str + "questionPrice" );
		ass = true;
	}else{
		int questionPrice_int = authorInfo_list.get("questionPrice");
		p.println( "Pass������������֧����" + questionPrice_int + "�ĵ�");
	}
	//��ʾ�����룺
	if(!authorInfo_list.containsKey("income"))
	{
		p.println( Errmessage_str + "income" );
		ass = true;
	}else{
		int income_int = authorInfo_list.get("income");
		if( income_int < 0){
			p.println(  "Error: income����������" );
			ass = true;
		}else{
			p.println( "Pass�������룺" + income_int + "�ĵ�");
		}
	}
	//����������ش���ʾ��
	if(!authorInfo_list.containsKey("answerIncome"))
	{
		p.println( Errmessage_str + "answerIncome" );
		ass = true;
	}else{
		int answerIncome_int = authorInfo_list.get("answerIncome");
		if( answerIncome_int < 0){
			p.println(  "Error: answerIncome����������" );
			ass = true;
		}else{
			p.println( "Pass���ش�" + answerIncome_int + "�ĵ�");
		}
	}
	//�������±���������ʾ��
	if(!authorInfo_list.containsKey("listenIncome"))
	{
		p.println( Errmessage_str + "listenIncome" );
		ass = true;
	}else{
		int listenIncome_int = authorInfo_list.get("listenIncome");
		if( listenIncome_int < 0){
			p.println(  "Error: listenIncome����������" );
			ass = true;
		}else{
			p.println( "Pass������������" + listenIncome_int + "�ĵ�");
		}
	}
}	

//���ܵ�4:ȫ��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("all")){
	p.println( Errmessage_str + "all" );
	ass = true;
}else{
	all_str = List.get("all");
	if(all_str.size() == 0){
		p.println( "�ʴ�ȫ��������Ϊ��" );
	}else{
		for( i=0; i < all_str.size(); i++ ){
			all_list = all_str.get(i);
			if(!all_list.containsKey("question")){
				p.println( Errmessage_str + "question" );
				ass = true;				
			}else{
				question_list = all_list.get("question");
				p.println("\n");
				p.println( "**********ȫ��************" );
				//�ʴ��ǳ�
				if(!question_list.containsKey("name")){
					p.println( Errmessage_str + "name" );
					ass = true;
				}else{
					String name_str = question_list.get("name");
					p.println( "Pass����" + (i+1) + "���ʴ���ǳƣ�" + name_str );
				}
				//�������ӹ��ܵ㣺2 ʱ����ʾ
				if(!question_list.containsKey("createTime")){
					p.println( "Error��createTime�ֶη��ش���" );
					ass = true;
				}else{
					String createTime_str = question_list.get("createTime") + "";
				   // String time="1256006105375";//long��ת���ɵ��ַ���  
					Date date= new Date(Long.parseLong(createTime_str.trim()));   
					String date_str = df.format(date);  
					if(date_str.equals("")){
						p.println( "Error��title�ֶη���Ϊ��" );	
					}else{
						p.println( "Pass����" + (i+1) + "���ʴ�ʱ����ʾΪ��" +  date_str );
					}	
				}
				//��ǩicon��ʾ
				if(!question_list.containsKey("icon")){
					p.println( Errmessage_str + "icon" );
					ass = true;
				}else{
					String icon_str = question_list.get("icon");
					p.println( "Pass����" + (i+1) + "����ǩ������Ϊ��" + icon_str );
				}
				//��������
				if(!question_list.containsKey("content")){
					p.println( Errmessage_str + "content" );
					ass = true;
				}else{
					String content_str = question_list.get("content");
					p.println( "Pass����" + (i+1) + "���ʴ�ľ���������ʾ��" + content_str );
				}
				//���廨��
				if(!question_list.containsKey("pay")){
					p.println( Errmessage_str + "pay" );
					ass = true;
				}else{
					int pay_int = question_list.get("pay");
					p.println( "Pass����" + (i+1) + "���ʴ�Ļ�����ʾ��" + pay_int + "�ĵ�" );
				}
				//״̬��ʾ��statusΪ1��ʾ���ѻش�2��ʾ�ѹ��ڡ�
				if(!question_list.containsKey("status")){
					p.println( Errmessage_str + "status" );
					ass = true;
				}else{
					int status_int = question_list.get("status");
					p.println( "Pass����" + (i+1) + "���ʴ��״̬��ʾ��" + status_map.get(status_int) );
				}
				p.println( "******************************" );
			}
			
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
