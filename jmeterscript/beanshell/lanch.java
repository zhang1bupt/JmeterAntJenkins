import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.JSONArray;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
try{
/* �����ӡ�ļ���Ϣ�� ---> */
String filename = "E:\\IOtest\\Top20\\test_result\\lanchtest.txt";
File file =new File(filename);
if(!file.exists())
{
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,true);//��true��Ϊfalse�������Ը��ǵķ�ʽд�����ݡ�
OutputStreamWriter out =new OutputStreamWriter(fs,"utf-8");//???? ������û������
PrintStream p = new PrintStream(fs);
p.println( "\n" );
p.println( "�Զ������Կ�ʼ����ʼͳ�Ʋ�����Ϣ" );
p.println( "-----------------------------------------------------" );

int message_num = 0;
String jsonString = prev.getResponseDataAsString();			//��ȡjson��,
JSONObject List = JSONValue.parse(jsonString);				//����ȡjson������List



boolean ass = false;	//assert����flg
String Errmessage_str = "Error:δ�����ֶΣ�";
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


	


p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("qq"))											//qq
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
/* if(!List.containsKey("prefer"))										//ƫ��
{
	p.println( Errmessage_str + "prefer" );
	ass = true;
}
else
{
	prefer_l = List.get("prefer");
	if(prefer_l == -1)
	{
		p.println( "Error��prefer�ֶη��ش���" );
		ass = true;
	}
}
if(!List.containsKey("sex"))										//�Ա�
{
	p.println( Errmessage_str + "sex" );
	ass = true;
}
else{
	sex_l = List.get("sex");
	if(sex_l == -1)
	{
		p.println( "Error��sex�ֶη��ش���" );
		ass = true;
	}
} */
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("isVip"))										//��Ա״̬
{
	p.println( Errmessage_str + "isVip" );
	ass = true;
}else{
	isVip_str = List.get("isVip") + "";
	if(isVip_str == null)
	{
		p.println( "Error��isVip�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass����¼�˺�Ϊ��Ա����¼��Vip�ȼ�Ϊ��" + isVip_str);
	}
}

p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("isLogin"))										//��¼״̬
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else{
	isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == null)
	{
		p.println( "Error��isLogin�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass��True��ʾ������¼��False��ʾδ��¼����¼״̬Ϊ" + isLogin_str);
	}
}
if(ass)
{
  prev.setSuccessful(false);
  p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
