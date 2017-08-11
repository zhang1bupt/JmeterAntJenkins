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
/* 输出打印文件信息流 ---> */
String filename = "E:\\IOtest\\Top20\\test_resultios\\userclick.txt";
File file =new File(filename);
if(!file.exists())
{
	file.createNewFile();
}
FileOutputStream fs = new FileOutputStream(file,false);//若true改为false，代表以覆盖的方式写入数据。
OutputStreamWriter out =new OutputStreamWriter(fs,"utf-8");//???? 代码中没看到用
PrintStream p = new PrintStream(fs);


/*封装类型*/

Map sex = new HashMap();  
sex.put(0, "男性");  
sex.put(1, "女性");  
Map ispaymonth = new HashMap();  
ispaymonth.put(1, "包月");  
ispaymonth.put(0, "未包月");  


int message_num = 0;
String jsonString = prev.getResponseDataAsString();			//获取json串,
JSONObject List = JSONValue.parse(jsonString);				//将获取json串赋给List

boolean ass = false;	//assert断言flg
/*常用逻辑函数化*/
String Errmessage_str = "Error:未返回字段：";
public void jadgepara( Object[] para_arr )
{
	str1 = "Error:未返回字段---";
	str2 = "Error:字段返回错误---";
	
	for( m=0; m<1000; m++ )
	{
		if(para_arr[m][0] != null)
		{
			obj = para_arr[m][0];
			para = para_arr[m][1];
			item = para_arr[m][2];
			
			if(!obj.containsKey(para))
			{
				p.println( str1 + para + "--" + item );									//Error:未返回字段---xxx
				ass = true;
			}
			else
			{
				para_str = obj.get(para) + "";
				if((para_str == null) || (para_str.equals("-1")))
				{
					p.println( str2 + para + "--" + item );								//Error:字段返回错误---xxx
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

SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
p.println( "\n" );
p.println( "自动化测试开始，开始统计测试信息,当前的测试时间为：" +  df.format(new Date()) );
p.println( "-----------------------------------------------------" );
	
/*功能区*/
/* if(!List.containsKey("code"))										//错误码
{
	p.println( Errmessage_str + "code" );
	ass = true;
}
else
{
	code_str = List.get("code");
	if(!code_str.equals("0"))
	{
		p.println( "Error：接口返回失败，错误码：" + code_str );
		ass = true;
	}
} */
//功能点1:QQ
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("qq"))											
{
	p.println( Errmessage_str + "qq" );
	ass = true;
}else{
	 long qq_int = List.get("qq");
	if(qq_int == -1)
	{
		p.println( "Error：qq字段为-1，未登录qq" );
		ass = true;
	}else{
		p.println( "Pass：qq登录成功，登录的qq为：" + qq_int);
	}
} 
//功能点2: 登录状态
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("isLogin"))										
{
	p.println( Errmessage_str + "isLogin" );
	ass = true;
}
else{
	String isLogin_str = List.get("isLogin") + "";
	if(isLogin_str == false)
	{
		p.println( "Error：登录状态为：未登录" );
		ass = true;
	}else{
		p.println( "Pass：登录状态为：正常登录");
	}
}
//功能点3:登录昵称显示，最上部显示。
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("nickName"))										
{
	p.println( Errmessage_str + "nickName" );
	ass = true;
}else{
	nickname_str = List.get("nickName") + "";
	if(nickname_str == null)
	{
		p.println( "Error：nickname 字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：登录的昵称为：" + nickname_str);
	}
}
//功能点4:是否有"icon"字段
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("icon"))										
{
	p.println( Errmessage_str + "icon" );
	ass = true;
}else{
	String icon_str =  List.get("icon") ;
	if(icon_str.equals(""))
	{
		p.println( "Error：icon字段为null" );
		ass = true;
	}else{
		p.println( "Pass：icon字段为：" + icon_str);
	}
}
//功能点5:是否包月，对应icon显示中右下角的小书图标：
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("isPayMonth"))										
{
	p.println( Errmessage_str + "isPayMonth" );
	ass = true;
}else{
	int isPayMonth_int =  List.get("isPayMonth") ;
	if(isPayMonth_int < 0)
	{
		p.println( "Error：isPayMonth字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：该用户" + ispaymonth.get(isPayMonth_int));
	}
}
//功能点6:用户的性别
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("gender"))										
{
	p.println( Errmessage_str + "gender" );
	ass = true;
}else{
	int gender_int =  List.get("gender") ;
	if(gender_int < 0)
	{
		p.println( "Error：gender字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：用户的性别为：" + sex.get(gender_int));
	}
}
//功能点7:会员等级，对应红色标签
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("vipLevel"))										
{
	p.println( Errmessage_str + "vipLevel" );
	ass = true;
}else{
	int vipLevel_int = List.get("vipLevel");
	if(vipLevel_int < 0)
	{
		p.println( "Error：vipLevel字段返回错误" );
		ass = true;
	}else if(vipLevel_int == 0){
		p.println( "Pass：登录账号不是会员");
	}else{
		p.println( "Pass：登录账号为会员，登录的Vip等级为：" + vipLevel_int);
	}
}
//功能点8:成长等级，对应绿色标签
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("growLevel"))										
{
	p.println( Errmessage_str + "growLevel" );
	ass = true;
}else{
	int growLevel_int = List.get("growLevel");
	if(growLevel_int < 0)
	{
		p.println( "Error：growLevel字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：登录的账号成长等级等级为：" + growLevel_int);
	}
}
//功能点9:个性签名，在红色会员标签下显示
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("sign"))										
{
	p.println( Errmessage_str + "sign" );
	ass = true;
}else{
	String sign_str = List.get("sign");
	p.println( "Pass：个性签名显示为：" + sign_str);
	
}
//功能点10：阅读时长
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("readTime"))										
{
	p.println( Errmessage_str + "readTime" );
	ass = true;
}else{
	int readTime_int = List.get("readTime");
	if(readTime_int < 0)
	{
		p.println( "Error：readTime字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：阅读时长为：" + readTime_int/1000/60/60 + "小时" + (readTime_int/1000/60 - ((int)readTime_int/1000/60/60)*60) + "分钟" );
	}
}
//功能点11：读过书的数量
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("readCount"))										
{
	p.println( Errmessage_str + "readCount" );
	ass = true;
}else{
	int readCount_int = List.get("readCount");
	if(readCount_int < 0)
	{
		p.println( "Error：praiseNum字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：读过" + readCount_int + "本数");
	}
}
//功能点12：赞的个数
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("praiseNum"))										
{
	p.println( Errmessage_str + "praiseNum" );
	ass = true;
}else{
	int praiseNum_int = List.get("praiseNum");
	if(praiseNum_int < 0)
	{
		p.println( "Error：praiseNum字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：收到赞的个数为：" + praiseNum_int);
	}
}

//功能点13："我的等级"右部显示有多少成长值升级
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("upgradeValue"))										
{
	p.println( Errmessage_str + "upgradeValue" );
	ass = true;
}else{
	int upgradeValue_int = List.get("upgradeValue");
	if(upgradeValue_int < 0)
	{
		p.println( "Error：upgradeValue字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：显示：再有" + upgradeValue_int + "成长值升级" );
	}
}
//功能点14：关注的书评
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("bookReviewList"))										
{
	p.println( Errmessage_str + "bookReviewList" );
	ass = true;
}else{
    bookReviewList_arr = List.get("bookReviewList");
	int bookReview_int = List.get("bookReviewCount");
	if(bookReviewList_arr.size() == 0){
		p.println( "关注的书评区为空" );
	}else{
		p.println( "关注的书评共：" + bookReview_int + "条" );
		for( i=0; i < bookReviewList_arr.size(); i++ ){
			bookReview_list = bookReviewList_arr.get(i);
			p.println("\n");
			p.println( "^^^^^^^^^^^^关注的书评^^^^^^^^^^^^^^" );
			//评论区子功能点：1 书名显示
			if(!bookReview_list.containsKey("bookName")){
				p.println( "Error：bookName字段未返回" );
				ass = true;
			}else{
				String bookName_str = bookReview_list.get("bookName");
				p.println( "Pass：关注的书评的数有：" + bookName_str );
			}
			p.println( "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^" );
		}
	}
}	
//功能点15：我的提问的数量
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("mQuestionCount"))										
{
	p.println( Errmessage_str + "mQuestionCount" );
	ass = true;
}else{
	int mQuestionCount_int = List.get("mQuestionCount");
	if(mQuestionCount_int < 0)
	{
		p.println( "Error：mQuestionCount字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：我的提问的数量为：" + mQuestionCount_int);
	}
}
//功能点15：我听过的数量
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("mListenCount"))										
{
	p.println( Errmessage_str + "mListenCount" );
	ass = true;
}else{
	int mListenCount_int = List.get("mListenCount");
	if(mListenCount_int < 0)
	{
		p.println( "Error：mListenCount字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：我听过的数量为：" + mListenCount_int);
	}
}

//功能点16：我的书架书的数量，在我的书架字下面显示。
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("shelfCount"))										
{
	p.println( Errmessage_str + "shelfCount" );
	ass = true;
}else{
	int shelfCount_int = List.get("shelfCount");
	if(shelfCount_int < 0)
	{
		p.println( "Error：shelfCount字段返回错误" );
		ass = true;
	}else{
		p.println( "Pass：我的书架书的数量为：" + shelfCount_int);
	}
}

//功能点17：我的书架中具体书的显示：包括，书名，作者名，封面，如有私密阅读等在我的书架右部覆盖显示私密阅读数量
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("shelfList"))										
{
	p.println( Errmessage_str + "shelfList" );
	ass = true;
}else{
	shelfList_arr = List.get("shelfList");
	int isSecret_int = shelfList_arr.get(0).get( "isSecret" );
	if(isSecret_int < 0){
		p.println( "Error：isSecret字段返回错误" );
		ass = true;
	}else if(isSecret_int > 0){
		p.println( "Pass：我的书架中私密阅读的数量为：" +  isSecret_int );
	}
	p.println( "我的书架" );
	if(shelfList_arr.size() == 0){
		p.println( "书架区为空" );
	}else{
		for( i=0; i < shelfList_arr.size(); i++ ){
			shelfList_list = shelfList_arr.get(i);
			p.println("\n");
			p.println( "**********我的书架************" );
			if(!shelfList_list.containsKey("bookCover")){
				p.println( "Error：bookCover字段返回错误" );
				ass = true;
			}else {
				String bookCover_str = shelfList_list.get("bookCover");
				if( bookCover_str == null ){	
					p.println( "Error：书架中封面bookCover字段为空"  );
				}else{
					p.println( "Pass：书架中封面：" + bookCover_str );
				}
			}
			if(!shelfList_list.containsKey("bookName")){
				p.println( "Error：bookName字段返回错误" );
				ass = true;
			}else {
				String bookName_str =  shelfList_list.get("bookName");	
				if( bookName_str == null ){
					p.println( "Error：书架中书名字段为空"  );
				}else{
					p.println( "Pass：书架中书名bookName：" + bookName_str);
				}
			}
			if(!shelfList_list.containsKey("author")){
				p.println( "Error：author字段返回错误" );
				ass = true;
			}else {
				String author_str =  shelfList_list.get("author");
				if( author_str == null ){
					p.println( "Error：书架中作者author字段为空"  );
				}else{
					p.println( "Pass：书架中作者：" + author_str );
				}
			}
			p.println( "******************************" );
		}
	}
}
//功能点18：我的评论区
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("commentList"))										
{
	p.println( Errmessage_str + "commentList" );
	ass = true;
}else{
    commentList_arr = List.get("commentList");
	int totalCount_int = List.get("totalCount");
	if(commentList_arr.size() == 0){
		p.println( "评论区为空" );
	}else{
		p.println( "评论区记录个数为：" + totalCount_int );
		for( i=0; i < commentList_arr.size(); i++ ){
			comment_list = commentList_arr.get(i);
			p.println("\n");
			p.println( "~~~~~~~~~我的评论~~~~~~~~~~~~" );
			//评论区子功能点：1 昵称显示
			if(!comment_list.containsKey("user")){
				p.println( "Error：user字段返回错误" );
				ass = true;
			}else{
				user_list = comment_list.get("user");
				if( user_list.size() == 0){	
					p.println( "Error：书架中封面user字段为空"  );
				}else if( !user_list.containsKey("nickname") ){
						p.println( "Error：我的评论区第" + (i+1) + "不包含昵称nickname字段" );
						ass = true;
					}else if( !user_list.containsKey("icon") ){
						p.println( "Error：我的评论区第" + (i+1) + "不包含图标icon字段" );
						ass = true;
					}else{
						String nickname_str1 = user_list.get("nickname");
						String ico_str1 = user_list.get("icon"); 
						p.println( "Pass：我的评论区第" + (i+1) + "条昵称nickname字段为：" +  nickname_str1 + "，icon显示正常");
					}
					
			}
			//评论区子功能点：2 日期显示
			if(!comment_list.containsKey("shortTime")){
				p.println( "Error：shortTime字段返回错误" );
				ass = true;
			}else{
				String shortTime_str = comment_list.get("shortTime");
				p.println( "Pass：我的评论区第" + (i+1) + "条日期显示为：" +  shortTime_str);
			}
			//评论区子功能点：3 标题显示
			if(comment_list.containsKey("title")){
				String title_str = comment_list.get("title");
				if(title_str.equals("")){
					p.println( "Error：title字段返回为空" );	
				}else{
					p.println( "Pass：我的评论区第" + (i+1) + "条标题显示为：" +  title_str);
				}	
			}else if(!comment_list.containsKey("contextContent")){
				p.println( "Error：title字段返回错误" );
				ass = true;
			}
			
			//评论区子功能点：4 标题下部评论显示
			if(!comment_list.containsKey("content")){
				p.println( "Error：content字段返回错误" );
				ass = true;
			}else{
				String content_str = comment_list.get("content");
				p.println( "Pass：我的评论区第" + (i+1) + "条评论内容显示为：" +  content_str);
			}
			//评论区子功能点：5 标题下部再评论显示
			if(comment_list.containsKey("contextContent")){
				String contextContent_str = comment_list.get("contextContent");
				if(contextContent_str.equals("")){
					p.println( "Error：contextContent字段返回为空" );
					ass = true;
				}else{
					p.println( "Pass：我的评论区第" + (i+1) + "条再评论内容显示为：" +  contextContent_str);	
				}
			}else if(comment_list.containsKey("Content")){
					p.println( "Error：contextContent字段没有返回");
					ass = true;
				}	
			//评论区子功能点：6 评论的书名
			
			if(!comment_list.containsKey("bookName")){
				p.println( "Error：bookName字段返回错误" );
				ass = true;
			}else{
				bookName_str = comment_list.get("bookName");
				p.println( "Pass：我的评论区第" + (i+1) + "条书名显示为：" +  "《" + bookName_str + "》");
			}
			//评论区子功能点：7 回复该条评论的数量和
			if(!comment_list.containsKey("contextContent")){
				if(comment_list.containsKey("replycount") || comment_list.containsKey("agree")){
					int replycount_int = comment_list.get("replycount");
					int agree_int = comment_list.get("agree");
					if(replycount_int < 0){
						p.println( "Error：replycount字段返回错误" );
						ass = true;
					}else{
					p.println( "Pass：我的评论区第" + (i+1) + "条评论，回复该条回复的数量显示为：" + replycount_int );
					}
					if( agree_int < 0 ){
						p.println( "Error：agree字段返回错误" );
						ass = true;
					}else{
						p.println( "Pass：我的评论区第" + (i+1) + "条评论，赞该条评论的数量显示为：" + agree_int );
					}
				}else{
					p.println( "Error：不包括replycount或者agree字段" );
					ass = true;
				} 
			}
			
			p.println( "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" );
		}
	}
}
//功能点19：互动记录
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("contentList"))										
{
	p.println( Errmessage_str + "contentList" );
	ass = true;
}else{
    contentList_arr = List.get("contentList");
	int contentCount_int = List.get("contentCount");
	if(contentList_arr.size() == 0){
		p.println( "评论区为空" );
	}else{
		p.println( "互动记录条数为：" + contentCount_int );
		for( i=0; i < contentList_arr.size(); i++ ){
			content_list = contentList_arr.get(i);
			p.println("\n");
			p.println( "##########我的互动###########" );
			//评论区子功能点：1 互动记录条数显示
			if(!content_list.containsKey("num")){
				p.println( "Error：num字段返回错误" );
				ass = true;
			}else{
				int num_int = content_list.get("num");
				p.println( "Pass：投推荐票、打赏阅点等互动的数量为：" + num_int );
			}
			//评论区子功能点：2 时间显示
			if(!content_list.containsKey("createTime")){
				p.println( "Error：createTime字段返回错误" );
				ass = true;
			}else{
				String createTime_str = content_list.get("createTime") + "";
			   // String time="1256006105375";//long型转换成的字符串  
			    Date date= new Date(Long.parseLong(createTime_str.trim()));   
			    String date_str = df.format(date);  
				if(date_str.equals("")){
					p.println( "Error：title字段返回为空" );	
				}else{
					p.println( "Pass：第" + (i+1) + "条互动记录时间显示为：" +  date_str );
				}	
			}
			//评论区子功能点：3 显示具体的互动内容
			if(!content_list.containsKey("message")){
				p.println( "Error：message字段返回错误" );
				ass = true;
			}else{
				String message_str = content_list.get("message");
				p.println( "Pass：第" + (i+1) + "条互动记录显示为：" +  message_str);
			}
			p.println( "############################" );
		}
	}
}	

	

if(ass)
{
	prev.setSuccessful(false);
	p.println( "\n" );
	p.println( "测试结束，当前时间为：" + df.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}else{
	p.println( "\n" );
	p.println( "测试结束，当前时间为：" + df.format(new Date()) );
	p.println( "-----------------------------------------------------\n" );
}

p.close();
}catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
