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
String filename = "E:\\IOtest\\Top20\\test_resultios\\getManitoHome.txt";
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

SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
p.println( "\n" );
p.println( "自动化测试开始，开始统计测试信息,当前的测试时间为：" +  df.format(new Date()) );
p.println( "-----------------------------------------------------" );
	
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

//功能点3：作者介绍，位于界面最上端
p.println( "第" + ++message_num + "个测试点如下：" );

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
		//子功能点1：作者名
		if(!info_list.containsKey("authorName"))										
		{
			p.println( Errmessage_str + "authorName" );
			ass = true;
		}else{
			authorName_str = info_list.get("authorName");
			p.println( "Pass：作者的昵称为：" + authorName_str);
		}
		//子功能点2：累计创作
		if(!info_list.containsKey("totalWords")){
			p.println( Errmessage_str + "totalWords" );
			ass = true;
		}else{
			totalWords_list = info_list.get("totalWords");
			if(totalWords_list.containsKey("count") && totalWords_list.containsKey("unit")){
				p.println("Pass：累计创作" + totalWords_list.get("count") + totalWords_list.get("unit") + "字");
			}else{
				p.println( Errmessage_str + "count或unit" );
				ass = true;
			}
			
		}
		//子功能点3：评论数量
		if(!info_list.containsKey("totalCount")){
			p.println( Errmessage_str + "totalCount" );
			ass = true;
		}else{
			int totalCount_int = info_list.get("totalCount");
			p.println("Pass：作者共评论" + totalCount_int + "条" );
		}
		//子功能点4：作品数量
		if(!info_list.containsKey("booksCount")){
			p.println( Errmessage_str + "booksCount" );
			ass = true;
		}else{
			int booksCount_int = info_list.get("booksCount");
			p.println("Pass：作者全部作品共" + booksCount_int + "本" );
		}
		//子功能点5：作者主要类型
		if(!info_list.containsKey("categoryName")){
			p.println( Errmessage_str + "categoryName" );
			ass = true;
		}else {
			String categoryName_str = info_list.get("categoryName");
			if(categoryName_str.equals("")){
				p.println("Pass：主要类型暂无 ");
			}else{
				p.println("Pass：主要类型为：" + categoryName_str );
			}
		}	
		//子功能点6：作品粉丝
		if(!info_list.containsKey("fansCount")){
			p.println( Errmessage_str + "fansCount" );
			ass = true;
		}else{
			fansCount_list = info_list.get("fansCount");
			if(fansCount_list.containsKey("count") && fansCount_list.containsKey("unit")){
				p.println("Pass：作品粉丝共" + fansCount_list.get("count") + fansCount_list.get("unit") + "个");
			}else{
				p.println( Errmessage_str + "count或unit" );
				ass = true;
			}
			
		}
	}

}	

//功能点4:全部作品
p.println( "第" + ++message_num + "个测试点如下：" );
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
			p.println( "我的作品区为空" );
		}else{
			for( i=0; i < books_arr.size(); i++ ){
				books_list = books_arr.get(i);
				p.println("\n");
				p.println( "**********我的作品************" );
				//子功能1：封面是否显示
				if(!books_list.containsKey("cover")){
					p.println( "Error：bookCover字段返回错误" );
					ass = true;
				}else {
					String cover_str = books_list.get("cover");
					if( cover_str == null ){	
						p.println( "Error：我的作品中封面cover字段为空"  );
					}else{
						p.println( "Pass：我的作品区第" + (i+1) + "个作品中封面：" + cover_str );
					}
				}
				//书名显示
				if(!books_list.containsKey("title")){
					p.println( "Error：title字段返回错误" );
					ass = true;
				}else {
					String title_str =  books_list.get("title");	
					if( title_str == null ){
						p.println( "Error：我的作品书名字段为空"  );
					}else{
						p.println( "Pass：我的作品区第" + (i+1) + "个书名为" + title_str);
					}
				}
				//子功能点3：作品类型显示
				if(!books_list.containsKey("level3CategoryShortName")){
					p.println( "Error：intro字段返回错误" );
					ass = true;
				}else {
					String Type_str =  books_list.get("level3CategoryShortName");
					if( Type_str.equals("") ){
						p.println( "Error：该作品类型为空"  );
					}else{
						p.println( "Pass：我的作品区第" + (i+1) + "个作品的类型为" + Type_str );
					}
				}
				//子功能点4：更新章节显示
				if(!books_list.containsKey("lastChapter")){
					p.println( "Error：intro字段返回错误" );
					ass = true;
				}else {
					int lastChapter_int =  books_list.get("lastChapter");
					if( lastChapter_int < 0 ){
						p.println( "Error：章节更新章节错误"  );
						ass = true;
					}else{
						p.println( "Pass：我的作品区第" + (i+1) + "个作品的更新第" + lastChapter_int + "章" );
					}
				}
				//子功能点5：介绍显示
				if(!books_list.containsKey("intro")){
					p.println( "Error：intro字段返回错误" );
					ass = true;
				}else {
					String intro_str =  books_list.get("intro");
					if( intro_str.equals("") ){
						p.println( "Error：我的作品介绍为空"  );
					}else{
						p.println( "Pass：我的作品区第" + (i+1) + "个作品介绍为" + intro_str );
					}
				}
				p.println( "******************************" );
			}
		}
	}
}

//功能点5：我的评论区
p.println( "第" + ++message_num + "个测试点如下：" );
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
			p.println( "评论区为空" );
		}else{
			for( i=0; i < commentlist_arr.size(); i++ ){
				comment_list = commentlist_arr.get(i);
				p.println("\n");
				p.println( "~~~~~~~~~我的评论~~~~~~~~~~~~" );
				//评论区子功能点1：昵称显示
				if(!comment_list.containsKey("user")){
					p.println( Errmessage_str + "user" );
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
					if(!user_list.containsKey("isauthor")){
						p.println( Errmessage_str + "isauthor" );
						ass = true;
					}else{
						public int isauthor_int = user_list.get("isauthor");
						if(isauthor_int < 0 || isauthor_int > 2){
							p.println( "Error：isauthor字段返回错误" );
						}else if(isauthor_int == 1){
							p.println( "Pass：评论的是作者" );
						}else{
							p.println( "Pass：评论的书是不是作者" );
						}
					}				
				}
				//评论区子功能点：2 日期显示
				if(!comment_list.containsKey("shortTime")){
					p.println( Errmessage_str + "shortTime" );
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
					p.println( Errmessage_str + "title" );
					ass = true;
				}
				
				//评论区子功能点：4 标题下部评论显示
				if(!comment_list.containsKey("content")){
					p.println( Errmessage_str + "content" );
					ass = true;
				}else{
					String content_str = comment_list.get("content");
					p.println( "Pass：我的评论区第" + (i+1) + "条评论内容显示为：" +  content_str);
				}
				//评论区子功能点5： 标题下部再评论显示
				// if(comment_list.containsKey("contextTitle")){
					// String contextTitle_str = comment_list.get("contextTitle");
					// if(contextTitle_str.equals("")){
						// p.println( "Error：contextTitle字段返回为空" );
						ass = true;
					// }else{
						// p.println( "Pass：我的评论区第" + (i+1) + "条再评论内容显示为：" +  contextTitle_str);	
					// }
				// }else if(comment_list.containsKey("Content")){
						// p.println( Errmessage_str + "contextTitle" );
						// ass = true;
					// }	
				//评论区子功能点：5 评论的书名
				
				if(!comment_list.containsKey("source")){
					p.println( Errmessage_str + "source" );
					ass = true;
				}else{
					source_str = comment_list.get("source");
					p.println( "Pass：我的评论区第" + (i+1) + "条书名显示为：" +   source_str );
				}
				//评论区子功能点6：赞该条评论的数量,如果是作者，在评论者右上角添加图标
				if(!comment_list.containsKey("replycount")){
					p.println( Errmessage_str + "replycount" );
					ass = true;
				}else{
					int replycount_int = comment_list.get("replycount");
					if(replycount_int < 0){
						p.println( "Error：replycount字段返回错误" );
						ass = true;
					}else{
						p.println( "Pass：我的评论区第" + (i+1) + "条评论，赞该条回复的数量显示为：" + replycount_int );
					}
				}
				//评论区子功能点7：回复该条评论的数量
				if(!comment_list.containsKey("agree")){
					p.println( Errmessage_str + "agree" );
					ass = true;
				}else{
					int agree_int = comment_list.get("agree");
					if(agree_int < 0){
						p.println( "Error：replycount字段返回错误" );
						ass = true;
					}else{
						p.println( "Pass：我的评论区第" + (i+1) + "条评论，回复该条回复的数量显示为：" + agree_int );
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
