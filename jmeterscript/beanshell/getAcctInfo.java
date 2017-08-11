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
String filename = "E:\\IOtest\\Top20\\test_result\\getAcctInfo.txt";
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
public void jadgepara( Object[] para_arr )
{
	str1 = "Error:δ�����ֶ�---";
	str2 = "Error:�ֶη��ش���---";
	
	for( m=0; m<1000; m++ )
	{
		if(para_arr[m][0] != null)
		{
			obj = para_arr[m][0];
			para = para_arr[m][1];
			item = para_arr[m][2];
			
			if(!obj.containsKey(para))
			{
				p.println( str1 + para + "--" + item );									//Error:δ�����ֶ�---xxx
				ass = true;
			}
			else
			{
				para_str = obj.get(para)+"";
				if((para_str == null) || (para_str.equals("-1")))
				{
					p.println( str2 + para + "--" + item );								//Error:�ֶη��ش���---xxx
					ass = true;
				}
			}
		}
		else
		{
			break;
		}
	}
}

SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
p.println( "\n" );
p.println( "�Զ������Կ�ʼ����ʼͳ�Ʋ�����Ϣ,��ǰ�Ĳ���ʱ��Ϊ��" +  df.format(new Date()) );
p.println( "-----------------------------------------------------" );
	
/*������*/
/* if(!List.containsKey("code"))										//������
{
	p.println( Errmessage_str + "code" );
	ass = true;
}
else
{
	code_str = List.get("code");
	if(!code_str.equals("0"))
	{
		p.println( "Error���ӿڷ���ʧ�ܣ������룺" + code_str );
		ass = true;
	}
} */
//���ܵ�1:QQ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("qq"))											
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}else{
	 String qq_str = List.get("qq");
	if(qq_str == null)
	{
		p.println( "Error��qq�ֶ�Ϊnull��δ��¼qq" );
		ass = true;
	}else{
		p.println( "Pass��qq��¼�ɹ�����¼��qqΪ��" + qq_str);
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
//���ܵ�3:��Ա�ȼ�����Ӧ��ɫ��ǩ
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
//���ܵ�4:�ɳ��ȼ�����Ӧ��ɫ��ǩ
// p.println( "��" + ++message_num + "�����Ե����£�" );
// if(!List.containsKey("growLevel"))										
// {
	// p.println( Errmessage_str + "growLevel" );
	// ass = true;
// }else{
	// int growLevel_int = List.get("growLevel");
	// if(growLevel_int < 0)
	// {
		// p.println( "Error��growLevel�ֶη��ش���" );
		// ass = true;
	// }else{
		// p.println( "Pass����¼���˺ųɳ��ȼ��ȼ�Ϊ��" + growLevel_int);
	// }
// }
//���ܵ�5: ��¼�û�����������ʾ���ۼ��Ķ�����ʱ�䡱
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("readTimeStr"))										
{
	p.println( Errmessage_str + "readTimeStr" );
	ass = true;
}
else{
	String readTimeStr_str = List.get("readTimeStr") + "";
	if(isLogin_str == "")
	{
		p.println( "Error������ʾ�Ķ�ʱ��" );
		ass = true;
	}else{
		p.println( "pass����ʾ��" + readTimeStr_str );
	}
}

//���ܵ�6:�ҵ��˻���ʾ�������+�������
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("balance"))										
{
	p.println( Errmessage_str + "balance" );
	ass = true;
}else if(!List.containsKey("bookTicket"))										
	{
		p.println( Errmessage_str + "bookTicket" );
		ass = true;
	}else{
		 int balance_int = List.get("balance") ;
		 int bookTicket_int = List.get("bookTicket") ;
		if(balance_int < 0){
			p.println( "Error��balance �ֶη��ش���" );
			ass = true;
		}else if(bookTicket_int < 0){
			p.println( "Error��bookTicket �ֶη��ش���" );
			ass = true;
		}else{
			p.println( "Pass���ҵ��˻���ʾ��" + balance_int + "���" + bookTicket_int + "��ȯ" );
		}
	}

//���ܵ�7:���ҵ��˻�������ʾ��������Ʊ�������Ƽ�Ʊ�������ۿ�ȯ��
/* p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("icon"))										
{
	p.println( Errmessage_str + "icon" );
	ass = true;
}else{
	String icon_str =  List.get("icon") ;
	if(icon_str == null)
	{
		p.println( "Error��icon�ֶ�Ϊnull" );
		ass = true;
	}else{
		p.println( "Pass��icon�ֶ�Ϊ��" + icon_str);
	}
}
 */

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
