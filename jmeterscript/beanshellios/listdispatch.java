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
String filename = "E:\\IOtest\\Top20\\test_resultios\\listdispatch.txt";
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

if(!List.containsKey("infos"))										
{
	p.println( Errmessage_str + "infos" );
	ass = true;
}else{
    infos_arr = List.get("infos");
	if(infos_arr.size() == 0){
		p.println( "�ղ�Ϊ��" );
	}else{
		for( i=0; i < infos_arr.size(); i++ ){
			infos_list = infos_arr.get(i);
			p.println("\n");
			p.println( "##########�ҵ��ղ�###########" );
			//�ҵ��ղ��ӹ��ܵ�1������1�� ���⡢���ۺ�ͼƬ
			int moudle_int = infos_list.get("moudle");
			if(	moudle_int == 1	){
				if(!infos_list.containsKey("info")){
					p.println( "Error��info�ֶη��ش���" );
					ass = true;
				}else{
					info_list = infos_list.get("info");
					//������ʾ��
					if(!info_list.containsKey("title")){
						p.println( Errmessage_str + "title" );
						ass = true;
					}else{
						String title_str = info_list.get("title");
						if(title_str.equals("")){
							p.println( "Error������Ϊ��" );
							ass = true;
						}else{
							p.println( "Pass��������ʾΪ��" + title_str );
						}
					}
					//�����²���ʾ
					if(!info_list.containsKey("desc")){
						p.println( Errmessage_str + "desc" );
						ass = true;
					}else{
						String desc_str = info_list.get("desc");
						if(desc_str.equals("")){
							p.println( "Error������������ʾΪ��" );
							ass = true;
						}else{
							p.println( "Pass������������ʾΪ��" + desc_str );
						}
					}
					//ͼƬ��ʾ
					if(!info_list.containsKey("pics")){
						p.println( Errmessage_str + "pics" );
						ass = true;
					}else{
						pics_arr = info_list.get("pics");
						if(pics_arr.size() == 0){
							p.println( "Error����ͼƬ���ӵ�ַ" );
							ass = true;
						}else{
							String url_str = pics_arr.get(0).get("url");;
							p.println( "Pass��ͼƬ�����ӵ�ַΪ��" + url_str );
						}
					}	
				}
			}
			// �ҵ��ղ��ӹ��ܵ�2������2�� ���ߡ������͡����ݺ�ͼƬ����ʾ
			if(	moudle_int == 3	){
				if(!infos_list.containsKey("info")){
					p.println( "Error��info�ֶη��ش���" );
					ass = true;
				}else{
					info_list = infos_list.get("info");
					//������ʾ��
					if(!info_list.containsKey("author")){
						p.println( Errmessage_str + "author" );
						ass = true;
					}else{
						String author_str = info_list.get("author");
						if(author_str.equals("")){
							p.println( "Error������Ϊ��" );
							//ass = true;
						}else{
							p.println( "Pass��������ʾΪ��" + author_str );
						}
					}
					//���������ʾ
					if(!info_list.containsKey("booktilte")){
						p.println( Errmessage_str + "booktilte" );
						ass = true;
					}else{
						String booktilte_str = info_list.get("booktilte");
						if(booktilte_str.equals("")){
							p.println( "Error������������ʾΪ��" );
							ass = true;
						}else{
							p.println( "Pass������������ʾΪ��" + booktilte_str );
						}
					}
					//���������ʾ
					if(!info_list.containsKey("content")){
						p.println( Errmessage_str + "content" );
						ass = true;
					}else{
						String content_str = info_list.get("content");
						if(content_str.equals("")){
							p.println( "Error���ղ����������ʾΪ��ʾΪ��" );
							ass = true;
						}else{
							p.println( "Pass������������ʾΪ��" + content_str );
						}
					}
					//ͼƬ��ʾ
					if(!info_list.containsKey("authorIcon")){
						p.println( Errmessage_str + "authorIcon" );
						ass = true;
					}else{
						String authorIcon_str = info_list.get("authorIcon");
						if(authorIcon_str.equals("")){
							p.println( "Error����ͼƬ���ӵ�ַ" );
							//ass = true;
						}else{
							p.println( "Pass��ͼƬ�����ӵ�ַΪ��" + authorIcon_str );
						}
					}
					//ͼƬ��ʾ
					// if(!info_list.containsKey("pics")){
						// p.println( Errmessage_str + "pics" );
						// ass = true;
					// }else{
						// desc_arr = info_list.get("pics");
						// if(desc_str.size() == 0){
							// p.println( "Error����ͼƬ���ӵ�ַ" );
							// ass = true;
						// }else{
							// String url_str = desc_arr.get(0).get("url");;
							// p.println( "Pass��ͼƬ�����ӵ�ַΪ��" + url_str );
						// }
					// }	
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
