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
String filename = "E:\\IOtest\\Top20\\test_resultios\\queryoperation2.txt";
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
/* //���ܵ�3������������ʾ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("ads"))										
{
	p.println( Errmessage_str + "ads" );
	ass = true;
}else{
    ads_list = List.get("ads");
	if(!ads_list.containsKey("103283"))//103282������Ƶ��103283����ŮƵ~								
	{
		p.println( Errmessage_str + "103283" );
		ass = true;
	}
	cid103283_list = ads_list.get("103283");
	if(!cid103283_list.containsKey("adList"))
	{
		p.println( "Error���������ϲ��������������" );
		ass = true;
	}else{
		adList_arr = cid103283_list.get("adList");
		if(adList_arr.size() == 0)
		{
			p.println( "Error���������ϲ��������������" );
			ass = true;
		}else{
			for(int i = 0;i < adList_arr.size();i++){
				p.println( "\n" );
				p.println("**************���������ʾ**************");
				adList_list = adList_arr.get(i);
				//���������ʾ��
				if(!adList_list.containsKey("title"))										
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}
				else{
					String title_str = adList_list.get("title") + "";
					if(title_str.equals("") )
					{
						p.println( "Error����������Ϊ��" );
						ass = true;
					}else{
						p.println( "Pass��������ʾΪ��" + title_str);
					}
				}
				//�������ͼƬ��ַ��ʾ��
				if(!adList_list.containsKey("imageUrl"))										
				{
					p.println( Errmessage_str + "imageUrl" );
					ass = true;
				}
				else{
					String imageUrl_str = adList_list.get("imageUrl");
					if(imageUrl_str.equals("") )
					{
						p.println( "Error����������Ϊ��" );
						ass = true;
					}else{
						p.println( "Pass��ͼƬ��ַ������ʾΪ��" + imageUrl_str);
					}
				}
				p.println("***********************************");
			}
		}
	}
} */
//���ܵ�4���ٲ�ʽ������ͣ�������������ʾ����ͼ�Ͳ���ͼ���ֱ���cols��jzqmCols��
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("cols"))										
{
	p.println( Errmessage_str + "cols" );
	ass = true;
}else{
    cols_list = List.get("cols");
	if(!cols_list.containsKey("10641"))//cid = 10647���У���10655��Ů����10641 �����棩�����Ӧ�������Ϊ�������~										
	{
		p.println( Errmessage_str + "10641" );
		ass = true;
	}else{
		cid10641_list = cols_list.get("10641");
		//ģ��������ʾ
		if(!cid10641_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid10641_list.get("title");
			p.println( "Pass��ģ��������ʾΪ��" + title1_str);
		}
		if(!cid10641_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid10641_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************�� ��������� ��**************");
				bookList_list = bookList_arr.get(i);
				//������
				if(!bookList_list.containsKey("author"))									
				{
					p.println( Errmessage_str + "author" );
					ass = true;
				}else{
					author_str = bookList_list.get("author");
					p.println( "Pass�����������ʾΪ��" + author_str);
				}
				//����
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass��������ʾΪ��" + title_str);
				}
				//ԭ����ʾ
				if(!bookList_list.containsKey("originalPrice"))									
				{
					p.println( Errmessage_str + "originalPrice" );
					ass = true;
				}else{
					originalPrice_str = bookList_list.get("originalPrice");
					p.println( "Pass�����ԭ����ʾΪ��" + originalPrice_str);
				}
				//�ۿۼ���ʾ
				if(!bookList_list.containsKey("discountPrice"))									
				{
					p.println( Errmessage_str + "discountPrice" );
					ass = true;
				}else{
					discountPrice_str = bookList_list.get("discountPrice");
					p.println( "Pass������ۿۼ���ʾΪ��" + discountPrice_str);
				}
				//������ʾ
				if(!bookList_list.containsKey("intro"))									
				{
					p.println( Errmessage_str + "intro" );
					ass = true;
				}else{
					intro_str = bookList_list.get("intro");
					p.println( "Pass��������ʾΪ��" + intro_str);
				}
				//������ʾ
				if(!bookList_list.containsKey("totalWords"))									
				{
					p.println( Errmessage_str + "totalWords" );
					ass = true;
				}else{
					totalWords_str = bookList_list.get("totalWords");
					p.println( "Pass��������ʾΪ��" + totalWords_str);
				}
				//�鼮������ʾ
				if(!bookList_list.containsKey("catel2name"))									
				{
					p.println( Errmessage_str + "catel2name" );
					ass = true;
				}else{
					catel2name_str = bookList_list.get("catel2name");
					p.println( "Pass��������ʾΪ��" + catel2name_str);
				}
				p.println("*********************************");
			}
		}
	}
	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!cols_list.containsKey("10644"))//cid = 10647���У���10655��Ů����10644 �����棩�����Ӧ�������Ϊ��������~										
	{
		p.println( Errmessage_str + "10644" );
		ass = true;
	}else{
		cid10644_list = cols_list.get("10644");
		//ģ��������ʾ
		if(!cid10644_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid10644_list.get("title");
			p.println( "Pass��ģ��������ʾΪ��" + title1_str);
		}
		if(!cid10644_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid10644_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************�� ��������� ��**************");
				bookList_list = bookList_arr.get(i);
				//������
				if(!bookList_list.containsKey("author"))									
				{
					p.println( Errmessage_str + "author" );
					ass = true;
				}else{
					author_str = bookList_list.get("author");
					p.println( "Pass�����������ʾΪ��" + author_str);
				}
				//����
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass��������ʾΪ��" + title_str);
				}
				//ԭ����ʾ
				if(!bookList_list.containsKey("originalPrice"))									
				{
					p.println( Errmessage_str + "originalPrice" );
					ass = true;
				}else{
					originalPrice_str = bookList_list.get("originalPrice");
					p.println( "Pass�����ԭ����ʾΪ��" + originalPrice_str);
				}
				//�ۿۼ���ʾ
				if(!bookList_list.containsKey("discountPrice"))									
				{
					p.println( Errmessage_str + "discountPrice" );
					ass = true;
				}else{
					discountPrice_str = bookList_list.get("discountPrice");
					p.println( "Pass������ۿۼ���ʾΪ��" + discountPrice_str);
				}
				//������ʾ
				if(!bookList_list.containsKey("intro"))									
				{
					p.println( Errmessage_str + "intro" );
					ass = true;
				}else{
					intro_str = bookList_list.get("intro");
					p.println( "Pass��������ʾΪ��" + intro_str);
				}
				//������ʾ
				if(!bookList_list.containsKey("totalWords"))									
				{
					p.println( Errmessage_str + "totalWords" );
					ass = true;
				}else{
					totalWords_str = bookList_list.get("totalWords");
					p.println( "Pass��������ʾΪ��" + totalWords_str);
				}
				//�鼮������ʾ
				if(!bookList_list.containsKey("catel2name"))									
				{
					p.println( Errmessage_str + "catel2name" );
					ass = true;
				}else{
					catel2name_str = bookList_list.get("catel2name");
					p.println( "Pass��������ʾΪ��" + catel2name_str);
				}
				p.println("*********************************");
			}
		}
	}

	p.println( "��" + ++message_num + "�����Ե����£�" );
	if(!cols_list.containsKey("10642"))//cid = 2044��2049��Ů��,10642(����) ��Ӧ�������Ϊ�������~										
	{
		p.println( Errmessage_str + "10642" );
		ass = true;
	}else{
		cid10642_list = cols_list.get("10642");
		//ģ��������ʾ
		if(!cid10642_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid10642_list.get("title");
			p.println( "Pass��ģ��������ʾΪ��" + title1_str);
		}
		if(!cid10642_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid10642_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************�� ������� ��**************");
				bookList_list = bookList_arr.get(i);
				//������
				if(!bookList_list.containsKey("author"))									
				{
					p.println( Errmessage_str + "author" );
					ass = true;
				}else{
					author_str = bookList_list.get("author");
					p.println( "Pass�����������ʾΪ��" + author_str);
				}
				//����
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass��������ʾΪ��" + title_str);
				}
				//ԭ����ʾ
				if(!bookList_list.containsKey("originalPrice"))									
				{
					p.println( Errmessage_str + "originalPrice" );
					ass = true;
				}else{
					originalPrice_str = bookList_list.get("originalPrice");
					p.println( "Pass�����ԭ����ʾΪ��" + originalPrice_str);
				}
				//�ۿۼ���ʾ
				if(!bookList_list.containsKey("discountPrice"))									
				{
					p.println( Errmessage_str + "discountPrice" );
					ass = true;
				}else{
					discountPrice_str = bookList_list.get("discountPrice");
					p.println( "Pass������ۿۼ���ʾΪ��" + discountPrice_str);
				}
				//������ʾ
				if(!bookList_list.containsKey("intro"))									
				{
					p.println( Errmessage_str + "intro" );
					ass = true;
				}else{
					intro_str = bookList_list.get("intro");
					p.println( "Pass��������ʾΪ��" + intro_str);
				}
				//������ʾ
				if(!bookList_list.containsKey("totalWords"))									
				{
					p.println( Errmessage_str + "totalWords" );
					ass = true;
				}else{
					totalWords_str = bookList_list.get("totalWords");
					p.println( "Pass��������ʾΪ��" + totalWords_str);
				}
				//�鼮������ʾ
				if(!bookList_list.containsKey("catel2name"))									
				{
					p.println( Errmessage_str + "catel2name" );
					ass = true;
				}else{
					catel2name_str = bookList_list.get("catel2name");
					p.println( "Pass��������ʾΪ��" + catel2name_str);
				}
				p.println("**********************************");
			}
		}
	}
}
	//���²���������
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("jzqmCols")){
	p.println( Errmessage_str + "2056" );
	ass = true;
}else{
	jzqmCols_list = List.get("jzqmCols");
	if(!jzqmCols_list.containsKey("2056"))//cid = 2053��2052��Ů����2057�����棩 �����Ӧ�������Ϊ��������~										
	{
		p.println( Errmessage_str + "2056" );
		ass = true;
	}else{
		cid2056_list = jzqmCols_list.get("2056");
		if(!cid2056_list.containsKey("title")){
			p.println( Errmessage_str + "title" );
			ass = true;
		}else{
			title1_str = cid2056_list.get("title");
			p.println( "Pass��ģ��������ʾΪ��" + title1_str);
		}
		if(!cid2056_list.containsKey("bookList"))										
		{
			p.println( Errmessage_str + "bookList" );
			ass = true;
		}else{
			bookList_arr = cid2056_list.get("bookList");
			for(int i = 0;i < bookList_arr.size();i++){
				p.println( "\n" );
				p.println("**************�� �������� ��**************");
				bookList_list = bookList_arr.get(i);
				//����
				if(!bookList_list.containsKey("title"))									
				{
					p.println( Errmessage_str + "title" );
					ass = true;
				}else{
					title_str = bookList_list.get("title");
					p.println( "Pass��������ʾΪ��" + title_str);
				}
				//����������ʾ
				if(!bookList_list.containsKey("jzcount"))									
				{
					p.println( Errmessage_str + "jzcount" );
					ass = true;
				}else{
					jzcount_str = bookList_list.get("jzcount");
					p.println( "Pass������������ʾΪ��" + jzcount_str );
				}				
				p.println("*********************************");
			}
		}	
	}
}
SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ	
if(ass)
{
	prev.setSuccessful(false);
	p.println( "\n" );
	p.println( "���Խ�������ǰʱ��Ϊ��" + df1.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}else{
	p.println( "\n" );
	p.println( "���Խ�������ǰʱ��Ϊ��" + df1.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
