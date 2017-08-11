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
String filename = "E:\\IOtest\\Top20\\test_resultios\\getManitoHome.txt";
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

if(!List.containsKey("manitoInfo"))										
{
	p.println( Errmessage_str + "manitoInfo" );
	ass = true;
}else{
    manitoInfo_list = List.get("manitoInfo");
	if(!manitoInfo_list.containsKey("info"))										
	{
		p.println( Errmessage_str + "info" );
		ass = true;
	}else{
		info_list = manitoInfo_list.get("info");
		//�ӹ��ܵ�1��������
		if(!info_list.containsKey("authorName"))										
		{
			p.println( Errmessage_str + "authorName" );
			ass = true;
		}else{
			authorName_str = info_list.get("authorName");
			p.println( "Pass�����ߵ��ǳ�Ϊ��" + authorName_str);
		}
		//�ӹ��ܵ�2���ۼƴ���
		if(!info_list.containsKey("totalWords")){
			p.println( Errmessage_str + "totalWords" );
			ass = true;
		}else{
			totalWords_list = info_list.get("totalWords");
			if(totalWords_list.containsKey("count") && totalWords_list.containsKey("unit")){
				p.println("Pass���ۼƴ���" + totalWords_list.get("count") + totalWords_list.get("unit") + "��");
			}else{
				p.println( Errmessage_str + "count��unit" );
				ass = true;
			}
			
		}
		//�ӹ��ܵ�3����������
		if(!info_list.containsKey("totalCount")){
			p.println( Errmessage_str + "totalCount" );
			ass = true;
		}else{
			int totalCount_int = info_list.get("totalCount");
			p.println("Pass�����߹�����" + totalCount_int + "��" );
		}
		//�ӹ��ܵ�4����Ʒ����
		if(!info_list.containsKey("booksCount")){
			p.println( Errmessage_str + "booksCount" );
			ass = true;
		}else{
			int booksCount_int = info_list.get("booksCount");
			p.println("Pass������ȫ����Ʒ��" + booksCount_int + "��" );
		}
		//�ӹ��ܵ�5��������Ҫ����
		if(!info_list.containsKey("categoryName")){
			p.println( Errmessage_str + "categoryName" );
			ass = true;
		}else {
			String categoryName_str = info_list.get("categoryName");
			if(categoryName_str.equals("")){
				p.println("Pass����Ҫ�������� ");
			}else{
				p.println("Pass����Ҫ����Ϊ��" + categoryName_str );
			}
		}	
		//�ӹ��ܵ�6����Ʒ��˿
		if(!info_list.containsKey("fansCount")){
			p.println( Errmessage_str + "fansCount" );
			ass = true;
		}else{
			fansCount_list = info_list.get("fansCount");
			if(fansCount_list.containsKey("count") && fansCount_list.containsKey("unit")){
				p.println("Pass����Ʒ��˿��" + fansCount_list.get("count") + fansCount_list.get("unit") + "��");
			}else{
				p.println( Errmessage_str + "count��unit" );
				ass = true;
			}
			
		}
	}

}	

//���ܵ�4:ȫ����Ʒ
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("manitoInfo")){
	p.println( Errmessage_str + "manitoInfo" );
	ass = true;
}else{
	manitoInfo_list = List.get("manitoInfo");
	if(!manitoInfo_list.containsKey("books"))										
	{
		p.println( Errmessage_str + "books" );
		ass = true;
	}else{
		books_arr = manitoInfo_list.get("books");
		if(books_arr.size() == 0){
			p.println( "�ҵ���Ʒ��Ϊ��" );
		}else{
			for( i=0; i < books_arr.size(); i++ ){
				books_list = books_arr.get(i);
				p.println("\n");
				p.println( "**********�ҵ���Ʒ************" );
				//�ӹ���1�������Ƿ���ʾ
				if(!books_list.containsKey("cover")){
					p.println( "Error��bookCover�ֶη��ش���" );
					ass = true;
				}else {
					String cover_str = books_list.get("cover");
					if( cover_str == null ){	
						p.println( "Error���ҵ���Ʒ�з���cover�ֶ�Ϊ��"  );
					}else{
						p.println( "Pass���ҵ���Ʒ����" + (i+1) + "����Ʒ�з��棺" + cover_str );
					}
				}
				//������ʾ
				if(!books_list.containsKey("title")){
					p.println( "Error��title�ֶη��ش���" );
					ass = true;
				}else {
					String title_str =  books_list.get("title");	
					if( title_str == null ){
						p.println( "Error���ҵ���Ʒ�����ֶ�Ϊ��"  );
					}else{
						p.println( "Pass���ҵ���Ʒ����" + (i+1) + "������Ϊ" + title_str);
					}
				}
				//�ӹ��ܵ�3����Ʒ������ʾ
				if(!books_list.containsKey("level3CategoryShortName")){
					p.println( "Error��intro�ֶη��ش���" );
					ass = true;
				}else {
					String Type_str =  books_list.get("level3CategoryShortName");
					if( Type_str.equals("") ){
						p.println( "Error������Ʒ����Ϊ��"  );
					}else{
						p.println( "Pass���ҵ���Ʒ����" + (i+1) + "����Ʒ������Ϊ" + Type_str );
					}
				}
				//�ӹ��ܵ�4�������½���ʾ
				if(!books_list.containsKey("lastChapter")){
					p.println( "Error��intro�ֶη��ش���" );
					ass = true;
				}else {
					int lastChapter_int =  books_list.get("lastChapter");
					if( lastChapter_int < 0 ){
						p.println( "Error���½ڸ����½ڴ���"  );
						ass = true;
					}else{
						p.println( "Pass���ҵ���Ʒ����" + (i+1) + "����Ʒ�ĸ��µ�" + lastChapter_int + "��" );
					}
				}
				//�ӹ��ܵ�5��������ʾ
				if(!books_list.containsKey("intro")){
					p.println( "Error��intro�ֶη��ش���" );
					ass = true;
				}else {
					String intro_str =  books_list.get("intro");
					if( intro_str.equals("") ){
						p.println( "Error���ҵ���Ʒ����Ϊ��"  );
					}else{
						p.println( "Pass���ҵ���Ʒ����" + (i+1) + "����Ʒ����Ϊ" + intro_str );
					}
				}
				p.println( "******************************" );
			}
		}
	}
}

//���ܵ�5���ҵ�������
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("manitoInfo")){
	p.println( Errmessage_str + "manitoInfo" );
	ass = true;
}else{
	manitoInfo_list = List.get("manitoInfo");
	if(!manitoInfo_list.containsKey("commentlist"))										
	{
		p.println( Errmessage_str + "commentlist" );
		ass = true;
	}else{
		commentlist_arr = manitoInfo_list.get("commentlist");
		if(commentlist_arr.size() == 0){
			p.println( "������Ϊ��" );
		}else{
			for( i=0; i < commentlist_arr.size(); i++ ){
				comment_list = commentlist_arr.get(i);
				p.println("\n");
				p.println( "~~~~~~~~~�ҵ�����~~~~~~~~~~~~" );
				//�������ӹ��ܵ�1���ǳ���ʾ
				if(!comment_list.containsKey("user")){
					p.println( Errmessage_str + "user" );
					ass = true;
				}else{
					user_list = comment_list.get("user");
					if( user_list.size() == 0){	
						p.println( "Error������з���user�ֶ�Ϊ��"  );
					}else if( !user_list.containsKey("nickname") ){
							p.println( "Error���ҵ���������" + (i+1) + "�������ǳ�nickname�ֶ�" );
							ass = true;
						}else if( !user_list.containsKey("icon") ){
							p.println( "Error���ҵ���������" + (i+1) + "������ͼ��icon�ֶ�" );
							ass = true;
						}else{
							String nickname_str1 = user_list.get("nickname");
							String ico_str1 = user_list.get("icon"); 
							p.println( "Pass���ҵ���������" + (i+1) + "���ǳ�nickname�ֶ�Ϊ��" +  nickname_str1 + "��icon��ʾ����");
						}
					if(!user_list.containsKey("isauthor")){
						p.println( Errmessage_str + "isauthor" );
						ass = true;
					}else{
						public int isauthor_int = user_list.get("isauthor");
						if(isauthor_int < 0 || isauthor_int > 2){
							p.println( "Error��isauthor�ֶη��ش���" );
						}else if(isauthor_int == 1){
							p.println( "Pass�����۵�������" );
						}else{
							p.println( "Pass�����۵����ǲ�������" );
						}
					}				
				}
				//�������ӹ��ܵ㣺2 ������ʾ
				if(!comment_list.containsKey("shortTime")){
					p.println( Errmessage_str + "shortTime" );
					ass = true;
				}else{
					String shortTime_str = comment_list.get("shortTime");
					p.println( "Pass���ҵ���������" + (i+1) + "��������ʾΪ��" +  shortTime_str);
				}
				//�������ӹ��ܵ㣺3 ������ʾ
				if(comment_list.containsKey("title")){
					String title_str = comment_list.get("title");
					if(title_str.equals("")){
						p.println( "Error��title�ֶη���Ϊ��" );	
					}else{
						p.println( "Pass���ҵ���������" + (i+1) + "��������ʾΪ��" +  title_str);
					}	
				}else if(!comment_list.containsKey("contextContent")){
					p.println( Errmessage_str + "title" );
					ass = true;
				}
				
				//�������ӹ��ܵ㣺4 �����²�������ʾ
				if(!comment_list.containsKey("content")){
					p.println( Errmessage_str + "content" );
					ass = true;
				}else{
					String content_str = comment_list.get("content");
					p.println( "Pass���ҵ���������" + (i+1) + "������������ʾΪ��" +  content_str);
				}
				//�������ӹ��ܵ�5�� �����²���������ʾ
				// if(comment_list.containsKey("contextTitle")){
					// String contextTitle_str = comment_list.get("contextTitle");
					// if(contextTitle_str.equals("")){
						// p.println( "Error��contextTitle�ֶη���Ϊ��" );
						ass = true;
					// }else{
						// p.println( "Pass���ҵ���������" + (i+1) + "��������������ʾΪ��" +  contextTitle_str);	
					// }
				// }else if(comment_list.containsKey("Content")){
						// p.println( Errmessage_str + "contextTitle" );
						// ass = true;
					// }	
				//�������ӹ��ܵ㣺5 ���۵�����
				
				if(!comment_list.containsKey("source")){
					p.println( Errmessage_str + "source" );
					ass = true;
				}else{
					source_str = comment_list.get("source");
					p.println( "Pass���ҵ���������" + (i+1) + "��������ʾΪ��" +   source_str );
				}
				//�������ӹ��ܵ�6���޸������۵�����,��������ߣ������������Ͻ����ͼ��
				if(!comment_list.containsKey("replycount")){
					p.println( Errmessage_str + "replycount" );
					ass = true;
				}else{
					int replycount_int = comment_list.get("replycount");
					if(replycount_int < 0){
						p.println( "Error��replycount�ֶη��ش���" );
						ass = true;
					}else{
						p.println( "Pass���ҵ���������" + (i+1) + "�����ۣ��޸����ظ���������ʾΪ��" + replycount_int );
					}
				}
				//�������ӹ��ܵ�7���ظ��������۵�����
				if(!comment_list.containsKey("agree")){
					p.println( Errmessage_str + "agree" );
					ass = true;
				}else{
					int agree_int = comment_list.get("agree");
					if(agree_int < 0){
						p.println( "Error��replycount�ֶη��ش���" );
						ass = true;
					}else{
						p.println( "Pass���ҵ���������" + (i+1) + "�����ۣ��ظ������ظ���������ʾΪ��" + agree_int );
					}
				}
				p.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
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
