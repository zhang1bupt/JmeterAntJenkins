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
String filename = "E:\\IOtest\\Top20\\test_resultios\\queryselectedtag.txt";
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
//���ܵ�1:�ҵ��ղ���ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("tags"))										
{
	p.println( Errmessage_str + "tags" );
	ass = true;
}else{
    tags_arr = List.get("tags");
	if(tags_arr.size() == 0){
		p.println( "δ��ӻ���" );
	}else{
		for( i=0; i < tags_arr.size(); i++ ){
			tags_list = tags_arr.get(i);
			p.println("\n");
			p.println( "##########����###########" );
			if(!tags_list.containsKey("extInfo")){
				p.println( "Error��extInfo�ֶη��ش���" );
				ass = true;
			}else{
				extInfo_list = tags_list.get("extInfo");
				//�ӹ��ܵ�1������������ʾ��
				if(!extInfo_list.containsKey("fullname")){
					p.println( Errmessage_str + "fullname" );
					ass = true;
				}else{
					String fullname_str = extInfo_list.get("fullname");
					if(fullname_str.equals("")){
						p.println( "Error����ǰ���ͻ����ֶ�λ��" );
						ass = true;
					}else{
						p.println( "Pass������������ʾΪ��" + fullname_str );
					}
				}
				//�ӹ��ܵ�2��������ռ����
				if(!extInfo_list.containsKey("wpercent")){
					p.println( Errmessage_str + "wpercent" );
					ass = true;
				}else{
					String wpercent_str = extInfo_list.get("wpercent");
					if(wpercent_str.equals("")){
						p.println( "Error������������ʾΪ��" );
						ass = true;
					}else{
						p.println( "Pass������������ռ������ʾΪ��" + wpercent_str );
					}
				}
			}
		}	
		p.println( "############################" );
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
