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
String filename = "E:\\IOtest\\Top20\\test_resultios\\followManitos.txt";
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
//���ܵ�1����ע������
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("followManitoList"))										
{
	p.println( Errmessage_str + "followManitoList" );
	ass = true;
}else{
    followManitoList_arr = List.get("followManitoList");
	if(followManitoList_arr.size() == 0){
		p.println( "���޹�ע������" );
	}else{
		for( i=0; i < followManitoList_arr.size(); i++ ){
			followManito_list = followManitoList_arr.get(i);
			p.println("\n");
			p.println( "~~~~~~~~~~~~~��ע������~~~~~~~~~~~~~~~~~" );
			//��ע�������ӹ��ܵ�1��ͼ����ʾ
			if(!followManito_list.containsKey("icon")){
				p.println( "Error��icon�ֶη��ش���" );
				ass = true;
			}else{
				String icon_str = followManito_list.get("icon");
				if(icon_str.equals("")){
					p.println( "Pass��û�����ߵ�ͼ��" );
				}else{
					p.println( "Pass��ͼ��ĵ�ַΪ��" + icon_str );
				}
			}
			//��ע�������ӹ��ܵ�2������������ʾ
			if(!followManito_list.containsKey("nickname")){
				p.println( "Error��nickname�ֶη��ش���" );
				ass = true;
			}else{
				String nickname_str = followManito_list.get("nickname") ;
			   // String time="1256006105375";//long��ת���ɵ��ַ���  
				if(nickname_str == ""){
					p.println( "Error��nickname�ֶη���Ϊ��" );
					ass = true;					
				}else{
					p.println( "Pass����" + (i+1) + "�����ߵ�����Ϊ��" +  nickname_str );
				}	
			}
			//�������ӹ��ܵ㣺3 ��ʾ����Ļ�������
			if(!followManito_list.containsKey("desc")){
				p.println( "Error��message�ֶη��ش���" );
				ass = true;
			}else{
				String desc_str = followManito_list.get("desc");
				if(desc_str.equals(" ")){
					p.println( "Pass��δ�Ը�����������" );
				}else{
					p.println( "Pass����" + (i+1) + "�����߽�����ʾΪ��" +  desc_str);
				}
				
			}
			p.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
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
