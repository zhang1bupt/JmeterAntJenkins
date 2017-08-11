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
String filename = "E:\\IOtest\\Top20\\test_resultios\\myaccount.txt";
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
				p.println( "Pass�������ʾ��" + balance_int + "�ĵ�" );
				}	
	}
//���ܵ�2:�ľ���ʾ��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("gen_balance"))										
{
	p.println( Errmessage_str + "gen_balance" );
	ass = true;
	}else{
		 int gen_balance_int = List.get("gen_balance") ;
		 if(gen_balance_int < 0){
			p.println( "Error��bookTicket �ֶη��ش���" );
			ass = true;
		}else{
			p.println( "Pass���ҵ���ȯ��ʾ��" + gen_balance_int  );
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

//���ܵ�4:�ҵİ�����ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("monthUser")){
	p.println( Errmessage_str + "monthUser" );
	ass = true;	
}else{
	monthUser_list = List.get("monthUser");
	if(!monthUser_list.containsKey("vipComment")){
		p.println( Errmessage_str + "vipComment" );
			ass = true;
	}else{
		String vipComment_str = monthUser_list.get("vipComment") ;
		if(vipComment_str.equals("")){
			p.println( "Error��vipComment �ֶη��ش���" );
		}else{
			p.println( "Pass���ҵİ�����ʾ��" + vipComment_str );
		}
	}
} 

//���ܵ�5:�Ƽ�Ʊ��ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("leftTicket"))										
{
	p.println( Errmessage_str + "leftTicket" );
	ass = true;
	}else{
		int vipComment_int = List.get("leftTicket") ;
		if(vipComment_int.equals("")){
			p.println( "Error��leftTicket �ֶη��ش���" );
			}else{
				p.println( "Pass���Ƽ�Ʊ��ʾ��" + vipComment_int );
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
