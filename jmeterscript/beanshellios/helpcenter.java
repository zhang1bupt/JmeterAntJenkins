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
String filename = "E:\\IOtest\\Top20\\test_resultios\\helpcenter.txt";
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
Map vipstatus_map = new HashMap();  
vipstatus_map.put(1, "包月");  
vipstatus_map.put(2, "包年");  
vipstatus_map.put(0, "未包月"); 
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

//功能点3：1级帮助 [  成长等级、VIP等级等  ] 
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("typelist"))										
{
	p.println( Errmessage_str + "typelist" );
	ass = true;
}else{
    typelist_arr = List.get("typelist");
	if(typelist_arr.size() == 0){
		p.println( "Error：帮助中心为空");
		ass = true;
	}else{
		for(int i = 0;i < typelist_arr.size();i++){
			p.println( "\n" );
			p.println("**************一级帮助**************");
			typelist_list = typelist_arr.get(i);
			//一级帮助题目
			if(!typelist_list.containsKey("title")){
				p.println( Errmessage_str + "title" );
				ass = true;
			}else{
				String title_str = typelist_list.get("title");  
				if(title_str.equals("")){
					p.println( "Error：title字段返回为空" );
					ass = true;
				}else{
					p.println( "Pass：该条一级帮助题目为：" +  title_str );
				}	
			}
			//2级帮助信息  { 什么是QQ阅读成长等级等   }
			if(!typelist_list.containsKey("list")){
				p.println( Errmessage_str + "list" );
				ass = true;
			}else{
				list_arr = typelist_list.get("list");  
				if(list_arr.size() == 0){
					p.println( "Error：不包含任何的二级帮助信息");
					ass = true;
				}else{
					for(int j = 0;j < list_arr.size();j++){
						p.println( "\n" );
						p.println("~~~~~~~~~~~~~二级帮助~~~~~~~~~~~~~~~");
						list_list = list_arr.get(j);
						//2：二级帮助题目
						if(!list_list.containsKey("title")){
							p.println( Errmessage_str + "title" );
							ass = true;
						}else{
							title1_str = list_list.get("title");  
							if(title1_str.equals("")){
								p.println( "Error：二级帮助中的title字段返回为空" );	
								ass = true;
							}else{
								p.println("Pass：该条二级帮助题目为：" +  title1_str );
							}	
						}
						//2：二级帮助内容
						if(!list_list.containsKey("content")){
							p.println( Errmessage_str + "content" );
							ass = true;
						}else{
							content_str = list_list.get("content");  
							if(content_str.equals("")){
								p.println( "Error：二级帮助中的content返回内容为空" );	
								ass = true;
							}else{
								p.println("Pass：该条二级帮助信息为：" +  content_str );
							}	
						}
						p.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					}
				}
			}
			p.println("********************************");
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
