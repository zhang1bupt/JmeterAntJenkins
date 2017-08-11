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
String filename = "E:\\IOtest\\Top20\\test_resultios\\question.txt";
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

//���ܵ�3�������߽���
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("qanode"))										
{
	p.println( Errmessage_str + "qanode" );
	ass = true;
}else{
    qanode_list = List.get("qanode");
	if(!qanode_list.containsKey("question")){
		p.println( Errmessage_str + "question" );
		ass = true;				
	}
	else{
		question_list = qanode_list.get("question");
		//�ʴ��ǳ�
		if(!question_list.containsKey("name")){
			p.println( Errmessage_str + "name" );
			ass = true;
		}else{
			String name_str = question_list.get("name");
			p.println( "Pass�����������ߵ��ǳƣ�" + name_str );
			}
		//�������ӹ��ܵ㣺2 ʱ����ʾ
		if(!question_list.containsKey("createTime")){
			p.println( "Error��createTime�ֶη��ش���" );
			ass = true;
		}else{
			String createTime_str = question_list.get("createTime") + "";  
			Date date= new Date(Long.parseLong(createTime_str.trim()));   
			String date_str = df.format(date);  
			if(date_str.equals("")){
				p.println( "Error��createTime�ֶη���Ϊ��" );	
			}else{
				p.println( "Pass���������ʵ�ʱ����ʾΪ��" +  date_str );
			}	
		}
		//��ǩicon��ʾ
		if(!question_list.containsKey("icon")){
			p.println( Errmessage_str + "icon" );
			ass = true;
		}else{
			String icon_str = question_list.get("icon");
			p.println( "Pass�������ߵ�iconͼ�������Ϊ��" + icon_str );
		}
		//��������
		if(!question_list.containsKey("content")){
			p.println( Errmessage_str + "content" );
			ass = true;
		}else{
			String content_str = question_list.get("content");
			p.println( "Pass�����ʵľ���������ʾ��" + content_str );
		}
		//���廨��
		if(!question_list.containsKey("pay")){
			p.println( Errmessage_str + "pay" );
			ass = true;
		}else{
			int pay_int = question_list.get("pay");
			p.println( "Pass�����������ʵĻش���Ҫ������ʾ��" + pay_int + "�ĵ�" );
		}
		//״̬��ʾ��statusΪ1��ʾ���ѻش�2��ʾ�ѹ��ڡ�
		if(!question_list.containsKey("status")){
			p.println( Errmessage_str + "status" );
			ass = true;
		}else{
			int status_int = question_list.get("status");
			p.println( "Pass���������ʵĵ�״̬��ʾ��" + status_map.get(status_int) );
		}
	}
}
//���ܵ�4:����ش�
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("qanode"))										
{
	p.println( Errmessage_str + "qanode" );
	ass = true;
}else{
    qanode_list = List.get("qanode");
	if(!qanode_list.containsKey("answer")){
		p.println( Errmessage_str + "answer" );
		ass = true;				
	}
	else{
		answer_list = qanode_list.get("answer");
		//��ǩicon��ʾ
		if(!answer_list.containsKey("icon")){
			p.println( Errmessage_str + "icon" );
			ass = true;
		}else{
			String icon_str = answer_list.get("icon");
			p.println( "Pass����ǩ������Ϊ��" + icon_str );
		}
		//�ش���ʾ
		if(!answer_list.containsKey("content")){
			p.println( Errmessage_str + "content" );
			ass = true;
		}else{
			String content_str = answer_list.get("content");
			p.println( "Pass��Ҫ���ش���ʾ��" + content_str );
		}
		//�ش�ʱ����ʾ
		if(!answer_list.containsKey("audioDuration")){
			p.println( Errmessage_str + "audioDuration" );
			ass = true;
		}else{
			int audioDuration_int = answer_list.get("audioDuration");
			p.println( "Pass���ش��ʱ��Ϊ��" + audioDuration_int + "��" );
			}
		//������ʾ����������������
		if(!answer_list.containsKey("eavesDroppingCount")){
			p.println( Errmessage_str + "eavesDroppingCount" );
			ass = true;
		}else{
			int eavesDroppingCount_int = answer_list.get("eavesDroppingCount");
			p.println( "Pass����" + eavesDroppingCount_int + "��������");
			}
		//������ʾ,��ö����ĵ�
		if(!answer_list.containsKey("earnMoney")){
			p.println( Errmessage_str + "earnMoney" );
			ass = true;
		}else{
			int earnMoney_int = answer_list.get("earnMoney");
			p.println( "Pass�����" + earnMoney_int + "�ĵ�");
			}
		//������ʾ����������
		if(!answer_list.containsKey("listenCount")){
			p.println( Errmessage_str + "listenCount" );
			ass = true;
		}else{
			int listenCount_int = answer_list.get("listenCount");
			p.println( "Pass������" + listenCount_int );
			}
		//�����ǳ�
		if(!answer_list.containsKey("authorName")){
			p.println( Errmessage_str + "authorName" );
			ass = true;
		}else{
			String authorName_str = answer_list.get("authorName");
			p.println( "Pass�����ߵ��ǳƣ�" + authorName_str );
		}	
		//�ʴ������ǳ�
		// if(!answer_list.containsKey("authorName")){
			// p.println( Errmessage_str + "authorName" );
			// ass = true;
		// }else{
			// String authorName_str = answer_list.get("authorName");
			// p.println( "Pass�����ߵ��ǳƣ�" + authorName_str );
		// }	
	}
}
//���ܵ�5:�����������߻ش�������⣬��������������
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("authornode"))										
{
	p.println( Errmessage_str + "authornode" );
	ass = true;
}else{
    qanode_list = List.get("authornode");
	if(!List.containsKey("authornode")){
		p.println( Errmessage_str + "authornode" );
		ass = true;
	}else{
		authornode_list = List.get("authornode");
		//�ش�������ǳ�
		if(!authornode_list.containsKey("authorName")){
			p.println( Errmessage_str + "authorName" );
			ass = true;
		}else{
			String authorName_str = authornode_list.get("authorName");
			p.println( "Pass�����ߵ��ǳƣ�" + authorName_str );
		}
		//�ش��������
		if(!authornode_list.containsKey("answerCount")){
			p.println( Errmessage_str + "answerCount" );
			ass = true;
		}else{
			int answerCount_int = authornode_list.get("answerCount");
			p.println( "Pass���ش�" + answerCount_int + "������");
		}
		//��������������
		if(!authornode_list.containsKey("listenCount")){
			p.println( Errmessage_str + "listenCount" );
			ass = true;
		}else{
			int listenCount_int = authornode_list.get("listenCount");
			p.println( "Pass���ش�" + listenCount_int + "������");
		}
	}
}
//���ܵ�6�������������Ʒ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("booklist"))										
{
	p.println( Errmessage_str + "booklist" );
	ass = true;
}else{
	booklist_arr = List.get("booklist");
	if(booklist_arr.size() == 0){
		p.println( "����������ƷΪ��" );
	}else{
		for( i=0; i < booklist_arr.size(); i++ ){
			booklist_list = booklist_arr.get(i);
			p.println("\n");
			p.println( "**********�����������Ʒ************" );
			//��Ʒ������ʾ
			if(!booklist_list.containsKey("title")){
				p.println( "Error��title�ֶη��ش���" );
				ass = true;
			}else {
				String title_str =  booklist_list.get("title");	
				if( title_str.equals("")){
					p.println( "Error����Ʒû��������ʾ"  );
					ass = true;
				}else{
					p.println( "Pass����Ʒ������ʾ��" + title_str );
				}
			}
			//��Ʒ����
			if(!booklist_list.containsKey("intro")){
				p.println( "Error��intro�ֶη��ش���" );
				ass = true;
			}else {
				String intro_str =  booklist_list.get("intro");
				if( intro_str.equals("") ){
					p.println( "Error����Ʒ������intro�ֶ�Ϊ��"  );
				}else{
					p.println( "Pass����������ߣ�" + intro_str );
				}
			}
			p.println( "******************************" );
		}
	}
}
//���ܵ�7��ȫ���ظ�
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("replylist"))										
{
	p.println( Errmessage_str + "replylist" );
	ass = true;
}else{
    replylist_arr = List.get("replylist");
	if(replylist_arr.size() == 0){
		p.println( "�ظ���Ϊ��" );
	}else{
		for( i=0; i < replylist_arr.size(); i++ ){
			replylist_list = replylist_arr.get(i);
			p.println("\n");
			p.println( "##########ȫ���ظ�###########" );
			//�������ӹ��ܵ㣺1 ¥����ʾ
			if(!replylist_list.containsKey("index")){
				p.println( "Error��index�ֶη��ش���" );
				ass = true;
			}else{
				int index_int = replylist_list.get("index");
				if(index_int <= 0){
					p.println( "Error��¥����ʾ������С��1¥" );
				}else if(index_int == 2){
					p.println( "Pass����" + (i+1) + "¥����ʾ��ɳ��" );
				}else{
					p.println( "Pass����" + (i+1) + "¥����ʾ��" + index_int + "¥" );
				}
			}
			//�������ӹ��ܵ㣺2 ʱ����ʾ
			if(!replylist_list.containsKey("createtime")){
				p.println( "Error��createTime�ֶη��ش���" );
				ass = true;
			}else{
				String createTime_str = replylist_list.get("createtime") + "";
			   // String time="1256006105375";//long��ת���ɵ��ַ���  
			    Date date= new Date(Long.parseLong(createTime_str.trim()));   
			    String date_str = df.format(date);  
				if(date_str.equals("")){
					p.println( "Error��title�ֶη���Ϊ��" );	
				}else{
					p.println( "Pass����" + (i+1) + "��ʱ����ʾΪ��" +  date_str );
				}	
			}
			//�������ӹ��ܵ㣺3 ��ʾ�����˵���Ϣ
			if(!replylist_list.containsKey("user")){
				p.println( "Error��user�ֶη��ش���" );
				ass = true;
			}else{
				user_list = replylist_list.get("user");
				 //�������ǳ���ʾ
				if(!user_list.containsKey("nickname")){
					p.println( "Error��nickname�ֶη��ش���" );
					ass = true;
				}else{
					String nickname_str = user_list.get("nickname");
					p.println( "Pass����" + (i+1) + "�������ǳ���ʾΪ��" +  nickname_str);
				}
				//icon��ַ������ʾ
				if(!user_list.containsKey("icon")){
					p.println( "Error��icon�ֶη��ش���" );
					ass = true;
				}else{
					String icon_str = user_list.get("icon");
					p.println( "Pass����" + (i+1) + "��������icon�ĵ�ַ����Ϊ��" +  icon_str);
				}
				//�������Ƿ����
				if(!user_list.containsKey("vipStatus")){
					p.println( "Error��icon�ֶη��ش���" );
					ass = true;
				}else{
					int vipStatus_int = user_list.get("vipStatus");
					p.println( "Pass����" + (i+1) + "������" +  ispaymonth.get(vipStatus_int));
				}
			}
			p.println( "############################" );
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
