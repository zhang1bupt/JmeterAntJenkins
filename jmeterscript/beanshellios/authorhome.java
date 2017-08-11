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
String filename = "E:\\IOtest\\Top20\\test_resultios\\authorhome.txt";
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

//功能点3：作者介绍，位于界面最上端
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("authorInfo"))										
{
	p.println( Errmessage_str + "authorInfo" );
	ass = true;
}else{
    authorInfo_list = List.get("authorInfo");
	//图标显示
	if(!authorInfo_list.containsKey("icon"))										
	{
		p.println( Errmessage_str + "icon" );
		ass = true;
	}else{
		String icon_str = authorInfo_list.get("icon");
		p.println( "Pass：显示的图标链接为：" + icon_str);
	}
	//介绍显示
	if(!authorInfo_list.containsKey("desc"))
	{
		p.println( Errmessage_str + "desc" );
		ass = true;
	}else{
		String desc_str = authorInfo_list.get("desc");
		p.println( "Pass：显示的作者介绍为：" + desc_str);
	}
	//显示向我提问需支付：
	if(!authorInfo_list.containsKey("questionPrice"))
	{
		p.println( Errmessage_str + "questionPrice" );
		ass = true;
	}else{
		int questionPrice_int = authorInfo_list.get("questionPrice");
		p.println( "Pass：向我提问需支付：" + questionPrice_int + "阅点");
	}
	//显示月收入：
	if(!authorInfo_list.containsKey("income"))
	{
		p.println( Errmessage_str + "income" );
		ass = true;
	}else{
		int income_int = authorInfo_list.get("income");
		if( income_int < 0){
			p.println(  "Error: income返回有问题" );
			ass = true;
		}else{
			p.println( "Pass：月收入：" + income_int + "阅点");
		}
	}
	//月收入下面回答显示：
	if(!authorInfo_list.containsKey("answerIncome"))
	{
		p.println( Errmessage_str + "answerIncome" );
		ass = true;
	}else{
		int answerIncome_int = authorInfo_list.get("answerIncome");
		if( answerIncome_int < 0){
			p.println(  "Error: answerIncome返回有问题" );
			ass = true;
		}else{
			p.println( "Pass：回答：" + answerIncome_int + "阅点");
		}
	}
	//月收入下被悄悄听显示：
	if(!authorInfo_list.containsKey("listenIncome"))
	{
		p.println( Errmessage_str + "listenIncome" );
		ass = true;
	}else{
		int listenIncome_int = authorInfo_list.get("listenIncome");
		if( listenIncome_int < 0){
			p.println(  "Error: listenIncome返回有问题" );
			ass = true;
		}else{
			p.println( "Pass：被悄悄听：" + listenIncome_int + "阅点");
		}
	}
}	

//功能点4:全部
p.println( "第" + ++message_num + "个测试点如下：" );
if(!List.containsKey("all")){
	p.println( Errmessage_str + "all" );
	ass = true;
}else{
	all_str = List.get("all");
	if(all_str.size() == 0){
		p.println( "问答全部中内容为空" );
	}else{
		for( i=0; i < all_str.size(); i++ ){
			all_list = all_str.get(i);
			if(!all_list.containsKey("question")){
				p.println( Errmessage_str + "question" );
				ass = true;				
			}else{
				question_list = all_list.get("question");
				p.println("\n");
				p.println( "**********全部************" );
				//问答昵称
				if(!question_list.containsKey("name")){
					p.println( Errmessage_str + "name" );
					ass = true;
				}else{
					String name_str = question_list.get("name");
					p.println( "Pass：第" + (i+1) + "条问答的昵称：" + name_str );
				}
				//评论区子功能点：2 时间显示
				if(!question_list.containsKey("createTime")){
					p.println( "Error：createTime字段返回错误" );
					ass = true;
				}else{
					String createTime_str = question_list.get("createTime") + "";
				   // String time="1256006105375";//long型转换成的字符串  
					Date date= new Date(Long.parseLong(createTime_str.trim()));   
					String date_str = df.format(date);  
					if(date_str.equals("")){
						p.println( "Error：title字段返回为空" );	
					}else{
						p.println( "Pass：第" + (i+1) + "条问答时间显示为：" +  date_str );
					}	
				}
				//标签icon显示
				if(!question_list.containsKey("icon")){
					p.println( Errmessage_str + "icon" );
					ass = true;
				}else{
					String icon_str = question_list.get("icon");
					p.println( "Pass：第" + (i+1) + "条标签的链接为：" + icon_str );
				}
				//具体问题
				if(!question_list.containsKey("content")){
					p.println( Errmessage_str + "content" );
					ass = true;
				}else{
					String content_str = question_list.get("content");
					p.println( "Pass：第" + (i+1) + "条问答的具体内容显示：" + content_str );
				}
				//具体花费
				if(!question_list.containsKey("pay")){
					p.println( Errmessage_str + "pay" );
					ass = true;
				}else{
					int pay_int = question_list.get("pay");
					p.println( "Pass：第" + (i+1) + "条问答的花费显示：" + pay_int + "阅点" );
				}
				//状态显示：status为1表示：已回答，2表示已过期。
				if(!question_list.containsKey("status")){
					p.println( Errmessage_str + "status" );
					ass = true;
				}else{
					int status_int = question_list.get("status");
					p.println( "Pass：第" + (i+1) + "条问答的状态显示：" + status_map.get(status_int) );
				}
				p.println( "******************************" );
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
