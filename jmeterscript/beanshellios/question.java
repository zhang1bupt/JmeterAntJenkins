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
String filename = "E:\\IOtest\\Top20\\test_resultios\\question.txt";
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
Map status_map = new HashMap();  
status_map.put(1, "已回答");  
status_map.put(2, "已过期");  

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

//功能点3：提问者介绍
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("qanode"))										
{
	p.println( Errmessage_str + "qanode" );
	ass = true;
}else{
    qanode_list = List.get("qanode");
	if(!qanode_list.containsKey("question")){
		p.println( Errmessage_str + "question" );
		ass = true;				
	}
	else{
		question_list = qanode_list.get("question");
		//问答昵称
		if(!question_list.containsKey("name")){
			p.println( Errmessage_str + "name" );
			ass = true;
		}else{
			String name_str = question_list.get("name");
			p.println( "Pass：该条提问者的昵称：" + name_str );
			}
		//评论区子功能点：2 时间显示
		if(!question_list.containsKey("createTime")){
			p.println( "Error：createTime字段返回错误" );
			ass = true;
		}else{
			String createTime_str = question_list.get("createTime") + "";  
			Date date= new Date(Long.parseLong(createTime_str.trim()));   
			String date_str = df.format(date);  
			if(date_str.equals("")){
				p.println( "Error：createTime字段返回为空" );	
			}else{
				p.println( "Pass：该条提问的时间显示为：" +  date_str );
			}	
		}
		//标签icon显示
		if(!question_list.containsKey("icon")){
			p.println( Errmessage_str + "icon" );
			ass = true;
		}else{
			String icon_str = question_list.get("icon");
			p.println( "Pass：提问者的icon图标的链接为：" + icon_str );
		}
		//具体问题
		if(!question_list.containsKey("content")){
			p.println( Errmessage_str + "content" );
			ass = true;
		}else{
			String content_str = question_list.get("content");
			p.println( "Pass：提问的具体内容显示：" + content_str );
		}
		//具体花费
		if(!question_list.containsKey("pay")){
			p.println( Errmessage_str + "pay" );
			ass = true;
		}else{
			int pay_int = question_list.get("pay");
			p.println( "Pass：听该条提问的回答需要花费显示：" + pay_int + "阅点" );
		}
		//状态显示：status为1表示：已回答，2表示已过期。
		if(!question_list.containsKey("status")){
			p.println( Errmessage_str + "status" );
			ass = true;
		}else{
			int status_int = question_list.get("status");
			p.println( "Pass：该条提问的的状态显示：" + status_map.get(status_int) );
		}
	}
}
//功能点4:大神回答
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("qanode"))										
{
	p.println( Errmessage_str + "qanode" );
	ass = true;
}else{
    qanode_list = List.get("qanode");
	if(!qanode_list.containsKey("answer")){
		p.println( Errmessage_str + "answer" );
		ass = true;				
	}
	else{
		answer_list = qanode_list.get("answer");
		//标签icon显示
		if(!answer_list.containsKey("icon")){
			p.println( Errmessage_str + "icon" );
			ass = true;
		}else{
			String icon_str = answer_list.get("icon");
			p.println( "Pass：标签的链接为：" + icon_str );
		}
		//回答显示
		if(!answer_list.containsKey("content")){
			p.println( Errmessage_str + "content" );
			ass = true;
		}else{
			String content_str = answer_list.get("content");
			p.println( "Pass：要听回答显示：" + content_str );
		}
		//回答时长显示
		if(!answer_list.containsKey("audioDuration")){
			p.println( Errmessage_str + "audioDuration" );
			ass = true;
		}else{
			int audioDuration_int = answer_list.get("audioDuration");
			p.println( "Pass：回答的时长为：" + audioDuration_int + "秒" );
			}
		//红字显示，被多少人悄悄听
		if(!answer_list.containsKey("eavesDroppingCount")){
			p.println( Errmessage_str + "eavesDroppingCount" );
			ass = true;
		}else{
			int eavesDroppingCount_int = answer_list.get("eavesDroppingCount");
			p.println( "Pass：被" + eavesDroppingCount_int + "人悄悄听");
			}
		//红字显示,获得多少阅点
		if(!answer_list.containsKey("earnMoney")){
			p.println( Errmessage_str + "earnMoney" );
			ass = true;
		}else{
			int earnMoney_int = answer_list.get("earnMoney");
			p.println( "Pass：获得" + earnMoney_int + "阅点");
			}
		//灰字显示，听过多少
		if(!answer_list.containsKey("listenCount")){
			p.println( Errmessage_str + "listenCount" );
			ass = true;
		}else{
			int listenCount_int = answer_list.get("listenCount");
			p.println( "Pass：听过" + listenCount_int );
			}
		//作者昵称
		if(!answer_list.containsKey("authorName")){
			p.println( Errmessage_str + "authorName" );
			ass = true;
		}else{
			String authorName_str = answer_list.get("authorName");
			p.println( "Pass：作者的昵称：" + authorName_str );
		}	
		//问答作者昵称
		// if(!answer_list.containsKey("authorName")){
			// p.println( Errmessage_str + "authorName" );
			// ass = true;
		// }else{
			// String authorName_str = answer_list.get("authorName");
			// p.println( "Pass：作者的昵称：" + authorName_str );
		// }	
	}
}
//功能点5:作者名，作者回答多少问题，被多少人悄悄听
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("authornode"))										
{
	p.println( Errmessage_str + "authornode" );
	ass = true;
}else{
    qanode_list = List.get("authornode");
	if(!List.containsKey("authornode")){
		p.println( Errmessage_str + "authornode" );
		ass = true;
	}else{
		authornode_list = List.get("authornode");
		//回答的作者昵称
		if(!authornode_list.containsKey("authorName")){
			p.println( Errmessage_str + "authorName" );
			ass = true;
		}else{
			String authorName_str = authornode_list.get("authorName");
			p.println( "Pass：作者的昵称：" + authorName_str );
		}
		//回答多少问题
		if(!authornode_list.containsKey("answerCount")){
			p.println( Errmessage_str + "answerCount" );
			ass = true;
		}else{
			int answerCount_int = authornode_list.get("answerCount");
			p.println( "Pass：回答：" + answerCount_int + "个问题");
		}
		//被多少人悄悄听
		if(!authornode_list.containsKey("listenCount")){
			p.println( Errmessage_str + "listenCount" );
			ass = true;
		}else{
			int listenCount_int = authornode_list.get("listenCount");
			p.println( "Pass：回答：" + listenCount_int + "个问题");
		}
	}
}
//功能点6：大神最近的作品
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("booklist"))										
{
	p.println( Errmessage_str + "booklist" );
	ass = true;
}else{
	booklist_arr = List.get("booklist");
	if(booklist_arr.size() == 0){
		p.println( "大神最新作品为空" );
	}else{
		for( i=0; i < booklist_arr.size(); i++ ){
			booklist_list = booklist_arr.get(i);
			p.println("\n");
			p.println( "**********大神的最新作品************" );
			//作品名字显示
			if(!booklist_list.containsKey("title")){
				p.println( "Error：title字段返回错误" );
				ass = true;
			}else {
				String title_str =  booklist_list.get("title");	
				if( title_str.equals("")){
					p.println( "Error：作品没有名字显示"  );
					ass = true;
				}else{
					p.println( "Pass：作品名称显示：" + title_str );
				}
			}
			//作品介绍
			if(!booklist_list.containsKey("intro")){
				p.println( "Error：intro字段返回错误" );
				ass = true;
			}else {
				String intro_str =  booklist_list.get("intro");
				if( intro_str.equals("") ){
					p.println( "Error：作品中作者intro字段为空"  );
				}else{
					p.println( "Pass：书架中作者：" + intro_str );
				}
			}
			p.println( "******************************" );
		}
	}
}
//功能点7：全部回复
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("replylist"))										
{
	p.println( Errmessage_str + "replylist" );
	ass = true;
}else{
    replylist_arr = List.get("replylist");
	if(replylist_arr.size() == 0){
		p.println( "回复区为空" );
	}else{
		for( i=0; i < replylist_arr.size(); i++ ){
			replylist_list = replylist_arr.get(i);
			p.println("\n");
			p.println( "##########全部回复###########" );
			//评论区子功能点：1 楼层显示
			if(!replylist_list.containsKey("index")){
				p.println( "Error：index字段返回错误" );
				ass = true;
			}else{
				int index_int = replylist_list.get("index");
				if(index_int <= 0){
					p.println( "Error：楼层显示不可能小于1楼" );
				}else if(index_int == 2){
					p.println( "Pass：第" + (i+1) + "楼层显示：沙发" );
				}else{
					p.println( "Pass：第" + (i+1) + "楼层显示：" + index_int + "楼" );
				}
			}
			//评论区子功能点：2 时间显示
			if(!replylist_list.containsKey("createtime")){
				p.println( "Error：createTime字段返回错误" );
				ass = true;
			}else{
				String createTime_str = replylist_list.get("createtime") + "";
			   // String time="1256006105375";//long型转换成的字符串  
			    Date date= new Date(Long.parseLong(createTime_str.trim()));   
			    String date_str = df.format(date);  
				if(date_str.equals("")){
					p.println( "Error：title字段返回为空" );	
				}else{
					p.println( "Pass：第" + (i+1) + "条时间显示为：" +  date_str );
				}	
			}
			//评论区子功能点：3 显示评论人的信息
			if(!replylist_list.containsKey("user")){
				p.println( "Error：user字段返回错误" );
				ass = true;
			}else{
				user_list = replylist_list.get("user");
				 //评论者昵称显示
				if(!user_list.containsKey("nickname")){
					p.println( "Error：nickname字段返回错误" );
					ass = true;
				}else{
					String nickname_str = user_list.get("nickname");
					p.println( "Pass：第" + (i+1) + "条评论昵称显示为：" +  nickname_str);
				}
				//icon地址链接显示
				if(!user_list.containsKey("icon")){
					p.println( "Error：icon字段返回错误" );
					ass = true;
				}else{
					String icon_str = user_list.get("icon");
					p.println( "Pass：第" + (i+1) + "条评论者icon的地址链接为：" +  icon_str);
				}
				//评论者是否包月
				if(!user_list.containsKey("vipStatus")){
					p.println( "Error：icon字段返回错误" );
					ass = true;
				}else{
					int vipStatus_int = user_list.get("vipStatus");
					p.println( "Pass：第" + (i+1) + "评论者" +  ispaymonth.get(vipStatus_int));
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
