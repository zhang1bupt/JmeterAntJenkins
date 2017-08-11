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
String filename = "E:\\IOtest\\Top20\\test_result\\myaccount.txt";
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
//���ܵ�1:�����ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("balance"))										
{
	p.println( Errmessage_str + "balance" );
	ass = true;
	}else{
		int balance_int = List.get("balance") ;
		if(balance_int < 0){
			p.println( "Error��balance �ֶη��ش���" );
			}else{
				p.println( "Pass�������ʾ��" + balance_int + "���" );
				}	
	}
//���ܵ�2:�����ʾ��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("bookTicket"))										
{
	p.println( Errmessage_str + "bookTicket" );
	ass = true;
	}else{
		 int bookTicket_int = List.get("bookTicket") ;
		 if(bookTicket_int < 0){
			p.println( "Error��bookTicket �ֶη��ش���" );
			ass = true;
		}else{
			p.println( "Pass���ҵ��˻���ʾ��" + bookTicket_int + "��ȯ" );
		}
	}
//���ܵ�3���ֿ�ȯ��ʾ
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

//���ܵ�:�ҵİ�����ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("vipComment"))										
{
	p.println( Errmessage_str + "vipComment" );
	ass = true;
	}else{
		String vipComment_str = List.get("vipComment") ;
		if(vipComment_str == null){
			p.println( "Error��vipComment �ֶη��ش���" );
			}else{
				p.println( "Pass���ҵİ�����ʾ��" + vipComment_str );
				}	
	}
//���ܵ�:��Ʊ��ʾ
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
//���ܵ�:�ҵİ������鿨
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("vipComment"))										
{
	p.println( Errmessage_str + "vipComment" );
	ass = true;
	}else{
		String vipComment_str = List.get("vipComment") ;
		if(vipComment_str == null){
			p.println( "Error��vipComment �ֶη��ش���" );
			}else{
				p.println( "Pass���ҵİ�����ʾ��" + vipComment_str );
				}	
	}
//���ܵ�:�Ƽ�Ʊ��ʾ
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
//���ܵ�3:��¼�ǳ���ʾ�����ϲ���ʾ��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("nickName"))										
{
	p.println( Errmessage_str + "nickName" );
	ass = true;
}else{
	nickname_str = List.get("nickName") + "";
	if(nickname_str == null)
	{
		p.println( "Error��nickname_str �ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass����¼���ǳ�Ϊ��" + nickname_str);
	}
}
//���ܵ�4:�Ƿ���"icon"�ֶ�
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("icon"))										
{
	p.println( Errmessage_str + "icon" );
	ass = true;
}else{
	String icon_str =  List.get("icon") ;
	if(icon_str == "")
	{
		p.println( "Error��icon�ֶ�Ϊnull" );
		ass = true;
	}else{
		p.println( "Pass��icon�ֶ�Ϊ��" + icon_str);
	}
}
//���ܵ�5:�Ƿ���£���Ӧicon��ʾ�����½ǵ�С��ͼ�꣺δ�ҵ���Ӧ�ֶ�
p.println( "��" + ++message_num + "�����Ե����£�" );
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
//���ܵ�6:�ɳ��ȼ�����Ӧ��ɫ��ǩ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("gender"))										
{
	p.println( Errmessage_str + "gender" );
	ass = true;
}else{
	int gender_int =  List.get("gender") ;
	if(gender_int < 0)
	{
		p.println( "Error��gender�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���û����Ա�Ϊ��" + sex.get(gender_int));
	}
}
//���ܵ�7:��Ա�ȼ�����Ӧ��ɫ��ǩ
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
//���ܵ�8:�ɳ��ȼ�����Ӧ��ɫ��ǩ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("growLevel"))										
{
	p.println( Errmessage_str + "growLevel" );
	ass = true;
}else{
	int growLevel_int = List.get("growLevel");
	if(growLevel_int < 0)
	{
		p.println( "Error��growLevel�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass����¼���˺ųɳ��ȼ��ȼ�Ϊ��" + growLevel_int);
	}
}
//���ܵ�9:����ǩ�����ں�ɫ��Ա��ǩ����ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("sign"))										
{
	p.println( Errmessage_str + "sign" );
	ass = true;
}else{
	String sign_str = List.get("sign");
	p.println( "Pass������ǩ����ʾΪ��" + sign_str);
	
}
//���ܵ�10���Ķ�ʱ��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("readTime"))										
{
	p.println( Errmessage_str + "readTime" );
	ass = true;
}else{
	int readTime_int = List.get("readTime");
	if(readTime_int < 0)
	{
		p.println( "Error��readTime�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���Ķ�ʱ��Ϊ��" + readTime_int/1000/60 + "����" );
	}
}
//���ܵ�11���յ��޵ĸ���
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("praiseNum"))										
{
	p.println( Errmessage_str + "praiseNum" );
	ass = true;
}else{
	int praiseNum_int = List.get("praiseNum");
	if(praiseNum_int < 0)
	{
		p.println( "Error��praiseNum�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���յ��޵ĸ���Ϊ��" + praiseNum_int);
	}
}
//���ܵ�12��"�ҵĵȼ�"�Ҳ���ʾ�ж��ٳɳ�ֵ����
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("upgradeValue"))										
{
	p.println( Errmessage_str + "upgradeValue" );
	ass = true;
}else{
	int upgradeValue_int = List.get("upgradeValue");
	if(upgradeValue_int < 0)
	{
		p.println( "Error��upgradeValue�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass����ʾ-���У�" + upgradeValue_int + "�ɳ�ֵ����" );
	}
}
//���ܵ�13���ҵ����������������ҵ������������ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("shelfCount"))										
{
	p.println( Errmessage_str + "shelfCount" );
	ass = true;
}else{
	int shelfCount_int = List.get("shelfCount");
	if(shelfCount_int < 0)
	{
		p.println( "Error��shelfCount�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���ҵ�����������Ϊ��" + shelfCount_int);
	}
}
//���ܵ�14���ҵ����������������ҵ������������ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("shelfCount"))										
{
	p.println( Errmessage_str + "shelfCount" );
	ass = true;
}else{
	int shelfCount_int = List.get("shelfCount");
	if(shelfCount_int < 0)
	{
		p.println( "Error��shelfCount�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���ҵ�����������Ϊ��" + shelfCount_int);
	}
}
//���ܵ�15���ҵ�����о��������ʾ�������������������������棬
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("shelfList"))										
{
	p.println( Errmessage_str + "shelfList" );
	ass = true;
}else{
	shelfList_arr = List.get("shelfList");
	//p.println( List );
	//p.println( shelfList_list );
	if(shelfList_arr.size() == 0){
		p.println( "����в�������" );
	}else{
		for( i=0; i < shelfList_arr.size(); i++ ){
			shelfList_list = shelfList_arr.get(i);
			p.println("\n");
			p.println( "**********�ҵ����************" );
			if(!shelfList_list.containsKey("bookCover")){
				p.println( "Error��bookCover�ֶη��ش���" );
				ass = true;
			}else if( bookCover_str == null ){	
				p.println( "Error������з���bookCover�ֶ�Ϊ��"  );
			}else{
				String bookCover_str = shelfList_list.get("bookCover");
				p.println( "Pass������з��棺" + bookCover_str );
			}
			if(!shelfList_list.containsKey("bookName")){
				p.println( "Error��bookName�ֶη��ش���" );
				ass = true;
			}else if( bookName_str == null ){
				p.println( "Error������������ֶ�Ϊ��"  );
			}else{
				String bookName_str =  shelfList_list.get("bookName");
				p.println( "Pass�����������bookName��" + bookName_str);
			}
			if(!shelfList_list.containsKey("author")){
				p.println( "Error��author�ֶη��ش���" );
				ass = true;
			}else if( author_str == null ){
				p.println( "Error�����������author�ֶ�Ϊ��"  );
			}else{
				String author_str =  shelfList_list.get("author");
				p.println( "Pass����������ߣ�" + author_str );
			}
			p.println( "******************************" );
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
