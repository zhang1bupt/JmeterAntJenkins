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
String filename = "E:\\IOtest\\Top20\\test_resultios\\getmessage.txt";
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

//功能点3：通知/互动 messages_arr [    ] 
p.println( "第" + ++message_num + "个测试点如下：" );

if(!List.containsKey("messages"))										
{
	p.println( Errmessage_str + "messages" );
	ass = true;
}else{
    messages_arr = List.get("messages");
	if(messages_arr.size() == 0){
		p.println( "Pass：通知/互动消息为空");
	}else{
		for(int i = 0;i < messages_arr.size();i++){
			//每一条 messagelist {    }
			p.println( "\n" );
			p.println("**************通知/互动**************");
			messages_list = messages_arr.get(i);
			//1：时间显示
			if(!messages_list.containsKey("ctime")){
				p.println( Errmessage_str + "ctime" );
				ass = true;
			}else{
				String createTime_str = messages_list.get("ctime") + "";  
				Date date= new Date(Long.parseLong(createTime_str.trim()));   
				String date_str = df.format(date);  
				if(date_str.equals("")){
					p.println( "Error：ctime字段返回为空" );	
				}else{
					p.println( "Pass：该条提问的时间显示为：" +  date_str );
				}	
			}
			//每条通知/互动 data_list{}
			if(!messages_list.containsKey("data")){
				p.println( Errmessage_str + "data" );
				ass = true;
			}else{
				data_list = messages_list.get("data");  
				data_list = messages_list.get("data");  
				//2：最下面哪个区域的通知和互动
				if(!data_list.containsKey("bname")){
					p.println( Errmessage_str + "bname" );
					ass = true;
				}else{
					bname_str = data_list.get("bname");  
					if(bname_str.equals("")){
						p.println( "Error：ctime字段返回为空" );	
						ass = true;
					}else{
						p.println( "Pass：在：" +  bname_str + "上有通知/互动");
					}	
				}
				//3 具体通知/互动消息
				if(!data_list.containsKey("context")){
					p.println( Errmessage_str + "context" );
					ass = true;
				}else{
					context_str = data_list.get("context");  
					if(context_str.equals("")){
						p.println( "Error：context字段返回为空" );
						ass = true;						
					}else{
						p.println( "Pass：互动消息：" +  context_str);
					}	
				}
				//4 具体通知/互动 回复消息
				if(!data_list.containsKey("reply")){
					p.println( Errmessage_str + "reply" );
					ass = true;
				}else{
					reply_str = data_list.get("reply");  
					if(reply_str.equals("")){
						p.println( "Error：reply字段返回为空" );
						ass = true;						
					}else{
						p.println( "Pass：回复消息：" +  reply_str);
					}	
				}
				//每条通知/互动 sende1_list{   }
				if(!data_list.containsKey("sender")){
					p.println( Errmessage_str + "sender" );
					ass = true;
				}else{
					sender_list = data_list.get("sender");  
					//5 具体通知/互动 互动者昵称
					if(!sender_list.containsKey("nickname")){
						p.println( Errmessage_str + "nickname" );
						ass = true;
					}else{
						nickname_str = sender_list.get("nickname");  
						if(nickname_str.equals("")){
							p.println( "Error：nickname字段返回为空" );
							ass = true;						
						}else{
							p.println( "Pass：互动者的昵称显示为：" +  nickname_str);
						}	
					}
					//5 具体通知/互动 互动者icon
					if(!sender_list.containsKey("icon")){
						p.println( Errmessage_str + "icon" );
						ass = true;
					}else{
						icon_str = sender_list.get("icon");  
						if(icon_str.equals("")){
							p.println( "Error：icon字段返回为空" );
							ass = true;						
						}else{
							p.println( "Pass：互动者的图标地址链接为：" +  icon_str);
						}	
					}
					//6 具体通知/互动 互动者包月状况
					if(!sender_list.containsKey("vipStatus")){
						p.println( Errmessage_str + "vipStatus" );
						ass = true;
					}else{
						int vipStatus_int = sender_list.get("vipStatus");
						if(vipStatus_int < 0 || vipStatus_int > 3){
							p.println( "Error：vipStatus字段返回错误" );
							ass = true;						
						}else{
							p.println( "Pass：互动者的包月状况为：" +  vipstatus_map.get(vipStatus_int));
						}	
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
