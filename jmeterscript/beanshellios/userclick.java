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
String filename = "E:\\IOtest\\Top20\\test_resultios\\userclick.txt";
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
				para_str = obj.get(para) + "";
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
		p.println( "Error��nickname �ֶη��ش���" );
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
	if(icon_str.equals(""))
	{
		p.println( "Error��icon�ֶ�Ϊnull" );
		ass = true;
	}else{
		p.println( "Pass��icon�ֶ�Ϊ��" + icon_str);
	}
}
//���ܵ�5:�Ƿ���£���Ӧicon��ʾ�����½ǵ�С��ͼ�꣺
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("isPayMonth"))										
{
	p.println( Errmessage_str + "isPayMonth" );
	ass = true;
}else{
	int isPayMonth_int =  List.get("isPayMonth") ;
	if(isPayMonth_int < 0)
	{
		p.println( "Error��isPayMonth�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass�����û�" + ispaymonth.get(isPayMonth_int));
	}
}
//���ܵ�6:�û����Ա�
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
		p.println( "Pass���Ķ�ʱ��Ϊ��" + readTime_int/1000/60/60 + "Сʱ" + (readTime_int/1000/60 - ((int)readTime_int/1000/60/60)*60) + "����" );
	}
}
//���ܵ�11�������������
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("readCount"))										
{
	p.println( Errmessage_str + "readCount" );
	ass = true;
}else{
	int readCount_int = List.get("readCount");
	if(readCount_int < 0)
	{
		p.println( "Error��praiseNum�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass������" + readCount_int + "����");
	}
}
//���ܵ�12���޵ĸ���
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

//���ܵ�13��"�ҵĵȼ�"�Ҳ���ʾ�ж��ٳɳ�ֵ����
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
		p.println( "Pass����ʾ������" + upgradeValue_int + "�ɳ�ֵ����" );
	}
}
//���ܵ�14����ע������
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("bookReviewList"))										
{
	p.println( Errmessage_str + "bookReviewList" );
	ass = true;
}else{
    bookReviewList_arr = List.get("bookReviewList");
	int bookReview_int = List.get("bookReviewCount");
	if(bookReviewList_arr.size() == 0){
		p.println( "��ע��������Ϊ��" );
	}else{
		p.println( "��ע����������" + bookReview_int + "��" );
		for( i=0; i < bookReviewList_arr.size(); i++ ){
			bookReview_list = bookReviewList_arr.get(i);
			p.println("\n");
			p.println( "^^^^^^^^^^^^��ע������^^^^^^^^^^^^^^" );
			//�������ӹ��ܵ㣺1 ������ʾ
			if(!bookReview_list.containsKey("bookName")){
				p.println( "Error��bookName�ֶ�δ����" );
				ass = true;
			}else{
				String bookName_str = bookReview_list.get("bookName");
				p.println( "Pass����ע�����������У�" + bookName_str );
			}
			p.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
		}
	}
}	
//���ܵ�15���ҵ����ʵ�����
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("mQuestionCount"))										
{
	p.println( Errmessage_str + "mQuestionCount" );
	ass = true;
}else{
	int mQuestionCount_int = List.get("mQuestionCount");
	if(mQuestionCount_int < 0)
	{
		p.println( "Error��mQuestionCount�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass���ҵ����ʵ�����Ϊ��" + mQuestionCount_int);
	}
}
//���ܵ�15��������������
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("mListenCount"))										
{
	p.println( Errmessage_str + "mListenCount" );
	ass = true;
}else{
	int mListenCount_int = List.get("mListenCount");
	if(mListenCount_int < 0)
	{
		p.println( "Error��mListenCount�ֶη��ش���" );
		ass = true;
	}else{
		p.println( "Pass��������������Ϊ��" + mListenCount_int);
	}
}

//���ܵ�16���ҵ����������������ҵ������������ʾ��
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

//���ܵ�17���ҵ�����о��������ʾ�������������������������棬����˽���Ķ������ҵ�����Ҳ�������ʾ˽���Ķ�����
p.println( "��" + ++message_num + "�����Ե����£�" );
if(!List.containsKey("shelfList"))										
{
	p.println( Errmessage_str + "shelfList" );
	ass = true;
}else{
	shelfList_arr = List.get("shelfList");
	int isSecret_int = shelfList_arr.get(0).get( "isSecret" );
	if(isSecret_int < 0){
		p.println( "Error��isSecret�ֶη��ش���" );
		ass = true;
	}else if(isSecret_int > 0){
		p.println( "Pass���ҵ������˽���Ķ�������Ϊ��" +  isSecret_int );
	}
	p.println( "�ҵ����" );
	if(shelfList_arr.size() == 0){
		p.println( "�����Ϊ��" );
	}else{
		for( i=0; i < shelfList_arr.size(); i++ ){
			shelfList_list = shelfList_arr.get(i);
			p.println("\n");
			p.println( "**********�ҵ����************" );
			if(!shelfList_list.containsKey("bookCover")){
				p.println( "Error��bookCover�ֶη��ش���" );
				ass = true;
			}else {
				String bookCover_str = shelfList_list.get("bookCover");
				if( bookCover_str == null ){	
					p.println( "Error������з���bookCover�ֶ�Ϊ��"  );
				}else{
					p.println( "Pass������з��棺" + bookCover_str );
				}
			}
			if(!shelfList_list.containsKey("bookName")){
				p.println( "Error��bookName�ֶη��ش���" );
				ass = true;
			}else {
				String bookName_str =  shelfList_list.get("bookName");	
				if( bookName_str == null ){
					p.println( "Error������������ֶ�Ϊ��"  );
				}else{
					p.println( "Pass�����������bookName��" + bookName_str);
				}
			}
			if(!shelfList_list.containsKey("author")){
				p.println( "Error��author�ֶη��ش���" );
				ass = true;
			}else {
				String author_str =  shelfList_list.get("author");
				if( author_str == null ){
					p.println( "Error�����������author�ֶ�Ϊ��"  );
				}else{
					p.println( "Pass����������ߣ�" + author_str );
				}
			}
			p.println( "******************************" );
		}
	}
}
//���ܵ�18���ҵ�������
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("commentList"))										
{
	p.println( Errmessage_str + "commentList" );
	ass = true;
}else{
    commentList_arr = List.get("commentList");
	int totalCount_int = List.get("totalCount");
	if(commentList_arr.size() == 0){
		p.println( "������Ϊ��" );
	}else{
		p.println( "��������¼����Ϊ��" + totalCount_int );
		for( i=0; i < commentList_arr.size(); i++ ){
			comment_list = commentList_arr.get(i);
			p.println("\n");
			p.println( "~~~~~~~~~�ҵ�����~~~~~~~~~~~~" );
			//�������ӹ��ܵ㣺1 �ǳ���ʾ
			if(!comment_list.containsKey("user")){
				p.println( "Error��user�ֶη��ش���" );
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
					
			}
			//�������ӹ��ܵ㣺2 ������ʾ
			if(!comment_list.containsKey("shortTime")){
				p.println( "Error��shortTime�ֶη��ش���" );
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
				p.println( "Error��title�ֶη��ش���" );
				ass = true;
			}
			
			//�������ӹ��ܵ㣺4 �����²�������ʾ
			if(!comment_list.containsKey("content")){
				p.println( "Error��content�ֶη��ش���" );
				ass = true;
			}else{
				String content_str = comment_list.get("content");
				p.println( "Pass���ҵ���������" + (i+1) + "������������ʾΪ��" +  content_str);
			}
			//�������ӹ��ܵ㣺5 �����²���������ʾ
			if(comment_list.containsKey("contextContent")){
				String contextContent_str = comment_list.get("contextContent");
				if(contextContent_str.equals("")){
					p.println( "Error��contextContent�ֶη���Ϊ��" );
					ass = true;
				}else{
					p.println( "Pass���ҵ���������" + (i+1) + "��������������ʾΪ��" +  contextContent_str);	
				}
			}else if(comment_list.containsKey("Content")){
					p.println( "Error��contextContent�ֶ�û�з���");
					ass = true;
				}	
			//�������ӹ��ܵ㣺6 ���۵�����
			
			if(!comment_list.containsKey("bookName")){
				p.println( "Error��bookName�ֶη��ش���" );
				ass = true;
			}else{
				bookName_str = comment_list.get("bookName");
				p.println( "Pass���ҵ���������" + (i+1) + "��������ʾΪ��" +  "��" + bookName_str + "��");
			}
			//�������ӹ��ܵ㣺7 �ظ��������۵�������
			if(!comment_list.containsKey("contextContent")){
				if(comment_list.containsKey("replycount") || comment_list.containsKey("agree")){
					int replycount_int = comment_list.get("replycount");
					int agree_int = comment_list.get("agree");
					if(replycount_int < 0){
						p.println( "Error��replycount�ֶη��ش���" );
						ass = true;
					}else{
					p.println( "Pass���ҵ���������" + (i+1) + "�����ۣ��ظ������ظ���������ʾΪ��" + replycount_int );
					}
					if( agree_int < 0 ){
						p.println( "Error��agree�ֶη��ش���" );
						ass = true;
					}else{
						p.println( "Pass���ҵ���������" + (i+1) + "�����ۣ��޸������۵�������ʾΪ��" + agree_int );
					}
				}else{
					p.println( "Error��������replycount����agree�ֶ�" );
					ass = true;
				} 
			}
			
			p.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		}
	}
}
//���ܵ�19��������¼
p.println( "��" + ++message_num + "�����Ե����£�" );

if(!List.containsKey("contentList"))										
{
	p.println( Errmessage_str + "contentList" );
	ass = true;
}else{
    contentList_arr = List.get("contentList");
	int contentCount_int = List.get("contentCount");
	if(contentList_arr.size() == 0){
		p.println( "������Ϊ��" );
	}else{
		p.println( "������¼����Ϊ��" + contentCount_int );
		for( i=0; i < contentList_arr.size(); i++ ){
			content_list = contentList_arr.get(i);
			p.println("\n");
			p.println( "##########�ҵĻ���###########" );
			//�������ӹ��ܵ㣺1 ������¼������ʾ
			if(!content_list.containsKey("num")){
				p.println( "Error��num�ֶη��ش���" );
				ass = true;
			}else{
				int num_int = content_list.get("num");
				p.println( "Pass��Ͷ�Ƽ�Ʊ�������ĵ�Ȼ���������Ϊ��" + num_int );
			}
			//�������ӹ��ܵ㣺2 ʱ����ʾ
			if(!content_list.containsKey("createTime")){
				p.println( "Error��createTime�ֶη��ش���" );
				ass = true;
			}else{
				String createTime_str = content_list.get("createTime") + "";
			   // String time="1256006105375";//long��ת���ɵ��ַ���  
			    Date date= new Date(Long.parseLong(createTime_str.trim()));   
			    String date_str = df.format(date);  
				if(date_str.equals("")){
					p.println( "Error��title�ֶη���Ϊ��" );	
				}else{
					p.println( "Pass����" + (i+1) + "��������¼ʱ����ʾΪ��" +  date_str );
				}	
			}
			//�������ӹ��ܵ㣺3 ��ʾ����Ļ�������
			if(!content_list.containsKey("message")){
				p.println( "Error��message�ֶη��ش���" );
				ass = true;
			}else{
				String message_str = content_list.get("message");
				p.println( "Pass����" + (i+1) + "��������¼��ʾΪ��" +  message_str);
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
